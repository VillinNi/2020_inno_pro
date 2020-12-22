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
<body>
<img alt="河南大学" src="https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=3151332307,3812494003&fm=26&gp=0.jpg"
width="200" height="100">
<div class="menu">
	<ul class="menubar">
		<li class="menu-value" ><a href="admin_login.jsp">管理员登录</a></li>
		<li class="" ><a href="teacher_login.jsp">教师登录</a></li>
		<li class="" ><a href="student_login.jsp">学生登录</a></li>
		</ul>
</div>
    <div id="login">

        <%session.setAttribute("teacher_name",null);
            session.setAttribute("admin_name",null);
            session.setAttribute("student_id",null);
        %>
        <h1>管理员登录</h1>  
        <form action="admin_login" method="post">
            <input type="text" required="required" placeholder="用户名" name="admin_name"></input>
            <input type="password" required="required" placeholder="密码" name="password"></input>
            <button class="but" type="submit">登录</button>  
        </form>  
    </div>  
</body>
</html>