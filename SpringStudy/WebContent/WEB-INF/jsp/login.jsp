<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
	<p>返回的消息：${requestScope.resultMessage}</p>
	<form action="${pageContext.request.contextPath}/user/login.do" method="post">
		<h5>用戶名:</h5><input type="text" name="userName"  value="${requestScope.user.userName}"/> 
		<h5>密    碼:</h5><input type="password" name="password" value="${requestScope.user.password}"/>
		<h5>${requestScope.errorMessage}</h5>
		<input type="submit" value="提交" />
	</form>
</body>
</html>