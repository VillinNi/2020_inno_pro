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
    <title>上机考试管理</title>
</head>
<body>
    <%String teacher_name=request.getParameter("teacher_name");
        session.setAttribute("teacher_name",teacher_name);
        //out.println("session "+session.getAttribute("teacher_name"));
        //out.println("para is "+teacher_name);
    %>
    <script>
        function check() {
            var a=document.getElementById("p1").value;
            var b=document.getElementById("p2").value;
            if(a==b){
                return true;
            }
            else
            {
                document.write(alert("两次密码不一致"));
                return false;
            }

        }
    </script>
    <div>
    <form action="/jsp/admin/ChangeTeacherPassword" method="post">
        <input type="password" placeholder="新密码" id="p1" name="new_password"required>
        <input type="password" placeholder="重复密码" id="p2" required>
        <input type="submit"placeholder="提交" onclick="check()">
    </form>
    </div>
    <div>
        <form action="/jsp/admin/ChangeTeacherRealname" method="post">
            <input type="text" placeholder="真实姓名" required name="new_name">
            <input type="submit" placeholder="提交">
        </form>

    </div>

    <%out.print("<a href='/jsp/admin/DeleteTeacher?'teacher_name="+teacher_name+" >点击删除教师</a>");%>
</body>
</html>
