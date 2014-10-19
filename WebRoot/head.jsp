<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="header">
  <div class="container" >
    <div style="float:left"> <img src="images/logo.png" style="margin-left:30px;"/> </div>
    <div class="nav page-nav">
      <ul>
        <li><a href="home.jsp">我的资料</a></li>
        <li><a href="myClass_myClass">班级</a></li>
        <li><a href="message.jsp">消息</a></li>
      </ul>
    </div>
    <div class="nav info-ul">
      <ul>
        <li><a>您好 <s:property value="#session.user.name"/></a></li>
        <li><a href="modify.jsp" title="设置">设置</a> </li>
        <li><a href="/logout" title="退出">退出</a> </li>
      </ul>
    </div>
  </div>
</div>