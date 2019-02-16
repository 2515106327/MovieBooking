<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/movie_list.css"/>
		<script type="text/javascript" src="js/jquery-2.1.1.min.js"></script>
		<script type="text/javascript" src="js/movie_list.js"></script>
<script type="text/javascript">
	window.onload=function(){
	  document.getElementById("page").value="${pageBean.page}";
	}
</script>
</head>
<body>
		<div class="panel admin-panel">
			<div class="panel-head">
				<strong class="icon-reorder"> 电影列表</strong>
			</div>
			<div class="movie-type">
				<ul>
					<li><div class="">类型</div></li>
					<li><a href="InterfaceServlet?opr=filmquery&page=1&f_type=">全部</a></li>
					<li><a href="InterfaceServlet?opr=filmquery&page=1&f_type=1">喜剧</a></li>
					<li><a href="InterfaceServlet?opr=filmquery&page=1&f_type=科幻">科幻</a></li>
					<li><a href="InterfaceServlet?opr=filmquery&page=1&f_type=动作">动作</a></li>
				</ul>
			</div>
			<table class="table table-hover text-center">
				<c:forEach items="${pagebean.data}" var="film" varStatus="s">
					<tr>
						<td><a href="InterfaceServlet?opr=showfilm&f_id=${film.f_id}">ssd<img src="${film.f_avatar}"/></a></td>
						<td>${film.f_name}</td>
						<td>${film.hot}</td>
					</tr>
					<tr>
				</c:forEach>
				<tr>
					<td colspan="8">
						<div class="pagelist">
						    <c:forEach begin="1" end="${pagebean.totalPage}" var="p">
						    	<a href="InterfaceServlet?opr=filmquery&page=${p}&f_type=${f_type}">${p}</a>
						    </c:forEach>
						    <select onchange="location.href='InterfaceServlet?opr=filmquery&f_type=${f_type}&page='+this.value" id="page">
						     <c:forEach begin="1" end="${pagebean.totalPage}" var="p">
						    	<option value="${p}">${p}</option>
						    </c:forEach>
						    </select>
						</div>
					</td>
				</tr>
			</table>
		</div>

</body>
</html>