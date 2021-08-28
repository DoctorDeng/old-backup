<%--
  Created by IntelliJ IDEA.
  User: Doctor邓
  Date: 2017/4/7
  Time: 18:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="zh">
<head>
    <title>校园论坛-发帖</title>
    <jsp:include page="../pages/commonHead.jsp"/>
    <link rel="stylesheet" type="text/css" href="${path}/plugin/font-awesome-4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="${path}/plugin/wangEditor/dist/css/wangEditor.min.css">
    <link rel="stylesheet" type="text/css" href="${path}/css/post.css">
    <link rel="stylesheet" type="text/css" href="${path}/plugin/bootstrap-select-1.12.2/dist/css/bootstrap-select.css">
    <%--    <link rel="stylesheet" type="text/css" href="${path}/plugin/easydropdown-master/demo.css"/>
        <link rel="stylesheet" type="text/css" href="${path}/plugin/easydropdown-master/themes/easydropdown.css"/>--%>
</head>
<body>
<div class="modal fade" tabindex="-1" role="dialog" id="modal_point">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title">警告</h4>
            </div>
            <div class="modal-body">
                <p id="message_error"></p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->


<jsp:include page="../pages/header.jsp"/>


<div class="container post">
    <div class="row form-horizontal">
        <div class="form-group form-inline">
            <label for="topic_title" class="col-sm-1 control-label" style="font-size: 20px;">标题:</label>
            <div class="col-sm-11">
                <input type="text" class="form-control" style="width:70%;" id="topic_title" name="topic_title">
                <span style="margin-left: 20px;">还可输入&nbsp;<span id="topic_title_surplus_length"
                                                                 style="color: rgb(42,149,249);">50</span>&nbsp;个字符</span>
            </div>
        </div>

        <div class="form-group">
            <label for="forum_id" class="col-sm-1 control-label" style="font-size: 20px;">板块:</label>
            &nbsp;&nbsp;&nbsp;
            <select class="selectpicker" id="forum_id" name="forum_id">
                <c:forEach var="forum" items="${requestScope.forums}">
                    <option value="${forum.forum_id}">${forum.forum_name}</option>
                </c:forEach>
            </select>
        </div>

        <hr>

        <div class="form-group">
            <div style="width: 100%;">
                <div id="topic_content" class="" style="height: 500px;"></div>
            </div>
        </div>
        <br>
        <div class="form-group">
            <button id="button_topic_post" class="btn btn-success btn-block"
                    data-toggle="popover" title="警告"
                    data-placement="top"
                    data-trigger="focus">
                <span class="glyphicon glyphicon-cloud-upload"></span>发表
            </button>
        </div>
    </div>
</div>
<jsp:include page="../pages/bottom.jsp"/>
</body>
<jsp:include page="../pages/commonJs.jsp"/>
<%--<script type="text/javascript" src="${path}/plugin/wangEditor/dist/js/lib/jquery-1.10.2.min.js"></script>--%>
<script type="text/javascript" src="${path}/plugin/wangEditor/dist/js/wangEditor.min.js"></script>
<script type="text/javascript" src="${path}/plugin/easydropdown-master/src/jquery.easydropdown.js"></script>
<script type="text/javascript" src="${path}/plugin/bootstrap-select-1.12.2/dist/js/bootstrap-select.js"></script>
<script type="text/javascript">
    /*  $(function () {

     });*/
    $(function () {
        /* $("#signupForm").validate();*/
        var editor = new wangEditor('topic_content');
        editor.create();

        $('#button_topic_post').click(function () {
            // 获取编辑器区域完整html代码
            var html = editor.$txt.html();
            // 获取编辑器纯文本内容
            var text = editor.$txt.text();
            // 获取格式化后的纯文本
            var formatText = editor.$txt.formatText();

            var topic_title = $("#topic_title").val();
            var forum_id = $("#forum_id").find("option:selected").val();
            if (topic_title.length < 5) {
                /* $("#button_topic_post").popover({
                 content: "标题至少为 5 个字节!"
                 });*/
                $("#message_error").text("标题至少为 5 个字节!");
                $("#modal_point").modal('show');
            } else if (text.length < 10) {
                $("#message_error").text("内容至少为 10 个字节!");
                $("#modal_point").modal('show');
            } else {
                $.ajax({
                    url: "${requestScope.path}/topic/addTopic",
                    type: "POST",
                    data: {
                        "topic_content": html,
                        "topic_title": $("#topic_title").val(),
                        "forum_id": $("#forum_id").find("option:selected").val()
                    },
                    dataType: "json",
                    success: function (data) {
                       if(data.resultCode == '1') {
                           $("#message_error").text(data.resultMessage);
                           $("#modal_point").modal('show');
                       }
                       else {
                          window.location = "${requestScope.path}/index";
                       }
                    },
                    error:function (data) {
                        $("#message_error").text("抱歉！服务器出错了");
                        $("#modal_point").modal('show');
                    }
                });
            }
        });

        $("#topic_title").bind('keyup', function () {
            var input_topic_title_length = $("#topic_title").val().length;

            if (input_topic_title_length <= 50) {
                $("#topic_title_surplus_length").text(50 - input_topic_title_length);
            } else {
                $("#topic_title").val($("#topic_title").val().substring(0, 50));
            }
        });
    });
</script>
</html>
