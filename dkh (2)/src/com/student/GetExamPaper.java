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

@WebServlet("/jsp/student/GetExamPaper")
public class GetExamPaper extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
        String filename= (String) session.getAttribute("exam_name");
        String exam_name=(String) req.getSession().getAttribute("exam_name");
        filename=filename+".zip";
        if(exam_name==null)
            resp.sendRedirect("/jsp/student/student_main.jsp");

        resp.setContentType(getServletContext().getMimeType(filename));
        resp.setHeader("content-Disposition", "attachment;filename="+filename);
        String fulFileName=getServletContext().getRealPath("/WEB-INF/upload/exam_paper/"+exam_name);
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
        resp.sendRedirect("/jsp/student/student_main.jsp");
    }
}
