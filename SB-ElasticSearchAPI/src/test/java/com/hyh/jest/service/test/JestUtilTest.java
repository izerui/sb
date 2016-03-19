package com.hyh.jest.service.test;

import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.Test;

import com.hyh.es.entity.News;
import com.hyh.utils.es.JestUtil;

public class JestUtilTest {

	@Test
	public void testFindAll() {
		int page = 0;
		int size = 1000;
		Boolean flag = true;
		while (flag) {
			flag = false;
			SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
			searchSourceBuilder.from(page * size);
			searchSourceBuilder.size(size);
			page++;
			JestUtil.searchReturnObj("conac_yuqing", "portals_web_data", searchSourceBuilder, News.class);
		}
	}

	@Test
	public void testFenYe() {
		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
		searchSourceBuilder.from(0);
		searchSourceBuilder.size(15);
		JestUtil.searchReturnObj("index", "news", searchSourceBuilder, Object.class);
	}

	public void search() {
		String query = "感冒";
		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
		searchSourceBuilder.query(QueryBuilders.queryString(query));
		// searchSourceBuilder.query(QueryBuilders.matchQuery("name", "感冒"));
		searchSourceBuilder.field("name");
	}
}
