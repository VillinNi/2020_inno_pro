package com.admin;

import com.DaoIm.ExamImp;
import com.myutils.DbUtil;
import com.myutils.MdPasswd;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

@WebServlet("/jsp/admin/ChangePassword")
public class ChangePassword extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String new_pass = req.getParameter("new_passwd");
        String admin_name = (String) req.getSession().getAttribute("admin_name");
        try {
            DbUtil.ChangeAdminPass(admin_name, MdPasswd.encry_passwd(new_pass));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        resp.sendRedirect("/jsp/admin/admin_main.jsp");

    }
}
