<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- enctype="multipart/form-data" 告诉表单要使用文件上传所需的一种特殊类型编码，会影响提交表单时如何打包和发送POST数据  -->
	<form enctype="multipart/form-data"  action="${pageContext.request.contextPath}/springTest/testUploadFile.do" method="post">
		上传文件:<input type="file" name="file" />
		<input type="submit" value="提交">
	</form>
</body>
</html>