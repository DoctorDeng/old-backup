<%--
  Created by IntelliJ IDEA.
  User: Doctor邓
  Date: 2017/4/8
  Time: 18:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="zh">
<head>
    <title>校园论坛-发布公告</title>
    <jsp:include page="/WEB-INF/jsp/pages/commonHead.jsp"/>
</head>
<body>
<jsp:include page="/WEB-INF/jsp/pages/header.jsp"/>

<div class="container" style="margin-top: 80px">
    <div class="row">
        <div class="col-xs-3">
            <ul class="nav nav-pills nav-stacked">
                <li role="presentation" class="active"><a href="${requestScope.path}/manage/addNotice">发布公告</a></li>
                <li role="presentation"><a href="${requestScope.path}/admin/setting">个人信息修改</a></li>
                <%-- <li role="presentation"><a href="#">查看新帖</a></li>--%>
                <li role="presentation"><a href="${requestScope.path}/manage/apply/best">申精管理</a></li>
                <li role="presentation"><a href="${requestScope.path}/manage/user/power">封锁用户</a></li>
                <li role="presentation"><a href="${requestScope.path}/manage/addForum">板块管理</a></li>
                <!--<li role="presentation"><a href="#">Messages</a></li>-->
            </ul>
        </div>

        <div class="col-md-9">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">
                        发布公告
                    </h3>
                </div>
                <div class="panel-body">
                    <div class="column">
                        <form action="${requestScope.path}/manage/doAddNotice" method="post">
                            <div class="form-group">
                                <label for="topic_title">公告标题：</label>
                                <input required type="text" class="form-control" name="topic_title" id="topic_title" width="200px"
                                       height="80px"
                                       placeholder="请输入标题">
                            </div>

                            <dl class="form-group">
                                <dt><label>公告内容：</label></dt>
                                <dd><textarea id="topic_content" cols="20" rows="5" name="topic_content"
                                              class="ckeditor"></textarea></dd>
                            </dl>
                            <p style="color: red;">&nbsp;${requestScope.error_add_notice}</p>
                            <p>
                                <button type="submit" class="btn btn-success">发布公告</button>
                            </p>
                        </form>
                    </div>
                </div>

            </div>
        </div>
    </div>
</div>
<div style="height: 300px;"></div>
<jsp:include page="/WEB-INF/jsp/pages/bottom.jsp"/>
</body>
<jsp:include page="/WEB-INF/jsp/pages/commonJs.jsp"/>
<script type="text/javascript" src="${path}/plugin/ckeditor/ckeditor.js"></script>
<script type="text/javascript">

</script>
</html>
