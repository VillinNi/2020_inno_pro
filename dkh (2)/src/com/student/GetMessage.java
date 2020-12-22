package com.student;

import com.bean.Message;
import com.myutils.DbUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/jsp/student/GetMessage")
public class GetMessage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        resp.setCharacterEncoding("utf-8");
        String sql="select * from info";
        ResultSet rs=null;
        StringBuffer sb=new StringBuffer();
        List<Message> list =DbUtil.get_message();
        for(Message message:list){
            sb.append("<tr><td>"+message.getMessage() +"</td><td>"+ message.getTime() + "</td></tr>");
        }
        PrintWriter writer=resp.getWriter();
        System.out.println(sb.toString());
        writer.print(sb.toString());
    }
}
