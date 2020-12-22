<%@ page import="com.bean.ExamBean" %>
<%@ page import="java.util.List" %>
<%@ page import="com.dao.ExamDao" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>上机考试系统</title>
    <link rel="stylesheet" type="text/css" href="../../CSS/teacher_create_exam.css"/> 
</head>
<body>
<jsp:include page="teacher_head.jsp"/><br>

<table class="table table-striped table-bordered">
    <thead>
    <tr>
        <th class="span3">考试名称</th>
        <th class="span3">考试时间</th>
        <th>创建人</th>
        <th>进行中</th>
        <th>已结束</th>
        <th>已清理</th>
        <th>&nbsp;</th>
        <th>&nbsp;</th>
        <th>&nbsp;</th>
    </tr>
    </thead>
    <tbody>
    <%
        String exam_name=ExamDao.check_exam_exist();
        if(exam_name==null)
        {
            response.sendRedirect("/jsp/teacher/teacher_create_exam.jsp");
        }else
        {
            session.setAttribute("exam_name",exam_name);
        }
        String teacher_name = (String) session.getAttribute("teacher_name");

        List<ExamBean> list = ExamDao.get_started_exam(teacher_name);

        for(ExamBean exam:list){
            if(exam.isIs_start())
            {
                System.out.println(exam.getE_name());
                out.print("<tr>");
                out.print("<td>"+exam.getE_name()+"</td>");
                out.print("<td>"+exam.getStarttime()+"</td>");
                out.print("<td>"+exam.getE_teacher()+"</td>");
                out.print("<td>"+exam.isIs_start()+"</td>");
                out.print("<td>"+exam.isArchived()+"</td>");
                out.print("<td>"+exam.isCleaned()+"</td>");
                out.print("<td>"+"<a href='/jsp/teacher/StopExam?exam_name="+exam.getE_name()+"'>停止考试"+"</td>");
                //out.print("<td>"+"<a href='/jsp/teacher/GetStudentList?exam_name="+exam.getE_name()+"'>获取考生信息"+"</td>");

                out.print("<td>"+"<a href='/jsp/teacher/ClearExam?"+exam.getE_name()+"'>"+"</td>");
                out.print("</tr>");
            }

        }

    %>
    </tbody>
</table>
    <div>
        <p1>发送新通知</p1>
        <form action="/jsp/teacher/add_message" method="post">
            <input type="text" placeholder="消息" name="message" required>
            <input type="submit" placeholder="点击提交">
        </form>
    </div>


</body>
</html>