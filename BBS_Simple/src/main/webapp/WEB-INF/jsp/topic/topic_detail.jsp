<%--
  Created by IntelliJ IDEA.
  User: Doctor邓
  Date: 2017/4/7
  Time: 22:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="zh">
<head>
    <title>${requestScope.topic_title}</title>
    <jsp:include page="../pages/commonHead.jsp"/>
    <link href="${path}/css/post-detail.css" rel="stylesheet">
</head>
<body>
<jsp:include page="../pages/header.jsp"/>



<c:forEach items="${requestScope.page.resultList}" var="topicDetail">
    <!-- 楼主 -->
    <c:if test="${topicDetail.sign == 0}">
        <jsp:include page="../pages/topicDetail.jsp">
            <jsp:param name="topic_id"        value="${topicDetail.topic_id}" />
            <jsp:param name="reply_num"       value="${topicDetail.reply_num}" />
            <jsp:param name="topic_title"     value="${topicDetail.topic_title}" />
            <jsp:param name="forum_name"      value="${topicDetail.forum_name}" />
            <jsp:param name="user_ico_url"    value="${topicDetail.user_ico_url}" />
            <jsp:param name="user_name"       value="${topicDetail.user_name}" />
            <jsp:param name="user_sex"        value="${topicDetail.user_sex}" />
            <jsp:param name="publish_time"    value="${topicDetail.publish_time}" />
            <jsp:param name="publish_content" value="${topicDetail.publish_content}" />
            <jsp:param name="user_introduction" value="${topicDetail.user_introduction}" />
        </jsp:include>
    </c:if>
    <!-- 回复 -->
    <c:if test="${topicDetail.sign == 1}">
        <jsp:include page="../pages/reply.jsp">
            <jsp:param name="user_ico_url"    value="${topicDetail.user_ico_url}" />
            <jsp:param name="user_name"       value="${topicDetail.user_name}" />
            <jsp:param name="user_sex"        value="${topicDetail.user_sex}" />
            <jsp:param name="publish_time"    value="${topicDetail.publish_time}" />
            <jsp:param name="reply_floor"     value="${topicDetail.reply_floor}" />
            <jsp:param name="publish_content" value="${topicDetail.publish_content}" />
            <jsp:param name="user_introduction" value="${topicDetail.user_introduction}" />
        </jsp:include>
    </c:if>
</c:forEach>

<div class="container">
    <div class="row">
        <div class="col-md-11">
            <ul class="pagination page-float" style="float: right;margin-right: 0px;">
                <c:if test="${!empty requestScope.page.resultList}">
                    <c:if test="${requestScope.page.currPage == requestScope.page.indexPage}">
                        <li class="disabled"><a href="#">首页</a></li>
                    </c:if>
                    <c:if test="${requestScope.page.currPage != requestScope.page.indexPage}">
                        <li>
                            <a href="${requestScope.path}/topic/${requestScope.topic_id}?currPage=${requestScope.page.indexPage}&pageSize=${requestScope.page.pageSize}">首页</a>
                        </li>
                    </c:if>

                    <c:if test="${requestScope.page.currPage == requestScope.page.indexPage}">
                        <li><a class="disabled" href="#">上一页</a></li>
                    </c:if>
                    <c:if test="${requestScope.page.currPage != requestScope.page.indexPage}">
                        <li>
                            <a href="${requestScope.path}/topic/${requestScope.topic_id}?currPage=${requestScope.page.previousPage}&pageSize=${requestScope.page.pageSize}">上一页</a>
                        </li>
                    </c:if>

                    <c:forEach items="${requestScope.page.navigatePages}" var="navigate">
                        <c:if test="${requestScope.page.currPage == navigate}">
                            <li class="active"><a
                                    href="${requestScope.path}/topic/${requestScope.topic_id}?currPage=${navigate}&pageSize=${requestScope.page.pageSize}">${navigate}</a>
                            </li>
                        </c:if>
                        <c:if test="${requestScope.page.currPage != navigate}">
                            <li>
                                <a href="${requestScope.path}/topic/${requestScope.topic_id}?currPage=${navigate}&pageSize=${requestScope.page.pageSize}">${navigate}</a>
                            </li>
                        </c:if>
                    </c:forEach>

                    <c:if test="${requestScope.page.currPage == requestScope.page.endPage}">
                        <li><a class="disabled" href="#">下一页</a></li>
                    </c:if>
                    <c:if test="${requestScope.page.currPage != requestScope.page.endPage}">
                        <li>
                            <a href="${requestScope.path}/topic/${requestScope.topic_id}?currPage=${requestScope.page.nextPage}&pageSize=${requestScope.page.pageSize}">下一页</a>
                        </li>
                    </c:if>

                    <c:if test="${requestScope.page.currPage == requestScope.page.endPage}">
                        <li class="disabled"><a href="#">尾页</a></li>
                    </c:if>
                    <c:if test="${requestScope.page.currPage != requestScope.page.endPage}">
                        <li>
                            <a href="${requestScope.path}/topic/${requestScope.topic_id}?currPage=${requestScope.page.endPage}&pageSize=${requestScope.page.pageSize}">尾页</a>
                        </li>
                    </c:if>
                </c:if>
            </ul>
        </div>
    </div>
</div>
<c:if test="${!empty sessionScope.user}">
    <div class="container">
        <div class="row">
            <div class="col-md-11">
                <div style="height: 200px;margin: 50px auto;margin-left: 100px; ">
                        <%--<form action="#" method="post">--%>
                    <input type="hidden" name="postId" value="">
                    <input type="hidden" name="page" value="">
                    <div style="margin: 5px auto;height: 100px; ">
                        <textarea id="reply_content" cols="20" rows="1" name="content" class="ckeditor"></textarea>
                    </div>
                        <%--                    <s:fielderror fieldName="limit"></s:fielderror>--%>
                    <div style="float:right;margin: 60px auto">
                        <input type="submit" class="btn btn-primary" style="width: 60px;" value="回复" onclick="addReply(${requestScope.topic_id})" />
                    </div>
                        <%--</form>--%>
                </div>
            </div>
        </div>
    </div>
</c:if>
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
<div style="height: 250px;"></div>
<jsp:include page="../pages/bottom.jsp" />
</body>
<jsp:include page="../pages/commonJs.jsp"/>
<script type="text/javascript" src="${path}/plugin/ckeditor/ckeditor.js"></script>
<script type="text/javascript">
    function addReply(topic_id) {
        $.ajax({
            url: "${requestScope.path}/topic/addReply",
            type: "POST",
            data: {
                "topic_id": topic_id,
                "reply_content":CKEDITOR.instances.reply_content.getData()
            },
            dataType: "json",
            success: function (data) {
                if (data.resultCode == '1') {
                    $("#message_error").text(data.resultMessage);
                    $("#modal_point").modal('show');
                }
                else {
                    $("#message_error").text("回复成功!");
                    $("#modal_point").modal('show');
                    $("#signIsRefresh").val(2);
                    //buttonObj.setAttribute("display", "disabled");
                }
            },
            error: function () {
                $("#message_error").text("回复失败, 请稍后再试！");
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
<script type="text/javascript" src="${path}/js/topic_detail.js"></script>
</html>
