<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<base href="${base}/" />
<link rel="stylesheet" type="text/css" href="css/information.css"/>
		<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
		<script src="js/information.js" type="text/javascript" charset="utf-8"></script>
</head>
<body>
<div class="content">
			<div class="introduce">
				<div class="ima">
					<img src=""/>
				</div>
				<div class="movie-introduce">
					<p style="font-size: 30px;">${cinema.c_name}</p>
                    <p> ${cinema.c_adr}</p>
                    <p>${cinema.c_tel}</p>
				</div>
				<div class="estimate">热度</div>
			</div>
	<table class="table table-hover text-center">
				<c:forEach items="${films}" var="films" varStatus="s">
					<tr>
						<td><a href="InterfaceServlet?opr=timingquery&f_id=${films.f_id}&c_id=${cinema.c_id}">sgf<img src="${films.f_avatar}"/></a></td>
						<td>${films.f_name}</td>
						<td>${films.hot}</td>
					</tr>
					<tr>
				</c:forEach>
			</table>
      <div>${film.f_name}</div>
      
      
      
      <table class="table table-hover text-center">
				<tr>
					<th>放映时间</th>
					<th>放映厅</th>
					<th>售价</th>
					<th>选座购票</th>
				</tr>
				<c:forEach items="${pagebean.data}" var="timing" varStatus="s">
					<tr>
						<td>${timing.t_start}~${timing.t_end}</td>
						<td>${timing.mh_id}</td>
						<td>${timing.t_price}</td>
						<td><div class="button-group">
								<a href="InterfaceServlet?opr=seatinit&page=1&t_id=${timing.t_id}"><img src="images/购票.png"/></a>
							</div></td>
					</tr>
				</c:forEach>
				
			</table>  
		</div>

</body>
</html>