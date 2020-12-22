<%@ page import="com.bean.TeacherBean" %>
<%@ page import="java.util.List" %>
<%@ page import="com.dao.ExamDao" %>
<%@ page import="com.bean.ExamBean" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
		 pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>上机考试管理系统</title>
<link href="../../assets/css/admin_header.css" rel="stylesheet">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<link href="../../assets/css/bootstrap.css" rel="stylesheet">
<style>
body {
	padding-top: 60px;
	/* 60px to make the container go all the way to the bottom of the topbar */
}
</style>
</head>
<link href="../../assets/css/bootstrap-responsive.css" rel="stylesheet">
<body>
	<%@ include file="admin_header.jsp"%>
	<div class="container">

		<h1>
			<img src="../assets/img/exam-admin.png" />
		</h1>
		<br />
		<table class="table table-striped table-bordered">
			<thead>
				<tr>
					<th>考试名称</th>
					<th>考试时间</th>
					<th>创建教师</th>
					<th>&nbsp;</th>
				</tr>
			</thead>
			<tbody>
				<%
					List<ExamBean> list = ExamDao.get_all_exam();
					for(ExamBean exam:list){
						out.print("<tr>");
						out.print("<th>"+exam.getE_name()+"</th>");
						out.print("<th>"+exam.getStarttime()+"</th>");
						out.print("<th>"+exam.getE_teacher()+"</th>");
						out.print("<th>"+"<a href='/jsp/admin/DeleteExam?exam_name="+exam.getE_name()+"'>删除考试</a>"+"</th>");
						out.print("</tr>");
					}
				%>
			</tbody>
		</table>
	</div>
	<script src="../../assets/js/jquery.min.js"></script>
	<script src="../../assets/js/bootstrap.min.js"></script>
</body>
</html>