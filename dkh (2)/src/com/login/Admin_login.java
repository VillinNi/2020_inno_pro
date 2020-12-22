package com.login;

import com.myutils.DbUtil;
import com.myutils.MdPasswd;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

@WebServlet("/admin_login")
public class Admin_login extends HttpServlet {
    private static String admin_table="t_admin";
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username;
        String password;
        username = req.getParameter("admin_name");
        password = req.getParameter("password");
        Writer writer=resp.getWriter();
        try {
            if(DbUtil.check_admin_password(username, password)) {
                req.getSession().setAttribute("admin_name", username);
                resp.sendRedirect("/jsp/admin/admin_main.jsp");
            }else{
                writer.write("用户名或密码错误!");
                Thread.sleep(500);
                resp.sendRedirect("./admin_login.jsp");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
