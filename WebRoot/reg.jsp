<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
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

<title>注册_我们班</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script type="text/javascript" src="js/jquery-1.8.1.min.js"></script>
<link rel="stylesheet" href="css/reg.css" />

<script type="text/javascript">  
	    function changeValidateCode(obj) {  
	        var currentTime= new Date().getTime();  
	        obj.src = "rand.action?d=" + currentTime;  
	    }  
	</script>

</head>

<body>
	<div class="nav">
  <div class="nav_c">
    <div class="logo"><img src="images/i_logo.png" /></div>
  </div>
</div>
<div class="main">
  <div class="main_l">
    <form action="register" method="post" id="form1">
      <div style="margin-left:80px;height:30px;"></div>
      <div class="m_l_c">
        <label for="email" >邮箱<font color="#FF0000">*</font></label>
        <input type="text" placeholder="请输入注册邮箱" id="email" name="user.email"/>
        <div class="m_l_c_tip" id="eimal_tip"></div>
      </div>
      <div class="m_l_c">
        <label for="name" >姓名<font color="#FF0000">*</font></label>
        <input type="text" placeholder="请输入真实姓名" id="name" name="user.name"/>
        <div class="m_l_c_tip" id="name_tip"></div>
      </div>
      <div class="m_l_c">
        <label for="pass">密码<font color="#FF0000">*</font></label>
        <input type="password" placeholder="请输入登录密码" id="pass" name="user.password"/>
        <div class="m_l_c_tip" id="pass_tip"></div>
      </div>
      <div class="m_l_c">
        <label for="repass">确认密码<font color="#FF0000">*</font></label>
        <input type="password" placeholder="请再次输入密码" id="repass"/>
        <div class="m_l_c_tip" id="repass_tip"></div>
      </div>
      <div class="m_l_c">
        <label for="ver_code">验证码<font color="#FF0000">*</font></label>
        <input type="text" placeholder="请输入右侧的验证码" style="width:120px;" id="ver_code"/>
        <div style="width:130px;float:left"> <img src="rand.action" onclick="changeValidateCode(this)" style="margin-top:13px; float:left;cursor:pointer;" /> </div>
        <div class="m_l_c_tip" id="ver_code_tip"></div>
      </div>
      <div class="m_l_c" style="margin-left:192px;font-size:18px;">
        <div style="float:left;width:279px;">
          <input type="checkbox" checked="checked" id="service"/>
          已阅读并同意<a href="#" style="text-decoration:none;">"我们班"</a>条款 </div>
        <div class="m_l_c_tip" id="service_tip" style="font-size:16px;"></div>
      </div>
      <div class="m_l_c">
        <div class="btn">立 即 注 册</div>
        <!--
      <div ><input class="btn" type="submit" value="立 即 注 册"/></div>
      --> 
      </div>
    </form>
  </div>
</div>

<s:debug></s:debug>
<script type="text/javascript">
$(document).ready(function(e) {
	$("#email").focus().blur(verify_email);
	$("#name").blur(verify_name);
	$("#pass").blur(verify_pass);
	$("#repass").blur(verify_repass);
    $(".btn").click(function(e) {
		var flag = false;
		if(isEmpty($("#email").val()) || !(verify_email())){	
			flag = true;
		}
		if(isEmpty($("#name").val()) || !(verify_name())){
			
			flag = true;
		}
		if(isEmpty($("#pass").val()) || !(verify_pass())){
			
			flag = true;
		}
		if(isEmpty($("#repass").val()) || !(verify_repass())){
			
			flag = true;
		}
		if(verify_service() == false)
			flag = true;
		if(flag)
			return false;
		$("#form1").submit();
        
    });
	//判断input是否为空 传入的参数类似$("#email").val()
	function isEmpty(x){
		if(x == "" || $.trim(x).length<=0)
		return true;
		return false;
	}
	//验证邮箱
	function verify_email(){
		var reg = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/; //验证邮箱的正则表达式
		if(isEmpty($("#email").val())){
			$("#eimal_tip").html("<font style='color:red'> 请输入邮箱注册邮箱</font>");
			//$("#email").focus();
			return false;
			}
		else if(!reg.test($("#email").val()))
		{
			$("#eimal_tip").html("<font style='color:red'> 请输入正确的邮箱</font>");
			//$(this).focus();
			return false;
		}else{
			$.post("json/JsonCheck",{email:$("#email").val()},function(data){
				//直接使用数据，这里不能取得data.name的值，因为在Action中使用注解使其不被返回
				if(data.result == false)
					$("#eimal_tip").html("<font style='color:green'> 此邮箱可以注册</font>");
				else{
					$("#eimal_tip").html("<font style='color:red'> 此邮箱已经被注册</font>");
					return false;
				}
					
			},"json");
			}
		return true;
	}
	//判断用户名不能为空
	function verify_name(){
		if(isEmpty($("#name").val())){
			$("#name_tip").html("<font style='color:red'> 请输姓名</font>");
			//$("#name").focus();
			return false;
		}else{
			$("#name_tip").html("");
		}
		return true;
	}
	//判断密码不能为空
	function verify_pass(){
		var pass = $("#pass");
		if(isEmpty(pass.val())){
			$("#pass_tip").html("<font style='color:red'> 请输入密码</font>");	
			//pass.focus();
			return false;
		}
		else{
			$("#pass_tip").html("");
			}
		return true;
	}
	//判断密码是否一致
	function verify_repass(){
		var pass = $("#pass");
		var repass = $("#repass");
		if(isEmpty(pass.val())){
			$("#pass_tip").html("<font style='color:red'> 请输入密码</font>");	
			//pass.focus();
			return false;
		}else{$("#pass_tip").html("");
			}
		if(isEmpty(repass.val())){
			$("#repass_tip").html("<font style='color:red'> 请再次输入密码</font>");	
			//repass.focus();
			return false;
		}else{
			$("#repass_tip").html("");	
		}
		if(!(pass.val() == repass.val())){
			$("#repass_tip").html("<font style='color:red'> 两次输入的密码不一致</font>");	
			//pass.focus();
			return false;
		}else{
			$("#repass_tip").html("");	
			}
		return true;
	}
	//判断服务条款是否已经选择
	function verify_service(){
		if(!($("#service").attr("checked") == "checked")){
			$("#service_tip").html("<font style='color:red'> 请同意服务条款</font>");
			return false;
		}else{
			$("#service_tip").html("");
		}
		return true;
	}
});
</script>
</body>
</html>
