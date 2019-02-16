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
	<form method="post" action="MovieHall">
		<div class="panel admin-panel">
			<div class="panel-head">
				<strong class="icon-reorder"> 影厅列表</strong>
			</div>

			<table class="table table-hover text-center">
				<tr>
					<th>序号</th>
					<th>厅号</th>
					<th>座位数</th>
					<th>操作</th>
				</tr>
				<c:forEach items="${pageBean.data}" var="movhall" varStatus="s">
					<tr>
						<td>${s.count}</td>
						<td>${movhall.mh_name}</td>
						<td>${movhall.seat_number}</td>
						<td><div class="button-group">
								<a class="button border-main"
									href="MovieHall?opr=initupdatehall&mh_id=${movhall.mh_id}"><span
									class="icon-edit"></span> 修改</a> <a class="button border-red"
									href="javascript:void(0)"
									onclick="javascript:location.href='MovieHall?opr=delhall&mh_id=${movhall.mh_id}'"><span
									class="icon-trash-o"></span> 删除</a>
							</div></td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="8">
						<div class="pagelist">
							<c:forEach begin="1" end="${pageBean.totalPage}" var="p">
								<a href="MovieHall?opr=query&page=${p}">${p}</a>
							</c:forEach>
								<!--
							<select>
						    	 <c:forEach begin="1" end="${pageBean.totalPage}" var="p">
						    	<option>${p}</option>
						    </c:forEach>
						    </select>
						      -->
						</div>
					</td>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>