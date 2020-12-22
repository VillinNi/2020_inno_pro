<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <title>上机考试系统</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">




    <link href="assets/css/bootstrap.css" rel="stylesheet">
    <link href="assets/css/exam.css" rel="stylesheet">
    <style>
        body {
            padding-top: 60px;
        }
    </style>
    <link href="assets/css/bootstrap-responsive.css" rel="stylesheet">


    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>

</head>

<body>
<div class="container">
    <ul id="loginTab" class="nav nav-tabs">
        <li class="active"><a href="#student" data-toggle="tab">学生登录</a>
        </li>
        <li><a href="#teacher" data-toggle="tab">教师登录</a></li>
        <li><a href="#admin" data-toggle="tab">管理员登录</a></li>
    </ul>

    <div id="loginTabContent" class="tab-content">
        <div class="tab-pane fade in active" id="teacher">
            <div class="container">
                <div class="row vertical-center">
                    <div class="exam-login">
                        <h3>
                            <img class="img-circle" src="assets/img/exam-teacher.png" />
                            教师登录
                        </h3>

                        <form class="exam-form" action="teacher_login" method="post">
                            <p>
                                <input type="text" name="name" placeholder="用户名" /> <br /> <input
                                    type="password" name="pass" placeholder="口令" />
                            </p>
                            <p>
                                <input type="submit" class="btn btn-primary" value="登录"
                                       style="width: 100%" />
                            </p>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <div class="tab-pane fade in active" id="admin">
            <div class="container">
                <div class="row vertical-center">
                    <div class="exam-login">
                        <h3>
                            <img class="img-circle" src="assets/img/exam-admin.png" />
                            管理员登录
                        </h3>

                        <form class="exam-form" action="admin_login" method="post">
                            <p>
                                <input type="text" name="name" placeholder="用户名" /> <br />
                                <input type="password" name="pass" placeholder="口令" />
                            </p>
                            <p>
                                <input type="submit" class="btn btn-primary" value="登录"
                                       style="width: 100%" />
                            </p>
                        </form>
                    </div>
                </div>
            </div>
        </div>

        <div class="tab-pane fade in active" id="student">
            <div class="container">
                <div class="row vertical-center">
                    <div class="exam-login">

                        <h3>
                            <img class="img-circle" src="assets/img/exam-student.png" />
                            学生登录
                        </h3>

                        <form class="exam-form" action="student_login" method="post">
                            <p>
                                <input type="text" name="name" placeholder="用户名" /> <br />
                                <input type="password" name="pass" placeholder="口令" />
                            </p>
                            <p>
                                <input type="submit" class="btn btn-primary" value="登录"
                                       style="width: 100%" />
                            </p>
                        </form>

                    </div>
                </div>


            </div>
        </div>
    </div>
</div>
<!-- /container -->
<!-- Placed at the end of the document so the pages load faster -->
<SCRIPT src="assets/js/jquery.min.js"></SCRIPT>
<SCRIPT src="assets/js/bootstrap.min.js"></SCRIPT>
</body>
</html>