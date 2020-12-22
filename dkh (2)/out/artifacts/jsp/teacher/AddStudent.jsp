<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create_exam</title>
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


<p class="exam-info">完成学生名单的导入和修改后，
	<a class="btn" href="teacher_exam_modify?id=0"><i class="icon-edit"></i>返回编辑</a>
</p>

<form class="exam-form form-inline" action="teacher_student_insert"
	method="post">
	<h4>添加单个学生</h4>
	<input type="text" name="sno" placeholder="学号*" size="20" />
	<input type="text" name="sname" placeholder="姓名*" size="20" />
	<input type="text" name="sclass" placeholder="班级" size="20" />
	<input type="hidden" name="eid" value="0" />
	<input type="submit" class="btn btn-primary" value="添加" />
</form>

<form class="exam-form form-inline" action="teacher_student_upload"
	enctype="multipart/form-data" method="post">
	<h4>批量导入学生名单</h4>
	<input type="hidden" name="eid" value="0" />
	<input type="file" name="students" /> <input type="submit"
		class="btn btn-primary" value="导入" />
</form>


	</div>
	<script src="../../js/jquery.min.js"></script>
	<script src="../../js/bootstrap.min.js"></script>
	<script src="../../js/bootstrap-datetimepicker.js"></script>
	<script src="../../js/bootstrap-datetimepicker.zh-CN.js"></script>
</body>
</html>