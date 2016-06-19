package com.sb.hyh.main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.apache.log4j.Logger;

import com.sb.hyh.po.OpenapiBanjie;
import com.sb.hyh.po.OpenapiBuzhengbuqi;
import com.sb.hyh.po.OpenapiBuzhenggaozhi;
import com.sb.hyh.po.OpenapiShenqing;
import com.sb.hyh.po.OpenapiShouli;
import com.sb.hyh.po.OpenapiTebiechengxujieguo;
import com.sb.hyh.po.OpenapiTebiechengxushenqing;
import com.sb.hyh.po.OpenapiUser;

public class GenericCodeUtils2 {
	private static Logger logger = Logger.getLogger(GenericCodeUtils2.class);

	public static void main(String[] args) throws Exception {
		genericCode(OpenapiBanjie.class, String.class);
		genericCode(OpenapiBuzhengbuqi.class, String.class);
		genericCode(OpenapiBuzhenggaozhi.class, String.class);
		genericCode(OpenapiShenqing.class, String.class);
		genericCode(OpenapiShouli.class, String.class);
		genericCode(OpenapiTebiechengxujieguo.class, String.class);
		genericCode(OpenapiTebiechengxushenqing.class, String.class);
		genericCode(OpenapiUser.class, String.class);
	}

	public static void createFile(File file) {
		try {
			file.delete();
			if (!file.getParentFile().exists()) {
				file.getParentFile().mkdirs();
			}
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void genericCode(Class<?> entityClass, Class<?> IDClass) throws IOException {
		String name = entityClass.getSimpleName();
		String classPath = entityClass.getResource("/").getPath();
		String sourceFolder = classPath.replace("target/classes", "src/main/java");
		sourceFolder = sourceFolder.replace("target/test-classes", "src/main/java");

		String basePackage = "com/sb/hyh";
		String packagePath = sourceFolder + basePackage;

		File daoFile = new File(packagePath + "/dao/" + name + "Dao.java");
		createFile(daoFile);
		genericDao(daoFile, entityClass, IDClass);

		File serviceFile = new File(packagePath + "/service/" + name + "Service.java");
		createFile(serviceFile);
		genericService(serviceFile, entityClass, IDClass);

		File controllerFile = new File(packagePath + "/controller/" + name + "Controller.java");
		createFile(controllerFile);
		genericController(controllerFile, entityClass, IDClass);
	}

	private static void genericDao(File file, Class<?> entityClass, Class<?> IDClass) throws IOException {
		PrintWriter pw = new PrintWriter(new FileWriter(file));
		pw.println("package com.sb.hyh.dao;");
		pw.println("");
		pw.println("import " + entityClass.getName() + ";");
		pw.println("import com.sb.hyh.repository.base.GenericDao;");
		pw.println("");
		pw.println("public interface " + file.getName().replace(".java", "") + " extends GenericDao<"
				+ entityClass.getSimpleName() + "," + IDClass.getSimpleName() + "> {");
		pw.println("}");
		pw.flush();
		pw.close();
	}

	private static void genericService(File file, Class<?> entityClass, Class<?> IDClass) throws IOException {
		String CamerName = entityClass.getSimpleName().substring(0, 1).toLowerCase()
				+ entityClass.getSimpleName().substring(1);
		PrintWriter pw = new PrintWriter(new FileWriter(file));
		pw.println("package com.sb.hyh.service;");
		pw.println("");
		pw.println("import " + entityClass.getName() + ";");
		pw.println("import org.springframework.beans.factory.annotation.Autowired;");
		pw.println("import org.springframework.stereotype.Service;");
		pw.println("import com.sb.hyh.service." + entityClass.getSimpleName() + "Service;");
		pw.println("import com.sb.hyh.dao." + entityClass.getSimpleName() + "Dao;");
		pw.println("import com.sb.hyh.service.base.GenericServiceImpl;");
		pw.println("import org.springframework.transaction.annotation.Transactional;");
		pw.println("");
		pw.println("@Service");
		pw.println("@Transactional");
		pw.println("public class " + file.getName().replace(".java", "") + " extends GenericServiceImpl<"
				+ entityClass.getSimpleName() + "," + IDClass.getSimpleName() + "> {");
		pw.println("");
		pw.println("    @Autowired");
		pw.println("    private " + entityClass.getSimpleName() + "Dao " + CamerName + "Dao;");
		pw.println("");
		pw.println("}");
		pw.flush();
		pw.close();
	}

	private static void genericController(File file, Class<?> entityClass, Class<?> IDClass) throws IOException {
		String camelName = entityClass.getSimpleName().substring(0, 1).toLowerCase()
				+ entityClass.getSimpleName().substring(1);
		PrintWriter pw = new PrintWriter(new FileWriter(file));
		pw.println("package com.sb.hyh.controller;");
		pw.println("");
		pw.println("import " + entityClass.getName() + ";");
		pw.println("import org.springframework.beans.factory.annotation.Autowired;");
		pw.println("import com.sb.hyh.service." + entityClass.getSimpleName() + "Service;");
		pw.println("import org.springframework.stereotype.Controller;");
		pw.println("import org.springframework.web.bind.annotation.RequestMapping;");
		pw.println("");
		pw.println("@Controller");
		pw.println("@RequestMapping(\"" + camelName + "\")");
		pw.println("public class " + file.getName().replace(".java", "") + " {");
		pw.println("");
		pw.println("    @Autowired");
		pw.println("    private " + entityClass.getSimpleName() + "Service " + camelName + "Service;");
		pw.println("");
		pw.println("}");
		pw.flush();
		pw.close();
	}
}
