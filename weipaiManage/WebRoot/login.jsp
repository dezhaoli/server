<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>微牌后台管理系统登陆</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Modern Responsive web template, Bootstrap Web Templates, Flat Web Templates,
			 Andriod Compatible web template,Smartphone Compatible web template, free webdesigns for Nokia, Samsung,
			  LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript">
			addEventListener("load", function() {
				setTimeout(hideURLbar, 0);
			}, false);

			function hideURLbar() {
				window.scrollTo(0, 1);
			}
		</script>
<script type="text/javascript">

	function login(){
	
		$.ajax({	
		
			   type: "POST",
			   url: "<%=basePath%>controller/manager/login",
			   data: "username="+$("#username").val()+"&password="+$("#password").val(),
			   success: function data(data){
			            
						var param = eval('('+data+')');
						if(param.mess == 0){
							
							window.location = "<%=basePath%>view/index.jsp";
				} else {
					alert("登录失败，账户或密码有误");
				}
			}
		});
	}
	
</script>

<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel='stylesheet' type='text/css' />
<!-- Custom CSS -->
<link href="css/style.css" rel='stylesheet' type='text/css' />
<link href="css/font-awesome.css" rel="stylesheet">
<!-- jQuery -->
<script src="js/jquery.min.js"></script>
<!----webfonts--->
<link
	href='http://fonts.useso.com/css?family=Roboto:400,100,300,500,700,900'
	rel='stylesheet' type='text/css'>
<!---//webfonts--->
<!-- Bootstrap Core JavaScript -->
<script src="js/bootstrap.min.js"></script>

<script type="text/javascript" src="js/sysOperate/users.js"></script>
</head>

<body id="login">
	<div class="login-logo">
		<a href="index.html"><img src="images/logo.png" alt="" /> </a>
	</div>
	<div class="app-cam">
		<form>
			<input type="text" class="text" value="用户名" id="username"
				onfocus="this.value = '';"
				onblur="if (this.value == '') {this.value = '用户名';}"> &nbsp;
			<input type="password" value="password" id="password"
				onfocus="this.value = '';"
				onblur="if (this.value == '') {this.value = 'Password';}"> <!-- <input
				type="radio" name="role" value="admin" /> <label> 管理员 </label> <input
				type="radio" name="role" value="agent" /> <label> 代理商 </label> <input
				type="radio" name="role" value="retailer" /> <label> 零售商 </label> -->
			<div class="button">
				<input type="button" onclick="login()" value="登陆">
			</div>
			<ul class="new">
				<li class="new_left">
					<p>
						<a href="#">修改密码</a>
					</p></li>
				<li class="new_right">
					<p class="sign">
						<a href="register.html"> 注册</a>
					</p></li>
				<div class="clearfix"></div>
			</ul>
		</form>
	</div>
	<div class="copy_layout login">
		<p>
			Copyright &copy; 2016.Company name All rights reserved. <a
				target="_blank">微牌官方</a>
		</p>
	</div>
</body>
</html>
