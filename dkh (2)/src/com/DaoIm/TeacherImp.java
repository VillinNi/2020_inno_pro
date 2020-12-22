package com.DaoIm;


import com.bean.TeacherBean;
import com.dao.TeacherDao;
import com.myutils.DbUtil;
import com.myutils.MdPasswd;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeacherImp implements TeacherDao {
    @Override
    public Boolean login(String username, String password) {

        return true;
    }

    @Override
    public Boolean add_single_teacher(TeacherBean teacher) {
        String sql="insert in to t_teacher(username, password, fullname) values(? ? ?);";
        Boolean stat=new Boolean(false);
        try{
            PreparedStatement ps= DbUtil.get_con().prepareStatement(sql);
            ps.setString(1, teacher.getUsername());
            ps.setString(2, teacher.getT_pwd());
            ps.setString(3, teacher.getT_name());
            stat=ps.execute();

        }catch (SQLException e){
            e.printStackTrace();
        }

        return stat;
    }

    @Override
    public Boolean delete_teacher(String username) {
        Boolean stat=new Boolean(false);
        String sql="delete  from t_teacher where username=?;";
        try{
            PreparedStatement ps = DbUtil.get_con().prepareStatement(sql);
            ps.setString(1,username);
            stat=ps.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }

        return stat;
    }

    @Override
    public Boolean update_teacher_info(TeacherBean teacher) {
        Boolean stat=new Boolean(false);
        try{
            String sql="update t_teacher set password=? fullname=? where username=?;";
            PreparedStatement ps = DbUtil.get_con().prepareStatement(sql);
            ps.setString(1,teacher.getT_pwd());
            ps.setString(2,teacher.getT_name());
            ps.setString(3,teacher.getUsername());
            stat = ps.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return stat;
    }

    @Override
    public List<TeacherBean> get_all_teacher() {
        List<TeacherBean> list=new ArrayList<TeacherBean>();
        String sql="select * from t_teacher;";


        try{
            PreparedStatement ps = DbUtil.get_con().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                TeacherBean teacherBean=new TeacherBean();
                teacherBean.setT_name(rs.getString("fullname"));
                //teacherBean.setT_pwd(rs.getString(3));
                teacherBean.setUsername(rs.getString("username"));
                System.out.println(rs.getString("username"));
                list.add(teacherBean);

            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void update_teacher_password(String teacher_name, String password) {
        String sql="update t_teacher set password = ? where teacher_name=?";
        try{
            PreparedStatement ps = DbUtil.get_con().prepareStatement(sql);
            ps.setString(1,MdPasswd.encry_passwd(password));
            ps.setString(2, teacher_name);
            ps.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void update_teacher_fullname(String teacher_name, String fulname) {
        String sql="update t_teacher set fullname = ? where username=?";
        try{
            PreparedStatement ps = DbUtil.get_con().prepareStatement(sql);
            ps.setString(1,fulname);
            ps.setString(2, teacher_name);
            ps.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
