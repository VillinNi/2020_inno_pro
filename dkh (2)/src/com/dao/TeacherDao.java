package com.dao;

import com.bean.TeacherBean;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.List;

public interface TeacherDao {
    public Boolean login(String username, String password);
    public Boolean add_single_teacher(TeacherBean teacher);
    public Boolean delete_teacher(String username);
    public Boolean update_teacher_info(TeacherBean teacher);
    public List<TeacherBean> get_all_teacher();
    public void update_teacher_password(String teacher_name, String new_password);
    public void update_teacher_fullname(String teacher_name, String fulname);

}
