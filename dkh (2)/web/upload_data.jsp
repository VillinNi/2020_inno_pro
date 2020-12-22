<%--
  Created by IntelliJ IDEA.
  User: dkh
  Date: 2020/11/26
  Time: 20:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <p>now you see me</p>
    <form action="UploadExamPaper" method="post" enctype="multipart/form-data">
        <input type="file" name="file1"><br>
        <button type="submit">click me</button>
    </form>

</body>
</html>
