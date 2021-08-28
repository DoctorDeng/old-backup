package vip.doctordeng.bbs.common;

import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;
import vip.doctordeng.bbs.common.constant.FileConstant;
import vip.doctordeng.bbs.common.enums.FileTypeEnum;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * 
 * @ClassName:  FileUtil   
 * @Description:TODO 文件操作工作类
 * @author: DoctorDeng
 * @date:   2017年2月27日 下午9:38:31   
 * @Blog: 
 *
 */
public class FileUtil {
	private static String getFileAbsoluteDir(FileTypeEnum fileTypeEnum, HttpServletRequest request) {
		return getAbsolutePath(request, getFileRelativeDir(fileTypeEnum));
	}

	private static String getFileRelativeDir(FileTypeEnum fileTypeEnum){
		if (fileTypeEnum == FileTypeEnum.UserIco) return FileConstant.PATH_UPLOAD_USER_ICO;
		else return FileConstant.PATH_UPLOAD_OTHER;
	}

	private static String getAbsolutePath(HttpServletRequest request, final String path) {
		return request.getSession().getServletContext().getRealPath(path);
	}

	private static String getFileRelativePath(final String fileName, FileTypeEnum fileTypeEnum) {
		return getFileRelativeDir(fileTypeEnum) + FileConstant.SEPARATOR + fileName;
	}

	private static String getFileAbsolutePath(final String fileName, FileTypeEnum fileTypeEnum, HttpServletRequest request){
		return getFileAbsoluteDir(fileTypeEnum, request) + FileConstant.SEPARATOR + fileName;
	}
	private static String getFileName(final String fileSuffix){
		return UUID.randomUUID().toString() + "." + fileSuffix;
	}

	public static String uploadFileByMVC(MultipartFile file, HttpServletRequest request, FileTypeEnum fileTypeEnum) throws IOException {
		if (null == file || file.isEmpty()) return "";

		final String fileName = getFileName(getFileSuffix(file.getOriginalFilename()));
		final String fileRelativePath = getFileRelativePath(fileName, fileTypeEnum);
		final String fileAbsolutePath = getFileAbsolutePath(fileName, fileTypeEnum, request);
		saveFile(file.getInputStream(), fileAbsolutePath);
		return fileRelativePath;
	}

	private static String getFileSuffix(String originalFilename) {
		String fileSuffix = "";
		if (null == originalFilename || originalFilename.length() == 0) {
			return fileSuffix;
		}
		// 通过 split 分割来获取文件后缀
		if (originalFilename.contains(".")) {
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
	private static void saveFile(InputStream inputStream, String filePath) throws IOException {
		FileUtils.copyInputStreamToFile(inputStream, new File(filePath));
	}
}
