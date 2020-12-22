package com.teacher;


import com.DaoIm.ExamImp;
import com.bean.ExamBean;
import com.myutils.DbUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/jsp/teacher/AddNewExam")
public class AddNewExam extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("add new exam");
        ExamBean examBean = new ExamBean();
        examBean.setE_name(req.getParameter("ename"));
        examBean.setStarttime(req.getParameter("etime"));
        String teacher_name=(String)req.getSession().getAttribute("teacher_name");
        req.getAttribute("teacher_name");
        System.out.println("atr is "+  req.getAttribute("teacher_name"));
        examBean.setE_teacher(teacher_name);
        examBean.setE_teacher(teacher_name);
        System.out.println(examBean.getE_name()+"  "+examBean.getStarttime()+"  "+examBean.getE_teacher() );
        new ExamImp().add(examBean);
        resp.sendRedirect("/jsp/teacher/teacher_head.jsp");
    }
}
