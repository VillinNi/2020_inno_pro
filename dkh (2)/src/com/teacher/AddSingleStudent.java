package com.teacher;

import com.bean.ExamBean;
import com.bean.StudentBean;
import com.myutils.DbUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/jsp/teacher/add_single_student")
public class AddSingleStudent extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StudentBean stu=new StudentBean();
        HttpSession session=req.getSession();

        String username=req.getParameter("student_name");
        String stu_id = req.getParameter("student_id");
        String exam_name = (String)session.getAttribute("exam_name");
        StudentBean studentBean=new StudentBean();
        studentBean.setStu_id(stu_id);
        studentBean.setStu_name(username);
        studentBean.setStu_class(exam_name);
        DbUtil.add_single_student(studentBean);
        resp.sendRedirect("/jsp/teacher/exam_before.jsp");//跳回修改学生界面
    }
}
