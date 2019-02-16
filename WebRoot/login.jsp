<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/login.css"/>

</head>
<body>
<div class="content">
			<div class="log"></div>
			<div class="introduce"></div>
			<div class="login">
				<span id="" style="font-size: 20px;">帐号登录</span>
				<div class="tips" style="color:red">${msg}</div>
				<form action="User" method="post">
				<input type="hidden" name="opr" value="login">
				<div class="input_css">
				<input type="text" name="u_username" id="" value="" placeholder="手机/QQ" style="width:280px;height: 30px;"/></div>
				<div class="input_css">
				<input type="password" name="u_password" id="" value="" placeholder="密码" style="width:280px;height: 30px;"/></div>
				<div class="input_css" style="">
				<input type="" name="code" id="" value="" placeholder="请填写右侧验证码" style="width:180px;height: 30px;"/><img src="/MovieBooking/ChangeCodeServlet" width="100px" height="30px" cursor:pointer;"
										onclick="this.src=this.src+'?'"/>
				</div>
				<div class="input_css">
				<input type="submit"  name="" value="登录" style="width:284px;height: 30px;"/>
				
				</div>
				<div class="">
				<span id=""><a href="user/sign.jsp">注册</a></span>
				<span><a href="http://localhost:8080/MovieBooking/syslogin.jsp">系统管理员登陆</a></span>
				<span><a href="http://localhost:8080/MovieBooking/cinemalogin.jsp">影院管理员登陆</a></span>
				</div>
				</form>
			</div>
		</div>

</body>
</html>