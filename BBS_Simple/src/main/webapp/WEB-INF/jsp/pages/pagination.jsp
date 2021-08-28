<%--
  Created by IntelliJ IDEA.
  User: Doctor邓
  Date: 2017/4/7
  Time: 8:45
  TODO: 分页类模板
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="utf-8" %>
<ul class="pagination pagination-lg page-float ${param.custom_class}" style="${param.custom_style}">


    <li class="${param.current_page == param.end_page ? 'disabled' : ''}"><a href="">首页</a></li>
    <li><a href="">上一页</a></li>
    <!-- 其他页-->
    <li><a href="">444</a></li>
    <!-- 当前页 -->
    <li class="active ${param.current_page}"><a href="" >3333</a></li>
    <!-- 其他页-->
    <li><a href="">22</a></li>
    <li><a href="">下一页</a></li>
    <li class="${param.current_page == param.end_page ? 'disabled' : ''}"><a href="">尾页</a></li>
</ul>
<ul class="pagination page-float" style="float: right;margin-right: 0px;">
    <li class=""><a href="">首页</a></li>
    <li><a href="">上一页</a></li>
    <!-- 其他页-->
    <li><a href="">444</a></li>
    <li><a href="">444</a></li>
    <li><a href="">444</a></li>
    <li><a href="">444</a></li>
    <!-- 当前页 -->
    <li class="active"><a href="" >3333</a></li>
    <!-- 其他页-->
    <li><a href="">22</a></li>
    <li><a href="#">下一页</a></li>
    <li class="disabled"><a href="#">尾页</a></li>
</ul>