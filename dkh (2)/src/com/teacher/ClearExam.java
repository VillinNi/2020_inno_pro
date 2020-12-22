package com.teacher;

import com.DaoIm.ExamImp;
import com.bean.ExamBean;
import com.dao.ExamDao;
import com.myutils.DbUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@WebServlet("/jsp/teacher/ClearExam")
public class ClearExam extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // exam表设置已经清理 删除学生信息 删除文件
        String exam_name = req.getParameter("exam_name");
        new ExamImp().clean_exam(exam_name);

        try{
            File file=new File("/WEB-INF/upload/exam_paper/"+exam_name+".zip");
            if(file.exists()){
                file.delete();
            }
            String path ="/WEB-INF/upload/exam_answer/";
            File dir=new File(path+exam_name);

            if(dir.exists()){
                String [] list = dir.list();
                for(int i=0;i<list.length;i++){
                    File t =new File(path+list[i]);
                    t.delete();
                }
            }
            dir.delete();
        }catch (Exception e){
            e.printStackTrace();
        }
        resp.sendRedirect("/jsp/teacher/exam_end.jsp");
    }


}
