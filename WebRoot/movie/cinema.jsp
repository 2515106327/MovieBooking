<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/cinema.css"/>
<title>电影院</title>
<style type="text/css">
body{
	background-color:#BDCBE8;
}
</style>
<script type="text/javascript">
	window.onload=function(){
	  document.getElementById("page").value="${pageBean.page}";
	}
</script>
</head>
<body>
<form method="post" action="">
<div>${film.f_name}</div>
		<div class="panel admin-panel">
			<div class="panel-head">
				<strong class="icon-reorder"> 电影院列表</strong>
			</div>
			<div>
			电影院
		   <a href="InterfaceServlet?opr=cinemaquery&page=1&a_id=${Cinema.a_id}&f_id=${Cinema.f_id}">全部</a>
			<c:forEach items="${Cinemas}" var="cinem" varStatus="s">
			<a href="InterfaceServlet?opr=cinemaquery&page=1&c_name=${cinem.c_name}&a_id=${Cinema.a_id}&f_id=${Cinema.f_id}">${cinem.c_name}</a>
			</c:forEach>
			</div>
			<div>
			地区
			<a href="InterfaceServlet?opr=cinemaquery&page=1&c_name=${Cinema.c_name}&f_id=${Cinema.f_id}">全部</a>
			<c:forEach items="${Areas}" var="area" varStatus="s">
			<a href="InterfaceServlet?opr=cinemaquery&page=1&c_name=${Cinema.c_name}&a_id=${area.a_id}&f_id=${Cinema.f_id}">${area.a_name}</a>
			</c:forEach>
			</div>
			<div class="cinema-show">
			<table class="table table-hover text-center" style="margin:auto; border-spacing:100px">
				<tr>
					<th>电影院名称</th>
					<th>影院地址</th>
					<th>操作</th>
				</tr>
				<c:forEach items="${pagebean.data}" var="cinema" varStatus="s">
					<tr>
						<td>${cinema.c_name}</td>
						<td>${cinema.c_adr}</td>
						<td><div class="button-group">
								<a class="button border-main"
									href="InterfaceServlet?opr=timingquery&f_id=${Cinema.f_id}&c_id=${cinema.c_id}"><span
									class="icon-edit"></span> 购票</a>
							</div></td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="8">
						<div class="pagelist">
						    <c:forEach begin="1" end="${pagebean.totalPage}" var="p">
						    	<a href="InterfaceServlet?opr=cinemaquery&page=${p}&c_name=${Cinema.c_name}&f_id=${Cinema.f_id}">${p}</a>
						    </c:forEach>
						    <select onchange="location.href='InterfaceServlet?opr=cinemaquery&c_name=${Cinema.c_name}&f_id=${Cinema.f_id}&page='+this.value" id="page">
						     <c:forEach begin="1" end="${pagebean.totalPage}" var="p">
						    	<option value="${p}">${p}</option>
						    </c:forEach>
						    </select>
						</div>
					</td>
				</tr>
			</table>
			</div>
		</div>
	</form>
</body>
</html>