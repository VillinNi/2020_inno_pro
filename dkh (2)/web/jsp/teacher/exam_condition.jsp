<%@ page import="com.DaoIm.StudentImp" %>
<%@ page import="com.bean.StudentBean" %>
<%@ page import="com.dao.ExamDao" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>上机考试系统 </title>
    <link rel="stylesheet" type="text/css" href="../../CSS/teacher_create_exam.css"/>
</head>
<body>
<jsp:include page="teacher_head.jsp"/>
<div class="container">
    <h1>
        上机考试管理
    </h1>
    <%
        String exam_name= ExamDao.check_exam_exist();
        if(exam_name==null){
            response.sendRedirect("teacher_create_exam.jsp");
        }
        StudentImp stu=new StudentImp();
        session.setAttribute("exam_name",exam_name);
        int all =stu.get_student_num(exam_name);
        int logged = stu.get_logged_num(exam_name);
        int sub=stu.get_submitted_num(exam_name);
    %>
    <p>·参与考试学生总数：<%out.print(all);%></p>
    <p>·已登录学生数量：<%out.print(logged);%></p>
    <p>·未登录学生数量：<%out.print(all-logged);%></p>
    <p>·提交文件数量：<%out.print(sub);%></p>
    <p>·未提交学生数量：<%out.print(all-sub);%></p>
</div>
</body>
</html>