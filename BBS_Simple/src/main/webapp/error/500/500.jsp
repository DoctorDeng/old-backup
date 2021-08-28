<%--
  Created by IntelliJ IDEA.
  User: Doctor邓
  Date: 2017/4/25
  Time: 14:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>出错了, 在努力抢修中！</title>
    <link rel="SHORTCUT ICON" href="<%=request.getContextPath()%>/img/ico/school.ico">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/error/500/css/style.css"/>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/error/500/css/base.css"/>
</head>

<body>
<div id="errorpage">
    <div class="tfans_error">
        <div class="logo"></div>
        <div class="errortans clearfix">
            <div class="e404"></div>
            <p><b>出错啦！</b></p>
            <p>在努力抢修中</p>
            <div class="bt" ><a href="<%=request.getContextPath()%>/index">返回首页</a></div>
        </div>
    </div>
</div>

<%--<!-- xmoban.cn 提示文本 实际使用请删除 -->
<div style="padding:20px 0;margin-top:30px;">

    <div style="margin-bottom:30px;text-align:center;"><a href="http://www.xmoban.cn/">X模版</a> | <a href="http://www.xmoban.cn/404-Template">404页面模版</a> | <a href="http://www.xmoban.cn/management-Template">管理后台模版</a> | <a href="http://www.xmoban.cn/Package">打包下载</a> | <a href="http://www.xmoban.cn/Custom-design">定制设计</a></div>
</div>--%>
<!-- /xmoban.cn -->
</body>
</html>
