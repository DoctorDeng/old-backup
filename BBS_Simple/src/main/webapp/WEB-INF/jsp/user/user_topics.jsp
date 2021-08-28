<%--
  Created by IntelliJ IDEA.
  User: Doctor邓
  Date: 2017/4/8
  Time: 14:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="zh">
<head>
    <title>校园论坛-发帖记录</title>
    <jsp:include page="/WEB-INF/jsp/pages/commonHead.jsp"/>
</head>
<body>
<jsp:include page="/WEB-INF/jsp/pages/header.jsp"/>

<div class="container" style="margin-top: 30px">
    <div class="row">
        <div class="col-xs-3">
            <ul class="nav nav-pills nav-stacked">
                <li role="presentation"><a href="${requestScope.path}/user/setting">资料修改</a></li>
                <li role="presentation" class="active"><a href="${requestScope.path}/user/topics">我的帖子</a></li>
                <li role="presentation"><a href="${requestScope.path}/user/records/apply/best">申请记录</a></li>
                <!--<li role="presentation"><a href="#">Messages</a></li>-->
            </ul>
        </div>

        <div class="col-md-9">
            <ul class="list-group">
                <a class="list-group-item active">
                    <c:if test="${empty requestScope.page.resultList}">
                        抱歉, 你没有发别帖子!
                    </c:if>
                    <c:if test="${!empty requestScope.page.resultList}">
                        我的帖子
                    </c:if>
                </a>
                <c:forEach items="${requestScope.page.resultList}" var="topic_user">
                    <div class="list-group-item">
                        <a href="${topic_user.topic_id}" style="color:grey">
                            <h4 class="list-group-item-heading" style="color:black">
                                [${topic_user.forum_name}]</h4>
                                ${topic_user.topic_title}
                        </a>
                            <%-- <a href="#" style="float: right">编辑</a>&nbsp;|&nbsp;--%>
                        <c:if test="${topic_user.prop1 != '0' && topic_user.prop1 != '2'}">
                            <button class="btn btn-primary btn-xs" style="float: right;"
                                    onclick="applyBest(${topic_user.topic_id}, this)">申请精华贴
                            </button>
                        </c:if>
                        <c:if test="${topic_user.prop1 == '0' || topic_user.prop1 == '2'}">
                            <button class="btn btn-primary btn-xs" style="float: right;"
                                    onclick="" disabled="disabled">申请精华贴
                            </button>
                        </c:if>

                        <p style="float: right;margin-right: 50px">
                            浏览量:${topic_user.view_num}&nbsp;
                            评论量:${topic_user.reply_num}&nbsp;
                            发表日期:${topic_user.publish_time}
                        </p>
                    </div>
                </c:forEach>
            </ul>
        </div>

        <ul class="pagination pagination-lg" style="float:right">
            <c:if test="${!empty requestScope.page.resultList}">
                <c:if test="${requestScope.page.currPage == requestScope.page.indexPage}">
                    <li class="disabled"><a href="#">首页</a></li>
                </c:if>
                <c:if test="${requestScope.page.currPage != requestScope.page.indexPage}">
                    <li>
                        <a href="${requestScope.path}/user/topics?currPage=${requestScope.page.indexPage}&pageSize=${requestScope.page.pageSize}">首页</a>
                    </li>
                </c:if>

                <c:if test="${requestScope.page.currPage == requestScope.page.indexPage}">
                    <li><a class="disabled" href="#">上一页</a></li>
                </c:if>
                <c:if test="${requestScope.page.currPage != requestScope.page.indexPage}">
                    <li>
                        <a href="${requestScope.path}/user/topics?currPage=${requestScope.page.previousPage}&pageSize=${requestScope.page.pageSize}">上一页</a>
                    </li>
                </c:if>

                <c:forEach items="${requestScope.page.navigatePages}" var="navigate">
                    <c:if test="${requestScope.page.currPage == navigate}">
                        <li class="active"><a
                                href="${requestScope.path}/user/topics?currPage=${navigate}&pageSize=${requestScope.page.pageSize}">${navigate}</a>
                        </li>
                    </c:if>
                    <c:if test="${requestScope.page.currPage != navigate}">
                        <li>
                            <a href="${requestScope.path}/user/topics?currPage=${navigate}&pageSize=${requestScope.page.pageSize}">${navigate}</a>
                        </li>
                    </c:if>
                </c:forEach>

                <c:if test="${requestScope.page.currPage == requestScope.page.endPage}">
                    <li><a class="disabled" href="#">下一页</a></li>
                </c:if>
                <c:if test="${requestScope.page.currPage != requestScope.page.endPage}">
                    <li>
                        <a href="${requestScope.path}/user/topics?currPage=${requestScope.page.nextPage}&pageSize=${requestScope.page.pageSize}">下一页</a>
                    </li>
                </c:if>

                <c:if test="${requestScope.page.currPage == requestScope.page.endPage}">
                    <li class="disabled"><a href="#">尾页</a></li>
                </c:if>
                <c:if test="${requestScope.page.currPage != requestScope.page.endPage}">
                    <li>
                        <a href="${requestScope.path}/user/topics?currPage=${requestScope.page.endPage}&pageSize=${requestScope.page.pageSize}">尾页</a>
                    </li>
                </c:if>
            </c:if>
        </ul>
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
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div>
<%--<div style="height: 550px;"></div>--%>
<jsp:include page="/WEB-INF/jsp/pages/bottom.jsp">
    <jsp:param name="buttom_type" value="bottom_fixed"/>
</jsp:include>
</body>
<jsp:include page="/WEB-INF/jsp/pages/commonJs.jsp"/>
<script>
    function applyBest(topic_id, buttonObj) {
        $.ajax({
            url: "${requestScope.path}/topic/apply/best",
            type: "POST",
            data: {
                "topic_id": topic_id
            },
            dataType: "json",
            success: function (data) {
                if (data.resultCode == '1') {
                    $("#message_error").text(data.resultMessage);
                    $("#modal_point").modal('show');
                }
                else {
                    $("#message_error").text("申请成功!");
                    $("#modal_point").modal('show');
                    buttonObj.setAttribute("disabled", "disabled");
                }
            },
            error: function () {
                $("#message_error").text("申请失败, 请稍后再试！");
                $("#modal_point").modal('show');
            }
        });
    }
</script>
</html>