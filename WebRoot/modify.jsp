<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>设置资料_我们班</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="css/head.css" />
<link rel="stylesheet" type="text/css" href="css/home.css" />
<link rel="stylesheet" type="text/css" href="css/modify.css" />
<script type="text/javascript" src="js/jquery-1.8.1.min.js"></script>

</head>

<body>
	<div class="header">
		<div class="container">
			<div style="float:left">
				<img src="images/logo.png" style="margin-left:30px;" />
			</div>
			<div class="nav page-nav">
				<ul>
					<li><a href="home.jsp">我的资料</a></li>
       				<li><a href="myClass_myClass">班级</a></li>
        			<li><a href="message.jsp">消息</a></li>
				</ul>
			</div>
			<div class="nav info-ul">
				<ul>
					<li><a>您好<s:property value="#session.user.name" />
					</a>
					</li>
					<li><a href="/logout" title="退出">退出</a></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="home_container">
  <div class="nav_blank"><!-- 内容区域的一段白色的区分条--></div>
  <div class="user_info radiu" style="height:auto;"><!-- 用户信息 -->
    <div class="title"><span>我的资料</span>
      <hr/>
    </div>
    <form action="modify" method="post" id="fonm1" >
      <div class="u">
        <div class="u_l">用户名：</div>
        <div class="u_r">123456@123.com</div>
      </div>
      <div class="u">
        <div class="u_l">姓名：</div>
        <div class="u_r">123456</div>
      </div>
      <div class="u">
        <div class="u_l">学校：</div>
        <div class="u_r">广东金融学院</div>
      </div>
      <s:debug></s:debug>
      <s:if test="#session.user.phones == null || #session.user.phones.size() == 0">
      	<div class="u">
      		<div class="u_l">手机：</div>        
        	<div class="u_r">
          		<input type="text" value='' name="phones" class="phone"/>
	      		<div class="phone_remove"><img src="images/action_remove.png" style="height:20px;width:20px;" /></div>
	          	<div class="phone_add"><img src="images/action_add.png" style="height:20px;width:20px;" /></div>
       		 </div>
      	</div>
      </s:if>
      <s:iterator value="#session.user.phones" id="p" status="status">
      	<div class="u">
      		<s:if test="#status.index == 0">
      			<div class="u_l">手机号：</div>
      		</s:if>
      		<s:else>
      			<div class="u_l">&nbsp;&nbsp;&nbsp;</div>
      		</s:else>
        
        <div class="u_r">
          <input type="text" value='<s:property value="#p.phone"/>' name="phones" class="phone"/>
          <s:if test="#status.index == 0">
      		<div class="phone_remove"><img src="images/action_remove.png" style="height:20px;width:20px;" /></div>
          	<div class="phone_add"><img src="images/action_add.png" style="height:20px;width:20px;" /></div>
      	</s:if> 
        </div>
      </div>
      </s:iterator>
      
      <div class="btn_c">
        <div class="btn" id="save">保存</div>
        <div class="btn" id="cancel">取消</div>
      </div>
    </form>
  </div>
</div>
<script type="text/javascript">
$(document).ready(function(e) {
	$(".phone_remove").hide();
    $(".phone_add").click(function(e) {
        $(".u:last").after('<div class="u"><div class="u_l">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div><div class="u_r"><input type="text"  name="phones" class="phone"/> </div></div>');
		$(".phone_remove").show();
    });
	$(".phone_remove").click(function(e) {
        $(".u:last").remove();
		if($(".u").length == 4)
		$(".phone_remove").hide();
    });
	$("#save").click(function(e) {
		var reg =  /(^0{0,1}1[3|4|5|6|7|8|9][0-9]{9}$)/;
		var phones = $(".phone");
		for(var i = 0 ;i<phones.length;i++)
		{
			if(!reg.test(phones.get(i).value))
			{
				alert("请输入正确的手机号");
				return false;	
			}	
		}
        $("#fonm1").submit();
    });
	$("#cancel").click(function(e) {
        window.location.href="home.jsp";
    });
});
</script>
</body>
</html>
