package com.teacher;

import com.DaoIm.TeacherImp;
import com.bean.TeacherBean;
import com.myutils.DbUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/jsp/teacher/UpdateTeacher")
public class UpdateTeacher extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TeacherBean teacher = new TeacherBean();
        teacher.setT_name(req.getParameter("teacher_name"));
        teacher.setT_pwd(req.getParameter("password"));
        teacher.setUsername("real_name");
        new TeacherImp().update_teacher_info(teacher);
    }
}
