package com.sb.hyh.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("com.sb.hyh.config.ManagerConfiguration")
public class ManagerConfiguration {
	@Value("${esserver.cluster.name}")
	private String clusterName;
	@Value("${esserver.path.home}")
	private String pathHome;
	@Value("${esserver.path.data}")
	private String pathData;

	public String getClusterName() {
		return clusterName;
	}

	public String getPathData() {
		return pathData;
	}

	public String getPathHome() {
		return pathHome;
	}
}
