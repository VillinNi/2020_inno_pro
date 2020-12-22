<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<title>上机考试系统</title>
<link href="../../assets/css/admin_header.css" rel="stylesheet">
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
			<img src="../../assets/img/exam-admin.png" /> 系统管理
		</h1>
		<br />
		<div class="container-fluid">
			<div class="row-fluid">
				<div class="span4 exam-desc">
					<strong>教师管理</strong> <br /> <br />
					<ul>
						<li>可以对教师用户进行增删改查操作，并可以指定特定教师作为系统管理员</li>
						<li>系统可以有多个管理员</li>
						<li>如果没有任何一个教师具有管理员身份，则默认管理员登录信息有效</li>
					</ul>
				</div>
				<div class="span4 exam-desc">
					<strong>考试清理</strong> <br /> <br />
					<ul>
						<li>清除考试的相关数据，包括数据库中的信息、文件系统中的提交文件</li>
						<li>只有在主考教师已经打包下载学生提交文件后才可以进行</li>
						<li>清理后的考试可以删除</li>
					</ul>
				</div>
				<div class="span4 exam-desc">
					<strong>系统配置</strong> <br /> <br />
					<ul>
						<li>设置一些全局性的系统选项，包括后台任务的时间周期、分页查询时的每页记录数、手动开启考试的时间阈值、学生上传文件字节数的有效范围等</li>
						<li>可以指定是否允许主考教师清理和删除考试。</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<script src="../../assets/js/jquery.min.js"></script>
	<script src="../../assets/js/bootstrap.min.js"></script>
</body>
</html>