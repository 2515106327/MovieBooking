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
			<strong><span class="icon-pencil-square-o"></span>增加电影</strong>
		</div>
		<div class="body-content">
			<form method="post" class="form-x" action="moviefilm" enctype="multipart/form-data">
				<input type="hidden" name="opr" value="addfilm" />
				<div class="form-group">
					<div class="label">
						<label>电影名称：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" name="f_name"
							value="${student}" />
						<div class="tips">${errors.namemsg}</div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>电影类型：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" name="f_type"
							value="${student}" />
						<div class="tips">${errors.namemsg}</div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>导演：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" name="f_director"
							value="${student}" />
						<div class="tips">${errors.birthdatemsg}</div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>演员：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" name="f_play"
							value="${student}" />
						<div class="tips">${errors.birthdatemsg}</div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>简介：</label>
					</div>
					<div class="field">
						<textarea rows="5" cols="20" class="input w50" name="f_intro"></textarea>
						<div class="tips">${errors.birthdatemsg}</div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>语言：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" name="f_language"
							value="${student}" />
						<div class="tips">${errors.birthdatemsg}</div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>时长：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" name="f_long"
							value="${student}" />
						<div class="tips">${errors.birthdatemsg}</div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>上映时间：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" name="f_date"
							value="${student}" />
						<div class="tips">${errors.birthdatemsg}</div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>电影图片：</label>
					</div>
					<div class="field">
						<input type="file" class="input w50" name="f_avatar" />
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