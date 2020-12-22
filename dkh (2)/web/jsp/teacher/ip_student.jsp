<%@ page import="com.dao.ExamDao" %>
<%@ page import="com.bean.StudentBean" %>
<%@ page import="com.DaoIm.StudentImp" %>
<%@ page import="com.dao.StudentDao" %>
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
<% String exam_name= ExamDao.check_exam_exist();
	if(exam_name==null){
		response.sendRedirect("teacher_create_exam.jsp");
	}
	else{
		session.setAttribute("exam_name",exam_name);
	}
%>
	<div class="container">
		<h1>
			上机考试管理
		</h1>


<form class="exam-form form-inline" action="./ip_student.jsp"
	method="post">
	<h4>按学号查找已登录信息</h4>
	<input type="text" name="sno" placeholder="学号" size="20" required="required"/>
	<button type="submit" class="btn btn-primary"><i class="icon-search"></i> 查找</button>
</form>

		<!-- <form class="exam-form form-inline" action="teacher_manage_binding_searchip"
	method="post">
	<h4>学号查找已登录信息</h4>
	<input type="text" name="ip" placeholder="学号" size="20" />
	<button type="submit" class="btn btn-primary"><i class="icon-search"></i> 查找</button>
</form> -->


<div class="container-fluid">
	<div class="row-fluid">
		<h4>查找结果</h4>
		<table class="table table-striped table-bordered">
			<thead>
				<tr>
					<th >学号</th>
					<th >姓名</th>
					<th >班级</th>
					<th >ip</th>
					<th >是否登录过</th>
					<th >是否提交</th>
				</tr>
			</thead>
			<tbody>
				<%
					String sno=request.getParameter("sno");
					if(sno!=null)
					{
						StudentBean stu = StudentDao.get_student_by_sno(sno);
						if(stu.getStu_ip()!=null){
							out.print("<tr>");
							out.print("<td>"+stu.getStu_id()+"</td>");
							out.print("<td>"+stu.getStu_name()+"</td>");
							out.print("<td>"+stu.getStu_class()+"</td>");
							out.print("<td>"+stu.getStu_ip()+"</td>");
							out.print("<td>"+stu.getLogged()+"</td>");
							String sub=stu.getSub_time()==null?"未提交":"已经提交";
							out.print("<td>"+sub+"</td>");
							out.print("<td><a href='/jsp/teacher/UnlockStudentIP?student_no="+stu.getStu_id()+"'>解除锁定</td>");
							out.print("</tr>");
						}
					}
				%>
			</tbody>
		</table>
	</div>
</div>


	</div>
	<!-- /container -->
	<!-- placed at the end of the document so the pages load faster -->
	<script src="../../js/jquery.min.js"></script>
	<script src="../../js/bootstrap.min.js"></script>
	<script src="../../js/bootstrap-datetimepicker.js"></script>
	<script src="../../js/bootstrap-datetimepicker.zh-CN.js"></script>
</body>
</html>
