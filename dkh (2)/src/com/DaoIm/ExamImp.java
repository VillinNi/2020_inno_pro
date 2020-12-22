package com.DaoIm;

import com.bean.ExamBean;
import com.bean.TeacherBean;
import com.dao.ExamDao;
import com.myutils.DbUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.myutils.DbUtil;
public class ExamImp implements ExamDao {

    @Override
    public int add(ExamBean exam) {
        String sql = "insert into t_exam(name,starttime,autostart,teacher ,started) " +
                "values(?,?,?,?,false)";
        int result = 0;

        try {
            PreparedStatement ps=DbUtil.get_con().prepareStatement(sql);
            //ps.setString(1,exam.getE_name());

            ps.setString(1, exam.getE_name());
            ps.setString(2, exam.getStarttime());
            ps.setBoolean(3,false);
            ps.setString(4,exam.getE_teacher());
            result = ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int delete(String exam_name) {
        String sql ="delete from t_exam where name=?";
        try{
            new StudentImp().delete_student_by_exam(exam_name); //先把学生清理掉
            PreparedStatement ps=DbUtil.get_con().prepareStatement(sql);
            ps.setString(1,exam_name);
            ps.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int update_exam(ExamBean exam, String exam_name) {
        String sql="update table t_exam set starttime=?, autostart=?,exampaper=?," +
                "started=?,finished=?,archived=?,cleand=?";
        int status=0;
        try{
            PreparedStatement ps=DbUtil.get_con().prepareStatement(sql);
            ps.setBoolean(1,exam.isAuto_start());
            ps.setString(2,exam.getE_exam());
            ps.setBoolean(3,exam.isIs_start());
            ps.setBoolean(4,exam.isFinished());
            ps.setBoolean(5, exam.isArchived());
            ps.setBoolean(6,exam.isCleaned());
            status = ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }

        return status;
    }

    @Override
    public int start_exam(String exam_name) {
        clear_message();
        String sql="update t_exam set started=true where name=?";
        try{
            PreparedStatement ps=DbUtil.get_con().prepareStatement(sql);
            ps.setString(1,exam_name);
            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int clean_exam(String exam_name) {
        String sql="update t_exam set cleaned=true where name=?";
        try{
            PreparedStatement ps=DbUtil.get_con().prepareStatement(sql);
            ps.setString(1,exam_name);
            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int end_exam(String exam_name) {
        String sql="update t_exam set archived=true, started=false where name=?";
        try{
            PreparedStatement ps=DbUtil.get_con().prepareStatement(sql);
            ps.setString(1,exam_name);
            System.out.println(exam_name+"set false!");
            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public void stop_exam(String exam_name) {

    }

    @Override
    public void clear_message() {
        String sql="delete from info";
        try{
            PreparedStatement ps =DbUtil.get_con().prepareStatement(sql);
            ps.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public boolean check_paper(String exam_name) {
        String sql="select exampaper from t_exam where name=?";
        boolean status = false;
        try{
            PreparedStatement ps =DbUtil.get_con().prepareStatement(sql);
            ps.setString(1,exam_name);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                status=rs.getBoolean("exampaper");
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public void set_upload(String exam_name) {
        String sql="update t_exam set exampaper=true where name=?";
        try {
            PreparedStatement ps = DbUtil.get_con().prepareStatement(sql);
            ps.setString(1,exam_name);
            ps.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }


}
