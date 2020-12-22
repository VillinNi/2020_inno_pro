package com.teacher;

import com.myutils.DbUtil;
import com.myutils.MdPasswd;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/jsp/teacher/ChangeTeacherPassword")
public class ChangeTeacherPassword extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String teacher_name;
        String teacher_new_password;
        teacher_name=(String)req.getSession().getAttribute("teacher_name");
        teacher_new_password=req.getParameter("teacher_new_password");
       // System.out.println(req.getParameter("teacher_new_password"));
        String sql = "update  t_teacher set password = ? where username=?";
        try{
            PreparedStatement ps = DbUtil.get_con().prepareStatement(sql);
            ps.setString(1, MdPasswd.encry_passwd(teacher_new_password));
            ps.setString(2, teacher_name);
            ps.executeUpdate();

        }catch (SQLException | NoSuchAlgorithmException e){

            e.printStackTrace();
        }
        resp.sendRedirect("/jsp/teacher/exam_before.jsp");
    }
}
