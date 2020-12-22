<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>上机考试系统</title>
<link href="../../assets/css/admin_header.css" rel="stylesheet">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<link href="../../assets/css/bootstrap.css" rel="stylesheet">
<link href="../../assets/css/exam.css" rel="stylesheet">
<style>
body {
	padding-top: 60px;
	/* 60px to make the container go all the way to the bottom of the topbar */
}
</style>
<link href="../../assets/css/bootstrap-responsive.css" rel="stylesheet">
</head>
<body>
	<%@ include file="admin_header.jsp"%>
	<div class="container">
		<h1>
			<img src="../../assets/img/exam-admin.png" />
		</h1>
		<br />
	</div>
	<!--
		<form class="exam-form form-horizontal" action="admin_config_update"
			method="post">
			<h4>修改系统配置</h4>
			<div class="control-group">
				<label class="control-label" for="interval">后台任务间隔时间</label>
				<div class="controls">
					<input type="text" id="interval" name="interval" value="30"
						required />
-->
	<!-- 扫描间隔 -->
	<!--
					<p class="help-block">指定扫描考试信息的间隔时间，单位为 分钟。</p>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="pagesize">分页查询记录条数</label>
				<div class="controls">
					<input type="text" id="pagesize" name="pagesize" value="30"
						required />
-->
	<!-- 分页查询 -->
	<!--
					<p class="help-block">指定分页查询时每页显示记录数的默认值（查询页面中可以更改）。</p>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="timegap">手动开启考试时间阈值</label>
				<div class="controls">
					<input type="text" id="timegap" name="timegap" value="15" required />
					<p class="help-block">指定手工开启考试时允许的最大提前量，单位为分钟</p>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="minfilesize">上传文件字节数下限</label>
				<div class="controls">
					<input type="text" id="minfilesize" name="minfilesize" value="512"
						required />
					<p class="help-block">指定上传文件的长度下限（字节），低于此值发出警告</p>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="maxfilesize">上传文件字节数上限</label>
				<div class="controls">
					<input type="text" id="maxfilesize" name="maxfilesize"
						value="131072" required />
					<p class="help-block">指定上传文件的长度上限（字节），高于此值发出警告</p>
				</div>
			</div>
			<div class="control-group">
				<div class="controls">
					<label class="checkbox"> <input type="checkbox"
						id="candelete" name="candelete" value="true" checked />
						教师可以清理和删除考试  <!-- to make struts2 get unchecked input -->
	<!-- 
						<input type="hidden" id="__checkbox_candelete"
						name="__checkbox_candelete" value="true" required />
					</label>
				</div>
			</div>
			<div class="control-group">
				<div class="controls">
					<input type="submit" name="action" class="btn btn-primary"
						value="修改" required />
				</div>
			</div>
		</form>

	</div>

-->
	<script src="../../assets/js/jquery.min.js"></script>
	<script src="../../assets/js/bootstrap.min.js"></script>
</body>
</html>