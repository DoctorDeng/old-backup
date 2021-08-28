<%--
  Created by IntelliJ IDEA.
  User: Doctor邓
  Date: 2017/4/8
  Time: 10:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="zh">
<head>
    <title>校园论坛-搜索</title>
    <jsp:include page="../pages/commonHead.jsp"/>
    <link href="${path}/css/search-result.css" rel="stylesheet">
</head>
<body>
<jsp:include page="../pages/header.jsp"/>
<div class="list-group search-list">
    <a href="#" class="list-group-item active">
        <!-- 提示 -->
        <c:if test="${empty requestScope.page.resultList}">
            抱歉！没有帖子
        </c:if>
        <c:if test="${!empty requestScope.page.resultList}">
            帖子列表如下:
        </c:if>
    </a>

    <c:forEach items="${requestScope.page.resultList}" var="topic_search">
        <jsp:include page="../pages/simpleTopicItem.jsp">
            <jsp:param name="topic_id"           value="${topic_search.topic_id}" />
            <jsp:param name="forum_name"         value="${topic_search.forum_name}" />
            <jsp:param name="topic_title"        value="${topic_search.topic_title}" />
            <jsp:param name="topic_ico"          value="none" />
            <jsp:param name="view_num"           value="${topic_search.view_num}" />
            <jsp:param name="reply_num"          value="${topic_search.reply_num}" />
            <jsp:param name="publish_time"       value="${topic_search.publish_time}" />
        </jsp:include>
    </c:forEach>
<%--    <!-- 帖子 -->
    <a href="#" class="list-group-item">
        <h4 class="list-group-item-heading">
            [主板块名称]
        </h4>
        帖子标题&nbsp;[直属板块标题]
        <p class="text-right post-date">浏览量:3333&nbsp;评论量:33333&nbsp;发表日期:2017-06-05 02:30:30</p>
    </a>--%>
</div>


<!-- 分页区 -->
<ul class="pagination pagination-lg page-float">
<%--    <li class=""><a href="">首页</a></li>
    <li><a href="">上一页</a></li>
    <!-- 其他页-->
    <li><a href="">444</a></li>
    <!-- 当前页 -->
    <li class="active"><a href="" >3333</a></li>
    <!-- 其他页-->
    <li><a href="">22</a></li>
    <li><a href="">下一页</a></li>
    <li class="disabled"><a href="">尾页</a></li>--%>
    <c:if test="${!empty requestScope.page.resultList}">
        <c:if test="${requestScope.page.currPage == requestScope.page.indexPage}">
            <li class="disabled"><a href="#">首页</a></li>
        </c:if>
        <c:if test="${requestScope.page.currPage != requestScope.page.indexPage}">
            <li>
                <a href="${requestScope.path}/topic/topic/search?currPage=${requestScope.page.indexPage}&pageSize=${requestScope.page.pageSize}&keywords=${requestScope.keywords}&forum_id=${requestScope.forum_id}&type=${requestScope.type}">首页</a>
            </li>
        </c:if>

        <c:if test="${requestScope.page.currPage == requestScope.page.indexPage}">
            <li><a class="disabled" href="#">上一页</a></li>
        </c:if>
        <c:if test="${requestScope.page.currPage != requestScope.page.indexPage}">
            <li>
                <a href="${requestScope.path}/topic/topic/search?currPage=${requestScope.page.previousPage}&pageSize=${requestScope.page.pageSize}&keywords=${requestScope.keywords}&forum_id=${requestScope.forum_id}&type=${requestScope.type}">上一页</a>
            </li>
        </c:if>

        <c:forEach items="${requestScope.page.navigatePages}" var="navigate">
            <c:if test="${requestScope.page.currPage == navigate}">
                <li class="active"><a
                        href="${requestScope.path}/topic/topic/search?currPage=${navigate}&pageSize=${requestScope.page.pageSize}&keywords=${requestScope.keywords}&forum_id=${requestScope.forum_id}&type=${requestScope.type}">${navigate}</a>
                </li>
            </c:if>
            <c:if test="${requestScope.page.currPage != navigate}">
                <li>
                    <a href="${requestScope.path}/topic/topic/search?currPage=${navigate}&pageSize=${requestScope.page.pageSize}&keywords=${requestScope.keywords}&forum_id=${requestScope.forum_id}&type=${requestScope.type}">${navigate}</a>
                </li>
            </c:if>
        </c:forEach>

        <c:if test="${requestScope.page.currPage == requestScope.page.endPage}">
            <li><a class="disabled" href="#">下一页</a></li>
        </c:if>
        <c:if test="${requestScope.page.currPage != requestScope.page.endPage}">
            <li>
                <a href="${requestScope.path}/topic/topic/search?currPage=${requestScope.page.nextPage}&pageSize=${requestScope.page.pageSize}&keywords=${requestScope.keywords}&forum_id=${requestScope.forum_id}&type=${requestScope.type}">下一页</a>
            </li>
        </c:if>

        <c:if test="${requestScope.page.currPage == requestScope.page.endPage}">
            <li class="disabled"><a href="#">尾页</a></li>
        </c:if>
        <c:if test="${requestScope.page.currPage != requestScope.page.endPage}">
            <li>
                <a href="${requestScope.path}/topic/topic/search?currPage=${requestScope.page.endPage}&pageSize=${requestScope.page.pageSize}&keywords=${requestScope.keywords}&forum_id=${requestScope.forum_id}&type=${requestScope.type}">尾页</a>
            </li>
        </c:if>
    </c:if>
</ul>

<jsp:include page="../pages/bottom.jsp">
    <jsp:param name="buttom_type" value="bottom_fixed" />
</jsp:include>
</body>
<jsp:include page="../pages/commonJs.jsp"/>
</html>
