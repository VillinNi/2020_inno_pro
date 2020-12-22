package com.admin;

import com.DaoIm.TeacherImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/jsp/admin/DeleteTeacher")
public class DeleteTeacher extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String teacher_name =(String) req.getSession().getAttribute("teacher_name");
        new TeacherImp().delete_teacher(teacher_name);
        req.getSession().setAttribute("teacher_name", null);
        resp.sendRedirect("/jsp/admin/admin_teacher.jsp");
    }
}
