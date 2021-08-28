<%--
  Created by IntelliJ IDEA.
  User: Doctor邓
  Date: 2017/4/7
  Time: 8:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="utf-8"  %>
<div class="list-group search-list">
    <a href="#" class="list-group-item active">

        <!-- 搜索到的提示-->
        搜索结果如下：
        <!-- 未搜索到的提示-->
        抱歉！未找到符合的结果
    </a>

    <!-- 搜索到的帖子列表-->
    <a href="${param.topic_id}" class="list-group-item">
        <h4 class="list-group-item-heading">
            <!-- 所属板块名称 -->
            [${param.forum_name}]
        </h4>
        ${param.topic_simple_title}...
        <p class="text-right post-date">浏览量:${param.view_num}&nbsp;评论量:${param.reply_num}&nbsp;发表日期:${param.publish_time}</p>
    </a>
</div>