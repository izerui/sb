package com.sb.hyh.geo.test;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;
import static org.elasticsearch.index.query.FilterBuilders.geoDistanceRangeFilter;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.common.geo.GeoDistance;
import org.elasticsearch.common.unit.DistanceUnit;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.index.query.FilterBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.sort.GeoDistanceSortBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;

import com.sb.hyh.utils.es.ElasticSearchUtil;

/**
 * 附近的人查询:10万个基数查询,最大限额1000人,1米到100米范围内的人
 */
public class GeoDistanceTest {
    /**
     * field("term_vector","with_positions_offsets")
     * field("include_in_all","false") field("boost", 4.0) 打分,默认1.0
     * field("indexAnalyzer","not_analyzed") field("searchAnalyzer",
     * "not_analyzed")
     */
    public static XContentBuilder mapping(String index, String type) throws IOException {
        return XContentFactory.jsonBuilder()
                //
                .startObject()
                //
                .startObject(type)
                //
                .startObject("properties")
                //
                .startObject("title").field("type", "string").field("store", "yes").endObject()
                //
                .startObject("description").field("type", "string").field("index", "not_analyzed").endObject()
                //
                .startObject("price").field("type", "double").endObject()
                //
                .startObject("onSale").field("type", "boolean").endObject()
                //
                .startObject("type").field("type", "integer").endObject()
                //
                .startObject("createDate").field("type", "date").endObject()
                //
                .endObject()
                //
                .endObject()
                //
                .endObject();
    }

    public static XContentBuilder createMapping(String type) {
        XContentBuilder mapping = null;
        try {
            mapping = jsonBuilder()
                    //
                    .startObject()
                    // 索引库名（类似数据库中的表）
                    .startObject(type)
                    //
                    .startObject("properties")
                    // ID
                    .startObject("id").field("type", "long").endObject()
                    // 姓名
                    .startObject("name").field("type", "string").endObject()
                    // 位置
                    .startObject("location").field("type", "geo_point").endObject()
                    //
                    .endObject()
                    //
                    .endObject()
                    //
                    .endObject();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mapping;
    }

    // 添加数据
    public static Integer addIndexData100000(String index, String type) {
        List<String> list = new ArrayList<String>();
        double lat = 39.929986;
        double lon = 116.395645;
        for (int i = 0; i < 100000; i++) {
            double max = 0.00001;
            double min = 0.000001;
            Random random = new Random();
            double s = random.nextDouble() % (max - min + 1) + max;

            DecimalFormat df = new DecimalFormat("######0.000000");
            String lons = df.format(s + lon);
            String lats = df.format(s + lat);
            Double dlon = Double.valueOf(lons);
            Double dlat = Double.valueOf(lats);

            User user = new User(i, "郭德纲" + i, dlat, dlon);
            list.add(obj2JsonUserData(user));
        }
        return ElasticSearchUtil.addByBulk(index, type, list);
    }

    public static String obj2JsonUserData(User user) {
        String jsonData = null;
        try {
            XContentBuilder jsonBuild = XContentFactory.jsonBuilder();
            jsonBuild.startObject().field("id", user.getId()).field("name", user.getName()).startArray("location")
                    .value(user.getLat()).value(user.getLon()).endArray().endObject();
            jsonData = jsonBuild.string();
            System.out.println(jsonData);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonData;
    }

    // 获取附近的人
    @SuppressWarnings("unchecked")
    public static void testGetNearbyPeople(String index, String type, double lat, double lon) {
        SearchRequestBuilder srb = ElasticSearchUtil.getClient().prepareSearch(index).setTypes(type);
        // 1000人
        srb.setFrom(0).setSize(1000);

        // 于谦的坐标lon,lat,查询距离于谦1米到1000米
        FilterBuilder builder = geoDistanceRangeFilter("location").point(lon, lat).from("1m").to("100m")
                .optimizeBbox("memory").geoDistance(GeoDistance.PLANE);
        srb.setPostFilter(builder);

        // 获取距离多少公里 这个才是获取点与点之间的距离的
        GeoDistanceSortBuilder sort = SortBuilders.geoDistanceSort("location");
        sort.unit(DistanceUnit.METERS);
        sort.order(SortOrder.ASC);
        sort.point(lon, lat);
        srb.addSort(sort);

        SearchResponse searchResponse = srb.execute().actionGet();
        SearchHits hits = searchResponse.getHits();
        SearchHit[] searchHists = hits.getHits();

        Float usetime = searchResponse.getTookInMillis() / 1000f;
        System.out.println("于谦附近的人(" + hits.getTotalHits() + "个),耗时(" + usetime + "秒)：");

        for (SearchHit hit : searchHists) {
            String name = (String) hit.getSource().get("name");
            List<Double> location = (List<Double>) hit.getSource().get("location");
            // 获取距离值,
            BigDecimal geoDis = new BigDecimal((Double) hit.getSortValues()[0]);

            System.out.println(name + "的坐标：" + location + "他距离于谦" + geoDis.setScale(0, BigDecimal.ROUND_HALF_DOWN)
                    + DistanceUnit.METERS.toString());
            System.out.println("-----------------");
        }
    }

    public static void main(String[] args) throws IOException {
        String index = "es";
        String type = "people";
        System.out.println(ElasticSearchUtil.createMappings(index, type, createMapping(type)));

        // System.out.println(addIndexData100000(index, type));

        double lat = 39.929986;
        double lon = 116.395645;
        long start = System.currentTimeMillis();
        testGetNearbyPeople(index, type, lat, lon);
        long end = System.currentTimeMillis();
        System.out.println((end - start) + "毫秒");
    }
}