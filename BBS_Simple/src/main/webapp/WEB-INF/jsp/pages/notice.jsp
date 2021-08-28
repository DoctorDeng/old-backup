<%--
  Created by IntelliJ IDEA.
  User: Doctor邓
  Date: 2017/4/7
  Time: 9:10
  TODO: 论坛公告模板
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="utf-8"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="col-md-3 ${param.custom_class}" style="${param.custom_style}">
    <ul class="list-group">
        <div class="list-group-item active">论坛公告</div>
        <c:forEach items="${requestScope.notices}" var="notice">
            <a href="${requestScope.path}/topic/${notice.topic_id}" class="list-group-item">${notice.topic_title}</a>
        </c:forEach>
    </ul>
    <c:if test="${!empty sessionScope.user}">
        <c:if test="${sessionScope.user.user_type == 1}">
            <a href="${requestScope.path}/user/post" >
                <button type="button" class="btn btn-success" style="width: 200px;height:50px;margin-left: 30px">我要发帖</button>
            </a>
        </c:if>
        <c:if test="${sessionScope.user.user_type == 2}">
            <a href="${requestScope.path}/manage/addNotice" >
                <button type="button" class="btn btn-success" style="width: 200px;height:50px;margin-left: 30px">发布公告</button>
            </a>
        </c:if>
    </c:if>
</div>
