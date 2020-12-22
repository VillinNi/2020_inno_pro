<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>上机考试系统</title>
    <link rel="stylesheet" type="text/css" href="../../CSS/teacher_head.css"/>
    <link rel="stylesheet" type="text/css" href="../../CSS/teacher_create_exam.css"/>
    <script type="text/javascript">

    function submitXML(){
    	var fileInput = $('#reportXML').get(0).files[0];
    	console.info(fileInput);
    	if(fileInput){
    		$("#reportXMLform").submit();
    	}else{
    		alert("请选择上传文件！");
    	}
    }
    function submitXML2(){
    	var fileInput = $('#reportXML2').get(0).files[0];
    	console.info(fileInput);
    	if(fileInput){
    		$("#reportXMLform2").submit();
    	}else{
    		alert("请选择上传文件！");
    	}
    }
    </script>
</head>
<body>
<jsp:include page="teacher_head.jsp"/>
<%String exam_name=request.getParameter("exam_name");
    session.setAttribute("exam_name", exam_name);%>
<div class="container">
    <form class="exam-form form-inline" action="teacher_exam_insert" enctype="multipart/form-data" method="post">
        <h4>编辑考试</h4>
        <input type="text" name="ename" placeholder="考试名称*" size="20" required="required"/>
        <input type="text" name="etime" placeholder="考试时间*" size="20" required="required"/>
        <input type="submit" class="btn btn-primary" value="添加" required="required"/>
    </form>

    <h4>上传考生名单</h4>
    <form action="/jsp/teacher/AddMutStudent" method="post" enctype="multipart/form-data">
        <input type="file" id="reportXML" name="reportXML"  required="required" title="输入内容" multiple="multiple" >
		<button type="submit" onclick="submitXML()">提交</button>
    </form>
    <h4>上传试卷</h4>
    <form action="/jsp/teacher/UploadExamPaper" method="post" enctype="multipart/form-data">
        <input type="file" id="reportXML2" name="reportXML2"  required="required" title="输入内容" multiple="multiple">
		<button type="submit" >提交</button>
    </form>
    <form action="/jsp/teacher/StartExam" methos="post">
        <button type="submit">开始考试</button>
    </form>

    <div>
        <h4>添加单个学生</h4>
        <form action="/jsp/teacher/add_single_student" method="post">
            <input type="text" name="student_id" placeholder="学号" required="required"/>
            <input type="text" name="student_name" placeholder="姓名" required="required"/>
            <input type="submit" value="添加" required="required"/>
        </form>
    </div>
</div>
</body>
</html>