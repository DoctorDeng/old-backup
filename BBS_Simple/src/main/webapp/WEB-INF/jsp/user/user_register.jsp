<%--
  Created by IntelliJ IDEA.
  User: Doctor邓
  Date: 2017/4/7
  Time: 13:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="zh">
<head>
    <title>校园论坛-注册</title>
    <jsp:include page="../pages/commonHead.jsp"/>
    <link href="${path}/css/regist.css" rel="stylesheet">
</head>
<body>
<jsp:include page="../pages/header.jsp"/>

<div class="regist">
    <div class="container">
        <div class="form row">
            <form class="form-horizontal" id="form_register" name="form_register" method="post" action="${path}/user/doRegister">
                <div class="col-md-2"></div>
                <div class="col-sm-4 col-md-7">
                    <div class="form-group text-center">
                        <div class="col-md-9">
                            <h3 class="form-title">校园论坛-注册</h3>
                        </div>
                    </div>

                    <div class="form-group has-feedback">
                        <div class="col-md-9">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-user fa-lg"></i></span>
                                <input class="form-control" type="text" placeholder="账号" name="user_account" id="user_account"
                                       autofocus="autofocus"/>
                            </div>
                            <span class="glyphicon form-control-feedback" aria-hidden="true" sign="error_ico"></span>
                            <span id="user_account_status" class="sr-only">()</span>
                        </div>
                        <div class="col-md-3"></div>
                    </div>

                    <div class="form-group has-feedback">
                        <div class="col-md-9">
                            <div class="input-group">
                              <span class="input-group-addon">
                                <i class="fa fa-lock fa-lg"></i>
                              </span>
                                <input class="form-control" type="password" placeholder="密码" id="user_password"
                                       name="user_password"/>
                            </div>
                            <span class="glyphicon form-control-feedback" aria-hidden="true" sign="error_ico"></span>
                            <span id="user_password_status" class="sr-only">()</span>
                        </div>
                        <div class="col-md-3"></div>
                    </div>

                    <div class="form-group has-feedback">
                        <div class="col-md-9">
                            <div class="input-group">
                          <span class="input-group-addon">
                            <i class="fa fa-lock fa-lg"></i>
                          </span>
                                <input class="form-control" type="password" placeholder="再次输入密码"
                                       id="user_confirm_password"
                                       name="user_confirm_password"/>
                            </div>
                            <span class="glyphicon form-control-feedback" aria-hidden="true" sign="error_ico"></span>
                            <span id="user_password_status" class="sr-only">()</span>
                        </div>
                        <div class="col-md-3"></div>
                    </div>

                    <div class="form-group has-feedback">
                        <div class="col-md-9">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-envelope"></i></span>
                                <input class="form-control email" type="email" placeholder="邮箱" name="user_email" id="user_email"/>
                            </div>
                            <span class="glyphicon form-control-feedback" aria-hidden="true" sign="error_ico"></span>
                            <span id="user_password_status" class="sr-only">()</span>
                        </div>
                        <div class="col-md-3"></div>
                    </div>
                    <p style="color: red">${requestScope.registerError}</p>
                    <div class="form-group">
                        <div class="col-md-9">
                            <button class="btn btn-success btn-block" onclick="register()">
                                <i class="fa fa-registered" aria-hidden="true"></i>注&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;册
                            </button>
                            <br>
                            <button class="btn btn-info btn-block" onclick="toLogin()">
                                <i class="fa fa-sign-in" aria-hidden="true"></i>返回登录
                            </button>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

<jsp:include page="../pages/bottom.jsp">
    <jsp:param name="buttom_type" value="bottom_fixed"/>
</jsp:include>
</body>
<jsp:include page="../pages/commonJs.jsp"/>
<script type="text/javascript">
    function register() {
        $("#form_register").submit();
    }

    function toLogin() {
        window.location = "${path}/user/login";
    }
    $(function () {
        $("#form_register").validate({
            rules: {
                user_name: {
                    required: true
                },
                user_email: {
                    required: true,
                    email: true
                },
                user_account: {
                    required: true
                },
                user_password: {
                    required: true,
                    rangelength: [6, 20]
                },
                user_confirm_password: {
                    equalTo: "#user_password"
                }
            },
            messages: {
                user_name: {
                    required: "必填"
                },
                user_account: {
                    required: "必填"
                },
                user_email: {
                    required: "必填",
                    email: "邮箱格式不正确"
                },
                user_password: {
                    required: "不能为空",
                    rangelength: $.validator.format("密码长度:{0}~{1}")
                },
                user_confirm_password: {
                    equalTo: "两次密码输入不一致"
                }
            },
            errorPlacement: function (error, element) {
                error.appendTo(element.parent().parent().next("div"));
               /* $(element).parent().parent().parent().removeClass("has-success").addClass("has-error");
                 $(element).parent().parent().children("span[sign='error_ico']").removeClass("glyphicon-ok").addClass("glyphicon-remove");
                */
            },
            success: function (label) {
                $(label).parent().parent().removeClass("has-error").addClass("has-success");
                $(label).parent().prev("div").children("span[sign='error_ico']").removeClass("glyphicon-remove").addClass("glyphicon-ok");
            },
            errorElement: "span",
            showErrors: function(errorMap, errorList) {
                for (var key in errorMap) {
                   /* $("#" + key)*/
                    $("#" + key).parent().parent().parent().removeClass("has-success").addClass("has-error");
                    $("#" + key).parent().parent().children("span[sign='error_ico']").removeClass("glyphicon-ok").addClass("glyphicon-remove");
                }
                this.defaultShowErrors();
            }
        });
    });
</script>
</html>
