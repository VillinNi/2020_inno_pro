<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<title>上机考试系统</title>

<head>


    <link href="../../assets/css/bootstrap.css" rel="stylesheet">
    <link href="../../assets/css/exam.css" rel="stylesheet">
    <link href="../../assets/css/admin_header.css" rel="stylesheet">
    <style>
        body {
            padding-top: 60px;
            /* 60px to make the container go all the way to the bottom of the topbar */
        }
    </style>
    <link href="assets/css/bootstrap-responsive.css" rel="stylesheet">
</head>
<body>
<jsp:include page="admin_header.jsp"/>
<script>
    function check() {
        var p1=document.getElementById("new_passwod").value
        var p2=document.getElementById("new_password1").value
        if(p1==p2){
            return true;
        }
        else{
            document.write(alert("两次密码不一致!"));
            return false;
        }

    }
</script>
<div>
<form action="/jsp/admin/ChangePassword" method="post">

    <h4>修改口令</h4>

    <input type="password" name="new_passwd" placeholder="新口令" size="20" required/><br>
    <input type="password" name="new_password1" placeholder="重复口令" size="20" required/><br>
    <input type="submit" name="action" onclick="check()" value="修改"/>


</form>
</div>
</body>
</html>