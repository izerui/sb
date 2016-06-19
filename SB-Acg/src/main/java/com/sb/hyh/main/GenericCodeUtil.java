package com.sb.hyh.main;

import java.util.HashMap;
import java.util.Map;

import com.sb.hyh.po.User;

public class GenericCodeUtil {
	private static String rootPackage = "com.sb.hyh";

	public static void main(String[] args) {
		genericCode(User.class, Long.class);
	}

	public static void genericCode(Class<?> entityClass, Class<?> IDClass) {
		String modelName = entityClass.getSimpleName();
		String modelPrimaryKey = IDClass.getSimpleName();

		String classPath = entityClass.getResource("/").getPath();
		String sourceFolder = classPath.replace("target/classes", "src/main/java");
		sourceFolder = sourceFolder.replace("target/test-classes", "src/main/java");
		String packagePath = sourceFolder + rootPackage.replace(".", "/");

		Map<String, String> map = new HashMap<String, String>();
		map.put("rootPackage", rootPackage);
		map.put("modelName", modelName);

		String ModelName = entityClass.getSimpleName().substring(0, 1).toLowerCase()
				+ entityClass.getSimpleName().substring(1);
		map.put("ModelName", ModelName);

		map.put("modelPrimaryKey", modelPrimaryKey);

		String fileDaoName = packagePath + "/dao/" + modelName + "Dao.java";
		FreeMarkerUtil.generate(fileDaoName, FreeMarkerUtil.getContent(map, "dao.ftl"));

		String fileServiceName = packagePath + "/service/" + modelName + "Service.java";
		FreeMarkerUtil.generate(fileServiceName, FreeMarkerUtil.getContent(map, "service.ftl"));

		String fileControllerName = packagePath + "/controller/" + modelName + "Controller.java";
		FreeMarkerUtil.generate(fileControllerName, FreeMarkerUtil.getContent(map, "controller.ftl"));
	}
}
