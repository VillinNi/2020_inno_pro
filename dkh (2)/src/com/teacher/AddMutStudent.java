package com.teacher;

import com.bean.StudentBean;
import com.myutils.DbUtil;
import com.myutils.ExcelTest;
import com.myutils.ExcelUtil;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@WebServlet("/jsp/teacher/AddMutStudent")
public class AddMutStudent extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       try {
           DiskFileItemFactory factory = new DiskFileItemFactory();
           //2、创建一个文件上传解析器
           ServletFileUpload upload = new ServletFileUpload(factory);
           //解决上传文件名的中文乱码
           upload.setHeaderEncoding("UTF-8");
           if(!ServletFileUpload.isMultipartContent(req)){
               //按照传统方式获取数据
               return;
           }
           //4、使用ServletFileUpload解析器解析上传数据，解析结果返回的是一个List<FileItem>集合，每一个FileItem对应一个Form表单的输入项
           List<FileItem> list = upload.parseRequest(req);for(FileItem item : list){
               //如果fileitem中封装的是普通输入项的数据
               if(item.isFormField()){
                   String name = item.getFieldName();
                   //解决普通输入项的数据的中文乱码问题
                   String value = item.getString("UTF-8");
                   //value = new String(value.getBytes("iso8859-1"),"UTF-8");
                   System.out.println(name + "=" + value);
               }else{//如果fileitem中封装的是上传文件
                   //得到上传的文件名称，
                   String filename = item.getName();
                   System.out.println(filename);
                   if(filename==null || filename.trim().equals("")){
                       System.out.println("continued");
                       continue;
                   }

                   //filename = filename.substring(filename.lastIndexOf("\\")+1);
                   //System.out.println(1+"  "+filename);
                   //获取item中的上传文件的输入流
                   InputStream in = item.getInputStream();
                   //创建一个文件输出流
                   String exam_name = (String) req.getSession().getAttribute("exam_name");
                   System.out.println("add mu stu exam_name is "+exam_name);
                   List<StudentBean> student_list= ExcelUtil.read_student_from_excel(in);
                    for(StudentBean stu:student_list){
                        stu.setStu_class(exam_name);
                        DbUtil.add_single_student(stu);
                    }
               }
               System.out.println("insert ok!");
           }
       }catch (Exception e){
           e.printStackTrace();

           //todo 跳转没加 !!! 跳转到操作界面
           //resp.sendRedirect("");
       }
       resp.sendRedirect("/jsp/teacher/exam_before.jsp");
    }
}
