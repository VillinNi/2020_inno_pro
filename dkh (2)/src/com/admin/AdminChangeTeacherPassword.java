package com.admin;

import com.DaoIm.TeacherImp;
import com.myutils.DbUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/jsp/admin/AdminChangeTeacherPassword")
public class AdminChangeTeacherPassword extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String teacher_name;
        String teacher_new_password;
        teacher_name=(String)req.getSession().getAttribute("teacher_name");
        teacher_new_password=req.getParameter("teacher_new_password");
        new TeacherImp().update_teacher_password(teacher_name, teacher_new_password);
        //todo 重定向网址没加
        req.getSession().setAttribute("teacher_name", null);
        resp.sendRedirect("/jsp/admin/admin_main.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req ,resp);
    }
}
