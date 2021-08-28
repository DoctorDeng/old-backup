<%--
  Created by IntelliJ IDEA.
  User: Doctor邓
  Date: 2017/4/7
  Time: 9:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- 板块信息 -->
<h3 style="margin-top: 20px;margin-left: 15px">板块分类</h3>
<hr/>
<div class="container">
    <div class="row">
        <c:forEach items="${requestScope.forums}" var="forum">
            <div class="col-md-3 col-sm-12" style="margin-top: 20px;">
                <a href="${requestScope.path}/topic/topic/search?forum_id=${forum.forum_id}&type=forum">
                    <div class="btn btn-primary btn-lg"><h3>${forum.forum_name}</h3></div>
                </a>
            </div>
        </c:forEach>
    </div>
</div>
