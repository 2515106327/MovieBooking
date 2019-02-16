<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>选座</title>
<base href="${base}/" />
		<link rel="stylesheet" type="text/css" href="css/choose.css"/>
	    <script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
	    <script type="text/javascript" src="js/jquery-2.1.1.min.js"></script>
	    <script type="text/javascript" src="js/choose.js"></script>

</head>
<body>
		<div class="content">
			<div class="nav">
				<div class="yes item">可选座位<img src="./images/no.png"/>
				</div>
				<div class="no item">已售座位<img src="./images/already.png"/>
				</div>
				<div class="lodaing item">已选座位<img src="./images/yes.png"/>
				</div>
			</div>
			<div class="row-id">
				<div class="item-id">1</div>
				<div class="item-id">2</div>
			</div>
			<div class="seat">
	         <div class="row">
	         	<span data-index= "0001" data-id="1" data-bo="true"
	         	
	         	></span>
	         	<span data-index= "0002" data-id="2" data-bo="true"
	         	
	         	></span>
	         	<span data-index= "0003" data-id="3" data-bo="true"
	         	
	         	></span>
	         	<span data-index= "0004" data-id="4" data-bo="true"
	         	
	         	></span>
	         	<span data-index= "0005" data-id="5" data-bo="true"
	         	
	         	></span>
	         	
	         </div>
	         <div class="row">
	         	<span data-index="0101" data-id="6" data-bo="true"
	         	
	         	></span>
	         	<span data-index="0202" data-id="7" data-bo="true"
	         	
	         	></span>
	         	<span data-index="0303" data-id="8" data-bo="true"
	         	
	         	></span>
	         	<span data-index="0404" data-id="9" data-bo="true"
	         	
	         	></span>
	         	<span data-index="0505" data-id="10" data-bo="true"
	         	
	         	></span>
	         </div>
	         <!--<div class="">
	         	<label>你选择的座位是：</label><p></p>
	         </div>-->
	         	<form action="InterfaceServlet" method="post">  
	         		<input  type="hidden" name="opr"  value="buy"/>
	         	<input  type="hidden" name="t_id"  value="${timing.t_id }"/>
	     
	         	     <input  type="hidden" name="t_price"  value="${timing.t_price }"/>
	         	     <input  type="hidden" name="mh_id"  value="${timing.mh_id }"/>
	         		<input id="ceshi" style="width: ;" type="text" name="s_id" value="${ddd}"></input>
	         		<input type="submit" value="购票"/>
	         	</form>
	         	<c:forEach items="${seats}" var="seat" varStatus="s">
	         	 </c:forEach>
		</div>
	</body>

</html>