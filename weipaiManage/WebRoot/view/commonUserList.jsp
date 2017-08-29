<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>普通用户列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="普通用户列表">
	<script type="text/javascript" src="../js/jquery.js"></script>
	<script type="text/javascript" src="../js/jquery-easyui-1.2.6/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="../js/jquery-easyui-1.2.6/jquery.easyui.min.js"></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	<style  type="text/css" >
		#myTable tr th,td{
			width:80px;
			height: 30px;
			border:1px solid black;
			text-align: center;
		}
		#two{
			margin-left:200px;
			width:80%;
			height:85%;
			border: 1px solid black;
		}
		#foot{
			border: 1px solid black; 
		}
	</style>
	<script type="text/javascript">
		
	</script>
  </head>
  <body id="b">
   	 <div id="two">
   	 	<table id ="myTable">
   	 		<tr>
		   	 	<!-- <th>id</th>
		   	 	<th>用户表外键</th> -->
		   	 	<th>实名</th>
		   	 	<th style="width:200px">微信openid</th>
		   	 	<th>金额</th>
		   	 	<th  style="width:200px">申请时间</th>
		   	 	<th style="width:200px">审核/提现时间</th>
		   	 	<th style="width:200px">微信unionid</th>
		   	 	<th style="width:150px">是否提现</th>
		   	 	<th style="width:280px">红包流水号</th>
   	 		</tr>
   	 	</table>
   	 	<div id="foot">
   	 		当前页：<span class="currentPage"></span> 
   	 		总页数：<span class="allPages"></span>
   	 	</div>
   	 </div>
  </body>
</html>
