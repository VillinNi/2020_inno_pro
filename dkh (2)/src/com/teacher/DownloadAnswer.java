package com.teacher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@WebServlet("/jsp/teacher/DownloadAnswer")
public class DownloadAnswer extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String exam_name=(String) req.getSession().getAttribute("exam_name");
        if(exam_name==null)
            resp.sendRedirect("../../");
        String student_id=(String) req.getSession().getAttribute("student_id");

        resp.setContentType(getServletContext().getMimeType(student_id));
        resp.setHeader("content-Disposition", "attachment;filename="+student_id);
        String fulFileName=getServletContext().getRealPath("/WEB-INF/upload/exam_paper/"+student_id);
        //String fulFileName=getServletContext().getRealPath("/WEB-INF/upload/exam_paper/a.txt");
        InputStream in = new FileInputStream(fulFileName);
        OutputStream out = resp.getOutputStream();
        byte [] buffer = new byte[1024];
        while(in.read(buffer)!=-1)
        {
            out.write(buffer);
        }
        in.close();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
