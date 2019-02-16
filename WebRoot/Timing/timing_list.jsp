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
	<form method="post" action=""moviefilm"">
		<div class="panel admin-panel">
			<div class="panel-head">
			
				<strong class="icon-reorder"> 发布列表</strong>
			</div>
			<div class="padding border-bottom">
				<form method="post" action="moviefilm">
					<input type="hidden" name="opr" value="querytiming" />
					<ul class="search" style="padding-left:10px;">
						<li>电影名：<input type="text" placeholder="请输入电影名字"
							name="f_name" class="input"
							style="width:150px; line-height:17px;display:inline-block" />
							&nbsp;&nbsp;厅号：
						</li>
						<li><select name="mh_id" class="input" id="deptid"
							style="width:200px; line-height:17px;">
								<option value="0">不限</option>
								<c:forEach items="${movhalls}" var="movhall">
									<option value="${movhall.mh_id}">${movhall.mh_name}</option>
								</c:forEach>
						</select></li>
						<li><button class="button border-main icon-search">搜索</button></li>
					</ul>
				</form>
			</div>

			<table class="table table-hover text-center">
				<tr>
					<th>电影名</th>
					<th>开始时间</th>
					<th>结束时间</th>
					<th>厅号</th>
					<th>金额</th>
					<th>操作</th>
				</tr>
				<c:forEach items="${pageBean.data}" var="timing" varStatus="s">
					<tr>
						<td>${timing.f_name}</td>
						<td>${timing.t_start}</td>
						<td>${timing.t_end}</td>
						<td>${timing.mh_name}</td>
						<td>${timing.t_price}</td>
						<td><div class="button-group">
								<a class="button border-red" href="javascript:void(0)"
									onclick="javascript:location.href='moviefilm?opr=deltiming&t_id=${timing.t_id}'"><span
									class="icon-trash-o"></span> 删除</a>
							</div></td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="8">
						<div class="pagelist">
							<c:forEach begin="1" end="${pageBean.totalPage}" var="p">
								<a href="moviefilm?opr=querytiming&page=${p}">${p}</a>
							</c:forEach>
							<!--  -->
						</div>
					</td>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>