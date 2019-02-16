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
	<form method="post" action="Sys_sys_userServlet">
		<div class="panel admin-panel">
			<div class="panel-head">
				<strong class="icon-reorder"> 电影院管理员列表</strong>
			</div>
			<div class="padding border-bottom">
				<button type="button" class="button border-yellow"
					onclick="javascript:location='Sys_sys_userServlet?opr=cinemainitadd'">
					<span class="icon-plus-square-o"></span>增加电影院
				</button>
			</div>


			<div class="padding border-bottom">
				<form method="post" action="Sys_sys_userServlet">
					<input type="hidden" name="opr" value="cinemasearchquery" />
					<ul class="search" style="padding-left: 10px;">
						<li>电影院名字：<input type="text" placeholder="请输入电影院名字"
							name="c_name" class="input" value="${cinema.c_name}"
							style="width: 150px; line-height: 17px; display: inline-block" />
						</li>
						<li><select name="a_id" class="input" id="deptid"
							style="width: 200px; line-height: 17px;">
								<option value="-1">归属地区</option>
								<c:forEach items="${areas}" var="area">
									<option value="${area.a_id}">${area.a_name}</option>
								</c:forEach>
						</select></li>
						<li><button class="button border-main icon-search">搜索</button></li>
					</ul>
				</form>
			</div>

			<table class="table table-hover text-center">
				<tr>
					<th>序列</th>
					<th>影院名字</th>
					<th>影厅数量</th>
					<th>影院电话</th>
					<th>影院归属区</th>
					<th>影院地址</th>
					<th>影院管理员</th>
					<th>操作</th>
				</tr>
				<c:forEach items="${pageBean.data}" var="cinema" varStatus="s">
					<tr>
						<td>${s.count}</td>
						<td>${cinema.c_name}</td>
						<td>${cinema.c_num}</td>
						<td>${cinema.c_tel}</td>
						<td>${cinema.a_name}</td>
						<td>${cinema.c_adr}</td>
						<td>${cinema.mov_name}</td>
						<td><div class="button-group">
								<a class="button border-main"
									href="Sys_sys_userServlet?opr=cinemainitupdate&c_id=${cinema.c_id}"><span
									class="icon-edit"></span> 修改</a> <a class="button border-red"
									href="Sys_sys_userServlet?opr=cinemainitdel&c_id=${cinema.c_id}"
									onclick=""><span class="icon-trash-o"></span> 删除</a>
							</div></td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="8">
						<div class="pagelist">
							<c:forEach begin="1" end="${pageBean.totalPage}" var="p">
								<a href="Sys_sys_userServlet?opr=cinemaquery&page=${p}">${p}</a>
							</c:forEach>
							<select
								onchange="location.href='Sys_sys_userServlet?opr=cinemaquery&page='+this.value"
								id="page">
								<c:forEach begin="1" end="${pageBean.totalPage}" var="p">
									<option value="${p}">${p}</option>
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