<%@ page import="com.bean.ExamBean" %>
<%@ page import="com.dao.ExamDao" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
		 pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>上机考试系统</title>
    <link rel="stylesheet" type="text/css" href="../../CSS/teacher_head.css"/>
    <link rel="stylesheet" type="text/css" href="../../CSS/teacher_create_exam.css"/>
	<link href="../../CSS/bootstrap.css" rel="stylesheet">
	<link href="../../CSS/bootstrap-datetimepicker.css" rel="stylesheet">
	<link href="../../CSS/exam.css" rel="stylesheet">
<style>
body {
	padding-top: 60px;
	/* 60px to make the container go all the way to the bottom of the topbar */
}
</style>
<link href="../../CSS/bootstrap-responsive.css" rel="stylesheet">
</head>
<body>
<jsp:include page="teacher_head.jsp"/>
	<div class="container">
		<h1>
 			上机考试管理
		</h1>

<table class="table table-striped table-bordered">
	<thead>
		<tr>
			<th class="span3">考试名称</th>
			<th class="span3">考试时间</th>
			<th>创建人</th>
			<th>进行中</th>
			<th>已结束</th>
			<th>已清理</th>
			<th>&nbsp;</th>
			<th>&nbsp;</th>
			<th>&nbsp;</th>
			<th></th>
		</tr>
	</thead>
	<tbody>
		<%
			String teacher_name = (String) session.getAttribute("teacher_name");
			List<ExamBean> list = ExamDao.get_end_exam(teacher_name);

			for(ExamBean exam:list){
					out.print("<tr>");
					out.print("<td>"+exam.getE_name()+"</td>");
					out.print("<td>"+exam.getStarttime()+"</td>");
					out.print("<td>"+exam.getE_teacher()+"</td>");
					out.print("<td>"+exam.isIs_start()+"</td>");
					out.print("<td>"+exam.isArchived()+"</td>");
					out.print("<td>"+exam.isCleaned()+"</td>");

					out.print("<td>"+"<a href='/jsp/teacher/GetStudentList?exam_name="+exam.getE_name()+"'>获取考生信息"+"</td>");
					out.print("<td>"+"<a href='/jsp/teacher/ClearExam?exam_name="+exam.getE_name()+"'>清理考试</a>"+"</td>");
					out.print("<td>"+"<a href='/jsp/teacher/DownloadAllAnswer?exam_name="+exam.getE_name()+"'>下载答案</a></td>");
				System.out.println("<td>"+"<a href='/jsp/teacher/DownloadAllAnswer?exam_name="+exam.getE_name()+"'>下载答案</a></td>");

					out.print("</tr>");
			}

			String t="gaa";
		%>
	</tbody>
</table>


	</div>
	<!-- /container -->
	<!-- placed at the end of the document so the pages load faster -->
	<script src="../../js/jquery.min.js"></script>
	<script src="../../js/bootstrap.min.js"></script>
	<script src="../../js/bootstrap-datetimepicker.js"></script>
	<script src="../../js/bootstrap-datetimepicker.zh-CN.js"></script>
</body>
</html>
