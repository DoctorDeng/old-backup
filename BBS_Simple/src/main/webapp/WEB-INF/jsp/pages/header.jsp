<%--
  Created by IntelliJ IDEA.
  User: Doctor邓
  Date: 2017/4/6
  Time: 19:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="utf-8"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- navbar-fixed-top 导航条固定在顶部 -->
<nav class="navbar navbar-inverse" role="navigation">
    <div class="navbar-header">
        <a class="navbar-brand" href="#">校园论坛</a>
    </div>

    <div>
        <ul class="nav navbar-nav">
            <li><a href="${requestScope.path}/index">首页</a></li>
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                    精选板块 <b class="caret"></b>
                </a>
                <ul class="dropdown-menu">
                    <!-- 板块下拉列表-->
                    <li class="divider"></li> <!--分割线 -->
                    <li><a href="#">板块名称1</a></li>
                    <li class="divider"></li>
                    <li><a href="#">板块名称2</a>
                    </li>
                </ul>
            </li>
           <%-- <li><a href="${requestScope.path}/topic/topic/search?type=">论坛热帖</a></li>--%>
            <li><a href="${requestScope.path}/topic/topic/search?type=all">论坛新帖</a></li>
            <li><a href="${requestScope.path}/topic/topic/search?type=best">精华帖</a></li>
        </ul>
    </div>

    <c:if test="${!empty sessionScope.user}">
        <c:if test="${sessionScope.user.user_type == 1}">
            <ul class="nav navbar-nav navbar-right user">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            ${sessionScope.user.user_name}<b class="caret"></b>
                            <img style="width: 30px;height: 30px;" src="${requestScope.path}/${sessionScope.user.user_ico_url}">
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="${requestScope.path}/user/setting">资料修改</a></li>
                        <li><a href="${requestScope.path}/user/topics">我的帖子</a></li>
                        <li><a href="${requestScope.path}/user/post">我要发帖</a></li>
                        <li><a href="${requestScope.path}/user/records/apply/best">申请记录</a></li>
                        <li class="divider"></li>
                        <li><a href="${requestScope.path}/user/loginOut">退出登陆</a></li>
                    </ul>
                </li>
            </ul>
           <%-- <p class="navbar-text navbar-right">尊敬的用户您好！</p>--%>
        </c:if>
        <c:if test="${sessionScope.user.user_type == 2}">
            <ul class="nav navbar-nav navbar-right user">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            ${sessionScope.user.user_name}<b class="caret"></b>
                            <img style="width: 30px;height: 30px;" src="${requestScope.path}/${sessionScope.user.user_ico_url}">
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="${requestScope.path}/manage/addNotice">发布公告</a></li>
                        <li><a href="${requestScope.path}/admin/setting">个人信息修改</a></li>
                        <li><a href="${requestScope.path}/manage/apply/best">申精管理</a></li>
                        <li><a href="${requestScope.path}/manage/user/power">封锁用户</a></li>
                        <li><a href="${requestScope.path}/manage/addForum">板块管理</a></li>
                        <li class="divider"></li>
                        <li><a href="${requestScope.path}/user/loginOut">退出登陆</a></li>
                    </ul>
                </li>
            </ul>
           <%-- <p class="navbar-text navbar-right">尊敬的管理员您好！</p>--%>
        </c:if>
    </c:if>
    <c:if test="${empty sessionScope.user}">
        <ul class="nav navbar-nav navbar-right user">
            <li><a href="${requestScope.path}/user/login">登陆</a></li>
            <li><a href="${requestScope.path}/user/register">注册</a></li>
        </ul>
    </c:if>
    <!-- 搜索框 -->
    <form class="navbar-form navbar-right" role="search" action="${requestScope.path}/topic/topic/search?type=search" id="forum_search_topic" method="post">
        <div class="input-group">
            <input type="text" class="form-control" name="keywords" placeholder="搜索">
           <%-- <span class="input-group-addon"><span class="glyphicon glyphicon-search"></span> </span>--%>
            <span class="input-group-btn">
                <button class="btn btn-default" type="button"><span class="glyphicon glyphicon-search" style="height: 20px;" onclick="document.getElementById('forum_search_topic').submit()"></span></button>
            </span>
        </div>
    </form>
</nav>
