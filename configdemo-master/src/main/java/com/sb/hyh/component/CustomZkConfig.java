package com.sb.hyh.component;

import javax.annotation.PostConstruct;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.cache.ChildData;
import org.apache.curator.framework.recipes.cache.TreeCache;
import org.apache.curator.framework.recipes.cache.TreeCacheEvent;
import org.apache.curator.framework.recipes.cache.TreeCacheListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.google.common.base.Charsets;

@Component
public class CustomZkConfig {
	@Autowired
	public CuratorFramework client;
	@Value("${spring.application.name}")
	public String appName;

	@PostConstruct
	public void registerListener() {
		String basePath = "/config/" + appName;
		watchWholeTree(client, basePath);
	}

	@SuppressWarnings("resource")
	private void watchWholeTree(CuratorFramework client, String path) {
		TreeCache cache = new TreeCache(client, path);
		try {
			cache.start();
			TreeCacheListener listener = new TreeCacheListener() {

				@Override
				public void childEvent(CuratorFramework client, TreeCacheEvent event) throws Exception {
					ChildData childData = event.getData();
					if (childData == null) {
						return;
					}
					String value = null;
					if (childData.getData() != null) {
						value = new String(childData.getData());
					}
					switch (event.getType()) {
					case NODE_ADDED: {
						System.out.println("TreeNode added: " + childData.getPath() + ", value: " + value);
						break;
					}
					case NODE_UPDATED: {
						System.out.println("TreeNode changed: " + childData.getPath() + ", value: " + value);
						break;
					}
					case NODE_REMOVED: {
						System.out.println("TreeNode removed: " + childData.getPath());
						break;
					}
					default:
						System.out.println("Other event: " + event.getType().name());
					}
				}
			};
			cache.getListenable().addListener(listener);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void get() throws Exception {
		String basePath = "/config/" + appName;
		byte[] data = client.getData().forPath(basePath + "/msg");
		if (data != null) {
			System.out.println(new String(data, Charsets.UTF_8));
		}
	}
}
