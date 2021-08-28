<%--
  Created by IntelliJ IDEA.
  User: Doctor邓
  Date: 2017/4/7
  Time: 13:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="zh">
<head>
    <title>校园论坛-提示</title>
    <jsp:include page="../pages/commonHead.jsp"/>
    <link href="${path}/css/point.css" rel="stylesheet">
</head>
<body>
<jsp:include page="../pages/header.jsp"/>

<div class="regist">
    <div class="container">
        <br> <br>
        <div class="row">
            <div class="col-md-4"></div>
            <div class="col-sm-4 col-md-7">
                <img src="${path}/img/point/${requestScope.point_ico}" class="img-circle" alt="" style="width: 200px;height: 200px;">
            </div>
        </div>
        <br> <br><br> <br>

        <div class="row text-center">
            <div class="col-md-1"></div>
            <div class="col-sm-4 col-md-8" style="font-size: 20px; color: red;">${requestScope.point_text}</div>
        </div>
        <br> <br>
        <div class="row">
            <div class="col-md-2"></div>
            <div class="col-sm-4 col-md-7">
                <div class="col-md-11">
                    <button class="btn btn-success btn-block btn-lg" onclick="toURL()">
                        <i class="fa fa-sign-in" aria-hidden="true"></i>${requestScope.point_button}
                    </button>
                </div>
            </div>
        </div>
    </div>
</div>

<jsp:include page="../pages/bottom.jsp">
    <jsp:param name="buttom_type" value="bottom_fixed"/>
</jsp:include>
</body>
<jsp:include page="../pages/commonJs.jsp"/>
<script type="text/javascript">
    function toURL() {
        window.location = "${requestScope.path}/${requestScope.point_url}";
    }
</script>
</html>
