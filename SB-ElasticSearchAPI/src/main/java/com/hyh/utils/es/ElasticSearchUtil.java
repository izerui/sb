package com.hyh.utils.es;

import java.util.LinkedList;
import java.util.List;

import org.elasticsearch.action.index.IndexRequestBuilder;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.mlt.MoreLikeThisRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.MoreLikeThisFieldQueryBuilder;
import org.elasticsearch.index.query.MoreLikeThisQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;

import com.hyh.es.entity.Medicine;

public class ElasticSearchUtil {
	private Client client;

	public ElasticSearchUtil() {
		this("192.168.109.133");
	}

	public ElasticSearchUtil(String ipAddress) {
		Settings settings = ImmutableSettings.settingsBuilder().put("client.transport.ping_timeout", "10s").build();
		client = new TransportClient(settings).addTransportAddress(new InetSocketTransportAddress(ipAddress, 9300));
	}

	/**
	 * @param index
	 *            必须为小写
	 */
	public IndexResponse createIndex(String index, String type, String json) {
		// 一定要设置.setRefresh(true),否则第一次建立索引查找不到数据
		IndexRequestBuilder requestBuilder = client.prepareIndex(index, type).setRefresh(true);
		IndexResponse response = requestBuilder.setSource(json).execute().actionGet();
		return response;
	}

	public void createIndex(String index, String type, List<String> jsonList) {
		IndexRequestBuilder requestBuilder = client.prepareIndex(index, type).setRefresh(true);
		for (int i = 0; i < jsonList.size(); i++) {
			requestBuilder.setSource(jsonList.get(i)).execute().actionGet();
		}
	}

	public List<Medicine> searche(QueryBuilder queryBuilder, String index, String type) {
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
				list.add(new Medicine(id, name, function));
			}
		}
		return list;
	}

	public void moreLikeThisById(String index, String type, String id, String field) {
		MoreLikeThisRequestBuilder mlt = new MoreLikeThisRequestBuilder(client, index, type, id);
		mlt.setField(field);
		SearchResponse response = client.moreLikeThis(mlt.request()).actionGet();
	}

	public void moreLikeThisByQuery(String text) {
		MoreLikeThisQueryBuilder query = QueryBuilders.moreLikeThisQuery();
		query.boost(1.0f).likeText(text).minTermFreq(10);
	}

	public void moreLikeThis(String field) {
		MoreLikeThisFieldQueryBuilder query = QueryBuilders.moreLikeThisFieldQuery(field);
	}

	public void finalAll(String index, int size) {
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
}