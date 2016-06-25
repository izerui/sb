package com.sb.hyh.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class FreeMarkerUtil {
    private static String freemarkerPath = "src/main/resources/templates/";

    public static void createFile(String fileName) {
        try {
            File file = new File(fileName);
            file.delete();
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void generate(String fileName, String content) {
        try {
            createFile(fileName);
            PrintWriter pw = new PrintWriter(new FileWriter(fileName));
            pw.println(content);
            pw.flush();
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getContent(Map<?, ?> map, String templateName) {
        try {
            Configuration cfg = new Configuration();
            Template tpl = cfg.getTemplate(freemarkerPath + templateName);
            return FreeMarkerTemplateUtils.processTemplateIntoString(tpl, map);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
