<%@ page import="com.bean.TeacherBean" %>
<%@ page import="com.DaoIm.TeacherImp" %>
<%@ page import="java.util.List" %>
<%@ page import="com.myutils.DbUtil" %>
<%@ page import="com.myutils.TestUtil" %>
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
<link href="../../assets/css/exam.css" rel="stylesheet">
<style>
body {
	padding-top: 60px;
}
</style>
<link href="../../assets/css/bootstrap-responsive.css" rel="stylesheet">
</head>
<%int sep= TestUtil.sep;
	String t=request.getParameter("num");
	int num;
	if(t==null){
		num=0;
	}else
	{
		num=Integer.parseInt(t);
	}
%>
<body>
	<%@ include file="admin_header.jsp"%>
	<div class="container">
		<h1>
			<img src="../../assets/img/exam-admin.png" />
		</h1>
		<br />
		<form action="/jsp/admin/AddNewTeacher" method="post">
			<h4>添加教师</h4>
			<input type="text" name="teacher_name" placeholder="用户名*" size="20" />
			<input type="password" name="password" placeholder="初始口令*" size="20" />
			<input type="text" name="real_name" placeholder="真实姓名" size="20" />
			<input type="submit" name="action" class="btn btn-primary" value="添加" />
		</form>
		<table class="table table-striped table-bordered">
			<thead>
				<tr>
					<th >用户名</th>
					<th >真实姓名</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
			<% List<TeacherBean> list = new TeacherImp().get_all_teacher();
				int len=list.size();
				if((num)*sep<=len&&len!=0) {
					int max = len > (num + 1) * sep ? (num + 1) * sep : len;
					for (int i=(num)*sep;i<max;i++) {
						TeacherBean teacherBean = list.get(i);
						//out.println(cnt++);
						out.print("<tr>");
						out.println("<td>" + teacherBean.getUsername() + "</td> <td>" + teacherBean.getT_name() + "</td>");
						out.println("<td><a href='./ChangeTeacher.jsp?teacher_name=" + teacherBean.getUsername() + "'>编辑</a></td>");
						out.print("</tr>");
						out.println("<br>");
					}
					if(num!=0)  out.print("<a href='./admin_teacher.jsp?num="+(num-1)+"'>上一页</a>");
					if(num<(len+(sep-1))/sep-1)
						out.print("<a href='./admin_teacher.jsp?num="+(num+1)+"'>下一页</a>");
				}

			%>
			</tbody>
		</table>


	</div>
	<!-- /container -->
	<!-- placed at the end of the document so the pages load faster -->
	<script src="../../assets/js/jquery.min.js"></script>
	<script src="../../assets/js/bootstrap.min.js"></script>
</body>
</html>