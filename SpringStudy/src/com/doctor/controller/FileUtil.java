package com.doctor.controller;

public class FileUtil {
	public static String getFileSuffix(String originalFilename) {
		String fileSuffix = "";
		if (null == originalFilename || originalFilename.length() == 0) {
			return fileSuffix;
		}
		// 通过 split 分割来获取文件后缀
		if (originalFilename.indexOf(".") != -1) {
			String[] temps = originalFilename.split("\\.");
			fileSuffix = temps[temps.length - 1];
			return fileSuffix;
		}
		// 通过 substring 截取来获取文件后缀
	/*	int begin  = originalFilename.lastIndexOf(".");
		if (begin != -1) {
			fileSuffix = fileSuffix.substring(begin + 1);
		}*/
		return fileSuffix;
	}
}
