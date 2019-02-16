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
			<strong><span class="icon-pencil-square-o"></span>修改厅号</strong>
		</div>
		<div class="body-content">
			<form method="post" class="form-x" action="MovieHall">
				<input type="hidden" name="opr" value="updatehall" /> <input
					type="hidden" name="mh_id" value="${movhall.mh_id}" /> <input
					type="hidden" name="c_id" value="${movhall.c_id}" />
				<div class="form-group">
					<div class="label">
						<label>厅号：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" name="mh_name"
							value="${movhall.mh_name}" />
						<div class="tips">${errors.namemsg}</div>
					</div>
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