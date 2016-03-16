package com.sb.hyh.config;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;

@Configuration
@EnableSolrRepositories(basePackages = { "com.sb.hyh.repository" }, multicoreSupport = true)
public class SolrContext {
	private static int connectionTimeout = 60000;
	private static int soTimeout = 60000;
	private static int maxRetries = 1;
	private static int defaultMaxCOnnectionPerhost = 100;
	private static int maxTotalConnections = 100;
	private static boolean followRedirects = false;
	private static boolean allowCompression = true;

	@Bean
	public SolrServer solrServer(@Value("${solr.host}") String solrHost) {
		HttpSolrServer server = new HttpSolrServer(solrHost);
		server.setSoTimeout(soTimeout);
		server.setConnectionTimeout(connectionTimeout);
		server.setDefaultMaxConnectionsPerHost(defaultMaxCOnnectionPerhost);
		server.setMaxTotalConnections(maxTotalConnections);
		server.setFollowRedirects(followRedirects);
		server.setAllowCompression(allowCompression);
		server.setMaxRetries(maxRetries);

		return server;
	}
}