<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>零售商列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="零售商列表">
	<script type="text/javascript" src="../js/jquery.js"></script>
	<script type="text/javascript" src="../js/jquery-easyui-1.2.6/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="../js/jquery-easyui-1.2.6/jquery.easyui.min.js"></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	<style  type="text/css" >
		#myTable tr th,td{
			width:150px;
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
  </head>
  <body id="b">
  	<script type="text/javascript">
		$(function(){
			var currentPage=1;
			$.ajax({
				   type: "POST",
				   url: "<%=basePath%>controller/manager/getUserList",
				   data: "type=3&currentPage="+currentPage,
				   dataType: "html",
				   success: function data(data){
						  var dat = eval('('+data+')');
						  if(dat.status_code=="0"){
						   	 alert("1");
						   	 successFunction(dat);
						  }else{
						   		alert("失败")
						  }
					}
				});
			});
		function successFunction(dat){
			 //移除第一个字标签以后的所有标签
			 $("#myTable tr:gt(0)").remove();
			 var currentPage=dat.currentPage;
	         var allPages = dat.allPages;
	         var param = dat.data;
	         $.each(param, function (i, item) {
	         	alert("1");  
	              var td = "<td hidden='true'>"+param[i].id+"</td>";
						td+="<td  hidden='true'>"+param[i].name+"</td>";
						td+="<td>"+param[i].actualCard+"</td>";
						td+="<td>"+param[i].totalCard+"</td>";
				$("#myTable").append("<tr>"+td+"</tr>");
	          }); 
	            $(".currentPage").html(currentPage);//当前页
			    $(".allPages").html(allPages);//总页数
			    $(".allPages").nextAll().remove();//移除class为allPages后面的所有标签
				//type, page
				var prePage=0;
				var nextPage =0;
				if(currentPage < allPages  ){
					nextPage = page+1;
				}
				else{
					nextPage = allPages;
				}
				if(currentPage > 1 ){
					prePage =  page-1;
				}
				 var inpt = "<input  type='button' value='首页' class='firstPage' onclick='firstPage("+0+")'/>";
								inpt+="<input  type='button' value='上一页' class='prePage' onclick='prePage("+prePage+")'/>";
								inpt+="<input  type='button' value='下一页' class='nextPage' onclick='nextPage("+nextPage+")'/>";
								inpt+="<input  type='button' value='最后页' class='lastPage' onclick='lastPage("+allPages+")'/>";
				$("#foot").append(inpt);
			}
	</script>
   	 <div id="two" style="margin-left:50px;width:80%;height:85%;border: 1px solid black;">
   	 	<table id ="myTable">
   	 		<tr>
		   	 	<!-- <th>id</th>-->
		   	 	<th style="width:100px;height: 30px;border:1px solid black;text-align: center;">选择</th> 
		   	 	<th style="width:150px;height: 30px;border:1px solid black;text-align: center;">名字</th>
		   	 	<th style="width:200px;height: 30px;border:1px solid black;text-align: center;">当前金币</th>
		   	 	<th style="width:200px;height: 30px;border:1px solid black;text-align: center;">总金币</th>
		   	 	<th style="width:280px;height: 30px;border:1px solid black;text-align: center;">操作</th>
   	 		</tr>
   	 	</table>
   	 </div>
   	 <div id="foot">
   	 		当前页：<span class="currentPage"></span> 
   	 		总页数：<span class="allPages"></span>
   	 	</div>
  </body>
</html>