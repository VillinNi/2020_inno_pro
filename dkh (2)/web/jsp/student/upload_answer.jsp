<%--
  Created by IntelliJ IDEA.
  User: dkh
  Date: 2020/11/27
  Time: 22:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <p>now you see me</p>
    <form action="/jsp/student/UploadAnswer" method="post" enctype="multipart/form-data">
        <input type="file" name="file1" required="required"><br>
        <button type="submit">click me</button>
    </form>
</body>
</html>
