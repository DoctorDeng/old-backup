<%--
  Created by IntelliJ IDEA.
  User: Doctor邓
  Date: 2017/4/8
  Time: 9:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container">
    <div class="row" style="margin-top: 5px">
        <div class="col-md-1">
        </div>
        <div class="col-md-2 reply-head">
            <img alt="" class="img-responsive img-circle" src="${requestScope.path}/${param.user_ico_url}"
                 style="margin:1px 1px;width: 120px;height: 120px;margin: 30px auto;"/>
            <span class="">
              <span class="" style="margin-top: 5px;font-size: 18px;color: rgb(201,105,30);">${param.user_name}</span>
            </span><br/><br/>
            <%--<span class="user-info">
              <span class="badge" style="background: #2ecc71;margin-top: 5px">性别:</span>
              <span class="badge" style="background: #2ecc71;margin-top: 5px">${param.user_sex}</span>
            </span><br/>--%>
       <%--     <span class="user-info">
              <span class="badge" style="background: #ff6927;margin-top: 5px">论坛等级</span>:
              <span class="badge" style="background: #ff6927;margin-top: 5px">LV33</span>
            </span>--%>
            <span class="" style="font-size: 1px;color: rgb(153,153,156);">
                <span class="" style="margin-top: 5px;font-size: 10px;color: red;">个性签名:</span>
                ${param.user_introduction}
            </span>
            <br>
        </div>
        <div class="col-md-8 reply-content">
            <div class="reply-time">
                <span style="color: gray">回复于:${param.publish_time}</span>
                <c:choose>
                    <c:when test="${param.reply_floor == 1}">
                        <span class="badge" style="float:right;margin-right:10px;background: #ff6927;width: 50px;">沙发</span>
                    </c:when>
                    <c:when test="${param.reply_floor == 2}">
                        <span class="badge" style="float:right;margin-right:10px;background: #ff5959;width: 50px;">板凳</span>
                    </c:when>
                    <c:when test="${param.reply_floor == 3}">
                        <span class="badge" style="float:right;margin-right:10px;background: #4b9ded;width: 50px;">地板</span>
                    </c:when>
                    <c:otherwise>
                        <span class="badge"
                                style="float:right;margin-right:10px;background: #4b9ded;width: 50px;">${param.reply_floor}楼</span>
                    </c:otherwise>
                </c:choose>
            </div>
            <div style="margin: 20px;">
                ${param.publish_content}
            </div>
        </div>
        <!--  <div class="col-md-1 reply-border">
        </div> -->
    </div>
</div>
