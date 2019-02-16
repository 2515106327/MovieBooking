<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<base href="${base}/" />
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<script type="text/javascript">
function checktel() {
	var c_tel=document.getElementsByName("c_tel")[0].value;
	if(c_tel.trim().length>=12||c_tel.trim().length<7){
		document.getElementsByClassName("tips")[2].innerHTML="电话长度应该在7~11位";
	}
	else{
		document.getElementsByClassName("tips")[2].innerHTML="";
		
	}
}
function checkc_num() {
	var c_num=document.getElementsByName("c_num")[0].value;
	if(isNaN(c_num.trim())){
		document.getElementsByClassName("tips")[1].innerHTML="输入值应为数字";
	}
	else{
		document.getElementsByClassName("tips")[1].innerHTML="";
		
	}
}
</script>
</head>
<body>
	<div class="panel admin-panel">
		<div class="panel-head" id="add">
			<strong><span class="icon-pencil-square-o"></span>增加学生</strong>
		</div>
		<div class="body-content">
			<form method="post" class="form-x" action="Sys_sys_userServlet" onsubmit="return cheack()">
				<input type="hidden" name="opr" value="cinemaadd" />
				<div class="form-group">
					<div class="label">
						<label>电影院姓名：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" name="c_name" value="${cinema.c_name}" />
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>电影院影厅数量：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" name="c_num" value="${cinema.c_num}" onblur="checkc_num()"/>
						<div class="tips">${errors.namemsg}</div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>电影院电话：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" name="c_tel" value="${cinema.c_tel}" onblur="checktel()"/>
						<div class="tips"></div>
					</div>
				</div>
				
				<div class="form-group">
					<div class="label">
						<label>电影院影地址：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" name="c_adr" value="${cinema.c_adr}" />
						<div class="tips">${errors.namemsg}</div>
					</div>
				</div>
				
				<div class="form-group">
					<div class="label">
						<label>电影院隶属地区：</label>
					</div>
					<div class="field">
						<select name="a_id" id="a_id" class="input w50">
							
							<option value="0">请选择归属地区</option>
							<c:forEach items="${areas}" var="area">
								<option value="${area.a_id}">${area.a_name}</option>
							</c:forEach>
					</select>
					<div class="tips">${errors.deptidmsg}</div>
					</div>
				</div>
				
				<div class="form-group">
					<div class="label">
						<label>派遣电影院管理员：</label>
					</div>
					<div class="field">
						<select name="m_userid" id="m_userid" class="input w50">
							<option value="0">请选择电影管理员</option>
							<c:forEach items="${movie_Users}" var="movie_User">
								<option value="${movie_User.mov_id}">${movie_User.mov_name}</option>
							</c:forEach>
					</select>
					<div class="tips">${errors.deptidmsg}</div>
					</div>
				</div>
				
				<div class="form-group">
					<div class="label">
						<label></label>
					</div>
					<div class="field">
						<button class="button bg-main icon-check-square-o" type="submit">
							提交</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>