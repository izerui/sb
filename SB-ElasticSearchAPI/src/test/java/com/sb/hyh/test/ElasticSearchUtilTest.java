package com.sb.hyh.test;

import java.util.List;

import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
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
    public void testAddData() {
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
    public void testFindAll2() {
        ElasticSearchUtil.finalAll("index", 5);
    }

    @Test
    public void testFindAll3() {
        // 默认是10条
        QueryBuilder queryBuilder = QueryBuilders.matchAllQuery();
        test(queryBuilder);
    }

    public void test(QueryBuilder queryBuilder) {
        String index = "index";
        String type = "news";
        List<Medicine> result = ElasticSearchUtil.searche(queryBuilder, index, type);
        for (int i = 0; i < result.size(); i++) {
            Medicine medicine = result.get(i);
            System.out.println(
                    "id:" + medicine.getId() + ",name:" + medicine.getName() + ",function:" + medicine.getFunction());
        }
    }
}
