package com.admin;

import com.DaoIm.ExamImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/jsp/admin/DeleteExam")
public class DeleteExam extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String exam_name=req.getParameter("exam_name");
        new ExamImp().delete(exam_name);
        resp.sendRedirect("/jsp/admin/admin_exam.jsp");
    }
}
