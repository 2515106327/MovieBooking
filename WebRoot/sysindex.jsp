<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>系统管理-后台管理中心</title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
</head>
<body style="background-color: #f2f9fd;">
	<div class="header bg-main">
		<div class="logo margin-big-left fadein-top">
			<h1>
				<img src="${user.avatar}" class="radius-circle rotate-hover"
					height="50" />电影订票管理系统-系统管理员
			</h1>
		</div>
		<div class="head-l">
			<a class="button button-little bg-green" href="welcome.jsp"
				target="right"> <span class="icon-home"></span>管理首页
			</a> &nbsp;&nbsp; <a class="button button-little bg-red" href="Sys_sys_userServlet?opr=logout">
				<span class="icon-power-off"></span>退出登录
			</a>
			Welcome! ${sessionScope.user.name}!
		</div>
	</div>
	<div class="leftnav">
		<div class="leftnav-title">
			<strong><span class="icon-list"></span>菜单列表</strong>
		</div>
		<h2>
			<span class="icon-user"></span>地区管理
		</h2>
		<ul>
			<li><a href="Sys_sys_userServlet?opr=areainitadd" target="right"><span
					class="icon-caret-right"></span>增加地区</a></li>
			<li><a href="Sys_sys_userServlet?opr=areaquery" target="right"><span
					class="icon-caret-right"></span>地区列表</a></li>
		</ul>
		<h2>
			<span class="icon-pencil-square-o"></span>电影院管理员管理
		</h2>
		<ul>
			<li><a href="Sys_sys_userServlet?opr=movie_userinitadd" target="right"><span
					class="icon-caret-right"></span>增加电影院管理员</a></li>
			<li><a href="Sys_sys_userServlet?opr=movie_userquery" target="right"><span
					class="icon-caret-right"></span>电影院管理员列表</a></li>
		</ul>

		<h2>
			<span class="icon-user"></span>电影院管理
		</h2>
		<ul>
			<li><a href="Sys_sys_userServlet?opr=cinemainitadd" target="right"><span
					class="icon-caret-right"></span>增加电影院</a></li>
			<li><a href="Sys_sys_userServlet?opr=cinemaquery" target="right"><span
					class="icon-caret-right"></span>电影院列表</a></li>
		</ul>
	</div>
	<div class="admin">
		<iframe src="welcome.jsp" name="right" width="100%" height="100%"></iframe>
	</div>
</body>
</html>