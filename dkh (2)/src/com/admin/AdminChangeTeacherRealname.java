package com.admin;

import com.DaoIm.TeacherImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/jsp/admin/AdminChangeTeacherRealname")
public class AdminChangeTeacherRealname extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String teacher_name = (String)req.getSession().getAttribute("teacher_name");
        String real_name = req.getParameter("real_name");
        new TeacherImp().update_teacher_fullname(teacher_name, real_name);
        req.getSession().setAttribute("teacher_name", null);
        resp.sendRedirect("/jsp/admin/admin_main.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
