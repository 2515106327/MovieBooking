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
			
				<strong class="icon-reorder"> 电影列表</strong>
			</div>
			<div class="padding border-bottom">
			<form method="post" action="moviefilm">
				<input type="hidden" name="opr" value="queryfilm" />
				<ul class="search" style="padding-left:10px;">
					<li>电影名：<input type="text" placeholder="请输入电影名字"
						name="f_name" class="input" 
						style="width:150px; line-height:17px;display:inline-block" />
					</li>
					<li>类型：<input type="text" placeholder="请输入类型"
						name="f_type" class="input" 
						style="width:150px; line-height:17px;display:inline-block" />
					</li>
					<li><button class="button border-main icon-search">搜索</button></li>
				</ul>
			</form>
		</div>

			<table class="table table-hover text-center">
				<tr>
					<th>图片</th>
					<th>电影名</th>
					<th>类型</th>
					<th>语言</th>
					<th>时长</th>
					<th>操作</th>
				</tr>
				<c:forEach items="${pageBean.data}" var="film" varStatus="s">
					<tr>
						<td><img src='<c:if test="${empty film.f_avatar }">images/avatar/default.jpg</c:if><c:if test="${not empty film.f_avatar }">${film.f_avatar }</c:if>'
							width="100" height="150" /></td>
						<td>${film.f_name}</td>
						<td>${film.f_type}</td>
						<td>${film.f_language}</td>
						<td>${film.f_long}</td>
						<td><div class="button-group">
								<a class="button border-main" href="moviefilm?opr=initupdatefilm&f_id=${film.f_id}"><span
									class="icon-edit"></span> 修改</a> &nbsp;&nbsp;
								<a class="button border-red" href="javascript:void(0)" onclick="javascript:location.href='moviefilm?opr=delfilm&f_id=${film.f_id}'"><span
									class="icon-trash-o"></span> 删除</a> &nbsp;&nbsp;
								<a class="button border-main" href="moviefilm?opr=addinittiming&f_id=${film.f_id}"><span
									class="icon-edit"></span> 发布</a> 
							</div></td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="8">
						<div class="pagelist">
							<c:forEach begin="1" end="${pageBean.totalPage}" var="p">
								<a href="moviefilm?opr=query&page=${p}">${p}</a>
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