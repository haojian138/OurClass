<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'user.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/head.css" />
	<link rel="stylesheet" type="text/css" href="css/home.css" />

  </head>
  
  <body>
  <%@ include file="head.jsp"%>
    <div class="home_container">
  <div class="nav_blank"><!-- 内容区域的一段白色的区分条--></div>
  <div class="user_info radiu"><!-- 用户信息 -->
    <div class="title"><span>我的资料</span>
      <hr/>
      <div class="u">
        <div class="u_l">用户名：</div>
        <div class="u_r">123456789@qq.com</div>
      </div>
      <div class="u">
        <div class="u_l">姓名：</div>
        <div class="u_r"><s:property value="user.name"/></div>
      </div>
      <div class="u">
        <div class="u_l">学校：</div>
        <div class="u_r">广东金融学院</div>
      </div>
      <div class="u">
        <div class="u_l">手机：</div>
        <div class="u_r">13579246810</div>
      </div>
    </div>
  </div>
  <div class="nav_blank"><!-- 内容区域的一段白色的区分条--></div>
  
</div>
  </body>
</html>
