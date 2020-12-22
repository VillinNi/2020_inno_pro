package com.login;

import com.DaoIm.StudentImp;
import com.bean.AdminBean;
import com.myutils.DbUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

@WebServlet("/student_login")
public class Student_login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取用户名和密码
        String stu_id = req.getParameter("student_id");
        String stu_name = req.getParameter("student_username");
        String stu_exam=(String)req.getSession().getAttribute("exam_name");
        String ip = req.getHeader("x-forwarded-for");
        if(null == ip || 0 == ip.length() || "unknown".equalsIgnoreCase(ip)) {
            ip = req.getHeader("Proxy-Client-IP");
        }
        if(null == ip || 0 == ip.length() || "unknown".equalsIgnoreCase(ip)) {
            ip = req.getHeader("WL-Proxy-Client-IP");
        }
        if(null == ip || 0 == ip.length() || "unknown".equalsIgnoreCase(ip)) {
            ip = req.getHeader("X-Real-IP");
        }
        if(null == ip || 0 == ip.length() || "unknown".equalsIgnoreCase(ip)) {
            ip = req.getRemoteAddr();
        }
        if(null==ip||0==ip.length()||"unknown".equalsIgnoreCase(ip))
            resp.sendRedirect("student_login.jsp");
        try {
           // System.out.println(stu_id+"  "+  stu_name+" "+stu_exam);
            System.out.println("\n\n***ip  is +"+ip+"\n\n");
            if(DbUtil.check_student_password(stu_id,stu_name,stu_exam))
            {
                if(DbUtil.check_logged(stu_id)){ //已经登陆过了
                    if(DbUtil.check_ip(stu_id, ip)){
                        System.out.println("i logged an logged again");
                        req.getSession().setAttribute("student_name", stu_name);
                        req.getSession().setAttribute("student_id", stu_id);
                        //req.getSession().setAttribute("exam_name", stu_exam);
                       // System.out.println("oK!");
                        resp.sendRedirect("./jsp/student/student_main.jsp");

                    }else
                    {
                        System.out.println("ip ? oh no!");
                       // System.out.println("ip?");
                        resp.sendRedirect("./student_login.jsp");
                    }
                }
                else
                {
                   // System.out.println("no log");

                    new StudentImp().login(stu_id);
                    new StudentImp().bind_ip(stu_id,ip);
                    req.getSession().setAttribute("student_id",stu_id);
                    req.getSession().setAttribute("student_name", stu_name);
                    resp.sendRedirect("./jsp/student/student_main.jsp");
                }
            }
            else
            {
               // System.out.println("wrong pass");
                resp.sendRedirect("./student_login.jsp");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
