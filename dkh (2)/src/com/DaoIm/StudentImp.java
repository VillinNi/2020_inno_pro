package com.DaoIm;

import com.bean.StudentBean;
import com.dao.StudentDao;
import com.myutils.DbUtil;
import org.apache.poi.xslf.model.geom.SqrtExpression;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StudentImp implements StudentDao {
    @Override
    public Boolean login(String stu_no) {
        String sql="update t_student set logged=true where number=?";
        try{

            PreparedStatement ps = DbUtil.get_con().prepareStatement(sql);
            ps.setString(1,stu_no);
            ps.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public int delete(String stu_no) {
        String sql="delete from t_student where number=?";
        int rs=0;
        try{
            PreparedStatement ps = DbUtil.get_con().prepareStatement(sql);
            ps.setString(1, stu_no);
            rs = ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return rs;
    }





    @Override
    public int update_student_info(StudentBean student, String student_id) {
        String sql ="alter table set number=?,username=?";
        try{
            PreparedStatement ps=DbUtil.get_con().prepareStatement(sql);
            ps.setString(1,student.getStu_name());
            ps.setString(2,student.getStu_name());
            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override  //第一个传的是学号 懒得改名了
    public boolean bind_ip(String student_name, String ip){
        String sql="update t_student set ip=? where number=?";
        try{
            PreparedStatement ps=DbUtil.get_con().prepareStatement(sql);
            ps.setString(1, ip);
            ps.setString(2,student_name);
            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean record_submit_time(String student_name, String sub_time) {
        String sql="update t_student set submittime=? where ip=?";
        try{
            PreparedStatement ps=DbUtil.get_con().prepareStatement(sql);
            ps.setString(1, sub_time);
            ps.setString(2,student_name);
            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public void delete_student_by_exam(String exam_name) {
        String sql="delete from t_student where class=?";
        try{
            PreparedStatement ps=DbUtil.get_con().prepareStatement(sql);
            ps.setString(1, exam_name);
            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public int get_student_num(String exam_name) {
        int num=0;
        String sql="select count(*) from t_student where class=?";
        try{
            PreparedStatement ps = DbUtil.get_con().prepareStatement(sql);
            ps.setString(1, exam_name);
            ResultSet rs =ps.executeQuery();
            if(rs.next())
                num=rs.getInt(1);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return num;
    }

    @Override
    public int get_logged_num(String exam_name) {
        List<StudentBean> list =StudentDao.get_all_student_by_class(exam_name);
        int cnt=0;
        for(StudentBean stu:list){
            if(stu.getLogged()){
                cnt++;
            }
        }
        return cnt;
    }

    @Override
    public int get_submitted_num(String exam_name) {
        List<StudentBean> list =StudentDao.get_all_student_by_class(exam_name);
        int cnt=0;
        for(StudentBean stu:list){
            if(stu.getSub_time()!=null){
                cnt++;
            }
        }
        return cnt;

    }

    @Override
    public void set_submitted(String student_id) {
        String sql="update t_student set submittime=? where number=?";
        try {
            SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String t =time.format(new Date().getTime());
            PreparedStatement ps = DbUtil.get_con().prepareStatement(sql);
            System.out.println("time = "+t+" id is "+student_id);
            ps.setString(1,t);
            ps.setString(2,student_id);
            ps.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public boolean get_submit_status(String student_id) {
        String sql="select submittime from t_student where number=?";
        boolean status=false;
        try{
            PreparedStatement ps = DbUtil.get_con().prepareStatement(sql);
            ps.setString(1,student_id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                if(rs.getString("submittime")==null)
                {

                }else
                {
                    status=true;
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return status;
    }
}
