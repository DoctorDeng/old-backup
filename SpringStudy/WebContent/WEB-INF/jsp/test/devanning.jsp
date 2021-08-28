<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
	<h1>名称:${requestScope.person.name}</h1>
	<h1>年龄:${requestScope.person.age}</h1>
	<h1>性别:${requestScope.person.sex}</h1>
	<h1>信息:${requestScope.hello}</h1>
</body>
</html>