package com.teacher;

import com.DaoIm.TeacherImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/jsp/teacher/ChangeTeacherRealname")
public class ChangeTeacherRealname extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String new_name = req.getParameter("p1");
        String teacher_name = (String) req.getSession().getAttribute("teacher_name");
        new TeacherImp().update_teacher_fullname(new_name, teacher_name);
        resp.sendRedirect("/jsp/teacher/teacher_main.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
