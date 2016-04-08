package com.sb.hyh.utils.es;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.elasticsearch.search.builder.SearchSourceBuilder;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.sb.hyh.es.entity.News;

import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.config.HttpClientConfig;
import io.searchbox.core.Bulk;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import io.searchbox.core.SearchResult.Hit;
import io.searchbox.indices.CreateIndex;
import io.searchbox.indices.DeleteIndex;

public class JestUtil {
	private static JestClient jestClient;

	public static JestClient jestClient() {
		JestClientFactory factory = new JestClientFactory();
		factory.setHttpClientConfig(new HttpClientConfig.Builder("http://192.168.109.133:9200").multiThreaded(true)
				.connTimeout(60000).build());
		if (jestClient == null) {
			jestClient = factory.getObject();
		}
		return jestClient;
	}

	public static void createIndex(String index) {
		try {
			jestClient.execute(new CreateIndex.Builder(index).build());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void builderSearchIndex(String index, String type) {
		long start = System.currentTimeMillis();
		try {
			// drop
			DeleteIndex deleteIndex = new DeleteIndex(new DeleteIndex.Builder(index));
			jestClient.execute(deleteIndex);

			// create
			CreateIndex createIndex = new CreateIndex(new CreateIndex.Builder(index));
			jestClient.execute(createIndex);

			// Bulk 两个参数1:索引名称2:类型名称
			Bulk.Builder bulkBuilder = new Bulk.Builder().defaultIndex(index).defaultType(type);

			for (int i = 0; i < 10; i++) {
				News news = new News();
				news.setId(i + 1);
				news.setTitle("elasticsearch RESTful搜索引擎-(java jest 使用[入门])" + (i + 1));
				news.setContent(
						"好吧下面我介绍下jest(第三方工具),个人认为还是非常不错的...想对ES用来更好,多多研究源代码吧...迟点,会写一些关于ES的源代码研究文章,现在暂时还是入门的阶段.哈..(不敢,不敢)"
								+ (i + 1));
				bulkBuilder.addAction(new Index.Builder(news).build());
			}

			jestClient.execute(bulkBuilder.build());
			jestClient.shutdownClient();
		} catch (Exception e) {
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		System.out.println("数据量" + 10 + "记录,创建索引时间" + (end - start) / 1000 + "秒");
	}

	// public List<News> searchsNews(String param) {
	// try {
	// long start = System.currentTimeMillis();
	//
	// QueryBuilder queryBuilder = QueryBuilders.queryString(param);
	// Search search = new
	// Search(Search.createQueryWithBuilder(queryBuilder.toString()));
	// search.addIndex("news");
	// search.addType("article");
	// JestResult result = jestClient.execute(search);
	//
	// long end = System.currentTimeMillis();
	// System.out.println("在" + num + "条记录中,搜索新闻,共用时间 -->> " + (end - start) +
	// "毫秒");
	// return result.getSourceAsObjectList(News.class);
	// } catch (IOException e) {
	// e.printStackTrace();
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// return null;
	// }

	private static SearchResult search(String index, String type, SearchSourceBuilder searchSourceBuilder) {
		String json_result = searchSourceBuilder.toString();
		Search search = new Search.Builder(json_result).addIndex(index).addType(type).build();
		SearchResult searchResult = null;
		try {
			searchResult = jestClient().execute(search);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return searchResult;
	}

	public static <T> List<T> searchReturnObj(String index, String type, SearchSourceBuilder searchSourceBuilder,
			Class<T> myClass) {
		SearchResult searchResult = search(index, type, searchSourceBuilder);
		if (searchResult == null) {
			return null;
		}
		List<SearchResult.Hit<T, Void>> hits = searchResult.getHits(myClass);
		List<T> result = new LinkedList<T>();
		Iterator<Hit<T, Void>> hitsList = hits.iterator();
		while (hitsList.hasNext()) {
			result.add(hitsList.next().source);
		}
		return result;
	}

	public static String searchReturnJson(String index, String type, SearchSourceBuilder searchSourceBuilder) {
		SearchResult searchResult = search(index, type, searchSourceBuilder);
		if (searchResult == null) {
			return null;
		}
		return searchResult.getJsonString();
	}

	public static List<String> searchReturnIndexIdList(String index, String type,
			SearchSourceBuilder searchSourceBuilder) {
		SearchResult searchResult = search(index, type, searchSourceBuilder);
		if (searchResult == null) {
			return null;
		}
		JsonObject jsonObj = searchResult.getJsonObject();
		jsonObj = jsonObj.get("hits").getAsJsonObject();
		List<String> resultList = null;
		if (jsonObj.has("hits")) {
			resultList = new LinkedList<String>();
			JsonArray jsonArray = jsonObj.get("hits").getAsJsonArray();
			for (JsonElement obj : jsonArray) {
				JsonObject temp_jsonObj = obj.getAsJsonObject();
				if (temp_jsonObj.has("_id")) {
					resultList.add(temp_jsonObj.get("_id").getAsString());
				}
			}
		}
		return resultList;
	}
}
