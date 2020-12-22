<%@ page import="com.bean.TeacherBean" %>
<%@ page import="com.DaoIm.StudentImp" %>
<%@ page import="com.DaoIm.TeacherImp" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: dkh
  Date: 2020/12/4
  Time: 22:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%List<TeacherBean> list = new TeacherImp().get_all_teacher();
    int cnt=0;
    out.println("<table border='1'>");
    out.println("<tr>");
    out.println("<td>teacher name</td>");
    out.println("<td>realname</td>");
    out.println("<td> </td>");
    out.println("</tr>");
    for(int i=0;i<list.size();i++)
    {
        TeacherBean teacherBean=list.get(i);
        //out.println(cnt++);
        out.print("<tr>");
        out.println("<td>"+teacherBean.getUsername()+"</td> <td>"+teacherBean.getT_name()+"</td>");
        out.println("<td><a href='./ChangeTeacher.jsp?teacher_name="+teacherBean.getUsername()+"'>编辑</a></td>");
        out.print("</tr>");
        out.println("<br>");
    }
    out.println("</table>");
    %>

</body>
</html>
