<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<base href="${base}/" />
<title></title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
</head>
<body>
	<form method="post" action="">
		<div class="panel admin-panel">
			<div class="panel-head">
				<strong class="icon-reorder"> 电影院管理员列表</strong>
			</div>
			<div class="padding border-bottom">
				<button type="button" class="button border-yellow"
					onclick="javascript:location='Sys_sys_userServlet?opr=movie_userinitadd'">
					<span class="icon-plus-square-o"></span>增加电影院管理员
				</button>
			</div>
			<table class="table table-hover text-center">
				<tr>
					<th>序号</th>
					<th>电影院管理员ID</th>
					<th>电影院管理员账号</th>
					<th>电影院管理员密码</th>
					<th>操作</th>
				</tr>
				<c:forEach items="${pageBean.data}" var="movie_user" varStatus="s">
					<tr>
						<td>${s.count}</td>
						<td>${movie_user.mov_id}</td>
						<td>${movie_user.mov_name}</td>
						<td>${movie_user.mov_password}</td>
						<td><div class="button-group">
								<a class="button border-main"    
									href="Sys_sys_userServlet?opr=movie_userinitupdate&mov_id=${movie_user.mov_id}"><span
									class="icon-edit"></span> 修改</a> <a class="button border-red"
									href="javascript:void(0)"
									onclick="javascript:location.href='Sys_sys_userServlet?opr=movie_userinitdel&mov_id=${movie_user.mov_id}'"><span
									class="icon-trash-o"></span> 删除</a>
							</div></td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="8">
						<div class="pagelist">
							<c:forEach begin="1" end="${pageBean.totalPage}" var="p">
								<a href="Sys_sys_userServlet?opr=movie_userquery&page=${p}">${p}</a>
							</c:forEach>
							<select
								onchange="location.href='Sys_sys_userServlet?opr=movie_userquery&page='+this.value"
								id="page">
								<c:forEach begin="1" end="${pageBean.totalPage}" var="p">
									<option>${p}</option>
								</c:forEach>
							</select>
						</div>
					</td>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>