package com.admin;

import com.myutils.DbUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

@WebServlet("/jsp/admin/AddNewTeacher")
public class AddNewTeacher extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            System.out.println(req.getParameter("teacher_name"));
            System.out.println(req.getParameter("password"));
            System.out.println(req.getParameter("real_name"));
            DbUtil.add_single_teacher(req.getParameter("teacher_name"),
                    req.getParameter("password"),
                    req.getParameter("real_name"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        resp.sendRedirect("/jsp/admin/admin_teacher.jsp");
    }
}
