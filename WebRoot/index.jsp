<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
<base href="${base}/" />
		<link rel="stylesheet" type="text/css" href="css/index.css"/>
		<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
		<script type="text/javascript" src="js/index.js"></script>
		
</head>
<body>
<div class="content">
			<div class="nav">
		<div class="search">
			<form method="post" action="student" class="search-form">
				<input type="hidden" name="opr" value="query" />
					<input type="text" placeholder="请输入搜索内容" name="Sname" class="input" value=""/>
					<input type="submit" class="submit" name="" id="" value="" />
			</form>
		</div>
		<div class="display">
			<ul>
				<li style="background-color: red;"><a href="InterfaceServlet?opr=index">首页</a></li>
				<li><a href="InterfaceServlet?opr=filmquery&page=1">电影</a></li>
				<li><a href="InterfaceServlet?opr=cinemaquery&page=1">影院</a></li>
			</ul>
		</div>
				<div class="longin-img">
					<a href="<c:if test="${empty user.u_id}">login.jsp</c:if><c:if test="${not empty user.u_id}">user/usermanage.jsp</c:if>">
					<img src='<c:if test="${empty user.u_avatar}">images/登录.png</c:if><c:if test="${not empty user.u_avatar}">${user.u_avatar}</c:if>' 
						width="100" height="100"/>
					</a>
				</div>
			</div>
			
		<div class="wrapper">
        <ul>
            <li><img src="images/1.jpg" alt=""/></li>
            <li><img src="images/2.jpg" alt=""/></li>
            <li><img src="images/3.jpg" alt=""/></li>
        </ul>
        <ol>
            <li class="current">1</li>
            <li>2</li>
            <li>3</li>
        </ol>
    </div>
			<div class="">
			<div class="show">
				<div class="item1">
					<a href="InterfaceServlet?opr=showfilm&f_id=${filmv[0]}"><img src="${filmv[0]}" width="106px" height="114px"/></a>
				</div>
				<div class="item1">
				<a href="InterfaceServlet?opr=showfilm&f_id= ${filmv[1]}"><img src="${filmv[1]}" width="106px" height="114px"/></a>
				</div>
				<div class="item1">
				<a href="InterfaceServlet?opr=showfilm&f_id= ${filmv[2]}"><img src="${filmv[2]}" width="106px" height="114px"/></a>
				</div>
				<div class="item1">
				</div>
				<div class="item1">
				</div>
				<div class="item1">
				</div>
				<div class="item1">
				</div>
				<div class="item1">
				</div>
				<div class="item1">
				</div>
				<div class="item1">
				</div>
				<div class="item1">
				</div>
				<div class="item1">
				</div>
				<div class="item1">
				</div>
				<div class="item1">
				</div>
				<div class="item1">
				</div>
				<div class="item1">
				</div>
			</div>
            <div class="show-list">
            	<form method="post" action="">
		<div class="panel admin-panel">
			<div class="panel-head">
				<strong class="icon-reorder"> 电影列表</strong>
			</div>
			<table class="table table-hover text-center">
				<tr>
					<th>电影名称</th>
					<th style="display: block;margin-left: 150px;">热度</th>
				</tr>
				<c:forEach items="${filmd}" var="filmdate" varStatus="s">
					<tr>
						<td><a href="InterfaceServlet?opr=showfilm&f_id=${filmdate.f_id}" style="text-decoration: none;">${filmdate.f_name}</a></td>
						<td style="display: block;margin-left: 150px;">${filmdate.hot}</td>
					</tr>
				</c:forEach>
				
			</table>
		</div>
	</form>
            </div>
           </div>
		</div>
		 <div class="footer"><p>©2018&nbsp;2217&nbsp;</p></div>

</body>
</html>