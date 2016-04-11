package com.sb.hyh.test;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.elasticsearch.index.query.FilterBuilders;
import org.elasticsearch.index.query.FilteredQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.junit.Test;

import com.sb.hyh.es.entity.MakeDataFactory;
import com.sb.hyh.es.entity.Medicine;
import com.sb.hyh.utils.es.ElasticSearchUtil;

public class ElasticSearchUtilTest {
    public static void main(String[] args) {
        // 注意安装中文插件
        QueryBuilder queryBuilder = QueryBuilders.boolQuery().must(QueryBuilders.termQuery("name", "感冒"));
        System.out.println(queryBuilder.toString());
    }

    @Test
    public void testCreateIndex() {
        String index = "test";
        ElasticSearchUtil.createIndex(index);
    }

    @Test
    public void testIsExistIndex() {
        String index = "test";
        System.out.println(ElasticSearchUtil.isExistIndex(index));
    }

    @Test
    public void testAdd() {
        List<String> jsonList = MakeDataFactory.getInitJsonData();
        String index = "index";
        String type = "news";
        ElasticSearchUtil.addByList(index, type, jsonList);
    }

    @Test
    public void testGetMappingInfo() {
        String index = "index";
        String type = "news";
        ElasticSearchUtil.getMappingInfo(index, type);
    }

    @Test
    public void testFindAll1() {
        ElasticSearchUtil.finalAll("index", 5);
    }

    @Test
    public void testFindAll2() {
        // 默认是10条
        QueryBuilder queryBuilder = QueryBuilders.matchAllQuery();
        test(queryBuilder);
    }

    @Test
    public void testSearchDate() {
        Calendar ca = Calendar.getInstance();
        ca.setTime(new Date());
        ca.add(Calendar.MINUTE, -10);
        Date lastYear = ca.getTime();

        QueryStringQueryBuilder queryBuilder = new QueryStringQueryBuilder("功能");
        queryBuilder.field("function");

        FilteredQueryBuilder filteredQueryBuilder = QueryBuilders.filteredQuery(queryBuilder,
                FilterBuilders.boolFilter().must(
                        FilterBuilders.rangeFilter("date").from(lastYear.getTime()).to(System.currentTimeMillis())));

        // 有问题
        // FilteredQueryBuilder filteredQueryBuilder =
        // QueryBuilders.filteredQuery(queryBuilder,
        // FilterBuilders.boolFilter().must(FilterBuilders.rangeFilter("date").from(lastYear).to(new
        // Date())));

        test(filteredQueryBuilder);
    }

    public void test(QueryBuilder queryBuilder) {
        System.out.println(queryBuilder.toString());
        String index = "index";
        String type = "news";
        List<Medicine> result = ElasticSearchUtil.searche(queryBuilder, index, type);
        for (int i = 0; i < result.size(); i++) {
            Medicine medicine = result.get(i);
            System.out.println("id:" + medicine.getId() + ",name:" + medicine.getName() + ",function:"
                    + medicine.getFunction() + ",date:" + medicine.getDate());
        }
    }
}
