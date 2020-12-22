package com.teacher;


import com.bean.StudentBean;
import com.dao.StudentDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.List;

@WebServlet("/jsp/teacher/GetStudentList")
public class GetStudentList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String filename="list.txt";
        resp.setContentType(getServletContext().getMimeType(filename));
        resp.setHeader("content-Disposition", "attachment;filename="+filename);
        String exam_name = req.getParameter( "exam_name");
        OutputStream out = resp.getOutputStream();
        //out.write();
        List<StudentBean> list = StudentDao.get_all_student_by_class(exam_name);
        OutputStreamWriter writer=new OutputStreamWriter(out);
        String format=String.format("%-16s%-16s%-16s%-20s\n","学号","姓名","登陆情况","提交日期");
        writer.write(format);
        for(StudentBean stu:list){
            String name =String.format("%-16s%-16s%-16s%-20s\n",stu.getStu_id(),stu.getStu_name(),stu.getLogged(),stu.getSub_time());
            writer.write(name);
        }
        writer.close();
        out.close();
    }
}
