<%--
  Created by IntelliJ IDEA.
  User: Doctor邓
  Date: 2017/4/8
  Time: 9:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container" style="margin-top: 50px">
    <div class="row">
        <div class="col-md-1">
        </div>
        <div class="col-md-2 post-head" name="post_head">
            <img alt="" class="img-responsive img-circle" src="${requestScope.path}/${param.user_ico_url}"
                 style="margin:1px 1px;width: 120px;height: 120px;margin: 30px auto;"/>
            <span class="">
              <span class="" style="margin-top: 5px;font-size: 18px;color: rgb(201,105,30);">${param.user_name}</span>
            </span><br/><br/>
            <%--<span class="user-info">
              <span class="badge" style="background: #2ecc71;margin-top: 5px">性别:</span>
              :<span class="badge" style="background: #2ecc71;margin-top: 5px">${param.user_sex}</span>
            </span><br/>--%>
            <%--<span class="user-info">
              <span class="badge" style="background: #ff6927;margin-top: 5px">论坛等级</span>:
              <span class="badge" style="background: #ff6927;margin-top: 5px">LV333</span>
            </span>--%>
            <span class="" style="font-size: 1px;color: rgb(153,153,156);">
                <span class="" style="margin-top: 5px;font-size: 10px;color: red;">个性签名:</span>
                ${param.user_introduction}
            </span>
        </div>
        <div class="col-md-8 post-content" name="post_content">
            <div class="post-title">
                <h3 style="margin-left:20px;color:black">[${param.forum_name}]${param.topic_title}</h3>
                <div style="margin-left:20px">
                    <span class="glyphicon glyphicon-comment"></span>
                    <!-- 帖子回复数-->
                    &nbsp;&nbsp;${param.reply_num}&nbsp;|&nbsp;
                    <span>发表于:${param.publish_time}</span>

                    <!-- 楼主独有编辑 -->
                    <a style="float:right;margin-right: 20px;"
                       href="${param.topic_id}">编辑</a>
                </div>
                <strong style=" float:right;margin-right:10px;margin-top: 10px">
                    <span class="badge" style="background: #ff6927;width: 50px;">楼主</span></strong>
            </div>
            <div style="margin: 20px">
                ${param.publish_content}
            </div>
        </div>
        <!--   <div class="col-md-1 post-border">
        </div> -->
    </div>
</div>