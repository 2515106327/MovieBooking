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
</script>
</head>
<body>
	<div class="panel admin-panel">
		<div class="panel-head" id="add">
			<strong><span class="icon-pencil-square-o"></span>修改电影院信息</strong>
		</div>
		<div class="body-content">
			<form method="post" class="form-x" action="Sys_sys_userServlet">
				<input type="hidden" name="opr" value="cinemaupdate" />
				<input type="hidden" name="c_id" value="${cinema.c_id}" />
				<div class="form-group">
					<div class="label">
						<label>电影院名字：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" name="c_name" value="${cinema.c_name}" />
						<div class="tips">${errors.namemsg}</div>
					</div>
				</div>
				
				<div class="form-group">
					<div class="label">
						<label>影厅数量：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" name="c_num" value="${cinema.c_num}" />
						<div class="tips">${errors.namemsg}</div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>电影院电话：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" name="c_tel" value="${cinema.c_tel}" />
						<div class="tips">${errors.namemsg}</div>
					</div>
				</div>
				
				<div class="form-group">
					<div class="label">
						<label>归属地区：</label>
					</div>
					<div class="field">
						<select name="a_id" id="klassId" class="input w50">
							<option value="0">请选择归属区</option>
							<c:forEach items="${areas}" var="area">
								<option value="${area.a_id}" <c:if test="${area.a_id eq cinema.a_id}">selected</c:if>>${area.a_name}</option>
							</c:forEach>
					</select>
					<div class="tips">${errors.deptidmsg}</div>
					</div>
				</div>
				
				<div class="form-group">
					<div class="label">
						<label>重置电影院管理员：</label>
					</div>
					<div class="field">
						<select name="m_userid" id="m_userid" class="input w50">
							<option value="0">请选择电影院管理员</option>
							<c:forEach items="${movie_Users}" var="movie_User">
								<option value="${movie_User.mov_id}" <c:if test="${movie_User.mov_id eq cinema.mov_id}">selected</c:if>>${movie_User.mov_name}</option>
							</c:forEach>
					</select>
					<div class="tips">${errors.deptidmsg}</div>
					</div>
				</div>
				
				<div class="form-group">
					<div class="label">
						<label>电影院地址：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" name="c_adr" value="${cinema.c_adr}" />
						<div class="tips">${errors.namemsg}</div>
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