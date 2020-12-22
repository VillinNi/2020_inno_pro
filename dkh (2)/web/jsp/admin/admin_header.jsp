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

	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
				<!--  <span class="brand"><strong>上机考试系统</strong></span> -->

				<ul>
					<li><a href="admin_main.jsp">首页</a></li>
					<li><a href="admin_teacher.jsp">教师管理</a></li>
					<li><a href="admin_exam.jsp">考试清理</a></li>
					<li><a href="admin_config.jsp">系统配置</a></li>

					<li><span class="brand"><small>欢迎，<%out.print(session.getAttribute("admin_name"));%></small></span></li>
					<li><a href="admin_passwd.jsp">修改口令</a></li>
					<li><a href="/admin_login">退出</a></li>
				</ul>
			</div>
		</div>
	</div>

</body>
</html>