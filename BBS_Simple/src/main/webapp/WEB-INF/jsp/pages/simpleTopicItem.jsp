<%--
  Created by IntelliJ IDEA.
  User: Doctor邓
  Date: 2017/4/7
  Time: 8:32
  TODO: 帖子简略信息模板
  rely on: 依赖 search-result.css，必须放在 <div class="list-group"> 或 <ul class="list-group"> 中
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"   pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- 搜索到的帖子列表-->
<a href="${requestScope.path}/topic/${param.topic_id}" class="list-group-item">
    <h4 class="list-group-item-heading" style="color: rgb(56,147,235);">
        <!-- 所属板块名称 -->
        [${param.forum_name}]
    </h4>
    ${param.topic_title}

    <span class="topic-ico">
        <c:if test="${param.topic_ico == 'new'}">
            <img src="${path}/img/topic_new.png">
        </c:if>
        <c:if test="${param.topic_ico == 'hot'}">
            <img src="${path}/img/topic_hot.gif">
        </c:if>
    </span>

    <p class="text-right post-date">浏览量:${param.view_num}&nbsp;评论量:${param.reply_num}&nbsp;发表日期:${param.publish_time}</p>
</a>
