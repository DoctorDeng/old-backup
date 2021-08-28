<%--
  Created by IntelliJ IDEA.
  User: Doctor邓
  Date: 2017/4/6
  Time: 20:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${param.buttom_type == 'bottom_fixed'}">
    <div class="bottom" style="position:absolute;bottom:0px;margin-top: 20px;background-color: rgba(0,0,0,0.8);width:100%;height: 100px;color: darkgray">
        <div style="width: 460px;padding-top: 35px;padding-left:40px;padding-right: 40px;margin:auto;">
            <div>
                友情链接:
                <a href="https://github.com/DoctorDeng" style="color: darkgray">&nbsp;GitHub&nbsp;|&nbsp;</a>
                <a href="http://www.csdn.net/" style="color: darkgray">CSDN&nbsp;|&nbsp;</a>
                <a href="http://www.oschina.net/" style="color: darkgray">开源中国&nbsp;|&nbsp;</a>
                <a href="http://stackoverflow.com/" style="color: darkgray">Stack Overflow</a><br>
            </div>
        </div>
    </div>
</c:if>
<c:if test="${param.buttom_type != 'bottom_fixed'}">
    <div style="margin-top: 80px;background-color: rgba(0,0,0,0.8);height: 100px;color: darkgray">
        <div style="width: 460px;padding-top: 35px;padding-left:40px;padding-right: 40px;margin:auto;">
            <div>
                友情链接:
                <a href="https://github.com/DoctorDeng" style="color: darkgray">&nbsp;GitHub&nbsp;|&nbsp;</a>
                <a href="http://www.csdn.net/" style="color: darkgray">CSDN&nbsp;|&nbsp;</a>
                <a href="http://www.oschina.net/" style="color: darkgray">开源中国&nbsp;|&nbsp;</a>
                <a href="http://stackoverflow.com/" style="color: darkgray">Stack Overflow</a><br>
            </div>
        </div>
    </div>
</c:if>

