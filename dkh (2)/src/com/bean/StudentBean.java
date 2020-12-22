package com.bean;

import java.sql.Statement;

public class StudentBean {
    private String stu_id;
    private String stu_name;
    private String stu_class;
    private String stu_ans;
    private String stu_ip;
    private String stu_exam;
    private String sub_time;
    private boolean logged;
    public boolean getLogged() {
        return logged;
    }

    public void setLogged(Boolean logged) {
        this.logged = logged;
    }


    public String getSub_time() {
        return sub_time;
    }

    public void setSub_time(String sub_time) {
        this.sub_time = sub_time;
    }



    public StudentBean(){};

    public StudentBean(String stu_id,String stu_name,String stu_class,String stu_ans,String stu_exam,String stu_ip){
        this.stu_id = stu_id;
        this.stu_name = stu_name;
        this.stu_class = stu_class;
        this.stu_ans = stu_ans;
        this.stu_exam = stu_exam;
        this.stu_ip=stu_ip;
    }

    public String getStu_id() {
        return stu_id;
    }

    public void setStu_id(String stu_id) {
        this.stu_id = stu_id;
    }

    public String getStu_name() {
        return stu_name;
    }

    public void setStu_name(String stu_name) {
        this.stu_name = stu_name;
    }

    public String getStu_class() {
        return stu_class;
    }

    public void setStu_class(String stu_class) {
        this.stu_class = stu_class;
    }

    public String getStu_ans() {
        return stu_ans;
    }

    public void setStu_ans(String stu_ans) {
        this.stu_ans = stu_ans;
    }

    public String getStu_ip() {
        return stu_ip;
    }

    public void setStu_ip(String stu_ip) {
        this.stu_ip = stu_ip;
    }

    public String getStu_exam() {
        return stu_exam;
    }

    public void setStu_exam(String stu_exam) {
        this.stu_exam = stu_exam;
    }
}
