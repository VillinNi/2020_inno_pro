package com.teacher;

import com.DaoIm.ExamImp;
import com.dao.ExamDao;
import com.myutils.DbUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;

@WebServlet("/jsp/teacher/StopExam")
public class StopExam extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String exam_name = req.getParameter("exam_name");
        new ExamImp().end_exam(exam_name); //停止考试
        System.out.println("stop exam "+ exam_name);
        resp.sendRedirect("/jsp/teacher/exam_end.jsp");//跳到考试结束界面
    }
}
