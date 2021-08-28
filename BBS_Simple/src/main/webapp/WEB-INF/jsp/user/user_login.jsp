<%--
  Created by IntelliJ IDEA.
  User: Doctor邓
  Date: 2017/4/7
  Time: 13:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="zh">
<head>
    <title>校园论坛-登录</title>
    <jsp:include page="../pages/commonHead.jsp"/>
    <link href="${path}/css/login.css" rel="stylesheet">
</head>
<body>
<jsp:include page="../pages/header.jsp"/>

<div class="login">
    <form id="form_login" role="form" action="${requestScope.path}/user/doLogin" method="post">
        <div class="form-group text-center">
            <h3>校园论坛-登录</h3>
        </div>
        <div class="form-group">
            <div class="input-group">
                <span class="input-group-addon"><i class="fa fa-user fa-lg"></i></span>
                <input type="text" class="form-control  input-lg" id="user_account" name="user_account" placeholder="账号">
            </div>
        </div>
        <br>
        <div class="form-group">
            <div class="input-group">
                <span class="input-group-addon"><i class="fa fa-lock fa-lg"></i></span>
                <input type="password" class="form-control  input-lg" id="user_password" name="user_password" placeholder="密码">
            </div>
        </div>
        <p style="color: red;">&nbsp;${requestScope.message_login}</p>
        <button type="submit" class="btn btn btn-success btn-lg btn-block">
            <i class="fa fa-sign-in" aria-hidden="true"></i>登录
        </button>
        <br>
        <div class="form-group text-center">
            <a href="${requestScope.path}/user/register">注册论坛账号</a> |
            <a href="#">忘记密码?</a>
        </div>
    </form>
</div>

<jsp:include page="../pages/bottom.jsp">
    <jsp:param name="buttom_type" value="bottom_fixed" />
</jsp:include>
</body>
<jsp:include page="../pages/commonJs.jsp"/>
</html>
