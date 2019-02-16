<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
					<img src="${film.f_avatar}"/>
				</div>
				<div class="movie-introduce">
					<p style="font-size: 30px;">${film.f_name}</p>
                    <p> ${film.f_type}</p>
                    <p>${film.f_language}/ ${film.f_long}</p>
                    <p>${film.f_date}</p>
				</div>
				<div class="buy">
					<a href="InterfaceServlet?opr=cinemaquery&page=1&f_id=${film.f_id}"><img src="images/购票.png"/></a>
				</div>
				<div class="estimate">热度${film.hot}</div>
			</div>
	<div class="wrapper">
        <ul class="tab">
            <li class="tab-item active">介绍<span>◆</span></li>
            <li class="tab-item">演职人员<span>◆</span></li>
            <li class="tab-item">奖项<span>◆</span></li>
            <li class="tab-item">图集</li>
        </ul>
        <div class="products">
            <div class="main selected">
                <a href="###">
                ${film.f_intro}
                </a>
            </div>
            <div class="main">
                <a href="###"> </a>
            </div>
            <div class="main">
                <a href="###"><img src="images/qingjieyongpin.jpg" alt=""/></a>
            </div>
            <div class="main">
                <a href="###"><img src="images/图集.png" alt=""/></a>
            </div>
        </div>
    </div>
  
		</div>

</body>
</html>