<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>登录成功</h1>
	<h3>用户ID: ${sessionScope.user.userId}</h3>
	<h3>用 户名: ${sessionScope.user.userName}</h3>
	<h3>密     码: ${sessionScope.user.password}</h3>
</body>
</html>