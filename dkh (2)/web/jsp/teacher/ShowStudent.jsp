<%@ page import="com.myutils.TestUtil" %>
<%@ page import="com.bean.StudentBean" %>
<%@ page import="com.dao.StudentDao" %>
<%@ page import="java.util.List" %>
<%@ page import="com.dao.ExamDao" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
		 pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>上机考试系统</title>
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
<%int sep= TestUtil.sep; String exam_name= ExamDao.check_exam_exist();
	if(exam_name==null){
		response.sendRedirect("exam_before.jsp");
	}
	exam_name=ExamDao.check_exam_exist();

	String t=request.getParameter("num");

	int num;
	if(t==null){
		num=0;
	}
	else
	 num= (Integer.parseInt((String)request.getParameter("num"))) ;
%>
<br><br>
<div class="container">
<div class="container-fluid">

	<div class="row-fluid">
		<table class="table table-striped table-bordered">
			<thead>
				<tr>
					<th >学号</th>
					<th >姓名</th>
					<th >班级</th>
					<th >登录状态</th>
					<th >提交状态</th>
					<th>&nbsp;</th>
				</tr>
			</thead>

			<tbody>
			<%
				List<StudentBean> list = StudentDao.get_all_student_by_class(exam_name);
				int len=list.size();
				if((num)*sep<=len&&len!=0){
					int max=len>(num+1)*sep?(num+1)*sep:len;
					for(int i=(num)*sep;i<max;i++)
					{
						out.print("<tr>");
						out.print("<td>"+list.get(i).getStu_id()+"</td>");
						out.print("<td>"+list.get(i).getStu_name()+"</td>");

						out.print("<td>"+list.get(i).getStu_exam()+"</td>");
						String log;
						if(list.get(i).getLogged())
							log="已登录";
						else
							log="未登录";
						String sub;
						if(list.get(i).getSub_time()==null){
							sub="未提交";
						}else
						{
							sub=list.get(i).getSub_time();
						}
						out.print("<td>"+log+"</td>");
						out.print("<td>"+sub+"</td>");

						out.print("</tr>");
					}
					if(num!=0)  out.print("<a href='./ShowStudent.jsp?num="+(num-1)+"'>上一页</a>");
					if(num<(len+(sep-1))/sep-1)
						out.print("<a href='./ShowStudent.jsp?num="+(num+1)+"'>下一页</a>");

				}

			%>
			</tbody>
		</table>
	</div>

</div>
</div>
	<script src="../../js/jquery.min.js"></script>
	<script src="../../js/bootstrap.min.js"></script>
	<script src="../../js/bootstrap-datetimepicker.js"></script>
	<script src="../../js/bootstrap-datetimepicker.zh-CN.js"></script>
</body>
</html>
