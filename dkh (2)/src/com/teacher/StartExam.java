package com.teacher;

import com.DaoIm.ExamImp;
import com.DaoIm.StudentImp;
import com.DaoIm.TeacherImp;
import com.dao.ExamDao;
import com.myutils.DbUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/jsp/teacher/StartExam")
public class StartExam extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String exam_name = (String) req.getSession().getAttribute("exam_name");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");
        if(ExamDao.check_exam_exist()!=null){
            resp.getWriter().write("<p>目前有其他考试正在进行!</p>");
        }
        else {
            if(new ExamImp().check_paper(exam_name))
            {
                new ExamImp().start_exam(exam_name);
                req.getSession().setAttribute("exam_name", exam_name);
                resp.sendRedirect("/jsp/teacher/teacher_create_exam.jsp");
            }
            else{
                resp.getWriter().write("<p>暂未上传试卷!</p>");
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
