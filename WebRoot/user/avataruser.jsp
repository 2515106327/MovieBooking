<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<div class="panel admin-panel">
		<div class="panel-head" id="add">
			<strong><span class="icon-pencil-square-o"></span>上传头像</strong>
		</div>
		<div class="body-content">
			<form method="post" class="form-x" action="User"
				enctype="multipart/form-data">
				<input type="hidden" name="opr" value="updateAvatar" />
				<div class="form-group">
					<div class="label">
						<label></label>
					</div>
					<div class="field">
						<img src='<c:if test="${empty user.u_avatar}">images/登录.png</c:if><c:if test="${not empty user.u_avatar}">${user.u_avatar}</c:if>' width="100" height="100" 
						title="${user.u_username}" />
						
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>头像：</label>
					</div>
					<div class="field">
						<input type="file" class="input w50" name="u_avatar" />
						<div class="tips">${errors.namemsg}</div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label></label>
					</div>
					<div class="field">
						<button class="button bg-main icon-check-square-o" type="submit">
							提交</button>
					</div>
				</div>
			</form>
		</div>
	</div>

</body>
</html>