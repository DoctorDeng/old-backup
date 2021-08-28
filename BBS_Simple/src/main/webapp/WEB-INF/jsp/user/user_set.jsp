<%--
  Created by IntelliJ IDEA.
  User: Doctor邓
  Date: 2017/4/8
  Time: 14:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="zh">
<head>
    <title>校园论坛-个人信息修改</title>
    <jsp:include page="../pages/commonHead.jsp"/>
</head>
<body>
<jsp:include page="../pages/header.jsp"/>

<div class="container" style="margin-top: 30px">
    <div class="row">
        <div class="col-xs-3">
            <ul class="nav nav-pills nav-stacked">
                <li role="presentation" class="active"><a href="${requestScope.path}/user/setting">资料修改</a></li>
                <li role="presentation"><a href="${requestScope.path}/user/topics">我的帖子</a></li>
                <li role="presentation"><a href="${requestScope.path}/user/records/apply/best">申请记录</a></li>
            </ul>
        </div>

        <div class="col-xs-9">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">
                        个人信息修改
                    </h3>
                </div>
                <div class="panel-body">
                    <form id="form_user_set" action="${requestScope.path}/user/doSetting" method="post" enctype="multipart/form-data">
                        <div class="form-group">
                            <c:if test="${empty sessionScope.user.user_ico_url}">
                                <img alt="" class="avatar left" height="70" id="user_ico_url_old"
                                     name="user_ico_url_old"
                                     src="${requestScope.path}/img/ico/default_user_ico_1.png" width="70"/>
                            </c:if>
                            <c:if test="${!empty sessionScope.user.user_ico_url}">
                                <img alt="" class="avatar left" height="70" id="user_ico_url_old"
                                     name="user_ico_url_old"
                                     src="${requestScope.path}/${sessionScope.user.user_ico_url}" width="70"/>
                            </c:if>
                            <span id="user_ico_url_point">请上传你的头像</span><br/>
                        </div>
                        <input type="file" id="user_ico_url" name="user_ico_url" accept="image/*"/><br/>
                        <div class="form-group">
                            <label for="user_name">用户名</label>
                            <input type="text" class="form-control" name="user_name" id="user_name"
                                   width="200px" height="80px"
                                   value="${empty sessionScope.user.user_name ? '路人甲' : sessionScope.user.user_name}"
                                   placeholder="请输入名称">
                            <p class="help-block">

                            </p>
                        </div>
                        <div class="form-group">
                            <label for="user_sex_men">性 别</label><br/>
                            <!-- 男-->
                            男<input type="radio" id="user_sex_men"  name="user_sex" value="1">
                            &nbsp;&nbsp;
                            女<input type="radio" id="user_sex_women" name="user_sex" value="2">
                        </div>
                        <dl class="form-group">
                            <dt><label for="user_introduction">个性签名</label></dt>
                            <dd><%--<input id="user_introduction" type="tex" class="form-control" name="user_introduction"
                                       size="30" value="${requestScope.user.user_introduction}"/>
                                <p class="help-block">--%>
                                <textarea class="form-control" name="user_introduction"
                                          id="user_introduction">${sessionScope.user.user_introduction}</textarea>
                            </dd>
                        </dl>
                        <dl class="form-group">
                            <dt><label for="user_password">密码</label></dt>
                            <dd><input class="form-control" id="user_password" name="user_password" size="30"
                                       type="password"
                                       width="200px"/></dd>
                        </dl>
                        <dl class="form-group">
                            <dt><label for="user_confirm_password">重复密码</label></dt>
                            <dd><input class="form-control" id="user_confirm_password" name="user_confirm_password"
                                       size="30"
                                       type="password" width="200px"/></dd>
                        </dl>
                        <input class="btn btn-success" type="submit" value="提交">
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<div style="height: 100px"></div>
<jsp:include page="../pages/bottom.jsp" />
</body>
<jsp:include page="../pages/commonJs.jsp"/>
<script type="text/javascript">
    $(function () {
        $("#form_user_set").validate({
            rules: {
                user_name: {
                    required: true,
                    rangelength: [1, 6]
                },
                user_password: {
                    rangelength: [6, 20]
                },
                user_introduction:{
                    required: false,
                    rangelength: [0, 15]
                },
                user_confirm_password: {
                    equalTo: "#user_password"
                }
            },
            messages: {
                user_name: {
                    required: "必填",
                    rangelength: $.validator.format("用户名长度:{0}~{1}")
                },
                user_password: {
                    rangelength: $.validator.format("密码长度:{0}~{1}")
                },
                user_introduction:{
                    rangelength: $.validator.format("密码长度:{0}~{1}")
                },
                user_confirm_password: {
                    equalTo: "两次密码输入不一致"
                }
            }
        });

        // 回显示用户性别
        <c:choose>
        <c:when test="${sessionScope.user.user_sex == 1}">
            $("#user_sex_men").attr("checked","checked");
        </c:when>
        <c:when test="${sessionScope.user.user_sex == 2}">
            $("#user_sex_women").attr("checked","checked");
        </c:when>
        <c:otherwise>

        </c:otherwise>
        </c:choose>
    });
</script>

<style type="text/css">
    .error {
        color: red;
    }
</style>
</html>
