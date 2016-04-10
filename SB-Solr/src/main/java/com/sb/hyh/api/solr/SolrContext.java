package com.sb.hyh.api.solr;
//
//import javax.annotation.Resource;
//
//import org.apache.solr.client.solrj.SolrServer;
//import org.apache.solr.client.solrj.impl.HttpSolrServer;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.env.Environment;
//
//@Configuration
//// @EnableSolrRepositores(basePackages = { "com.acme.solr" }, multicoreSupport =
//// true)
//public class SolrContext {
//	public static final String SOLR_HOST = "solr.host";
//
//	@Resource
//	private Environment environment;
//
//	@Bean
//	public SolrServer solrServer() {
//		String solrHost = environment.getRequiredProperty(SOLR_HOST);
//		return new HttpSolrServer(solrHost);
//	}
//}