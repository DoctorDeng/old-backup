<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="bean.viewBean.*" %>
<%@page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title></title>
        <c:set var="hasPower">false</c:set>
        <c:forEach items="${sessionScope.admin.powerList}" var="adminPower" >
  		<c:set var="power">${adminPower.power}</c:set>
  			<c:choose>
  				<c:when test="${power==5}">
                	<c:set var="hasPower">true</c:set>
  				</c:when>
  			</c:choose>
  		</c:forEach>
  		<!-- 当用户没有此页面的权限时，跳转到权限提示页面 -->
  		<c:if test="${hasPower==false}">
  		<%
  			response.sendRedirect("../nopower.jsp");
  		%>
  		</c:if>
        <link type="text/css" rel="stylesheet" media="all" href="../styles/global.css" />
        <link type="text/css" rel="stylesheet" media="all" href="../styles/global_color.css" />
    </head>
    <body>
        <!--Logo区域开始-->
        <div id="header">
            <img src="../images/logo.png" alt="logo" class="left"/>
            <a href="#">[退出]</a>            
        </div>
        <!--Logo区域结束-->
        <!--导航区域开始-->
        <div id="navi">
            <ul id="menu">
                <%@include file= "../template/power.jsp" %>
            </ul>
        </div>
        <!--导航区域结束-->
        <!--主要区域开始-->
        <div id="main">            
            <form action="" method="" class="main_form">
                <>!--必填项-->
                <%
                List<ServiceAddViewBean>  lsit = (ArrayList<ServiceAddViewBean>)session.getAttribute("lsit");
                for(ServiceAddViewBean sv : lsit){
                %>
                <div class="text_info clearfix"><span>业务账号ID：</span></div>
                <div class="input_info"><input type="text"  readonly class="readonly" value="<%=sv.getBussinessId()%>" /></div>
                <div class="text_info clearfix"><span>账务账号ID：</span></div>
                <div class="input_info"><input type="text"  readonly class="readonly" value="<%=sv.getAdminId() %>"/></div>
                <div class="text_info clearfix"><span>客户姓名：</span></div>
                <div class="input_info"><input type="text" readonly class="readonly"  value="<%=sv.getCustomerName() %>"/></div>
                <div class="text_info clearfix"><span>身份证号码：</span></div>
                <div class="input_info"><input type="text" readonly class="readonly"  value="<%=sv.getIdNumber() %>"/></div>
                <div class="text_info clearfix"><span>服务器 IP：</span></div>
                <div class="input_info"><input type="text"  readonly class="readonly" value="<%=sv.getServerId() %>" /></div>
                <div class="text_info clearfix"><span>OS 账号：</span></div>
                <div class="input_info"><input type="text"  readonly class="readonly" value="<%=sv.getOsAccount() %>"/></div>
                <div class="text_info clearfix"><span>状态：</span></div>
                <div class="input_info">
                    <select disabled >
                        <option value="">开通</option>
                        <option value="">暂停</option>
                        <option value="">删除</option>
                    </select>                        
                </div>
                <div class="text_info clearfix"><span>开通时间：</span></div>
                <div class="input_info"><input type="text" readonly class="readonly" value="<%=sv.getOpenTime() %>" /></div>
                <div class="text_info clearfix"><span>资费 ID：</span></div>
                <div class="input_info"><input type="text" class="readonly" readonly value="<%=sv.getTariffId() %>"/></div>
                <div class="text_info clearfix"><span>资费名称：</span></div>
                <div class="input_info"><input type="text" readonly class="width200 readonly" value="<%=sv.getTraiffName() %>"/></div>
                <div class="text_info clearfix"><span>资费说明：</span></div>
                <div class="input_info_high">
                    <textarea class="width300 height70 readonly" readonly><%=sv.getTariffExplain() %></textarea>
                </div>  
                <!--操作按钮-->
                <div class="button_info clearfix">
                    <input type="button" value="返回" class="btn_save" onclick="location.href='service_list.jsp';" />
                </div>
                <%
                }
                %>>
            </form>
        </div>
        <!--主要区域结束-->
        <div id="footer">
           
        </div>
    </body>
</html>