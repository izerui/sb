package com.sb.hyh.api.solr;
//package com.ac.solr.utils;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//
//import org.apache.solr.client.solrj.SolrQuery;
//import org.apache.solr.client.solrj.SolrServerException;
//import org.apache.solr.client.solrj.impl.HttpSolrServer;
//import org.apache.solr.client.solrj.response.QueryResponse;
//import org.apache.solr.common.SolrDocumentList;
//import org.apache.solr.common.SolrInputDocument;
//
//import com.ac.solr.model.User;
//
//public class SolrUtil {
//	private static int connectionTimeout = 60000;
//	private static int soTimeout = 60000;
//	private static int maxRetries = 1;
//	private static int defaultMaxCOnnectionPerhost = 100;
//	private static int maxTotalConnections = 100;
//	private static boolean followRedirects = false;
//	private static boolean allowCompression = true;
//
//	public static void main(String[] args) throws ClassNotFoundException, IOException, SolrServerException {
//		add();
//		queryAll();
//	}
//
//	public static void queryAll() throws ClassNotFoundException, IOException {
//		try {
//			HttpSolrServer server = new HttpSolrServer("http://localhost:8080/solr/new_core");
//			server.setSoTimeout(soTimeout);
//			server.setConnectionTimeout(connectionTimeout);
//			server.setDefaultMaxConnectionsPerHost(defaultMaxCOnnectionPerhost);
//			server.setMaxTotalConnections(maxTotalConnections);
//			server.setFollowRedirects(followRedirects);
//			server.setAllowCompression(allowCompression);
//			server.setMaxRetries(maxRetries);
//			// 查询所有
//			SolrQuery params = new SolrQuery("*:*");
//			QueryResponse qs = server.query(params);
//			SolrDocumentList results = qs.getResults();
//			System.out.println(results.toString());
//			List<User> list = qs.getBeans(User.class);
//			for (User user : list) {
//				System.out.println(user.getName());
//			}
//			// System.out.println(list);
//		} catch (SolrServerException e) {
//			e.printStackTrace();
//		}
//	}
//
//	public static void add() throws SolrServerException, IOException {
//		HttpSolrServer server = new HttpSolrServer("http://localhost:8080/solr/new_core");
//		SolrInputDocument doc1 = new SolrInputDocument();
//		doc1.addField("id", "id1", 1.0f);
//		doc1.addField("name", "doc1", 1.0f);
//
//		SolrInputDocument doc2 = new SolrInputDocument();
//		doc2.addField("id", "id2", 1.0f);
//		doc2.addField("name", "doc2", 1.0f);
//
//		Collection<SolrInputDocument> docs = new ArrayList<SolrInputDocument>();
//		docs.add(doc1);
//		docs.add(doc2);
//
//		server.add(docs);
//
//		// 提交到索引中，不会出现在搜索结果中,如果想立马搜索，使用commit(boolean waitFlush, boolean
//		// waitSearcher)
//		server.commit();
//	}
//}