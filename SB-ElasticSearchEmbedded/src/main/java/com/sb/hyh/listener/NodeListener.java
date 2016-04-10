package com.sb.hyh.listener;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.node.Node;
import org.elasticsearch.node.NodeBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.sb.hyh.config.ManagerConfiguration;

/**
 * 启动ES服务
 */
@WebListener
public class NodeListener implements ServletContextListener {
	private Node node;

	public void contextInitialized(ServletContextEvent sce) {
		// 获取Spring的bean
		ServletContext servletContext = sce.getServletContext();
		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		ManagerConfiguration config = (ManagerConfiguration) context.getBean("com.sb.hyh.config.ManagerConfiguration");

		// 设置setting
		Map<String, String> settingMap = new HashMap<String, String>();
		String clusterName = config.getClusterName();
		String pathData = config.getPathData();
		String pathHome = config.getPathHome();
		settingMap.put("cluster.name", clusterName);
		settingMap.put("path.data", pathData);
		settingMap.put("path.home", pathHome);
		Settings settings = ImmutableSettings.settingsBuilder().put(settingMap).build();

		// 创建并启动节点
		NodeBuilder nodeBuilder = NodeBuilder.nodeBuilder();
		nodeBuilder.settings(settings);
		node = nodeBuilder.node();
		node.start();
	}

	public void contextDestroyed(ServletContextEvent sce) {
		if (null != node) {
			// 关闭节点
			node.stop();
		}
	}
}
