package com.login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import com.dao.ExamDao;
import com.myutils.DbUtil;
@WebServlet("/teacher_login")
public class Teacher_login extends HttpServlet {
    public String teacher_table="t_teacher";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username;
        String password;
        username = req.getParameter("teacher_name");
        password = req.getParameter("password");
        PrintWriter writer=resp.getWriter();
        //System.out.println("some thing wrong?");
        try {
            if(DbUtil.check_teacher_password(username, password,this.teacher_table)) {
                req.getSession().setAttribute("teacher_name",username);
                String exam_name= ExamDao.check_exam_exist();
                if(exam_name==null)
                    ;
                else
                    req.getSession().setAttribute("exam_name",exam_name);
                System.out.println("exam_name"+exam_name);
                resp.sendRedirect("./jsp/teacher/teacher_main.jsp");
            }else{
                writer.write("wrong pass or username!\n");
               resp.sendRedirect("./teacher_login.jsp");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        //resp.sendRedirect("./teacher_login.jsp");
    }
}
