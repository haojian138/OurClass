<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>班级_我们班</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/head.css" />
<link rel="stylesheet" type="text/css" href="css/home.css" />
<link rel="stylesheet" type="text/css" href="css/class.css" />
<link rel="stylesheet" type="text/css" href="css/dialog.css"/>
<script type="text/javascript" src="js/jquery-1.8.1.min.js"></script>

  </head>
  
  <body>
    <%@ include file="head.jsp"%>
    <div class="home_container">
  <div class="nav_blank"><!-- 内容区域的一段白色的区分条--></div>
  <div class="class_left"><!-- 班级页面的左半部分 -->
    <div class="class_top">
      <div class="class_btn radiu" id="join"><span>加入班级</span></div>
      <div class="class_btn radiu" id="create"><span>创建班级</span></div>
    </div>
    <s:iterator value="classes" id="c">
    	<s:if test="#c.user.id == #session.user.id">
		    <div class="class_name"><span><s:property value="#c.name"/></span>
		    	<input type="hidden" value='<s:property value="#c.id"/>' />
		       <div class="down"><input type="hidden" value='<s:property value="#c.id"/>' /></div>
		    </div>
	    </s:if>
	    <s:else>
		    <div class="class_name"><span><s:property value="#c.name"/></span>
		    	<input type="hidden" value='<s:property value="#c.id"/>' />
		      <div class="down_other"><input type="hidden" value='<s:property value="#c.id"/>' /></div>
		    </div>
	    </s:else>
	</s:iterator>
  </div>
  <div class="class_right"><!-- 班级显示的右侧界面 -->
    <div class="class_top"> <span>&gt;&nbsp;</span> </div>
   
  </div>
</div>
<!--定义了一些隐藏的显示层 在点击的时候会显示--> 
<!--鼠标点击下拉小图标的时候显示的隐藏层-->
<div class="down_content radiu">
  <div class="bgc"><span>邀请用户</span></div>
  <div class="bgc" id="modify"><span>修改信息</span></div>
  <div class="bgc"><span>删除班级</span></div>
</div>
<div class="down_content_other radiu">
  <div class="bgc"><span>邀请用户</span></div>
  <div class="bgc" id="exit"><span>退出班级</span></div>
</div>
<!-- 的模态对话框-->
<div class="modal_dialog"> </div>
<!--加入班级-->
<div class="join radiu">
  <div class="join_nav">
    <div class="nav_title">加入班级</div>
    <div class="nav_close">[关闭]</div>
  </div>
  <form action="myClass_join" method="post" id="form_join">
  <div class="join_search">输入班级名称或ID:
    <input type="text" style="width:200px;" id="search"/>
    <div class="btn_search radiu"><span>查 找</span></div>
  </div>
  <div class="join_result">
    <div class="join_result_select radiu"></div>
    <div class="join_result_content"> <span>请输入请求信息:</span>
      <input type="text" name="content"/>
    </div>
  </div>
  <div class="join_bottom radiu cancel"><span>取 消</span></div>
  <div class="join_bottom radiu" id="join_class"><span>加 入</span></div>
  </form>
</div>

<!-- 创建班级 -->
<div class="create radiu">
  <div class="create_nav">
    <div class="nav_title">创建班级</div>
    <div class="nav_close">[关闭]</div>
  </div>
  <form action="myClass_create" method="post" id="form_create">
  <div class="create_main">
    <div class="create_main_content" >班级名称:
      <input type="text" id="class_title" name="myClass.name"/>
    </div>
    <div class="create_main_content" >班级简介:
      <textarea name="myClass.description"></textarea>
    </div>
  </div>
  <div class="join_bottom radiu cancel"><span>取 消</span></div>
  <div class="join_bottom radiu" id="create_class"><span>创 建</span></div>
  </form>
</div>
<s:debug></s:debug>
<script type="text/javascript">
$(document).ready(function() {
	var myid;//记录用户点击的班级的id
	//点击修改信息
	 $("#modify").click(function(e) {
		 //修改此处决定调用的方法
		 window.location.href="http://www.baidu.com";
   });
	//用户退出班级
		$("#exit").click(function(e) {
	        window.location="myClass_kickout?id="+<s:property value="#session.user.id"/>+"&uid="+<s:property value="#session.user.id"/>+"&cid="+myid;
	    });
	//下拉按钮 鼠标经过变色
	$(".bgc").mouseover(function(e) {
        $(this).addClass("spancolor");
    }).mouseout(function(e) {
        $(this).removeClass("spancolor");
    });
	//下拉按钮的弹出框隐藏 并且绑定鼠标离开后隐藏
	$(".down_content").bind("mouseleave",function(){
		$(this).hide();
		}).hide();
	$(".down_content_other").bind("mouseleave",function(){
		$(this).hide();
		}).hide();
		
	//显示用户界面 鼠标经过那一行会变色
   $(".class_user").mouseover(function(){
	   $(this).css("background","#EAF5F9");
	   })
	 .mouseout(function(){
		   $(this).css("background","");
		   });
		   
	//班级显示界面 鼠标经过的时候变色
	 $(".class_name").mouseover(function(){
	   $(this).css("background","#EAF5F9");
	   })
	 .mouseout(function(){
		   $(this).css("background","");
		   });
		   
	//鼠标经过小下拉图标的时候图标会变色
		//此班级为自己创建 显示有邀请用户 修改信息 删除班级
	$(".down").mouseover(function(){
		$(this).addClass("down_mouseover");
		})
		.mouseout(function(){
			$(this).removeClass("down_mouseover");
			})
		.click(function(e) {
			myid = $(this).parent().children("input[type=hidden]").val();
            $(".down_content").css("left",e.clientX-4).css("top",e.pageY-4).show("slow")
				
        });
		//此班级非自己创建  显示有邀请用户 退出班级
	$(".down_other").mouseover(function(){
		$(this).addClass("down_mouseover");
		})
		.mouseout(function(){
			$(this).removeClass("down_mouseover");
			})
		.click(function(e) {
			myid = $(this).parent().children("input[type=hidden]").val();
            $(".down_content_other").css("left",e.clientX-4).css("top",e.pageY-4).show("slow")
				
        });
	
	//点击创建查找班级会显示模态对话框
	$(".modal_dialog").hide();
	$(".join").hide();
	$(".join_result").hide();
	$("#join").click(function(e) {
        $(".modal_dialog").css("height",$(document).height()).show();
		var left = ($(document).width()-500)/2;
		$(".join").css("left",left).show();
    });
	$(".nav_close,.cancel").click(function(e) {//同时也会关闭创建班级的页面
        $(".modal_dialog").hide();
		$(".join").hide();
		$(".join_result").hide();
		$(".create").hide();
    });
	//点击查找后使用ajax条用远程服务器
	$(".btn_search").click(function(e) {
		var s = $("#search").val();
		if(s == "" || $.trim(s).length <= 0)
		{
			alert("请输入查询条件");
			return false;	
		}
		$.post("json/JsonSearch_C",{ search:s },function(data){
			if(data.list == null || data.list.length<= 0){//查无结果
				$(".join_result_select").hide();
				$(".join_result_content").hide()
				$(".join_result").html("<p>没有查到相应的结果</p>").show();
			}else{//查到结果
				var ss ="";
				$.each(data.list,function(i,item){		
					ss = ss + '<div style="display:block; margin-left:20px;clear:both;"><input type="radio" name="class_id" value="'+item.id+'" style="float:left;" /><div style="float:left; margin-left:20px;">'+ item.name+'</div></div>';
				});
				$(".join_result_select").html(ss);
				$(".join_result").show();
			}	
		},"json");
		
    });
	
	//加入班级 点击加入后
	$("#join_class").click(function(e) {
        var select = $("input[name='class_id']:checked").val();
		if(select == undefined)
		{
			alert("请选择加入的班级");
			return false;
		}
		$("#form_join").submit();
    });
	
	//点击创建班级后出现对话框
	$(".create").hide();
	$("#create").click(function(e) {
        $(".modal_dialog").css("height",$(document).height()).show();
		var left = ($(document).width()-500)/2;
		$(".create").css("left",left).show();
    });
	//创建班级 点击创建后
	$("#create_class").click(function(e) {
        //验证班级名称不能为空
		var t = $("#class_title").val();
		if(t== null ||t == "" || $.trim(t).length<=0)
		{
			alert("班级名称不能为空");
			return false;
		}
		$("#form_create").submit();
    });
	//右侧显示第一个班级的用户
	
	
	//点击班级名称后 右侧显示相应的用户
	$(".class_name").children("span").click(function(e) {
        var t = $(this).parent().children("input[type=hidden]").val();//班级id
        var flag = false;
        if($(this).parent().children(".down").length > 0)
     		flag = true;
        var ss = '<div class="class_top"> <span>&gt;&nbsp;'+$(this).parent().children("span").text()+'</span> </div>';
        $.post("json/JsonGetClassUsers",{id:t},function(data){
        	$.each(data.list,function(i,item){		
				ss = ss + '<div class="class_user"><input type="hidden" value="'+item.id+'"/><div class="user_name">'+item.name+'</div><div class="user_line"></div><div class="user_address">广东省广州市</div><div class="user_line"></div>';
				if(flag && item.id != <s:property value="#session.user.id"/>)
					ss = ss + '<div class="user_btn radiu kickout" >踢出</div>';
				ss = ss + '<div class="user_btn radiu look">查看</div></div>';
			});
        	$(".class_right").html(ss);
        	$(".class_user").mouseover(function(){
        		   $(this).css("background","#EAF5F9");
        		   })
        		 .mouseout(function(){
        			   $(this).css("background","");
        			   });
        	$(".look").click(function(e) {
        	    var t1 = $(this).parent().children("input[type=hidden]").val();
        		window.open("userInfo?id="+t1+"&uid="+<s:property value="#session.user.id"/>);
        		
        	});
        	$(".kickout").click(function(e) {
        	    var t2 = $(this).parent().children("input[type=hidden]").val();
        		window.location="myClass_kickout?id="+t2+"&uid="+<s:property value="#session.user.id"/>+"&cid="+t;
        		
        	});
        },"json");
		
    });
	$(".class_name").children("span").first().click();
});

</script>
  </body>
</html>
