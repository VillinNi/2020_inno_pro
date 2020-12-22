package com.student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@WebServlet("/jsp/student/down_paper")
public class DownloadExam extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String filename;
        String exam_name=(String) req.getSession().getAttribute("exam_name");
        filename=exam_name+".zip";
        if(exam_name==null)
            resp.sendRedirect("./student_main.jsp");

        resp.setContentType(getServletContext().getMimeType(filename));
        resp.setHeader("content-Disposition", "attachment;filename="+filename);
        String fulFileName=getServletContext().getRealPath("/WEB-INF/upload/exam_paper/"+filename);
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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
