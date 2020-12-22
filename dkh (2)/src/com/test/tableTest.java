package com.test;

import com.DaoIm.StudentImp;
import com.bean.StudentBean;
import com.dao.StudentDao;
import com.myutils.DbUtil;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class tableTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam_sys","root","111111");
        String student_id="cccc";
       // String sql="update t_student set submittime=? where number=?";
        String sql="insert into info values(?,?)";
        String message="hi new message";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,message);
            Date date =new Date();
            SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String time=format.format(date);
            ps.setString(2,time);

            ps.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
