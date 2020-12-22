package com.teacher;

import com.myutils.ZipUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@WebServlet("/jsp/teacher/DownloadAllAnswer")
public class DownloadAllAnswer extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String  exam_name= req.getParameter("exam_name");

        String filename = exam_name + ".zip";
        if (exam_name == null)
            resp.sendRedirect("/jsp/student/student_main.jsp");

        resp.setContentType(getServletContext().getMimeType(filename));
        resp.setHeader("content-Disposition", "attachment;filename=" + filename);
        //文件夹名字
        String fulFileName = getServletContext().getRealPath("/WEB-INF/upload/exam_answer/" + exam_name);
        OutputStream out = resp.getOutputStream();
        ZipOutputStream zou = new ZipOutputStream(out);
        File[] files = null;
        files = new File(fulFileName).listFiles(); //累出文件夹下内容
        byte[] buffer = new byte[1024];
        int length = 0;

        try {
            for (File file : files) {
                String pathName = file.getPath();
                BufferedInputStream bis = new BufferedInputStream(new FileInputStream(pathName));
                zou.putNextEntry(new ZipEntry(pathName.substring(fulFileName.length())));
                while ((length = bis.read(buffer)) > 0) {
                    zou.write(buffer, 0, length);
                }
                bis.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        zou.close();
        out.close();
        resp.sendRedirect("/jsp/student/student_main.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            doGet(req,resp);

    }
}
