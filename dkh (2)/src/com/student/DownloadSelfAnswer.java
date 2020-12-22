package com.student;

import com.dao.ExamDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;

@WebServlet("/jsp/student/DownloadSelfAnswer")
public class DownloadSelfAnswer extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
        String filename= (String) session.getAttribute("student_id");
        if(filename==null)
        {
            resp.sendRedirect("/jsp/student/student_main.jsp");
            return;
        }
        String exam_name= ExamDao.check_exam_exist();
        filename=filename+".zip";
        if(exam_name==null)
        {
            resp.sendRedirect("/jsp/student/student_main.jsp");
            return;
        }
        System.out.println("student id "+filename);
        System.out.println("exam name  "+exam_name);
        resp.setContentType(getServletContext().getMimeType(filename));
        resp.setHeader("content-Disposition", "attachment;filename="+filename);
        String fulFileName=getServletContext().getRealPath("/WEB-INF/upload/exam_answer/"+exam_name+"/"+filename);
        //String fulFileName=getServletContext().getRealPath("/WEB-INF/upload/exam_paper/a.txt");
        File file =new File(fulFileName);
        if(!file.exists()){
            System.out.println("student not upload not exist");
            resp.sendRedirect("/jsp/student/student_main.jsp");
            return ;
        }
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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
