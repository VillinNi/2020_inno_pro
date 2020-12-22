<%@ page import="com.bean.StudentBean" %>
<%@ page import="com.DaoIm.StudentImp" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
		 pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../../CSS/teacher_create_exam.css"/>
</head>
<body>
<jsp:include page="student_head.jsp"/>
<div class="container">
<div class="container-fluid">
	<div class="row-fluid">
		<p1>上传状态: </p1>
		<%boolean status = new StudentImp().get_submit_status((String) session.getAttribute("student_id"));
			if(status==true)
			{
				out.print("<p>"+"已提交"+"</p>");
			}else{
				out.print("<p>"+"未提交"+"</p>");
			}
		%>
		<br>
		<a href="/jsp/student/DownloadSelfAnswer">点击下载自己答案</a>
	</div>
	<div class="row-fluid">
		<h4>答案上传</h4>
		<form class="form-inline" action="/jsp/student/UploadAnswer" enctype="multipart/form-data" method="get">
			<input type="file" required="required" name="answer" />
			<input type="submit" required="required" class="btn btn-primary" value="上传" />
		</form>
	</div>
</div>
</div>

</body>
</html>