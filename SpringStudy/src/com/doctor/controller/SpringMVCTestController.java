package com.doctor.controller;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * 练习 SpringMVC 的使用
 * @author Doctor邓
 *
 */
@Controller
public class SpringMVCTestController {
	private Logger log = Logger.getLogger(SpringMVCTestController.class);
	@RequestMapping(value="/admin", method=RequestMethod.GET, params = "add")
	public String doSave() {
		log.debug("正在保存！");
		 
		return "";
	}
	@RequestMapping("/uploadFile")
	public String uploadFile() {
		return "uploadFile";
	}
	@RequestMapping(value="/upload", method=RequestMethod.POST)
	public String uploadFile(@RequestParam("testFile")MultipartFile file) {
		System.out.println("文件 ContentType:" + file.getContentType());
		System.out.println("文件 name:" + file.getName());
		System.out.println("文件 originalFileName:" + file.getOriginalFilename());
		System.out.println("文件 size:" + file.getSize());
		
		//TODO 将文件保存到服务器磁盘上
		final String serverFilePath = "D:";
		//1、使用 FileUtils 工具类对文件进行存储
		try {
			FileUtils.copyInputStreamToFile(file.getInputStream(), 
					 new File(serverFilePath + "\\" + System.currentTimeMillis() + file.getOriginalFilename()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}
}
