<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../../CSS/teacher_create_exam.css"/>
    <link rel="stylesheet"
          href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <script
            src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <script
            src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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

</script>
    <script type="text/javascript">
        $(function() {
            setInterval("showInfo()", 10000);
        });

        function showInfo() {
            $.ajax({
                type : "post",
                url : "/jsp/student/GetMessage",
                success : function(text) {
                    $("#show").html(text);
                }
            });
        }
    </script>
</head>
<body>
<div class="container">
<jsp:include page="student_head.jsp"/>
<h1>正在进行考试...</h1>
<p>试卷下载</p>
    <!--<form action="/jsp/student/down_paper" method="post">
    <input type="submit" placeholder="下载">
</form>


    <button onclick="window.location.href='/jsp/student/DownloadSelfAnswer'">点击下载试卷</button>-->

    <a href="/jsp/student/DownloadExamPaper">点击下载试卷</a>
    请按照考试要求将答案文件打包，再次进行上传，同名文件多次上传将会覆盖。<br><br>
    <form action="/jsp/student/upload_zip_answer" method="post" enctype="multipart/form-data">
        <input type="file" id="reportXML" required="required" name="reportXML" title="输入内容" multiple="multipart/form-data">
		<input type="submit"  ></input>
    </form>
    <div>
        <table id="show" style="color: red">

        </table>
    </div>
</div>
</body>
</html>