package com.teacher;

import java.io.*;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DaoIm.ExamImp;
import com.bean.ExamBean;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

//上传成为zip形式
@WebServlet("/jsp/teacher/UploadExamPaper")
public class UploadExamPaper extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session= request.getSession();
        String exam_name = (String) session.getAttribute("exam_name");

        String savePath = this.getServletContext().getRealPath("/WEB-INF/upload/exam_paper");
        String paperPath = this.getServletContext().getRealPath("/WEB-INF/upload/exam_answer/"+exam_name);
        File answer_path=new File(paperPath);
        if(!answer_path.exists()||!answer_path.isDirectory()){
            answer_path.mkdir();
        }
        File paper_file = new File(savePath);
        if(!paper_file.exists()&&!paper_file.isDirectory()){
            paper_file.mkdir();
        }
        File file = new File(savePath);
        //判断上传文件的保存目录是否存在
        if (!file.exists() && !file.isDirectory()) {
            file.mkdir();
        }
        //消息提示
        String message = "";
        try{
            //使用Apache文件上传组件处理文件上传步骤：
            //1、创建一个DiskFileItemFactory工厂
            DiskFileItemFactory factory = new DiskFileItemFactory();
            //2、创建一个文件上传解析器
            ServletFileUpload upload = new ServletFileUpload(factory);
            //解决上传文件名的中文乱码
            upload.setHeaderEncoding("UTF-8");
            if(!ServletFileUpload.isMultipartContent(request)){
                //按照传统方式获取数据
                return;
            }
            //4、使用ServletFileUpload解析器解析上传数据，解析结果返回的是一个List<FileItem>集合，每一个FileItem对应一个Form表单的输入项
            List<FileItem> list = upload.parseRequest(request);
            for(FileItem item : list){
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

                    filename = filename.substring(filename.lastIndexOf("/")+1);
                    System.out.println(1+"  "+filename);
                    //获取item中的上传文件的输入流
                    InputStream in = item.getInputStream();
                    //创建一个文件输出流
                    String output_path=savePath + "/" + exam_name+".zip";
                    File out_file = new File(output_path);
                    if(out_file.exists())
                        out_file.delete();

                    FileOutputStream out = new FileOutputStream(new File(output_path));
                    ZipOutputStream zipOutputStream =new ZipOutputStream(out);
                    zipOutputStream.putNextEntry(new ZipEntry(filename));
                    //System.out.println("save file is "+savePath+"\\"+filename);
                    //创建一个缓冲区
                    byte buffer[] = new byte[1024];
                    //判断输入流中的数据是否已经读完的标识
                    int len = 0;
                    while((len=in.read(buffer))>0){
                        zipOutputStream.write(buffer, 0, len);
                    }
                    //关闭输入流
                    in.close();
                    //关闭输出流
                    zipOutputStream.close();
                    out.close();

                    //删除处理文件上传时生成的临时文件
                    item.delete();
                    message = "文件上传成功！";
                    // System.out.println("上传成功");
                }
            }
        }catch (Exception e) {
            // System.out.println("上传失败");
            message= "文件上传失败！";
            e.printStackTrace();
        }
        //上传完毕
        new ExamImp().set_upload(exam_name);
        response.sendRedirect("./teacher_create_exam.jsp");
    }
}
