package com.dao;

import com.bean.ExamBean;
import com.myutils.DbUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface ExamDao {
    public int add(ExamBean exam);
    /**
     * 添加考试
     * para 考试实例
     *return 待定
     */

    public int delete(String exam_name);

    /**
     * 删除考试
     * 参数为主键
     */
    static public ExamBean search(String exam_name){
        ExamBean exam=new ExamBean();
        String sql="select * from t_exam where name=?";
        try {
            PreparedStatement ps= DbUtil.get_con().prepareStatement(sql);
            ps.setString(1,exam_name);
            ResultSet rs=ps.executeQuery();
            if(!rs.next())
                return null;
            exam.setE_name(rs.getString("name"));
            exam.setStarttime(rs.getString("starttime"));
            exam.setAuto_start(rs.getBoolean("autostart"));
            exam.setStarttime(rs.getString("finished"));
            exam.setArchived(rs.getBoolean("archived"));
            exam.setCleaned(rs.getBoolean("cleaned"));
            exam.setE_teacher(rs.getString("teacher"));
        }catch (SQLException e){
            e.printStackTrace();
        }
        return exam;
    };
    /**
    * 获取考试实例
     */

    public int update_exam(ExamBean exam, String exam_name);
    public int start_exam(String exam_name);
    public int clean_exam(String exam_name);
    public int end_exam(String exam_name);
    public void stop_exam(String exam_name);
    public void clear_message();
    public boolean check_paper(String exam_name);
    public void set_upload(String exam_name);
    //public List<ExamBean> get_exam_by_teacher(String teacher_name);
    static public String check_exam_exist(){
        Boolean status=false;
        List<ExamBean> list=get_all_exam();
        String exam_name=null;
        for(ExamBean exam:list){
            if(exam.isIs_start()&&!exam.isArchived()){
                exam_name=exam.getE_name();
                break;
            }
        }
        return exam_name;
    }
    static public List<ExamBean> get_all_exam(){
        List<ExamBean> list = new ArrayList<ExamBean>();
        String sql="select * from t_exam ";
        try{
            PreparedStatement ps=DbUtil.get_con().prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                ExamBean examBean=new ExamBean();
                examBean.setE_name(rs.getString("name"));
                examBean.setStarttime(rs.getString("starttime"));
                examBean.setAuto_start(rs.getBoolean("autostart"));
                examBean.setIs_start(rs.getBoolean("started"));
                examBean.setFinished(rs.getBoolean("finished"));
                examBean.setArchived(rs.getBoolean("archived"));
                examBean.setCleaned(rs.getBoolean("cleaned"));
                examBean.setE_teacher(rs.getString("teacher"));
                list.add(examBean);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }


        return list;
    }

    static  public List<ExamBean> get_exam_by_teacher(String teacher_name){
        List<ExamBean> list = new ArrayList<ExamBean>();
        String sql = "select * from t_exam where teacher =? and started=false and archived=false and cleaned=false";
        try{
            PreparedStatement ps=DbUtil.get_con().prepareStatement(sql);
            ps.setString(1, teacher_name);
            ResultSet rs=ps.executeQuery();

            while(rs.next()){
                ExamBean examBean=new ExamBean();
                examBean.setE_name(rs.getString("name"));
                examBean.setStarttime(rs.getString("starttime"));
                examBean.setAuto_start(rs.getBoolean("autostart"));
                examBean.setIs_start(rs.getBoolean("started"));
                examBean.setFinished(rs.getBoolean("finished"));
                examBean.setArchived(rs.getBoolean("archived"));
                examBean.setCleaned(rs.getBoolean("cleaned"));
                examBean.setE_teacher(rs.getString("teacher"));
                list.add(examBean);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }

    static public List<ExamBean> get_end_exam(String teacher_name){
        List<ExamBean> list = new ArrayList<ExamBean>();
        String sql = "select * from t_exam where teacher =? and archived=true and cleaned=false";
        try{
            PreparedStatement ps=DbUtil.get_con().prepareStatement(sql);
            ps.setString(1, teacher_name);
            ResultSet rs=ps.executeQuery();

            while(rs.next()){
                ExamBean examBean=new ExamBean();
                examBean.setE_name(rs.getString("name"));
                examBean.setStarttime(rs.getString("starttime"));
                examBean.setAuto_start(rs.getBoolean("autostart"));
                examBean.setIs_start(rs.getBoolean("started"));
                examBean.setFinished(rs.getBoolean("finished"));
                examBean.setArchived(rs.getBoolean("archived"));
                examBean.setCleaned(rs.getBoolean("cleaned"));
                examBean.setE_teacher(rs.getString("teacher"));
                list.add(examBean);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }

    static public List<ExamBean> get_started_exam(String teacher_name){
        List<ExamBean> list = new ArrayList<ExamBean>();
        String sql = "select * from t_exam where teacher =? and started=true";
        try{
            PreparedStatement ps=DbUtil.get_con().prepareStatement(sql);
            ps.setString(1, teacher_name);
            ResultSet rs=ps.executeQuery();

            while(rs.next()){
                ExamBean examBean=new ExamBean();
                examBean.setE_name(rs.getString("name"));
                examBean.setStarttime(rs.getString("starttime"));
                examBean.setAuto_start(rs.getBoolean("autostart"));
                examBean.setIs_start(rs.getBoolean("started"));
                examBean.setFinished(rs.getBoolean("finished"));
                examBean.setArchived(rs.getBoolean("archived"));
                examBean.setCleaned(rs.getBoolean("cleaned"));
                examBean.setE_teacher(rs.getString("teacher"));
                list.add(examBean);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }

}
