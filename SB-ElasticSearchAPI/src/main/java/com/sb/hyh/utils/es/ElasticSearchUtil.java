package com.sb.hyh.utils.es;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.elasticsearch.action.admin.cluster.health.ClusterHealthRequest;
import org.elasticsearch.action.admin.indices.exists.indices.IndicesExistsRequest;
import org.elasticsearch.action.admin.indices.exists.indices.IndicesExistsRequestBuilder;
import org.elasticsearch.action.admin.indices.exists.indices.IndicesExistsResponse;
import org.elasticsearch.action.admin.indices.mapping.put.PutMappingRequest;
import org.elasticsearch.action.admin.indices.mapping.put.PutMappingResponse;
import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexRequestBuilder;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.mlt.MoreLikeThisRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.Requests;
import org.elasticsearch.cluster.metadata.MappingMetaData;
import org.elasticsearch.common.collect.ImmutableOpenMap;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.index.query.MoreLikeThisFieldQueryBuilder;
import org.elasticsearch.index.query.MoreLikeThisQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;

import com.sb.hyh.es.entity.Medicine;

public class ElasticSearchUtil {
    private static Client client = ES.getElasticSearch("172.17.80.110");

    public static void createIndex(String index) {
        if (!isExistIndex(index)) {
            System.out.println("create index");
            // 创建空索引
            client.admin().indices().prepareCreate(index).execute().actionGet();
            // waitForYellow
            client.admin().cluster().health(new ClusterHealthRequest(index).waitForYellowStatus()).actionGet();
        }
    }

    public static boolean isExistIndex(String index) {
        IndicesExistsRequest request = new IndicesExistsRequestBuilder(client.admin().indices(), index).request();
        IndicesExistsResponse response = client.admin().indices().exists(request).actionGet();
        return response.isExists();
    }

    public static boolean isExistType(String index, String type) {
        ImmutableOpenMap<String, MappingMetaData> mappings = client.admin().cluster().prepareState().execute()
                .actionGet().getState().getMetaData().getIndices().get(index).getMappings();
        return mappings.containsKey(type);
    }

    // 创建索引
    public static boolean createMappings(String index, String type, XContentBuilder mapping) {
        createIndex(index);
        if (!isExistType(index, type)) {
            System.out.println("create type and mapping");
            PutMappingRequest putMapping = Requests.putMappingRequest(index).type(type).source(mapping);
            PutMappingResponse response = client.admin().indices().putMapping(putMapping).actionGet();
            return response.isAcknowledged();
        }
        return true;
    }

    public static void getMappingInfo(String index, String type) {
        ImmutableOpenMap<String, MappingMetaData> mappings = client.admin().cluster().prepareState().execute()
                .actionGet().getState().getMetaData().getIndices().get(index).getMappings();
        System.out.println(mappings.get(type).source());
    }

    /**
     * @param index 必须为小写
     */
    public static IndexResponse add(String index, String type, String json) {
        IndexRequestBuilder requestBuilder = client.prepareIndex(index, type);
        IndexResponse response = requestBuilder.setSource(json).execute().actionGet();
        return response;
    }

    public static void addByList(String index, String type, List<String> jsonList) {
        IndexRequestBuilder requestBuilder = client.prepareIndex(index, type);
        for (int i = 0; i < jsonList.size(); i++) {
            requestBuilder.setSource(jsonList.get(i)).execute().actionGet();
        }
    }

    public static int addByBulk(String index, String type, List<String> list) {
        // 创建索引库
        List<IndexRequest> requests = new ArrayList<IndexRequest>();
        for (int i = 0; i < list.size(); i++) {
            IndexRequest request = ElasticSearchUtil.getClient().prepareIndex(index, type).setSource(list.get(i))
                    .request();
            requests.add(request);
        }
        // 批量创建索引
        BulkRequestBuilder bulkRequest = client.prepareBulk();
        for (IndexRequest request : requests) {
            bulkRequest.add(request);
        }

        BulkResponse bulkResponse = bulkRequest.execute().actionGet();
        if (bulkResponse.hasFailures()) {
            System.out.println("批量创建索引错误");
        }
        return bulkRequest.numberOfActions();
    }

    public static List<Medicine> searche(QueryBuilder queryBuilder, String index, String type) {
        List<Medicine> list = new LinkedList<Medicine>();
        SearchResponse searchResponse = client.prepareSearch(index).setTypes(type).setQuery(queryBuilder).execute()
                .actionGet();
        SearchHits hits = searchResponse.getHits();
        SearchHit[] searchHists = hits.getHits();
        if (searchHists != null && searchHists.length > 0) {
            for (SearchHit hit : searchHists) {
                Integer id = (Integer) hit.getSource().get("id");
                String name = (String) hit.getSource().get("name");
                String function = (String) hit.getSource().get("function");
                Date date = new Date((Long) hit.getSource().get("date"));
                list.add(new Medicine(id, name, function, date));
            }
        }
        return list;
    }

    public static void moreLikeThisById(String index, String type, String id, String field) {
        MoreLikeThisRequestBuilder mlt = new MoreLikeThisRequestBuilder(client, index, type, id);
        mlt.setField(field);
        SearchResponse response = client.moreLikeThis(mlt.request()).actionGet();
    }

    public static void moreLikeThisByQuery(String text) {
        MoreLikeThisQueryBuilder query = QueryBuilders.moreLikeThisQuery();
        query.boost(1.0f).likeText(text).minTermFreq(10);
    }

    public static void moreLikeThis(String field) {
        MoreLikeThisFieldQueryBuilder query = QueryBuilders.moreLikeThisFieldQuery(field);
    }

    public static void finalAll(String index, int size) {
        SearchResponse searchResponse = client.prepareSearch(index)
                // 可以提高性能,但第一次却不返回结果
                .setSearchType(SearchType.SCAN)
                // 实际返回的数量为size*index的主分片格式
                .setSize(size)
                // 游标维持多长时间
                .setScroll(TimeValue.timeValueMinutes(8)).execute().actionGet();

        // 第一次查询，只返回数量和一个scrollId
        System.out.println(searchResponse.getHits().getTotalHits());
        System.out.println(searchResponse.getHits().hits().length);
        // 第一次运行没有结果
        for (SearchHit hit : searchResponse.getHits()) {
            System.out.println(hit.getSourceAsString());
        }
        System.out.println("------------------------------");

        // 使用上次的scrollId继续访问
        searchResponse = client.prepareSearchScroll(searchResponse.getScrollId())
                .setScroll(TimeValue.timeValueMinutes(8)).execute().actionGet();
        System.out.println(searchResponse.getHits().getTotalHits());
        System.out.println(searchResponse.getHits().hits().length);
        for (SearchHit hit : searchResponse.getHits()) {
            System.out.println(hit.getSourceAsString());
        }
    }

    public static Client getClient() {
        return client;
    }

    public static void setClient(Client client) {
        ElasticSearchUtil.client = client;
    }
}