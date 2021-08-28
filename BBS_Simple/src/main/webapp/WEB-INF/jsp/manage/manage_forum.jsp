<%--
  Created by IntelliJ IDEA.
  User: Doctor邓
  Date: 2017/4/8
  Time: 18:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="zh">
<head>
    <title>校园论坛-板块管理</title>
    <jsp:include page="/WEB-INF/jsp/pages/commonHead.jsp"/>
    <link rel="stylesheet" type="text/css" href="${path}/plugin/bootstrap-select-1.12.2/dist/css/bootstrap-select.css">
</head>
<body>
<jsp:include page="/WEB-INF/jsp/pages/header.jsp"/>
<div class="container" style="margin-top: 80px">
    <div class="row">
        <div class="col-xs-3">
            <ul class="nav nav-pills nav-stacked">
                <li role="presentation"><a href="${requestScope.path}/manage/addNotice">发布公告</a></li>
                <li role="presentation"><a href="${requestScope.path}/admin/setting">个人信息修改</a></li>
                <li role="presentation"><a href="${requestScope.path}/manage/apply/best">申精管理</a></li>
                <li role="presentation"><a href="${requestScope.path}/manage/user/power">封锁用户</a></li>
                <li role="presentation" class="active"><a href="${requestScope.path}/manage/addForum">板块管理</a></li>
            </ul>
        </div>

        <div class="col-md-9">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">
                        创建讨论区
                    </h3>
                </div>

                <div class="panel-body">
                    <div class="column">
                        <%--<form action="#" method="post">--%>
                            <div class="form-group">
<%--                                <label for="forum_id" class="control-label">父板块:</label>
                                &nbsp;&nbsp;&nbsp;
                                &lt;%&ndash; <br>&ndash;%&gt;
                                <select class="selectpicker" id="forum_id">
                                    <option value="0">&nbsp;</option>
                                    <c:forEach var="forum" items="${requestScope.forums}">
                                        <option value="${forum.forum_id}">${forum.forum_name}</option>
                                    </c:forEach>
                                </select>--%>
                            </div>

                            <div class="form-group">
                                <label for="forum_name">板块名称:</label>
                                <input type="text" class="form-control" id="forum_name" name="forum_name" width="200px"
                                       height="80px"
                                       placeholder="请输入板块名称">
                            </div>
                            <div class="form-group">
                                <label for="forum_introduction">板块简介:</label>
                                <textarea class="form-control" id="forum_introduction"
                                          name="forum_introduction"></textarea>
                            </div>
                            <p>
                                <button class="btn btn-success" onclick="addForum()">创建板块</button>
                            </p>
                        <%--</form>--%>
                    </div>

                </div>
            </div>

        </div>
    </div>
</div>
<div style="height: 330px"></div>
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
<script type="text/javascript" src="${path}/plugin/bootstrap-select-1.12.2/dist/js/bootstrap-select.js"></script>
<script type="text/javascript">
    function addForum() {
        $.ajax({
            url: "${requestScope.path}/forum/addForum",
            type: "POST",
            data : {
                "forum_introduction": $("#forum_introduction").val(),
                "forum_name":$("#forum_name").val()
                /*"forum_id":$("#forum_id").find("option:selected").val()*/
            },
            success: function (data) {
                if (data.resultCode == '1') {
                    $("#message_error").text(data.resultMessage);
                    $("#modal_point").modal('show');
                }
                else {
                    $("#message_error").text("添加成功!");
                    $("#modal_point").modal('show');
                    $("#signIsRefresh").val(2);
                }
            },
            dataType:"json",
            error: function () {
                $("#message_error").text("添加失败, 请稍后再试！");
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
