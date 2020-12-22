<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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
<br><br>
    <div class="container">

			<strong>考前操作</strong>
			<br/>
			<ul>
				<li>可以新建考试：指定考试名称、开始时间等</li>
				<li>可以编辑自己创建的、未开始的考试，除了修改考试信息，还可以：
					<ul>
						<li>上传试卷</li>
						<li>学生名单导入</li>
						<li>开启考试</li>
					</ul>
				</li>
			</ul>

			<strong>考中管理</strong>
			<br/>

			<ul>
				<li>可以查看考试情况</li>
				<li>可以管理学生信息，手工添加个别学生信息</li>
				<li>可以解除学生登录锁定</li>
				<li>可以添加或删除通知消息</li>
			</ul>

			<strong>考后操作</strong>			
			<br/>
			<ul>
				<li>主考教师（考试创建者）可以结束考试</li>
				<li>主考教师可以打包下载学生提交文件</li>
				<li>主考教师可以导出提交信息</li>
				<li>如果管理员设置，主考教师可以清理和删除考试</li>
			</ul>
</div>


    

</body>
</html>