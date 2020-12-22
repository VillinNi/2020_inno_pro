package com.myutils;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.Date;

import com.bean.ExamBean;
import com.bean.TeacherBean;
import com.dao.ExamDao;
import  com.myutils.DbUtil;
public class test {

    public static void main(String[] args) throws SQLException, ClassNotFoundException, UnsupportedEncodingException, NoSuchAlgorithmException {
        /*String DB_URL = "jdbc:mysql://localhost:3306/exam_sys";

        String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        Class.forName(JDBC_DRIVER);
        Connection conn = DriverManager.getConnection(DB_URL,"root", "111111");
        String path="conf/mysql_conf.properties";
       /* File file=new File(path);
        if(file.exists()){
            System.out.println("yes");
        }
        else{
            System.out.println("not exits");
        }
        Connection conn = DbUtil.get_con();*/
        /*String sql="select * from t_admin";
        System.out.println(conn);
        PreparedStatement pstmt=conn.prepareStatement(sql);
        ResultSet rs=pstmt.executeQuery();
        while(rs.next()){
            System.out.println(rs.getString("username"));
            System.out.println(rs.getString("password"));
            System.out.println("next one");
        }*/
        /*File file=new File("conf/mysql_conf.properties");
        System.out.println(file.exists());
        Date date=new Date();
        System.out.println(date);*/
        String DB_URL = "jdbc:mysql://localhost:3306/exam_sys";

        /*String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        Class.forName(JDBC_DRIVER);
        Connection conn = DriverManager.getConnection(DB_URL,"root", "111111");
        //String sql="select password from t_teacher where username=?";
        //PreparedStatement ps= conn.prepareStatement(sql);
        //DbUtil.add_single_teacher("dkh","dkh","dkh");
        String sql ="insert into t_teacher(username, password) values(?,?)";
        PreparedStatement preparedStatement=conn.prepareStatement(sql);
        preparedStatement.setString(1,"dkh");
        preparedStatement.setString(2,MdPasswd.encry_passwd("dkh"));
        preparedStatement.executeUpdate();*/
        /*if(ExamDao.check_exam_exist())
        {
            System.out.println("exist");
        }else
        {
            System.out.println("no"
            );
        }*/
    }

}

