package com.sb.hyh.web;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class FileToolController {

	@RequestMapping("/")
	public String index(Model model) {
		return "index";
	}

	@RequestMapping(value = "/customerFile", method = RequestMethod.POST)
	public void uploadFile(HttpServletResponse response, HttpServletRequest request,
			@RequestParam(value = "file", required = false) MultipartFile file) throws IOException {
		response.setCharacterEncoding("UTF-8");
		String ctxPath = request.getSession().getServletContext().getRealPath("/") + "\\uploads\\";
		System.out.println(ctxPath);
		File tempFile = new File(ctxPath);
		if (!tempFile.exists()) {
			tempFile.mkdirs();
		}

		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
		for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
			MultipartFile mf = entity.getValue();
			String fileName = mf.getOriginalFilename();
			File uploadFile = new File(ctxPath + fileName);
			try {
				FileCopyUtils.copy(mf.getBytes(), uploadFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}