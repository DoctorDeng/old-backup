<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="${pageContext.request.contextPath}/resource/js/jquery-1.11.3.min.js"></script>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/test.css">
<script type="text/javascript">

	function test() {
		$.ajax({
			type : 'post',
			url : '${pageContext.request.contextPath}/springTest/ajaxTest.do',
			data : {name: $("#name").val(),age : $("#age").val()},
			success : function(data) {
				alert(data);
			}
		});
	}
	function testJson(){
		$.ajax({
			type : 'post',
			url : '${pageContext.request.contextPath}/json/jsonTest.do',
			dataType: "json",
			success : function(data) {
				$("p").html(data.message);
				var persons = data.persons;
				var result = "";
				for (var i=0; i<persons.length; i++) {
					result = result + "姓名:"+ persons[i].name +"年龄:"+persons[i].age+"性别:"+persons[i].sex+"<br/>";	
				}
				$("h5").html(result);
			}
		});
	}
</script>
</head>
<body>
	<h1>测试Resetful风格</h1>
	<a href="${pageContext.request.contextPath}/springTest/resetTest/1.do">测试一</a>
	<a href="${pageContext.request.contextPath}/springTest/resetTest/2.do">测试二</a>
	<a href="${pageContext.request.contextPath}/springTest/resetTest/3.do">测试三</a>
	<h1>测试重定向和内部转发</h1>
	<a href="${pageContext.request.contextPath}/controllerTest/hello.do">测试重定向</a>
	<a href="${pageContext.request.contextPath}/controllerTest/hello3.do">测试内部转发</a>
	<h1>测试Ajax</h1>
	姓名:<input type="text" id="name" />
	年龄:<input type="text" id="age" />
	<input type="button" value="开始测试" onclick="test()"/>
	<input type="button" value="测试Json" onclick="testJson()"/>
	<p></p>
	<h5></h5>
	
</body>
</html>