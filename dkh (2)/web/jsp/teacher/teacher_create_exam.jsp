<%@ page import="com.bean.ExamBean" %>
<%@ page import="com.DaoIm.ExamImp" %>
<%@ page import="com.dao.ExamDao" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>上机考试系统</title>
    <link rel="stylesheet" type="text/css" href="../../CSS/teacher_head.css"/>
    <link rel="stylesheet" type="text/css" href="../../CSS/teacher_create_exam.css"/>

</head>
<body>
<jsp:include page="teacher_head.jsp"/>
<br> <br>

<div class="container">
    <%session.setAttribute("exam_name",null);%>
    <h1>
        上机考试管理
    </h1>
    <form class="exam-form form-inline" action="/jsp/teacher/AddNewExam"  method="post">
        <h4>添加考试</h4>
        <input type="text" name="ename" placeholder="考试名称*" size="20" required="required"/>
        <input type="text" name="etime" placeholder="考试时间*" size="20" required="required"/>
        <input type="submit" class="btn btn-primary" required="required" value="添加"/>
    </form>
    <br>
    <table class="table table-striped table-bordered">
        <thead>
        <tr>
            <th class="span3">考试名称</th>
            <th class="span3">考试时间</th>
            <th>创建人</th>
           <!--<th>上传试卷</th>
            <th>自动开始</th>-->
            <th>进行中</th>
            <th>已结束</th>
            <th>&nbsp;</th>
        </tr>
        </thead>
        <tbody>

        <tr>
            <%
                String teacher_name=(String) session.getAttribute("teacher_name");
                List<ExamBean> list = ExamDao.get_exam_by_teacher(teacher_name);
                String exam_name=(String) session.getAttribute("exam_name");
                for(ExamBean exam: list){
                    out.print("<tr><td>"+exam.getE_name()+"</td>" +
                            "<td>"+exam.getStarttime()+"</td>" +
                            "<td>"+exam.getE_teacher()+"</td>" +
                            "<td>"+exam.isIs_start()+"</td>"
                    );
                    out.print("<td>"+"<a href='exam_before.jsp?exam_name="+exam.getE_name()+"'>编辑</a>"+"</td></tr>");
                }



            %>

            <!--td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td>
                <input type="button" onclick="javascript:window.location.href='exam_before.jsp';" value="编辑"/><i
                    class="icon-edit"></i>
            </td>-->

        </tr>

        </tbody>
    </table>


</div>
</body>
</html>