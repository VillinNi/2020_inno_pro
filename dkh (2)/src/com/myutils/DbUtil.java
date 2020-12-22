package com.myutils;

import com.bean.Message;
import com.bean.StudentBean;
import org.apache.poi.xslf.model.geom.SqrtExpression;

import javax.swing.*;

import java.io.*;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

public class DbUtil { ;
    private static String username="root";
    private static String password="111111";
    private static String dbname="exam_sys";
    private static String port="3306";
    private static String JDBC_DRIVER="com.mysql.jdbc.Driver";
    private static String db_url="jdbc:mysql://localhost:";
    static Connection con=null;
   /* static{
        File path = new File("conf/mysql_conf.properties");
        File file = new File("conf/mysql_conf.properties");
        System.out.println(path.exists());
        try {
            InputStream is=new BufferedInputStream(new FileInputStream(path));
            Properties properties=new Properties();
            properties.load(is);
            port = properties.getProperty("port");
            dbname=properties.getProperty("dbname");
            password=properties.getProperty("password");
            username=properties.getProperty("username");
            db_url+=port+"/"+dbname;
            System.out.println("port is "+port);
            System.out.println("dbname is "+dbname);
            System.out.println("username is "+username);
            System.out.println("dburl is "+db_url);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("file not found");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }*/
    public static Connection  get_con() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            //System.out.println("url is "+ db_url+" name "+username+ " password "+password);
            //db_url+=port+"/"+dbname;
            String url=db_url+port+"/"+dbname;
            String dbchar="?useUnicode=true&characterEncoding=UTF-8";
            url=url+dbchar;
           // System.out.println(url+username+password);
            con = DriverManager.getConnection(url, username, password);
        }catch (Exception e){
            e.printStackTrace();
        }

        return con;
    }
    public static boolean is_exist_exam() throws SQLException {
        String sql="select * from t_exam";
        Statement stmt=con.createStatement();
        ResultSet rs =stmt.executeQuery(sql);
        Date now=new Date();

        while(rs.next())
        {
            Date begin_date = rs.getDate("begin_date");
            Date end_date = rs.getDate("end_date");
        }
        return true;
    }
    private static String get_teacher_password(String username, String tablename) throws SQLException, UnsupportedEncodingException, NoSuchAlgorithmException {
        String sql="select password from t_teacher where name=?";

        con=get_con();
        PreparedStatement preparedStatement=con.prepareStatement(sql);
        preparedStatement.setString(1,username);
        ResultSet rs = preparedStatement.executeQuery();
        System.out.println(rs.toString());
        rs.next();
        return rs.getString("password");
    }

        public static boolean check_teacher_password(String username, String password, String tablename) throws UnsupportedEncodingException, SQLException, NoSuchAlgorithmException {
        String right_password="";
        String sql="select password  from t_teacher where username=?";
        con=get_con();
        System.out.println(username+"  and password is "+password);
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, username);
        ResultSet rs = ps.executeQuery();
        if(!rs.next())
            return false;
        right_password=rs.getString("password");

        return MdPasswd.encry_passwd(password).equals(right_password)?true:false;
    }

    public static boolean check_admin_password(String username, String password) throws UnsupportedEncodingException, SQLException, NoSuchAlgorithmException {
        String right_password="";
        String sql="select password  from t_admin where username=?";
        con=DbUtil.get_con();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, username);
        ResultSet rs = ps.executeQuery();
        if(!rs.next())
            return false;
        right_password=rs.getString("password");
        System.out.println("right pass is"+right_password);
        System.out.println("pass is "+MdPasswd.encry_passwd(password));
        return MdPasswd.encry_passwd(password).equals(right_password)?true:false;
    }

    public static boolean check_student_password(String student_id, String student_name, String exam_name) throws UnsupportedEncodingException, SQLException, NoSuchAlgorithmException {
        String right_name="";
        String sql="select username,class  from t_student where number=?";
        con=get_con();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, student_id);
        ResultSet rs = ps.executeQuery();

        if(!rs.next())
            return false;
        System.out.println("\n\n there is next \n\n");
        right_name=rs.getString("username");
        String exam=rs.getString("class");
        System.out.println(right_name+" username "+username+" exam  "+exam+" exam_name "+exam_name );
        if(student_name.equals(right_name)&&exam_name.equals(exam))
            return true;
        else
            return false;
       // return right_name.equals(student_name)?true:false;
    }

    public static boolean add_single_teacher(String username, String password ,String realname) throws SQLException, UnsupportedEncodingException, NoSuchAlgorithmException {
        String sql ="insert into t_teacher(username, password, fullname) values(?,?,?)";

        PreparedStatement preparedStatement=DbUtil.get_con().prepareStatement(sql);
        preparedStatement.setString(1,username);
        preparedStatement.setString(2,MdPasswd.encry_passwd(password));
        preparedStatement.setString(3, realname);
        int status =preparedStatement.executeUpdate();
        return true;
    }

    public static boolean add_single_student(StudentBean stu) {
        String sql="insert into t_student(number,username, class) values(?,?, ?)";
        try{
            Connection con=get_con();
            PreparedStatement preparedStatement=con.prepareStatement(sql);
            preparedStatement.setString(1,stu.getStu_id());
            preparedStatement.setString(2,stu.getStu_name());
            preparedStatement.setString(3,stu.getStu_class());
            //preparedStatement.setString(4,stu.getStu_ip());
            //preparedStatement.setString(5,stu.getSub_time());
            preparedStatement.execute();
            //preparedStatement.close();
           // con.close();
        }catch (SQLException e){
            e.printStackTrace();
        }

        return true;
    }

    public static List<StudentBean> get_students(String exam_name) throws SQLException {
        String sql="select * from t_student where class=?";
        PreparedStatement ps=get_con().prepareStatement(sql);
        ps.setString(1, exam_name);
        ResultSet rs=ps.executeQuery();
        List<StudentBean> list=new ArrayList<StudentBean>();
        while(rs.next()){
            StudentBean stu=new StudentBean();
            stu.setStu_name(rs.getString("username"));
            stu.setStu_id(rs.getString("number"));
            stu.setStu_class(rs.getString("class"));
            stu.setStu_ip(rs.getString("ip"));
            stu.setSub_time(rs.getString("submittime"));
            list.add(stu);
        }
        return list;
    }
    public static void unlock_student_ip(String stu_no){
        String sql = "update  t_student set ip=null where number=?";
        try{
            PreparedStatement ps = DbUtil.get_con().prepareStatement(sql);
            ps.setString(1,stu_no);
            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static Boolean check_logged(String stu_id){
        String sql ="select logged from t_student where number=?";
        boolean status=false;
        try {
            PreparedStatement ps =DbUtil.get_con().prepareStatement(sql);
            ps.setString(1,stu_id);
            ResultSet rs=ps.executeQuery();
            rs.next();
            status=rs.getBoolean("logged");

        }catch (SQLException e){
            e.printStackTrace();
        }
        return status;
    }
    public static Boolean check_ip(String stu_id,String ip){
        String sql = "select ip from t_student where number=?";
        boolean status=false;
        try {
            PreparedStatement ps =DbUtil.get_con().prepareStatement(sql);
            ps.setString(1,stu_id);
            ResultSet rs=ps.executeQuery();
            if(rs.next())
            {
                String real_ip=rs.getString("ip");
                status=ip.equals(real_ip);
                System.out.println("real ip "+real_ip);
                System.out.println("ip "+ip);
                System.out.println(real_ip==ip);
                System.out.println("status "+ status);
                if(real_ip==null)
                    status=true;
            }


        }catch (SQLException e){
            e.printStackTrace();
        }

        return status;
    }
    public static int get_exam_student(String exam_name){ //考试人数
        int num=0;
        String sql="select count(*) from t_student where class=?";
        try{
            PreparedStatement ps= DbUtil.get_con().prepareStatement(sql);
            ps.setString(1, exam_name);
            ResultSet rs =ps.executeQuery();
            if(!rs.next()){
                num=rs.getInt(1);
            }else
            {
                num=0;
            }
        }catch (SQLException e)
        {
            e.printStackTrace();;
        }
        return num;
    }
    public static int get_logged_student(String exam_name){ //登录人数
        int num=0;
        String sql="select count(*) from t_student where class=?&&logged=true";
        try{
            PreparedStatement ps= DbUtil.get_con().prepareStatement(sql);
            ps.setString(1, exam_name);
            ResultSet rs =ps.executeQuery();
            if(!rs.next()){
                num=rs.getInt(1);
            }else
            {
                num=0;
            }
        }catch (SQLException e)
        {
            e.printStackTrace();;
        }
        return num;
    }
    public static int get_submit_student(String exam_name){ //获取提交过的人数
        int num=0;
        String sql="select count(*) from t_student where class=?&&logged=true and submittime!=null";
        try{
            PreparedStatement ps= DbUtil.get_con().prepareStatement(sql);
            ps.setString(1, exam_name);
            ResultSet rs =ps.executeQuery();
            if(!rs.next()){
                num=rs.getInt(1);
            }else
            {
                num=0;
            }
        }catch (SQLException e)
        {
            e.printStackTrace();;
        }
        return num;
    }
    public static void create_message(String message){
        String sql="insert into info values(?,?)";
        try{
            PreparedStatement ps = DbUtil.get_con().prepareStatement(sql);
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
    public static List<Message> get_message(){
        List<Message> list = new ArrayList<Message>();
        String sql="select * from info";
        try {
            PreparedStatement ps=DbUtil.get_con().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Message message=new Message();
                message.setMessage(rs.getString("message"));
                message.setMessage(rs.getString("time"));
                list.add(message);
            }
        }catch (SQLException e){
            e.printStackTrace();;
        }
        return list;
    }
    public static void ChangeAdminPass(String admin_name, String new_pass){
        String sql="update t_admin set password=? where username=?";
        try{
            PreparedStatement ps = get_con().prepareStatement(sql);
            ps.setString(1,new_pass);
            ps.setString(2,admin_name);
            ps.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}
