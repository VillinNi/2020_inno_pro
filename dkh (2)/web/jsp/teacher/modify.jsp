<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>上机考试系统</title>
    <link rel="stylesheet" type="text/css" href="../../CSS/teacher_create_exam.css"/>
    <script type="text/javascript">
    function method2(){
		var a=document.getElementById("teacher_new_password").value;
		var b=document.getElementById("password3").value;
		if(a==b)
		{
			
				return;    
			
			//document.getElementById("submit").disabled = true;

		}
		else
			{
			alert("密码错误！");   
			}
    }
			</script> 
</head>
<body>
<jsp:include page="teacher_head.jsp"/><br>
<div class="container">
<form action="/jsp/teacher/ChangeTeacherPassword" method="post">
			<label><sup>*</sup>新密码：</label>
			<input type="password"  id="teacher_new_password" name="teacher_new_password" required="required"/>
			<label><sup>*</sup>确认密码：</label>
			<input type="password" id="password3" name="password3" required="required" onblur="method2()" /><br>

			<div>
				<input type="submit"value="提交" required="required"/>
				<input type="reset" value="重置" required="required"/>
			</div>
</form>
</div>
</body>
</html>