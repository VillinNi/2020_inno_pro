<%@ page import="com.dao.ExamDao" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="./CSS/main_login.css"/>
</head>
<div>

</div>
<body>
<img alt="河南大学" src="https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=3151332307,3812494003&fm=26&gp=0.jpg"
     width="200" height="100">
<%session.setAttribute("teacher_name",null);
    session.setAttribute("admin_name",null);
    session.setAttribute("student_id",null);
%>
<div class="menu">
    <ul class="menubar">
        <li class="menu-value" ><a href="admin_login.jsp">管理员登录</a></li>
        <li class="" ><a href="teacher_login.jsp">教师登录</a></li>
        <li class="" ><a href="student_login.jsp">学生登录</a></li>r
    </ul>
</div>

<%
    String exam_name= ExamDao.check_exam_exist();
    if(exam_name==null){
        out.print("没有考试！");
    }
    else
    {
        session.setAttribute("exam_name",exam_name);
        out.print("<p>"+exam_name+"正在执行</p>");
    }
%>
<div id="login">


    <h1>学生登录</h1>
    <form method="post" action="student_login">
        <input type="text" required="required" placeholder="用户名" name="student_id"></input>
        <input type="password" required="required" placeholder="密码" name="student_username"></input>
        <%if(exam_name!=null)
            out.print("<button class=\"but\" type=\"submit\">登录</button>");%>

    </form>
</div>
</body>
</html>