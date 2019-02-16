<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
body{
background-color:#BDCBE8;
}
</style>
<base href="${base}/" />
</head>
<body>
<div class="">
			<form action="User" method="post">
			<input type="hidden"name="opr" value="adduser"/>
			<div class="form-group">
			<div class="label"><label>用户帐号：</label></div>
			<div class="file"><input type="text" name="u_username"/></div>
			</div>
			<div class="form-group">
			<div class="label"><label>用户密码：</label></div>
			<div class="file"><input type="text" name="u_password"/></div>
			</div>
			<div class="form-group">
			<div class="label"><label>性别：</label></div>
			<div class="file"><input type="radio" name="u_sex">男<input type="radio" name="u_sex">女</div>
			</div>
			<div class="form-group">
		       <button type="submit">提交</button>
			</div>
			</form>
		</div>

</body>
</html>