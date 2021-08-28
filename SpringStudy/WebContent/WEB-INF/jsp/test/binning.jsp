<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>通过自动装箱、拆箱方式实现前后台交互</h1>
	<form method="post" action="../springTest/getPerson.do">
	 	<p>姓名:<input type="text" name="name" /></p>
		<p>年龄:<input type="text" name="age" /></p>
		<p>性别:<input type="text" name="sex" /></p>
		<p><input type="submit" value="提交" /></p>
	</form>
	<h1>通过HttpServletRequest注入值获取</h1>
	<form method="post" action="../springTest/inputPersonToServlet.do">
	 	<p>姓名:<input type="text" name="name" /></p>
		<p>年龄:<input type="text" name="age" /></p>
		<p>性别:<input type="text" name="sex" /></p>
		<p><input type="submit" value="提交" /></p>
	</form>
	<h1>通过和表单name设置相同的名称作为方法的参数，即可自动注入表单的值。</h1>
	<form method="post" action="../springTest/inputPersonByParameter.do">
	 	<p>姓名:<input type="text" name="name" /></p>
		<p>年龄:<input type="text" name="age" /></p>
		<p>性别:<input type="text" name="sex" /></p>
		<p><input type="submit" value="提交" /></p>
	</form>
	<h1>通过@RequestParam注解指定表单中提交的参数名称注入给自定方法参数</h1>
	<form method="post" action="../springTest/inputPersonAnnotation.do">
	 	<p>姓名:<input type="text" name="username" /></p>
		<p>年龄:<input type="text" name="age" /></p>
		<p>性别:<input type="text" name="sex" /></p>
		<p><input type="submit" value="提交" /></p>
	</form>
	<h1>通过Model返回多个值</h1>
	<form method="post" action="../springTest/getPersonByModel.do">
	 	<p>姓名:<input type="text" name="name" /></p>
		<p>年龄:<input type="text" name="age" /></p>
		<p>性别:<input type="text" name="sex" /></p>
		<p><input type="submit" value="提交" /></p>
	</form>
	<h1>通过ModelAndView后台向前台传值</h1>
	<form method="post" action="../springTest/getPersonByModelView.do">
	 	<p>姓名:<input type="text" name="name" /></p>
		<p>年龄:<input type="text" name="age" /></p>
		<p>性别:<input type="text" name="sex" /></p>
		<p><input type="submit" value="提交" /></p>
		<input type="date" value="日期" />
	</form>
</body>
</html>