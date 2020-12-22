<%--
  Created by IntelliJ IDEA.
  User: dkh
  Date: 2020/12/4
  Time: 23:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%String teacher_name=request.getParameter("teacher_name");
        session.setAttribute("teacher_name",teacher_name);
        out.println("session "+session.getAttribute("teacher_name"));
        out.println("para is "+teacher_name);
    %>
</body>
</html>
