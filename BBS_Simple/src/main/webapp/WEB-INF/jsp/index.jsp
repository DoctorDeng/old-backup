<%--
  Created by IntelliJ IDEA.
  User: Doctor邓
  Date: 2017/4/6
  Time: 20:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="zh">
<head>
    <title>校园论坛-首页</title>
    <jsp:include page="pages/commonHead.jsp"/>
    <link href="${path}/css/index.css" rel="stylesheet">
    <%--<link rel="stylesheet" type="text/css" href="/${path}/css/zzsc-demo.css">--%>
</head>
<body>
<jsp:include page="pages/header.jsp"/>

<div style="width: 100%;">
    <!--  首页轮播大图 -->
  <%-- <jsp:include page="pages/carouselPicture.jsp"  />--%>

    <div class="container" style="margin-top: 30px;">
        <div class="row">
            <div class="col-md-9">
                <ul class="list-group">
                    <div class="list-group-item active">
                        论坛新帖
                        <a href="${requestScope.path}/topic/topic/search?type=all"
                           style="float: right;color: white">更多>></a>
                        <!--<p style="float: right"></p>-->
                    </div>

                    <c:forEach items="${requestScope.topics_new}" var="topic_new">
                        <jsp:include page="pages/simpleTopicItem.jsp">
                            <jsp:param name="topic_id"           value="${topic_new.topic_id}" />
                            <jsp:param name="forum_name"         value="${topic_new.forum_name}" />
                            <jsp:param name="topic_title"        value="${topic_new.topic_title}" />
                            <jsp:param name="topic_ico"          value="new" />
                            <jsp:param name="view_num"           value="${topic_new.view_num}" />
                            <jsp:param name="reply_num"          value="${topic_new.reply_num}" />
                            <jsp:param name="publish_time"       value="${topic_new.publish_time}" />
                        </jsp:include>
                    </c:forEach>
                    <!-- 帖子 -->
             <%--       <a href="<%=request.getContextPath()%>/pages/post.jsp?postId=&&page=1"
                       class="list-group-item">
                        <h4 class="list-group-item-heading" >[板块名称]</h4>
                        帖子标题<span class="topic-ico"><img src="${path}/img/topic_new.png"></span>
                        <p class="text-right" style="float: right;margin-right: 20px">浏览量:333&nbsp;评论量:3333&nbsp;发表日期:2017-20-20
                            20:20:20</p>
                    </a>--%>
                </ul>
            </div>
            <!-- 论坛公告 -->
            <jsp:include page="pages/notice.jsp" />

            <div class="row">
                <div class="col-md-9" style="margin-left: 15px;">
                    <ul class="list-group" style="margin-right: 20px;">
                        <div class="list-group-item active">
                            精华帖
                            <a href="${requestScope.path}/topic/topic/search?type=best"
                               style="float: right;color: white">更多>></a>
                        </div>
                        <c:forEach items="${requestScope.topics_best}" var="topic_new">
                            <jsp:include page="pages/simpleTopicItem.jsp">
                                <jsp:param name="topic_id"           value="${topic_new.topic_id}" />
                                <jsp:param name="forum_name"         value="${topic_new.forum_name}" />
                                <jsp:param name="topic_title" value="${topic_new.topic_title}" />
                                <jsp:param name="topic_ico"          value="hot" />
                                <jsp:param name="view_num"           value="${topic_new.view_num}" />
                                <jsp:param name="reply_num"          value="${topic_new.reply_num}" />
                                <jsp:param name="publish_time"       value="${topic_new.publish_time}" />
                            </jsp:include>
                        </c:forEach>
                    </ul>
                </div>
            </div>
            <!-- 板块信息 -->
           <%-- <h3 style="margin-top: 20px;margin-left: 15px">板块分类</h3>
            <hr/>
            <div class="container">
                <div class="row">
                    <div class="col-md-3 col-sm-12" style="margin-top: 20px;">
                        <a href="">
                            <div class="btn btn-primary btn-lg"><h3>主板块名称</h3></div>
                        </a>
                    </div>
                </div>
            </div>--%>
            <!-- 板块信息 -->
            <jsp:include page="pages/forum.jsp" />
        </div>
    </div>
</div>


<jsp:include page="pages/bottom.jsp"/>
</body>
<jsp:include page="pages/commonJs.jsp"/>
</html>
