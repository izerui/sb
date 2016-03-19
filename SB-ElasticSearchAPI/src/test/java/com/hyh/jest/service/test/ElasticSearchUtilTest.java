package com.hyh.jest.service.test;

import java.util.List;

import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.junit.Test;

import com.hyh.es.entity.MakeDataFactory;
import com.hyh.es.entity.Medicine;
import com.hyh.utils.es.ElasticSearchUtil;

public class ElasticSearchUtilTest {
	public static void main(String[] args) {
		// 注意安装中文插件
		QueryBuilder queryBuilder = QueryBuilders.boolQuery().must(QueryBuilders.termQuery("name", "感冒"));
		System.out.println(queryBuilder.toString());
	}

	@Test
	public void testCreate() {
		ElasticSearchUtil elasticSearchUtil = new ElasticSearchUtil();
		List<String> jsonList = MakeDataFactory.getInitJsonData();
		String index = "index";
		String type = "news";
		elasticSearchUtil.createIndex(index, type, jsonList);
	}

	@Test
	public void testFindAll2() {
		ElasticSearchUtil elasticSearchUtil = new ElasticSearchUtil();
		elasticSearchUtil.finalAll("index", 5);
	}

	@Test
	public void testFindAll3() {
		// 默认是10条
		QueryBuilder queryBuilder = QueryBuilders.matchAllQuery();
		test(queryBuilder);
	}

	public void test(QueryBuilder queryBuilder) {
		ElasticSearchUtil elasticSearchUtil = new ElasticSearchUtil();
		String index = "index";
		String type = "news";
		List<Medicine> result = elasticSearchUtil.searche(queryBuilder, index, type);
		for (int i = 0; i < result.size(); i++) {
			Medicine medicine = result.get(i);
			System.out.println(
					"id:" + medicine.getId() + ",name:" + medicine.getName() + ",function:" + medicine.getFunction());
		}
	}
}
