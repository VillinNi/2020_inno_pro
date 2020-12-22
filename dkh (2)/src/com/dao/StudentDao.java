package com.dao;

import com.bean.ExamBean;
import com.bean.StudentBean;
import com.myutils.DbUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface StudentDao {
    public Boolean login(String stu_no);
    static public int add_single_student(StudentBean student) {
        String sql="insert into t_student(number,username,class) values(?,?,?)";
        int rs=0;
        try {
            PreparedStatement ps = DbUtil.get_con().prepareStatement(sql);

            ps.setString(2, student.getStu_name());
            ps.setString(1, student.getStu_id());
            ps.setString(3, student.getStu_class());
            rs = ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return rs;
    }
    public int delete(String stu_no);
    static public StudentBean get_student_by_sno(String sno) {
        StudentBean stu = new StudentBean();
        String sql = "select * from t_student where number =?";
        try{
            PreparedStatement ps= DbUtil.get_con().prepareStatement(sql);
            ps.setString(1,sno);
            ResultSet rs = ps.executeQuery();
            if(rs.next())
            {
                stu.setStu_id(rs.getString("number"));
                stu.setStu_class(rs.getString("class"));
                stu.setStu_ip(rs.getString("ip"));
                stu.setLogged(rs.getBoolean("logged"));
                stu.setStu_name(rs.getString("username"));
                stu.setSub_time(rs.getString("submittime"));
            }


        }catch (SQLException e){
            e.printStackTrace();
        }
        return stu;
    }
    static public List<StudentBean> get_all_student_by_class(String cla) {
        List<StudentBean> list = new ArrayList<StudentBean>();
        String sql="select * from t_student where class=?";
        try
        {
            PreparedStatement ps=DbUtil.get_con().prepareStatement(sql);
            ps.setString(1, cla);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                StudentBean studentBean=new StudentBean();
                studentBean.setStu_id(rs.getString("number"));
                studentBean.setStu_name(rs.getString("username"));
                studentBean.setStu_class(rs.getString("class"));
                studentBean.setStu_ip(rs.getString("ip"));
                studentBean.setSub_time(rs.getString("submittime"));
                studentBean.setLogged(rs.getBoolean("logged"));
                list.add(studentBean);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }

    public int update_student_info(StudentBean student, String student_id);//通过id传参
    public boolean bind_ip(String student_name, String ip);
    public boolean record_submit_time(String student_name, String sub_time);
    public void delete_student_by_exam(String exam_name);
    public int get_student_num(String exam_name);
    public int get_logged_num(String exam_name);
    public int get_submitted_num(String exam_name);
    public void set_submitted(String student_id);
    public boolean get_submit_status(String student_id);
    
}
