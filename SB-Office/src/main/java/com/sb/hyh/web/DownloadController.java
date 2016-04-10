package com.sb.hyh.web;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sb.hyh.utils.ExcelUtil;
import com.sb.hyh.vo.Project;

@Controller
public class DownloadController {
	@RequestMapping("index")
	public String index() {
		return "index";
	}

	@RequestMapping(value = "download")
	@ResponseBody
	public void download(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String fileName = "excel文件";
		List<Project> projects = createData();
		List<Map<String, Object>> list = createExcelRecord(projects);
		String columnNames[] = { "ID", "项目名", "销售人", "负责人", "所用技术", "备注" };
		String keys[] = { "id", "name", "saler", "principal", "technology", "remarks" };

		ByteArrayOutputStream os = new ByteArrayOutputStream();
		try {
			ExcelUtil.createWorkBook(list, keys, columnNames).write(os);
		} catch (IOException e) {
			e.printStackTrace();
		}
		byte[] content = os.toByteArray();
		InputStream is = new ByteArrayInputStream(content);
		response.reset();
		response.setContentType("application/vnd.ms-excel;charset=utf-8");
		response.setHeader("Content-Disposition",
				"attachment;filename=" + new String((fileName + ".xls").getBytes(), "iso-8859-1"));

		ServletOutputStream out = response.getOutputStream();
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			bis = new BufferedInputStream(is);
			bos = new BufferedOutputStream(out);
			byte[] buff = new byte[2048];
			int bytesRead;
			while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
				bos.write(buff, 0, bytesRead);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bis != null) {
				bis.close();
			}
			if (bos != null) {
				bos.close();
			}
		}
	}

	private List<Project> createData() {
		List<Project> list = new LinkedList<Project>();
		Project project = new Project();
		project.setId(1);
		project.setName("hong");
		project.setRemarks("2");
		project.setTechnology("java");
		list.add(project);
		return list;
	}

	private List<Map<String, Object>> createExcelRecord(List<Project> projects) {
		List<Map<String, Object>> listmap = new LinkedList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sheetName", "sheet1");
		listmap.add(map);
		for (int j = 0; j < projects.size(); j++) {
			Map<String, Object> mapValue = new HashMap<String, Object>();
			Project project = projects.get(j);
			mapValue.put("id", project.getId());
			mapValue.put("name", project.getName());
			mapValue.put("technology", project.getTechnology());
			mapValue.put("remarks", project.getRemarks());
			listmap.add(mapValue);
		}
		return listmap;
	}
}