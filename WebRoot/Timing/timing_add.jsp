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
			<strong><span class="icon-pencil-square-o"></span>发布电影</strong>
		</div>
		<div class="body-content">
			<form method="post" class="form-x" action="moviefilm" enctype="multipart/form-data">
				<input type="hidden" name="opr" value="addtiming" />
				
				<div class="form-group">
					<div class="label">
						<label>电影名称：</label>
					</div>
					<div class="field">
					<input type="hidden" name="f_id" value="${film.f_id }" />
					    &nbsp;&nbsp;${film.f_name}
						<div class="tips">${errors.namemsg}</div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>厅号：</label>
					</div>
					<div class="field">
					<select name="mh_id" id="deptid" class="input w50">
							<c:forEach items="${movhalls}" var="movhall">
								<option value="${movhall.mh_id }" > ${movhall.mh_name}</option>
							</c:forEach>
						</select>
						
						<div class="tips">${errors.namemsg}</div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>开始时间：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" name="t_start"
							value="${student}" />
						<div class="tips">${errors.birthdatemsg}</div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>结束时间：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" name="t_end"
							value="${student}" />
						<div class="tips">${errors.birthdatemsg}</div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>价格：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" name="t_price"/>
						<div class="tips">${errors.birthdatemsg}</div>
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