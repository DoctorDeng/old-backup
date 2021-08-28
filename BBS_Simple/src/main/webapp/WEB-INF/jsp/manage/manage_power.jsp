<%--
  Created by IntelliJ IDEA.
  User: Doctor邓
  Date: 2017/4/8
  Time: 18:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="zh">
<head>
    <title>校园论坛-用户权限</title>
    <jsp:include page="/WEB-INF/jsp/pages/commonHead.jsp"/>
</head>
<body>
<jsp:include page="/WEB-INF/jsp/pages/header.jsp"/>
<div class="container" style="margin-top: 80px">
    <div class="row">
        <div class="col-xs-3">
            <ul class="nav nav-pills nav-stacked">
                <li role="presentation"><a href="${requestScope.path}/manage/addNotice">发布公告</a></li>
                <li role="presentation"><a href="${requestScope.path}/admin/setting">个人信息修改</a></li>
                <%-- <li role="presentation"><a href="#">查看新帖</a></li>--%>
                <li role="presentation"><a href="${requestScope.path}/manage/apply/best">申精管理</a></li>
                <li role="presentation" class="active"><a href="${requestScope.path}/manage/user/power">封锁用户</a></li>
                <li role="presentation"><a href="${requestScope.path}/manage/addForum">板块管理</a></li>
            </ul>
        </div>

        <div class="col-md-9">
            <form style="float: right;" class="navbar-form navbar-right" role="search"
                  action="${requestScope.path}/manage/user/power" method="post" id="form_user_search">
                <div class="input-group" style="width: 300px">
                    <input type="text" class="form-control" name="keywords" placeholder="搜索用户(用户名/邮箱)"
                           value="${requestScope.keywords}">
                    <%-- <span class="input-group-addon"><span class="glyphicon glyphicon-search"></span></span>--%>
                    <span class="input-group-btn">
                        <button class="btn btn-default" type="button"><span class="glyphicon glyphicon-search"
                                                                            style="height: 20px;"
                                                                            onclick="search()"></span></button>
                    </span>
                </div>
            </form>
            <div style="margin-top: 50px;">
                <ul class="list-group">
                    <!-- 用户 -->
                    <c:if test="${empty requestScope.page.resultList}">
                        <div class="panel panel-danger">
                            <div class="panel-heading">抱歉!没有查找到用户数据</div>
                            <div class="panel-body">
                                &nbsp;
                            </div>
                        </div>
                    </c:if>
                    <c:forEach items="${requestScope.page.resultList}" var="user_power">
                        <div class="list-group-item" style="height: 60px;padding-top: 20px;">
                            <a href="" style="color:grey">
                                用户名:${user_power.user_name}&nbsp;|&nbsp;
                                邮箱:${user_power.user_email}
                            </a>

                            <div class="btn-group" style="float: right;margin-right: 20px;">
                                <button type="button" class="btn btn-default dropdown-toggle btn-xs"
                                        data-toggle="dropdown">
                                    设置用户权限<span class="caret"></span>
                                </button>
                                <ul class="dropdown-menu" role="menu">
                                    <li>
                                        <a href="#"><span onclick="updateUserPower('0', '${user_power.user_status}','${user_power.user_id}')">恢复正常</span></a>
                                    </li>
                                    <li>
                                        <a href="#"><span onclick="updateUserPower('1', '${user_power.user_status}','${user_power.user_id}')">删除账号</span></a>
                                    </li>
                                    <li>
                                        <a href="#"><span onclick="updateUserPower('3', '${user_power.user_status}','${user_power.user_id}')">限制回复</span></a>
                                    </li>
                                    <li>
                                        <a href="#"><span onclick="updateUserPower('2', '${user_power.user_status}','${user_power.user_id}')">限制发帖</span></a>
                                    </li>
                                    <li>
                                        <a href="#"><span onclick="updateUserPower('4', '${user_power.user_status}','${user_power.user_id}')">限制发帖与回复</span></a>
                                    </li>
                                </ul>
                            </div>
                            <div style="float: right;margin-right: 10px;">
                                状态：
                                <c:choose>
                                    <c:when test="${user_power.user_status == 0}">
                                        <span class="label label-success">正常</span>
                                    </c:when>
                                    <c:when test="${user_power.user_status == 1}">
                                        <span class="label label-default">被删除</span>
                                    </c:when>
                                    <c:when test="${user_power.user_status == 2}">
                                        <span class="label label-danger">无法发帖</span>
                                    </c:when>
                                    <c:when test="${user_power.user_status == 3}">
                                        <span class="label label-danger">无法回复</span>
                                    </c:when>
                                    <c:when test="${user_power.user_status == 4}">
                                        <span class="label label-danger">无法发帖和回复</span>
                                    </c:when>
                                </c:choose>
                            </div>
                        </div>
                    </c:forEach>
                </ul>
                <ul class="pagination pagination-lg" style="float:right">
                    <c:if test="${!empty requestScope.page.resultList}">
                        <c:if test="${requestScope.page.currPage == requestScope.page.indexPage}">
                            <li class="disabled"><a href="#">首页</a></li>
                        </c:if>
                        <c:if test="${requestScope.page.currPage != requestScope.page.indexPage}">
                            <li>
                                <a href="${requestScope.path}/manage/user/power?currPage=${requestScope.page.indexPage}&pageSize=${requestScope.page.pageSize}&keywords=${requestScope.keywords}">首页</a>
                            </li>
                        </c:if>

                        <c:if test="${requestScope.page.currPage == requestScope.page.indexPage}">
                            <li><a class="disabled" href="#">上一页</a></li>
                        </c:if>
                        <c:if test="${requestScope.page.currPage != requestScope.page.indexPage}">
                            <li>
                                <a href="${requestScope.path}/manage/user/power?currPage=${requestScope.page.previousPage}&pageSize=${requestScope.page.pageSize}&keywords=${requestScope.keywords}">上一页</a>
                            </li>
                        </c:if>

                        <c:forEach items="${requestScope.page.navigatePages}" var="navigate">
                            <c:if test="${requestScope.page.currPage == navigate}">
                                <li class="active"><a
                                        href="${requestScope.path}/manage/user/power?currPage=${navigate}&pageSize=${requestScope.page.pageSize}&keywords=${requestScope.keywords}">${navigate}</a>
                                </li>
                            </c:if>
                            <c:if test="${requestScope.page.currPage != navigate}">
                                <li>
                                    <a href="${requestScope.path}/manage/user/power?currPage=${navigate}&pageSize=${requestScope.page.pageSize}&keywords=${requestScope.keywords}">${navigate}</a>
                                </li>
                            </c:if>
                        </c:forEach>

                        <c:if test="${requestScope.page.currPage == requestScope.page.endPage}">
                            <li><a class="disabled" href="#">下一页</a></li>
                        </c:if>
                        <c:if test="${requestScope.page.currPage != requestScope.page.endPage}">
                            <li>
                                <a href="${requestScope.path}/manage/user/power?currPage=${requestScope.page.nextPage}&pageSize=${requestScope.page.pageSize}&keywords=${requestScope.keywords}">下一页</a>
                            </li>
                        </c:if>

                        <c:if test="${requestScope.page.currPage == requestScope.page.endPage}">
                            <li class="disabled"><a href="#">尾页</a></li>
                        </c:if>
                        <c:if test="${requestScope.page.currPage != requestScope.page.endPage}">
                            <li>
                                <a href="${requestScope.path}/manage/user/power?currPage=${requestScope.page.endPage}&pageSize=${requestScope.page.pageSize}&keywords=${requestScope.keywords}">尾页</a>
                            </li>
                        </c:if>
                    </c:if>
                </ul>
            </div>
        </div>
    </div>
</div>
<div style="height: 480px;"></div>
<div class="modal fade" tabindex="-1" role="dialog" id="modal_point">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title">提示</h4>
            </div>
            <div class="modal-body">
                <p id="message_error"></p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal" onclick="refresh()">关闭</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
    <input id="signIsRefresh" type="hidden" value="0">
</div>
<jsp:include page="/WEB-INF/jsp/pages/bottom.jsp"/>
</body>
<jsp:include page="/WEB-INF/jsp/pages/commonJs.jsp"/>
<script type="text/javascript">
    function search() {
        $("#form_user_search").submit();
    }
    function updateUserPower(type, status, user_id) {
        if (type == status) {
            $("#message_error").text("操作成功!");
            $("#modal_point").modal('show');
            return;
        }

        $.ajax({
            url: "${requestScope.path}/manage/user/power/update",
            type: "POST",
            dataType: "json",
            data: {
                "type": type,
                "user_id": user_id
            },
            success: function (data) {
                if (data.resultCode == '1') {
                    $("#message_error").text(data.resultMessage);
                    $("#modal_point").modal('show');
                }
                else {
                    $("#message_error").text("操作成功!");
                    $("#modal_point").modal('show');
                    $("#signIsRefresh").val(2);
                    //buttonObj.setAttribute("display", "disabled");
                }
            },
            error: function () {
                $("#message_error").text("操作失败!");
                $("#modal_point").modal('show');
            }
        });
    }

    function refresh() {
        if ($("#signIsRefresh").val() == 2) {
            window.location.reload();
        }
    }
</script>
</html>
