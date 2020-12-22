package com.student;

import com.dao.ExamDao;
import com.myutils.ZipUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@WebServlet("/jsp/student/DownloadExamPaper")
public class DownloadExamPaper extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String filename= ExamDao.check_exam_exist();
        if(filename==null)
        {resp.sendRedirect("/jsp/student/student_main.jsp");
            return ;
        }
        filename=filename+".zip";
        resp.setContentType(getServletContext().getMimeType(filename));
        resp.setHeader("content-Disposition", "attachment;filename="+filename);
        String fulFileName=this.getServletContext().getRealPath("/WEB-INF/upload/exam_paper/"+filename);
        //String fulFileName=getServletContext().getRealPath("/WEB-INF/upload/exam_paper/a.txt");

        OutputStream out = resp.getOutputStream();
        ZipOutputStream zou=new ZipOutputStream(out);

        byte [] buffer = new byte[1024];
        int length=0;
        //String base="/WEB-INF/upload/exam_answer/";
        File file = new File(fulFileName);
        if(!file.exists()){
            System.out.println(fulFileName);
            System.out.println("exampaper hasn't  upload ");
            resp.sendRedirect("/jsp/student/student_main.jsp");
            return ;
        }
        System.out.println("paper fullname is "+ fulFileName);
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
        zou.putNextEntry(new ZipEntry(filename));
        while ((length=bis.read(buffer))>0){
            zou.write(buffer,0,length);
        }
        bis.close();
       /* try{
            for(File file:files){
                String pathName = file.getPath();
                BufferedInputStream bis = new BufferedInputStream(new FileInputStream(pathName));
                zou.putNextEntry(new ZipEntry(pathName.substring(base.length())));
                while ((length=bis.read(buffer))>0){
                    zou.write(buffer,0,length);
                }
                bis.close();
            }
        }catch (IOException e){
            e.printStackTrace();
        }*/


        zou.close();
        out.close();
        resp.sendRedirect("/jsp/student/student_main.jsp");
    }
}
