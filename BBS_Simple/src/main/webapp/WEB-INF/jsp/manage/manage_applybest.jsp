<%--
  Created by IntelliJ IDEA.
  User: Doctor邓
  Date: 2017/4/8
  Time: 16:10
  TODO: 帖子申精管理
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="zh">
<head>
    <title>校园论坛-帖子申精管理</title>
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
                <li role="presentation" class="active"><a href="${requestScope.path}/manage/apply/best">申精管理</a></li>
                <li role="presentation"><a href="${requestScope.path}/manage/user/power">封锁用户</a></li>
                <li role="presentation"><a href="${requestScope.path}/manage/addForum">板块管理</a></li>
            </ul>
        </div>

        <div class="col-md-9">
            <ul class="list-group">
                <a class="list-group-item active">
                    <c:if test="${!empty requestScope.page.resultList}">
                        精华帖申请列表
                    </c:if>
                    <c:if test="${empty requestScope.page.resultList}">
                        抱歉！没有任何申请
                    </c:if>
                </a>

                <c:forEach items="${requestScope.page.resultList}" var="topic_applybest">
                    <div class="list-group-item">
                        <a href="${topic_applybest.topic_id}" style="color:grey">
                            <h4 class="list-group-item-heading" style="color:black">
                                [${topic_applybest.forum_name}]
                            </h4>
                                ${topic_applybest.topic_title}
                        </a>
                        <button class="btn btn-success btn-xs" style="float: right;"
                                onclick="rejectApplyBest(${topic_applybest.topic_id}, this)">拒绝
                        </button>
                        <button class="btn btn-danger btn-xs" style="float: right;"
                                onclick="agreeApplyBest(${topic_applybest.topic_id}, this)">同意
                        </button>
                       <%-- <a href="#" style="float: right">&nbsp;拒绝</a>&nbsp;
                        <a href="#" style="float: right">&nbsp;同意</a>--%>
                        <p style="float: right;margin-right: 50px">
                            评论量:${topic_applybest.reply_num}&nbsp;
                            发表日期:${topic_applybest.publish_time}
                        </p>
                    </div>
                </c:forEach>
                <ul class="pagination pagination-lg" style="float:right">
                    <c:if test="${!empty requestScope.page.resultList}">
                        <c:if test="${requestScope.page.currPage == requestScope.page.indexPage}">
                            <li class="disabled"><a href="#">首页</a></li>
                        </c:if>
                        <c:if test="${requestScope.page.currPage != requestScope.page.indexPage}">
                            <li>
                                <a href="${requestScope.path}/manage/apply/best?currPage=${requestScope.page.indexPage}&pageSize=${requestScope.page.pageSize}">首页</a>
                            </li>
                        </c:if>

                        <c:if test="${requestScope.page.currPage == requestScope.page.indexPage}">
                            <li><a class="disabled" href="#">上一页</a></li>
                        </c:if>
                        <c:if test="${requestScope.page.currPage != requestScope.page.indexPage}">
                            <li>
                                <a href="${requestScope.path}/manage/apply/best?currPage=${requestScope.page.previousPage}&pageSize=${requestScope.page.pageSize}">上一页</a>
                            </li>
                        </c:if>

                        <c:forEach items="${requestScope.page.navigatePages}" var="navigate">
                            <c:if test="${requestScope.page.currPage == navigate}">
                                <li class="active"><a
                                        href="${requestScope.path}/manage/apply/best?currPage=${navigate}&pageSize=${requestScope.page.pageSize}">${navigate}</a>
                                </li>
                            </c:if>
                            <c:if test="${requestScope.page.currPage != navigate}">
                                <li>
                                    <a href="${requestScope.path}/manage/apply/best?currPage=${navigate}&pageSize=${requestScope.page.pageSize}">${navigate}</a>
                                </li>
                            </c:if>
                        </c:forEach>

                        <c:if test="${requestScope.page.currPage == requestScope.page.endPage}">
                            <li><a class="disabled" href="#">下一页</a></li>
                        </c:if>
                        <c:if test="${requestScope.page.currPage != requestScope.page.endPage}">
                            <li>
                                <a href="${requestScope.path}/manage/apply/best?currPage=${requestScope.page.nextPage}&pageSize=${requestScope.page.pageSize}">下一页</a>
                            </li>
                        </c:if>

                        <c:if test="${requestScope.page.currPage == requestScope.page.endPage}">
                            <li class="disabled"><a href="#">尾页</a></li>
                        </c:if>
                        <c:if test="${requestScope.page.currPage != requestScope.page.endPage}">
                            <li>
                                <a href="${requestScope.path}/manage/apply/best?currPage=${requestScope.page.endPage}&pageSize=${requestScope.page.pageSize}">尾页</a>
                            </li>
                        </c:if>
                    </c:if>
                </ul>
            </ul>
        </div>
    </div>
</div>
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
<jsp:include page="/WEB-INF/jsp/pages/bottom.jsp">
    <jsp:param name="buttom_type" value="bottom_fixed" />
</jsp:include>
</body>
<jsp:include page="/WEB-INF/jsp/pages/commonJs.jsp"/>
<script type="text/javascript">
    function agreeApplyBest(topic_id, button) {
        $.ajax({
            url: "${requestScope.path}/topic/apply/best/update",
            type: "POST",
            data: {
                "topic_id": topic_id,
                "type":"agree"
            },
            dataType: "json",
            success: function (data) {
                if (data.resultCode == '1') {
                    $("#message_error").text(data.resultMessage);
                    $("#modal_point").modal('show');
                }
                else {
                    $("#message_error").text("操作成功!");
                    $("#modal_point").modal('show');
                    $(button).parent().hide();
                    $("#signIsRefresh").val(2);
                    //buttonObj.setAttribute("display", "disabled");
                }
            },
            error: function () {
                $("#message_error").text("操作失败, 请稍后再试！");
                $("#modal_point").modal('show');
            }
        });
    }
    function  rejectApplyBest(topic_id, button) {
        $.ajax({
            url: "${requestScope.path}/topic/apply/best/update",
            type: "POST",
            data: {
                "topic_id": topic_id,
                "type":"reject"
            },
            dataType: "json",
            success: function (data) {
                if (data.resultCode == '1') {
                    $("#message_error").text(data.resultMessage);
                    $("#modal_point").modal('show');
                }
                else {
                    $("#message_error").text("操作成功!");
                    $("#modal_point").modal('show');
                    $(button).parent().hide();
                    $("#signIsRefresh").val(2);
                    //buttonObj.setAttribute("display", "disabled");
                }
            },
            error: function () {
                $("#message_error").text("操作失败, 请稍后再试！");
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