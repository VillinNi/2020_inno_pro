package com.teacher;

import com.DaoIm.ExamImp;
import com.bean.ExamBean;
import com.dao.ExamDao;
import com.dao.TeacherDao;
import com.myutils.DbUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/jsp/teacher/GetExamInfo")
public class GetExamInfo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String teacher_name =(String) req.getSession().getAttribute("teacher_name");
        List<ExamBean> list = ExamDao.get_exam_by_teacher(teacher_name);
        resp.getWriter().write("");

    }
}
