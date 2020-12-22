<%@ page import="com.myutils.TestUtil" %>
<%@ page import="com.bean.StudentBean" %>
<%@ page import="java.util.List" %>
<%@ page import="com.DaoIm.StudentImp" %>
<%@ page import="com.dao.StudentDao" %><%--
  Created by IntelliJ IDEA.
  User: dkh
  Date: 2020/12/5
  Time: 23:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>上机考试系统</title>
</head>
<jsp:include page="teacher_head.jsp"></jsp:include>
<%int sep= TestUtil.sep;
    String exam_name =(String) request.getAttribute("exam_name");//第几页
    exam_name="aaa";
    List<StudentBean> list = StudentDao.get_all_student_by_class(exam_name);
    String t=request.getParameter("num");

    int num= (Integer.parseInt((String)request.getParameter("num"))) ;
%>
<body>
<table>
    <thead>
    <tr>
        <td>hello</td>>
        <td>world</td>
    </tr>
    </thead>
    <tbody>
    <%

        int len=list.size();
        if((num-1)*sep<len&&len!=0){
            int max=len>(num+1)*sep?(num+1)*sep:len;
            for(int i=(num)*sep;i<max;i++)
            {
                out.print("<tr>");
                out.print("<td>"+list.get(i).getStu_name()+"</td>");
                out.print("<td>"+list.get(i).getStu_id()+"</td>");
                out.print("</tr>");
            }
            if(num!=0)  out.print("<a href='./fenyeTest.jsp?num="+(num-1)+"'>上一页</a>");
            if(num<(len+(sep-1))/sep-1)
                out.print("<a href='./fenyeTest.jsp?num="+(num+1)+"'>下一页</a>");

        }

    %>
    </tbody>
</table>
</body>
</html>
