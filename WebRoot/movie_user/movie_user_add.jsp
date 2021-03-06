<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<base href="${base}/" />
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<script type="text/javascript">
</script>
</head>
<body>
	<div class="panel admin-panel">
		<div class="panel-head" id="add">
			<strong><span class="icon-pencil-square-o"></span>增加电影管理员</strong>
		</div>
		<div class="body-content">
			<form method="post" class="form-x" action="Sys_sys_userServlet">
				<input type="hidden" name="opr" value="movie_useradd" />
				<div class="form-group">
					<div class="label">
						<label>电影管理员账号：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" name="mov_name" value="${movie_user.mov_name}" />
						<div class="tips">${errors.mov_namemsg}</div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>电影管理员密码：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" name="mov_password" value="${movie_user.mov_password}"/>
						<div class="tips">${errors.birthdatemsg}</div>
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