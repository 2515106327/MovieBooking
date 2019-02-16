<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>后台管理中心</title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
</head>
<body style="background-color: #f2f9fd;">
	<div class="header bg-main">
		<div class="logo margin-big-left fadein-top">
			<h1>
				<img src="${user.uavatar}" class="radius-circle rotate-hover"
					height="50" />${CinemaUser.c_name}管理系统
			</h1>
		</div>
		<div class="head-l">
			<a class="button button-little bg-green" href="welcome.jsp"
				target="right"> <span class="icon-home"></span>管理首页
			</a> &nbsp;&nbsp; <a class="button button-little bg-red" href="MovieUser?opr=logout">
				<span class="icon-power-off"></span>退出登录
			</a>
		</div>
	</div>
	<div class="leftnav">
		<div class="leftnav-title">
			<strong><span class="icon-list"></span>菜单列表</strong>
		</div>
		<h2>
			<span class="icon-user"></span>影厅管理
		</h2>
		<ul>
			<li><a href="MovieHall?opr=initaddhall" target="right"><span
					class="icon-caret-right"></span>增加影厅</a></li>
			<li><a href="MovieHall?opr=query" target="right"><span
					class="icon-caret-right"></span>影厅列表</a></li>
		</ul>
		<h2>
			<span class="icon-pencil-square-o"></span>电影管理
		</h2>
		<ul>
			<li><a href="moviefilm?opr=initaddfilm" target="right"><span
					class="icon-caret-right"></span>增加电影</a></li>
			<li><a href="moviefilm?opr=queryfilm" target="right"><span
					class="icon-caret-right"></span>电影列表</a></li>
		</ul>

		<h2>
			<span class="icon-user"></span>发布管理
		</h2>
		<ul>
			<li><a href="moviefilm?opr=querytiming" target="right"><span
					class="icon-caret-right"></span>发布列表</a></li>
		</ul>
	</div>
	<div class="admin">
		<iframe src="welcome.jsp" name="right" width="100%" height="100%"></iframe>
	</div>
</body>
</html>