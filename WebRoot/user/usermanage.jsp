<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../css/usermanage.css"/>
<title>Insert title here</title>
	<base href="${base}/" />
</head>
<body>
<div class="header bg-main">
		<div class="logo margin-big-left fadein-top">
			<h1>
				<img src="${user.u_avatar}" class="radius-circle rotate-hover"
					height="50" />用户信息管理系统
			</h1>
			<div class="tips">${msg}</div>
		</div>
		<div class="head-l">
			<a class="button button-little bg-green" href="index.jsp"
				target="right"> <span class="icon-home"></span>管理首页
			</a> &nbsp;&nbsp; <a class="button button-little bg-red" href="login.jsp">
				<span class="icon-power-off"></span>退出登录
			</a>
		</div>
	</div>
	<div class="leftnav">
		<div class="leftnav-title">
			<strong><span class="icon-list"></span>菜单列表</strong>
		</div>
		<h2>
			<span class="icon-user"></span>信息管理
		</h2>
		<ul>
			<li><a href="User?opr=updateinit" target="right"><span
					class="icon-caret-right"></span>修改密码</a>
			</li>
		</ul>
		<h2>
			<span class="icon-pencil-square-o"></span>个人中心
		</h2>
		<ul>
			<li><a href="user/avataruser.jsp" target="right"><span
					class="icon-caret-right"></span>修改头像</a></li>
		</ul>
	</div>
</body>
</html>