<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>消息_我们班</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/head.css" />
<link rel="stylesheet" type="text/css" href="css/home.css" />
<link rel="stylesheet" type="text/css" href="css/message.css" />
<script type="text/javascript" src="js/jquery-1.8.1.min.js"></script>

  </head>
  
  <body>
    <%@ include file="head.jsp"%>
    <div class="home_container">
  <div class="nav_blank"><!-- 内容区域的一段白色的区分条--></div>
  <div class="m_main radiu">
    <div class="m_left">
      <div class="m_l_nav"> <span>消 息</span> </div>
      <div class="m_sort" id="my"> <span>我的申请</span> </div>
      <div class="m_sort" id="other"> <span>申请审批</span> </div>
    </div>
    <div class="m_right">
      <div class="m_r_main">
      </div>
    </div>
  </div>
</div>
<div class="dialog"></div>
<!-- 点击后显示本次申请的详细信息 -->
<div class="message radiu">
  <div class="message_nav">
    <div class="m_nav_title">消 息</div>
    <div class="m_nav_close">[关闭]</div>
  </div>
  <div class="message_con"> <a href="#">谁谁谁</a>请求加入班级：<a href="#">某某某</a><br/>
    请求信息为：我想加入班级某某某。 </div>
  <div style="border-bottom:1px solid #CCC;width:100%;margin-bottom:20px;"></div>
  <div class="m_bottom radiu cancel"><span>取 消</span></div>
  <div class="m_bottom radiu" id="agree"><span>不 同 意</span></div>
  <div class="m_bottom radiu" id="disagree"><span>同 意</span></div>
</div>
<script type="text/javascript">
$(document).ready(function(e) {
	//打开页面右侧加载我的申请
	$.post("json/JsonMessage",{type:1},function(data){
		var str = "";
		$.each(data.list,function(i,item){
			str += ' <div class="m_detail"><div class="m_detail_l">'+item.content+'</div><div class="m_detail_r">'+item.createDate+'</div><input type="hidden" value="1"/></div>';
		});
		$(".m_r_main").html(str);
		//加载完成之后还需要注册一次事件
		load();
	},"json");
	
    //鼠标点击左菜单 背景会变成白色 并且右侧内容进行加载
	var m = $(".m_sort");
	m.first().addClass("m_l_bgc");
	m.click(function(e) {
        $(this).addClass("m_l_bgc").siblings().removeClass("m_l_bgc");
    });
	
	//点击我的申请
	$("#my").click(function(e) {
		$.post("json/JsonMessage",{type:1},function(data){
			var str = "";
			$.each(data.list,function(i,item){
				str += ' <div class="m_detail"><div class="m_detail_l">'+item.content+'</div><div class="m_detail_r">'+item.createDate+'</div><input type="hidden" value="1"/></div>';
			});
			$(".m_r_main").html(str);
			//加载完成之后还需要注册一次事件
			load();
		},"json");
    });
	$("#my").click();
	//点击申请审批
	$("#other").click(function(e) {
		$.post("json/JsonMessage",{type:2},function(data){
			var str = "";
			$.each(data.list,function(i,item){
				str += ' <div class="m_detail"><div class="m_detail_l">'+item.content+'</div><div class="m_detail_r">'+item.createDate+'</div><input type="hidden" value="2"/></div>';
			});
			$(".m_r_main").html(str);
			//加载完成之后还需要注册一次事件
			load();
		},"json");
    });
	//页面重新加载后需要重新为DOM对象绑定事件
	function load()
	{
		//鼠标经过右侧信息对应的行会变色
		$(".m_detail").mouseover(function(e) {
	        $(this).css("background-color","#EAF5F9");
	    }).mouseout(function(e) {
	        $(this).css("background-color","");
	    });;
		//点击右侧信息会弹出对应的模态对话框
		$(".dialog").hide();
		$(".message").hide();
		$(".m_detail").click(function(e) {
	         $(".dialog").css("height",$(document).height()).show();
			 var left = ($(document).width()-500)/2;
			 if($(this).children("input[type=hidden]").val()==1)
			{
				 $("#agree").hide();
				 $("#disagree").hide();
			}
			$(".message").css("left",left).show();
	    });
		$(".m_nav_close,.cancel").click(function(e) {
	        $(".dialog").hide();
			$(".message").hide();
	    });
	}
	load();
	
});
</script>
  </body>
</html>
