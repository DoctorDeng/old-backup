<%--
  Created by IntelliJ IDEA.
  User: Doctor邓
  Date: 2017/4/8
  Time: 15:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="zh">
<head>
    <title>校园论坛-</title>
    <jsp:include page="/WEB-INF/jsp/pages/commonHead.jsp"/>
</head>
<body>
<jsp:include page="/WEB-INF/jsp/pages/header.jsp"/>


<div class="container" style="margin-top: 30px">
    <div class="row">
        <div class="col-xs-3">
            <ul class="nav nav-pills nav-stacked">
                <li role="presentation"><a href="${requestScope.path}/user/setting">资料修改</a></li>
                <li role="presentation"><a href="${requestScope.path}/user/topics">我的帖子</a></li>
                <li role="presentation" class="active"><a href="${requestScope.path}/user/records/apply/best">申请记录</a>
                </li>
                <!--<li role="presentation"><a href="#">Messages</a></li>-->
            </ul>
        </div>

        <div class="col-md-9">
            <ul class="list-group">
                <a class="list-group-item active">
                    <c:if test="${!empty requestScope.page.resultList}">
                        申请记录
                    </c:if>
                    <c:if test="${empty requestScope.page.resultList}">
                        没有任何申请！
                    </c:if>
                </a>
                <c:forEach items="${requestScope.page.resultList}" var="topic_applybest">
                    <div class="list-group-item">
                        <a href="${topic_applybest.topic_id}" style="color:grey">
                            <h4 class="list-group-item-heading" style="color:black">
                                [${topic_applybest.forum_name}]</h4>
                                ${topic_applybest.topic_title}
                        </a>
                        <p style="float: right;margin-right: 50px">
                            状态：
                            <c:choose>
                                <c:when test="${topic_applybest.prop1 == '0'}">
                                    <span class="label label-primary">正在申精</span>
                                </c:when>
                                <c:when test="${topic_applybest.prop1 == '1'}">
                                    <span class="label label-danger">申精被拒</span>
                                </c:when>
                                <c:when test="${topic_applybest.prop1 == '2'}">
                                    <span class="label label-success">申精通过</span>
                                </c:when>
                            </c:choose>
                        </p>
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
                            <a href="${requestScope.path}/user/records/apply/best?currPage=${requestScope.page.indexPage}&pageSize=${requestScope.page.pageSize}">首页</a>
                        </li>
                    </c:if>

                    <c:if test="${requestScope.page.currPage == requestScope.page.indexPage}">
                        <li><a class="disabled" href="#">上一页</a></li>
                    </c:if>
                    <c:if test="${requestScope.page.currPage != requestScope.page.indexPage}">
                        <li>
                            <a href="${requestScope.path}/user/records/apply/best?currPage=${requestScope.page.previousPage}&pageSize=${requestScope.page.pageSize}">上一页</a>
                        </li>
                    </c:if>

                    <c:forEach items="${requestScope.page.navigatePages}" var="navigate">
                        <c:if test="${requestScope.page.currPage == navigate}">
                            <li class="active"><a
                                    href="${requestScope.path}/user/records/apply/best?currPage=${navigate}&pageSize=${requestScope.page.pageSize}">${navigate}</a>
                            </li>
                        </c:if>
                        <c:if test="${requestScope.page.currPage != navigate}">
                            <li>
                                <a href="${requestScope.path}/user/records/apply/best?currPage=${navigate}&pageSize=${requestScope.page.pageSize}">${navigate}</a>
                            </li>
                        </c:if>
                    </c:forEach>

                    <c:if test="${requestScope.page.currPage == requestScope.page.endPage}">
                        <li><a class="disabled" href="#">下一页</a></li>
                    </c:if>
                    <c:if test="${requestScope.page.currPage != requestScope.page.endPage}">
                        <li>
                            <a href="${requestScope.path}/user/records/apply/best?currPage=${requestScope.page.nextPage}&pageSize=${requestScope.page.pageSize}">下一页</a>
                        </li>
                    </c:if>

                    <c:if test="${requestScope.page.currPage == requestScope.page.endPage}">
                        <li class="disabled"><a href="#">尾页</a></li>
                    </c:if>
                    <c:if test="${requestScope.page.currPage != requestScope.page.endPage}">
                        <li>
                            <a href="${requestScope.path}/user/records/apply/best?currPage=${requestScope.page.endPage}&pageSize=${requestScope.page.pageSize}">尾页</a>
                        </li>
                    </c:if>
                </c:if>
            </ul>
        </div>
    </div>
</div>

<jsp:include page="/WEB-INF/jsp/pages/bottom.jsp">
    <jsp:param name="buttom_type" value="bottom_fixed"/>
</jsp:include>
</body>
<jsp:include page="/WEB-INF/jsp/pages/commonJs.jsp"/>
</html>
