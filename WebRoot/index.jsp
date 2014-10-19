<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登陆_我们班</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="js/jquery-1.8.1.min.js"></script>
	<link rel="stylesheet" href="css/index.css" />
	<script type="text/javascript">  
		var verifycode = "";
	    function changeValidateCode(obj) {  
	        var currentTime= new Date().getTime();  
	        obj.src = "rand.action?d=" + currentTime; 
	        checkVC();
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
  <div class="main_l"><img src="images/show1.png" /></div>
  <div class="main_r">
    <div class="login_title"><span>登录我们班</span></div>
    <form action="login" method="post" id="form1">
      <div class="login_user"><span>用户名:
        <input type="text" name="user.email" id="user"/>
        </span></div>
      <div class="login_pass"><span>密&nbsp;&nbsp;&nbsp;码:
        <input type="text" name="user.password" id="pass"/>
        </span></div>
      <div class="login_verify"><span>验证码:
        <input type="text"  id="vc"/>
        </span>
        <div style="width:120px;float:right;"> <img src="rand.action" onclick="changeValidateCode(this)" style="margin-top:14px; float:left;cursor:pointer;" /> </div>
      </div>
      <div class="al">
        <div class="al_c">
          <input type="checkbox" />
          下次自动登录&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="#" style="text-decoration:none;"><font color="#0066FF">忘记密码？</font></a></div>
      </div>
      <div class="login_btn_c">
        <div class="login_btn">登录</div>
        <div class="register_btn"><a href="reg.jsp" style="text-decoration:none;color:#000;">注册</a></div>
      </div>
    </form>
  </div>
</div>
<script type="text/javascript">
	$(document).ready(function(e) {
		var flag = true;
		var str = "";
		function change(s,f)
		{
			str += s;
			flag = f;
		}
		function checkVC()
		{
			$.post("json/JsonCheckVC",{vc:$("#vc").val()},function(data){
				//if(!($("#vc").val()==""))
					if(data.result == false)
					{
						change("你输入的验证码错误，请重新输入",false);
						str += "你输入的验证码错误，请重新输入";
						flag = false;
						
					}
				},"json");
		}
		/*$("#vc").blur(function(e) {
            checkVC();
        });*/
		$(".login_btn").click(function(e) {
			
			if($("#user").val()=="")
			{
				flag = false;
				str += "\n用户名不能为空"	;
			}
			if($("#pass").val()=="")
			{
				flag = false;
				str += "\n用户密码不能为空";	
			}
			if($("#vc").val()=="")
			{
				flag = false;
				str += "\n验证码不能为空";	
			}else
				checkVC();
			if(!flag)
			{
				alert(str);
				str = "";
				flag = true;
				return;
			}
            $("#form1").submit();
        });
        
    });
</script>
  </body>
</html>
