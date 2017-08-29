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
		<title>主页</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="keywords" content="Modern Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
		Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
		<!-- Bootstrap Core CSS -->
		<link href="../css/bootstrap.min.css" rel='stylesheet' type='text/css' />
		<!-- Custom CSS -->
		<link href="../css/style.css" rel='stylesheet' type='text/css' />
		<!-- Graph CSS -->
		<link href="../css/lines.css" rel='stylesheet' type='text/css' />
		<link href="../css/font-awesome.css" rel="stylesheet">
		<!-- jQuery -->
		<script src="../js/jquery.min.js"></script>
		<!----webfonts--->
		<link href='http://fonts.useso.com/css?family=Roboto:400,100,300,500,700,900' rel='stylesheet' type='text/css'>
		<!---//webfonts--->
		<!-- Nav CSS -->
		<link href="../css/custom.css" rel="stylesheet">
		<link href="../css/jqvmap.css" rel='stylesheet' type='text/css' />
		<!-- Metis Menu Plugin JavaScript -->
		<script src="../js/metisMenu.min.js"></script>
		<script src="../js/custom.js"></script>
		<!-- Graph JavaScript -->
		<script src="../js/d3.v3.js"></script>
		<script src="../js/rickshaw.js"></script>
		<script type="text/javascript" src="../js/bootstrap.min.js"></script>
		
		<script type="text/javascript" src="../js/sysOperate/httprequest.js" ></script>
		<script type="text/javascript" src="../js/sysOperate/account_manage.js" ></script>
		<script type="text/javascript" src="../js/sysOperate/activity_manage.js" ></script>
		<script type="text/javascript" src="../js/sysOperate/gloable_data.js" ></script>
		<script type="text/javascript" src="../js/sysOperate/home.js" ></script>
		<script type="text/javascript" src="../js/sysOperate/operate_history.js" ></script>
		<script type="text/javascript" src="../js/sysOperate/user_manage.js" ></script>
		<script type="text/javascript" src="../js/sysOperate/users.js" ></script>
		
	</head>

	<body>
		<div id="wrapper">
			<div class="navbar-default sidebar" role="navigation">
				<div class="sidebar-nav navbar-collapse">
					<ul class="nav" id="side-menu">

						<li class="tltle_nav">
							<a href="#summary" onclick="selectPage('summary')"><i class="fa fa-dashboard fa-fw nav_icon"></i>概况</a>
						</li>

						<li class="tltle_nav">
							<a href="#user" onclick="selectPage('user')"><i class="fa fa-laptop nav_icon"></i>游戏会员管理<span class="fa arrow"></span></a>
						</li>
						<li class="tltle_nav">
							<a href="#activity" onclick="selectPage('activity')"><i class="fa fa-laptop nav_icon"></i>活动管理<span class="fa arrow"></span></a>
						</li>

						<li class="tltle_nav">
							<a onclick="selectPage('account')" href="#account"><i class="fa fa-indent nav_icon"></i>代理管理<span class="fa arrow"></span></a>
						</li>
						<li class="tltle_nav">
							<a onclick="selectPage('user')" href="#account"><i class="fa fa-indent nav_icon"></i>充值<span class="fa arrow"></span></a>
						</li>

						<!-- <li class="tltle_nav">
							<a href="#flow" onclick="selectPage('flow')"><i class="fa fa-envelope nav_icon"></i>流水查询<span class="fa arrow"></span></a>
						</li> -->
					</ul>
				</div>

			</div>
			<nav style="height: 50px ;line-height: 50px;background: #FFFDE7;width: 100%;" class="mobile_display">
				<a href="#summary" onclick="selectPage('summary')" style="width: 18%;text-align: center; display: inline-block;">概况</a>
				<a href="#user" onclick="selectPage('user')" style="width: 20%;text-align: center;display: inline-block;">会员管理</a>
				<a href="#activity" onclick="selectPage('activity')" style="width: 18%;text-align: center;display: inline-block;">活动管理</a>
				<a onclick="selectPage('account')" href="#account" style="width: 18%;text-align: center;display: inline-block;">账号管理</a>
				<a href="#flow" onclick="selectPage('flow')" style="width: 18%;text-align: center;display: inline-block;">流水查询</a>

			</nav>

			<div id="page-wrapper">
				<div class="graphs" id="summary">
					<div class="col_3">
						
						<p  class="sub_title">游戏公告</p>
						<label  style="margin-left: 12%;font-size:18px">当前公告： &nbsp;&nbsp;&nbsp;</label><textarea id="gameOldNotice"  style=" width: 70%;margin-top: 15px;"></textarea>
						<label  style="margin-left: 12%;font-size:18px;color:red">发布新公告：</label><textarea id="gameNotice"   placeholder="填写游戏公告" style=" width: 70%;height: 80px; margin-top: 15px;"> </textarea>
						<button  onclick="saveGameNoitce()"  style="border: 1px solid #00BCD4; border-radius: 5px; background: none; padding-left: 8px; padding-right: 8px;">发送</button>
					
					</div>
					<div class="col_3">
						<div class="sub_title">概况</div>
						
						
						<div class="col-md-3 widget widget1">
							<div class="r3_counter_box">
								<i class="pull-left fa fa-thumbs-up icon-rounded"></i>
								<div class="stats">
									<h5><strong>1245</strong></h5>
									<span>会员总数</span>
								</div>
							</div>
						</div>
						<div class="col-md-3 widget widget1">
							<div class="r3_counter_box">
								<i class="pull-left fa fa-users user1 icon-rounded"></i>
								<div class="stats">
									<h5><strong>120</strong></h5>
									<span>售出房卡总数</span>
								</div>
							</div>
						</div>
						<div class="col-md-3 widget widget1">
							<div class="r3_counter_box">
								<i class="pull-left fa fa-users user1 icon-rounded"></i>
								<div class="stats">
									<h5><strong>150</strong></h5>
									<span>房间总数</span>
								</div>
							</div>
						</div>

						<div class="clearfix"> </div>
					</div>

					<div class="col_3">
						<div class="sub_title">房间统计</div>
						<div class="col-md-3 r3_counter_box" style="height: 100px; float: left; width:48%;">

							<div style="text-align: center;">

								<div>
									<h5><strong>156</strong></h5>
									<span>当前在线房间总数</span>
								</div>
							</div>
						</div>
						<div class="col-md-3 r3_counter_box" style="float: right;height: 100px;width:48%;">
							<div style="text-align: center;">

								<div>
									<h5><strong>1019</strong></h5>
									<span>今天创建房间总数</span>
								</div>
							</div>
						</div>
						<div class="clearfix"> </div>

						<table class="table">
							<thead>
								<tr class="success">
									<th>游戏名字</th>
									<th>当前创建房间总数</th>
									<th>今天创建房间最高记录</th>
									<th>历史创建房间总数</th>
								</tr>
							</thead>
							<tbody>
								<tr class="active">
									<th scope="row">转转麻将</th>
									<td>Column content</td>
									<td>Column content</td>
									<td>Column content</td>
								</tr>
								<tr>
									<th scope="row">长沙麻将</th>
									<td>Column content</td>
									<td>Column content</td>
									<td>Column content</td>
								</tr>
								<tr>
									<th scope="row">划水麻将</th>
									<td>Column content</td>
									<td>Column content</td>
									<td>Column content</td>
								</tr>
							</tbody>
						</table>

					</div>
					<div class="col_3">
						<div class="sub_title">房卡统计</div>
						<div class="col-md-3 widget widget1">

							<div class="r3_counter_box">
								<i class="pull-left fa fa-thumbs-up icon-rounded"></i>
								<div class="stats">
									<h5><strong>45%</strong></h5>
									<span>总房卡数</span>
								</div>
							</div>
						</div>
						<div class="col-md-3 widget widget1">
							<div class="r3_counter_box">
								<i class="pull-left fa fa-users user1 icon-rounded"></i>
								<div class="stats">
									<h5><strong>1019</strong></h5>
									<span>今日售出</span>
								</div>
							</div>
						</div>
						<div class="col-md-3 widget widget1">
							<div class="r3_counter_box">
								<i class="pull-left fa fa-comment user2 icon-rounded"></i>
								<div class="stats">
									<h5><strong>1012</strong></h5>
									<span>本周售出</span>
								</div>
							</div>
						</div>

						<div class="clearfix"></div>
						<table class="table">
							<thead>
								<tr class="success">
									<th>代理名字</th>
									<th>总购房卡数</th>
									<th>售出房卡数</th>
									<th>剩余房卡数</th>
								</tr>
							</thead>
							<tbody>
								<tr class="active">
									<th scope="row">张毅</th>
									<td>158</td>
									<td>58</td>
									<td>47</td>
								</tr>
								<tr>
									<th scope="row">李青</th>
									<td>158</td>
									<td>100</td>
									<td>15</td>
								</tr>
								<tr>
									<th scope="row">XXX</th>
									<td>158</td>
									<td>12</td>
									<td>15</td>
								</tr>
							</tbody>
						</table>
					</div>

					<div class="col_3">
						<div class="sub_title">玩家统计</div>
						<div class="col-md-3 widget widget1">

							<div class="r3_counter_box">
								<i class="pull-left fa fa-thumbs-up icon-rounded"></i>
								<div class="stats">
									<h5><strong>45%</strong></h5>
									<span>玩家总数</span>
								</div>
							</div>
						</div>
						<div class="col-md-3 widget widget1">
							<div class="r3_counter_box">
								<i class="pull-left fa fa-users user1 icon-rounded"></i>
								<div class="stats">
									<h5><strong>1019</strong></h5>
									<span>当前在线人数</span>
								</div>
							</div>
						</div>
						<div class="col-md-3 widget widget1">
							<div class="r3_counter_box">
								<i class="pull-left fa fa-comment user2 icon-rounded"></i>
								<div class="stats">
									<h5><strong>1012</strong></h5>
									<span>今天在线人数最高纪录</span>
								</div>
							</div>
						</div>
						<div class="col-md-3 widget widget1">
							<div class="r3_counter_box">
								<i class="pull-left fa fa-comment user2 icon-rounded"></i>
								<div class="stats">
									<h5><strong>1012</strong></h5>
									<span>今日新增用户</span>
								</div>
							</div>
						</div>

						<div class="clearfix"></div>
						<table class="table">
							<thead>
								<tr class="success">
									<th>代理名字</th>
									<th>总购房卡数</th>
									<th>售出房卡数</th>
									<th>剩余房卡数</th>
								</tr>
							</thead>
							<tbody>
								<tr class="active">
									<th scope="row">张毅</th>
									<td>158</td>
									<td>58</td>
									<td>47</td>
								</tr>
								<tr>
									<th scope="row">李青</th>
									<td>158</td>
									<td>100</td>
									<td>15</td>
								</tr>
								<tr>
									<th scope="row">XXX</th>
									<td>158</td>
									<td>12</td>
									<td>15</td>
								</tr>
							</tbody>
						</table>
					</div>

				</div>
				<div class="graphs" id="user">
					<div class="col_3">
						<div class="sub_title">会员管理
							<button  style="float: right; line-height: 30px; margin-top: 5px;">搜索玩家</button>
							<input type="text"  value="请输入玩家id" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '请输入玩家id';}" style="float: right;line-height: 30px;color:black; margin-top: 5px; margin-right: 15px;" />

						</div>

						<table class="table" style="border-top: 1px #C0C0C0 solid;margin-top: 20px;">
							<thead>
								<tr class="success">
									<th>用户id</th>
									<th>用户名</th>
									<th>剩余房卡</th>
									<th>状态</th>
									<th>
										设置
									</th>
									<th>充值/退卡</th>
								</tr>
							</thead>
							<tbody id="userTbody">
							</tbody>
						</table>
					</div>

					<div style="float: right; padding-right: 50px ">
						<a>上一页</a>
						<span style="color: red;">1</span>/<span>5</span>
						<a>下一页</a>
					</div>

				</div>

				<div class="graphs" id="activity">
					<div class="col_3">
						<div class="sub_title">活动管理
						<select id="gift_display_select" style="float: right; background: none; color: white; height: 40px; margin-top: 5px;" onchange="frameChangeSelect()">
							<option value="volvo" style="color: #333;" selected="selected">结果查询</option>
							<option value="saab" style="color: #333;">抽奖设置</option>
							<option value="opel" style="color: #333;">奖品设置</option>
						</select>
						</div>
						
						<!-- 获奖结果表 -->
						<div id="result_frame">
							<table class="table" style="border-top: 1px #C0C0C0 solid;margin-top: 20px;"> 
								<thead>
									<tr class="success">
										<th>微信账号</th>
										<th>微信昵称</th>
										<th>奖品id</th>
										<th>奖品名称</th>
										<th>获奖时间</th>
										<th>发奖时间</th>
										<th>状态</th>
									</tr>
								</thead>
								<tbody id="activityTbody">
								</tbody>
							</table>
						</div>
	
						<!-- 奖品规则  -->
						<div style="clear：both; margin-top: 25px;padding-bottom: 5px; margin-left: 20px; margin-right: 20px; border: #d0d0d0 solid 1px; padding-left: ;" id="gift_rule_set">
							<p style="background: #A4E7A5; text-align: center;height: 40px;line-height: 40px; color: #00AAF1;" >填写奖品规则和每日抽奖次数</p>
							<p style="margin-top: 15px;">
								<label>每日抽奖次数</label>
								<input placeholder="填写每天抽奖次数" width="120px" />
							</p>
							<div style="margin-top: 15px;">
								<p>奖品规则说明</p>
								<textarea placeholder="填写每天抽奖次数" style="width: 80% ;margin-left: 10%; height: 80px;" ></textarea>
							</div>
							<p style="clear: both; height: 35px;">
								<button style="width: 60px; height: 35px; float: right; margin-right: 5px;">保存</button>
							</p>
						</div>
						<!--奖品设置框 -->
						<div id="content_gift_set">
							
							<table class="table" style="border-top: 1px #C0C0C0 solid;margin-top: 20px;" > 
							<thead>
								<tr class="success">
									<th>序号</th>
									<th>奖品图片</th>
									<th>名称</th>
									<th>中奖率</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody id="prizeTbody">
							</tbody>
							
						</table>
						<div><span style="font-size:20px;color:red;">注意：游戏期间修改的设置,需要重启服务器才能起效。中奖概率填写万分比的分子，例如万分之十对应填写10&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span> 
							<span style="font-size:20px;color:red;">当前概率总和        <span id="totalProbability"></span></div>
						</div>
					</div>
					

				</div>
				<div class="graphs" id="account">
					<div class="col_3">
						<div class="sub_title">代理管理
							<button style="float: right; line-height: 30px; margin-top: 5px;">搜索玩家</button>
							<input type="text" value="请输入玩家id" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '用户名';}" style="float: right;line-height: 30px; margin-top: 5px;color:black; margin-right: 15px;" />
						</div>
						<a href="#myModal" role="button" style="float: right;margin-top: 25px;margin-bottom: 25px;padding-top: 10px;padding-bottom: 10px;padding-left: 15px;padding-right: 15px; border-radius:6px; border: 1px solid #22BAA0;" data-toggle="modal">添加代理</a>
						<table class="table" style="border-top: 1px #C0C0C0 solid;margin-top: 20px;">
							<thead>
								<tr class="success">
									<th>账号</th>
									<th>密码</th>
									<th>手机号</th>
									<th>房卡余额</th>
									<th>总房卡数</th>
									<th>类型</th>
									<th>充值/退卡</th>
									<th>删除</th>
								</tr>
							</thead>
							<tbody id="accountTbody">
							</tbody>
						</table>
					</div>

				</div>
				<div class="graphs" id="flow">
					<div class="col_3">
						<div class="sub_title">日志查询</div>
						<table class="table" style="border-top: 1px #C0C0C0 solid;margin-top: 20px;">
							<thead>
								<tr class="success">
									<th>日期</th>
									<th>操作事由</th>
								</tr>
							</thead>
							<tbody>
								<tr style="background: #BCE8F1;">
									<th scope="row">2015-12-01 15:30</th>
									<td>**husnuhuglaohif9hafhai及时辐射危害*</td>

								</tr>
								<tr style="background: #C5E1A5;">
									<th scope="row">2015-12-01 15:30</th>
									<td>**husnuhuglaohif9hafhai及时辐射危害*</td>
								</tr>

							</tbody>
						</table>
					</div>
				</div>

				<!-- Modal  增加新用户账户-->
				<div id="myModal" class="modal fade" style="background: #fff; width: 50%;height: 30%;margin-left: 25%;margin-top: 20%;" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
						<h3 id="myModalLabel" style="color: #22BAA0;">增加新账户</h3>
					</div>
					<div class="modal-body" style="padding: 30px; height: 120px;">
						<div style="clear: both;">
							<span style="float: left;">用户名：<input  id="newManagerName" placeholder="输入新账户用户名"/></span>
							<span style="float: right;">密码：<input id="newManagerPwd"  placeholder="输入新用户密码"/></span>
						</div>
						<div style="clear: both;margin-top: 50px;">
							<span style="float: left;">手机号：<input id="newManagerTel"  placeholder="输入新账户手机号"/></span>
							<span style="float: right;height:25px">角色：
							<select id="newManagerType" style="float: right;width:175px; background: none; height: 25px; margin-top: 0px;">
								<option value="3" style="color: #333;" selected="selected" >代理商</option>
							</select>
							</span>
						</div>
					</div>
					<div class="modal-footer">
						<button class="btn" data-dismiss="modal" aria-hidden="true">取消</button>
						<button class="btn btn-primary" onclick="saveManager()" data-dismiss="modal" aria-hidden="true">保存</button>
					</div>
				</div>

				<!-- 删除用户对话框 -->
				<div id="deleteModal" class="modal fade" style="background: #fff; width: 50%;height: 30%;margin-left: 25%;margin-top: 20%;" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
						<h3 id="myModalLabel" style="color: red;">警告</h3>
					</div>
					<div class="modal-body" style="padding: 30px; height: 120px;">
						删除后账户数据将不能找回！你确认要删除吗？
					</div>
					<div class="modal-footer">
						<button class="btn" data-dismiss="modal" aria-hidden="true">取消</button>
						<button class="btn btn-primary">确认</button>
					</div>
				</div>

				<!-- 设置用户状态对话框 -->
				<div id="setModal" class="modal fade" style="background: #fff; width: 50%;height: 30%;margin-left: 25%;margin-top: 20%;" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
						<h3 id="myModalLabel" style="color: #22BAA0;">设置</h3>
					</div>
					<div class="modal-body" style="padding: 30px; height: 120px;">
						<span>设置用户状态 </span>
						<select>
							<option value="enable">激活可用</option>
							<option value="disable">禁用账户</option>
						</select>
					</div>
					<div class="modal-footer">
						<button class="btn" data-dismiss="modal" aria-hidden="true">取消</button>
						<button class="btn btn-primary">确认</button>
					</div>
				</div>

				<!-- 充值模块 -->
				<div id="rechargeModal" class="modal fade" style="background: #fff; width: 50%;height: 30%;margin-left: 25%;margin-top: 20%;" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
						<h3 id="myModalLabel" style="color: #22BAA0;">账户充值</h3>
					</div>
					<div class="modal-body" style="padding: 30px; height: 120px;">
						<span>充值房卡数</span><input id="payCardNum"  placeholder="请输入充值房卡数" />
					</div>
					<div class="modal-footer">
						<button class="btn" data-dismiss="modal" aria-hidden="true">取消</button>
						<button class="btn btn-primary"  onclick="payCard()" data-dismiss="modal" aria-hidden="true">确认</button>
					</div>
				</div>

				<!-- 退卡模块 -->
				<div id="reduceRoomCardModal" class="modal fade" style="background: #fff; width: 50%;height: 30%;margin-left: 25%;margin-top: 20%;" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
						<h3 id="myModalLabel" style="color: #22BAA0;">账户退卡</h3>
					</div>
					<div class="modal-body" style="padding: 30px; height: 120px;">
						<!--<span>设置用户状态 </span>
						<select>
							<option value="enable">激活可用</option>
							<option value="disable">禁用账户</option>
						</select>-->
						<div style="color: red;margin-bottom: 20px;">退卡将影响用户的体验和正常使用，请谨慎操作</div>
						<span>减少房卡数</span><input placeholder="请输入减少房卡数" />
					</div>
					<div class="modal-footer">
						<button class="btn" data-dismiss="modal" aria-hidden="true">取消</button>
						<button class="btn btn-primary">确认</button>
					</div>
				</div>

			</div>

		</div>

	</body>
	<!-- <script type="application/x-javascript"> -->
	<script type="text/javascript">
		var userId = 0;
		var managerId = 0;
		var totalProbability = parseInt("0");//奖品概率总分
		var oneProbability = parseInt("0");//某一个奖品概率
		var flag = 0;//判断修改之后是否保存了
	
		$(function(){
			//判断是超管才能查看全部功能
			if("<%=session.getAttribute("type")%>" != "1"){
				//非超管
				$("#side-menu li:lt(3)").remove();
				//$("#newManagerType").append("<option value='2' style='color: #333;' selected='selected' >代理商</option>")
				selectPage("account");
				
			}
			else{
				//超管
				$("#newManagerType").append("<option value='2' style='color: #333;' selected='selected' >顶级代理商</option>")
				$("#side-menu li:eq(4)").remove();
				$("#gameOldNotice").val("<%=session.getAttribute("notice")%>").attr("disabled","disabled");
			}
		})
		init("summary");
		var lastDisplayPage;

		function init(displayPage) {
			lastDisplayPage = displayPage;
			document.getElementById(lastDisplayPage).style.display = "block";
		}

		function selectPage(clickPage) {
			if(clickPage == "user"){
				//游戏会员管理
				$.ajax({	
				   type: "POST",
				   url: "<%=basePath%>controller/manager/getAccounts",
				   data: "",
				   success: function data(data){
						var param = eval(data);
						$("#userTbody").html("");
				        $.each(param, function (i, item) {  
				              var td = "<td>"+param[i].uuid+"</td>";
											td+="<td>"+param[i].nickname+"</td>";
											td+="<td>"+param[i].roomcard+"</td>";
											if(param[i].status =="0"){
												td+="<td>正常</td>";
											}else{
												td+="<td>注销</td>";
											}	
											td+="<th><a href='#setModal' data-toggle='modal'>设置 </a></th>";
											td+="<th><a href='#rechargeModal' data-toggle='modal' onclick=getUserId("+param[i].id+")>充值 </a>/<a href='#reduceRoomCardModal' data-toggle='modal'>退卡 </a></th>";
							//添加每行数据
							$("#userTbody").append("<tr>"+td+"</tr>");
				          }); 
					}
				});
			}
		    if(clickPage == "manager"){
		    	//游戏代理商，零售商管理
				$.ajax({	
				   type: "POST",
				   url: "<%=basePath%>controller/manager/getManagers",
				   data: "",
				   success: function data(data){
						var param = eval(data);
						$("#managerTbody").html("");
				        $.each(param, function (i, item) {
				              var td = "<td>"+param[i].id+"</td>";
											td+="<td>"+param[i].name+"</td>";
											if(param[i].powerId == 1){
												td+="<td>代理商</td>";
											}
											else{
												td+="<td>零售商</td>";
											}
											td+="<td>"+param[i].actualcard+"</td>";
											if(param[i].status =="0"){
												td+="<td>正常</td>";
											}else{
												td+="<td>注销</td>";
											}	
											td+="<th><a href='#setModal' data-toggle='modal'>设置 </a></th>";
											td+="<th><a href='#rechargeModal' data-toggle='modal'  onclick=getManagerId("+param[i].id+")>充值 </a>/<a href='#reduceRoomCardModal' data-toggle='modal'>退卡 </a></th>";
							//添加每行数据
							$("#managerTbody").append("<tr>"+td+"</tr>");
				          }); 
					}
				});
		    }
		    if(clickPage == "account"){
		    	//账号管理，首先获取自己下面的所有代理商，零售商  
		    	$.ajax({	
				   type: "POST",
				   url: "<%=basePath%>controller/manager/getManagers",
				   data: "",
				   success: function data(data){
						var param = eval(data);
						$("#accountTbody").html("");
				        $.each(param, function (i, item) {
				              var td = "<td>"+param[i].name+"</td>";
											td+="<td>****</td>";
											td+="<td>"+param[i].telephone+"</td>";
											td+="<td>"+param[i].actualcard+"</td>";
											td+="<td>"+param[i].totalcards+"</td>";
											if(param[i].powerId == 2){
												td+="<td>代理商</td>";
											}
											else{
												td+="<td>零售商</td>";
											}
											td+="<th><a href='#rechargeModal' data-toggle='modal' onclick=getManagerId("+param[i].id+")>充值 </a>/<a href='#reduceRoomCardModal' data-toggle='modal'>退卡 </a></th>";
											td+="<td><a href='#deleteModa' data-toggle='modal'>删除 </a></td>";
							//添加每行数据
							$("#accountTbody").append("<tr>"+td+"</tr>");
				          }); 
					}
				});
		    }
		    
		    if( clickPage == "activity"){
		    	//获取所有获奖人信息
		    	//微信账号weixin  	微信昵称nickName 	 奖品id:prizeId 	奖品名称:prizeName 
				//奖品数量（不需要） 	获奖时间createTime  发奖时间awardTime 	状态status
		   		 $.ajax({	
					   type: "POST",
					   url: "<%=basePath%>controller/manager/winnersInfo",
					   data: "",
					   success: function data(data){
							var param = eval(data);
							$("#activityTbody").html("");
					        $.each(param, function (i, item) {
				                  var td = "<td>"+param[i].weixin+"</td>";
											td+="<td>"+param[i].nickName+"</td>";
											td+="<td>"+param[i].prizeId+"</td>";
											td+="<td>"+param[i].prizeName+"</td>";
											td+="<td>"+param[i].createTime+"</td>";
											if(param[i].awardTime != null){
												td+="<td>"+param[i].awardTime+"</td>";
											}
											else{
												td+="<td></td>";
											}
											if(param[i].status == "0"){
												td+="<td>未发放奖品</td>";
											}
											else{
												td+="<td>已经发放奖品</td>";
											}
							//添加每行数据
							$("#activityTbody").append("<tr>"+td+"</tr>");
				          }); 
					}
				});
		    }
		    
			if(clickPage != lastDisplayPage) {
				document.getElementById(clickPage).style.display = "block";
				document.getElementById(lastDisplayPage).style.display = "none";
				lastDisplayPage = clickPage;
			}
		}
		//房卡充值，确认充值
		function payCard(){
			//alert($("#payCardNum").val());
			//alert(userId);
			$.ajax({	
				   type: "POST",
				   url: "<%=basePath%>controller/manager/addActualCardToAccount",
				   data: "payCardNum="+$("#payCardNum").val()+"&userid="+userId+"&managerid="+managerId,
				   success: function data(data){
					   //成功返回之后重置userId,managerId
					  var param  = eval('('+data+')');
					  if(param.status == 0){
					  	//成功
					  		alert("充值成功!");
					  }
					  else{
					  	//失败处理
					  	alert(param.error);
					  }
				   	  if(userId != 0 && managerId == 0){
				   		//alert("给玩家充值");
				   		selectPage("user");
				   	  }
				      else if(managerId != 0 && userId ==0){
				   		//alert("给管理充值");
				   		selectPage("account"); 
				      }
					   userId = 0;
					   managerId = 0;
				   }
			});
		}
		
		function saveManager(){
			//新增代理商/零售商 保存
			$.ajax({	
				   type: "POST",
				   url: "<%=basePath%>controller/manager/addProxyAccount",
				   data: "newManagerName="+$("#newManagerName").val()+"&newManagerPwd="+$("#newManagerPwd").val()+"&newManagerTel="+$("#newManagerTel").val()+"&newManagerType="+$("#newManagerType").val(),
				   success: function data(data){
					   //成功返回之后重置userId,managerId
					  var param  = eval('('+data+')');
					  if(param.status == 0){
					  	//成功
					  		alert("增加用户成功!");
					  }
					  else{
					  	//失败处理
					  	alert(param.error);
					  }
				   	  selectPage("account");
				   }
			});
		}
		
		function getUserId(userid){
			userId = userid;
			$("#payCardNum").val("");
		}
		function getManagerId(managerid){
			managerId = managerid;
			$("#payCardNum").val("");
		}
		
		function frameChangeSelect(){
			var obj=document.getElementById('gift_display_select');
			var index=obj.selectedIndex; //序号，取当前选中选项的序号
			if(index == 0){//结果查询
				document.getElementById("result_frame").style.display  = "block";
				document.getElementById("gift_rule_set").style.display = "none";
				document.getElementById("content_gift_set").style.display = "none";
			}else if(index ==1){//活动规则说明
				document.getElementById("result_frame").style.display  = "none";
				document.getElementById("gift_rule_set").style.display = "block";
				document.getElementById("content_gift_set").style.display = "none";
			}else if(index ==2){//奖品设置
				document.getElementById("result_frame").style.display  = "none";
				document.getElementById("gift_rule_set").style.display = "none";
				document.getElementById("content_gift_set").style.display = "block";
				//获取奖品信息,奖品设置
				$.ajax({	
				   type: "POST",
				   url: "<%=basePath%>controller/manager/prizesInfo",
				   data: "",
				   success: function data(data){
				   totalProbability = 0;
					 var param = eval(data);
					  	$("#prizeTbody").html("");
					        $.each(param, function (i, item) {
					        		totalProbability = totalProbability+param[i].probability;
				                  var td = "<td>"+param[i].id+"</td>";
											td+="<td>"+param[i].imageUrl+"</td>";
											td+="<td>"+param[i].prizeName+"</td>";
											td+="<td><input type='text'  id='probability"+param[i].id+"' disabled='true' value='"+param[i].probability+"'/></td>";
											td+="<td><input type='button' id='savePrize"+param[i].id+"' onclick=savePrize('"+param[i].id+"')  value='修改'/></td>";
											
							//添加每行数据
							$("#prizeTbody").append("<tr>"+td+"</tr>");
				          });
				          $("#totalProbability").text(totalProbability);
				   	}
				});
			}		
		}
		//修改保存奖品信息
		function savePrize(id){
			if($("#savePrize"+id+"").val() == "修改"  && flag == 0){
				flag = 1;
				//点了修改，然后才是可以编辑状态
				$("#savePrize"+id+"").val("保存");
				$("#probability"+id+"").attr("disabled",false);
				oneProbability = $("#probability"+id+"").val();
			}
			else if($("#savePrize"+id+"").val() == "保存" && flag == 1){
				flag = 0;
				//点了保存之后，检测总概率是否大于10000
				totalProbability = parseInt(totalProbability)+ parseInt($("#probability"+id+"").val()) - parseInt(oneProbability);
				if($("#probability"+id+"").val() == oneProbability){
						$("#probability"+id+"").attr("disabled",true);
						$("#savePrize"+id+"").val("修改");
						alert("未作修改，不需要保存");
				}
				else{
					if(totalProbability > 10000){
						totalProbability = parseInt(totalProbability) - parseInt(parseInt($("#probability"+id+"").val())) + parseInt(oneProbability);
						alert("总概率不能超过10000");
						flag = 1;
					}
					else{
						//下面进行修改数据库操作
						$.ajax({	
							   type: "POST",
							   url: "<%=basePath%>controller/manager/updatePrizeInfo",
							   data: "probability="+$("#probability"+id+"").val()+"&id="+id,
							   success: function data(data){
							   		var parma = eval('('+data+')');
							   		if(parma.status_code == "0"){
							   			alert("修改成功");
										$("#savePrize"+id+"").val("修改");
										$("#probability"+id+"").attr("disabled",true);
										$("#totalProbability").text(totalProbability);
							   		}
							   		else{
							   			alert("修改失败")
							   		}
							   }
						});
					}
				}
			}
			else{
				alert("请先保存上一次的操作!");			
			}
		}
	
		//发布游戏公告
		function saveGameNoitce(){
			alert($("#gameNotice").val());
			$.ajax({	
				   type: "POST",
				   url: "<%=basePath%>controller/manager/sendNotice",
				   data: "notice="+$("#gameNotice").val(),
				   success: function data(data){
				   var parma = eval('('+data+')');
							if(parma.status_code == "0"){
							  	alert("发布成功");
							}
							else{
							 	alert("发布失败")
							}
				   	}
				});
		}
	</script>

</html>