package com.bean;

import java.sql.Date;

public class ExamBean {
    private String e_name;
    private String e_teacher;
    private String e_exam;
    private String starttime;
    private boolean is_end;
    private boolean is_start;
    private boolean finished;
    private boolean archived;
    private boolean cleaned;
    private boolean auto_start;
    private boolean has_paper;

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }


    public boolean isAuto_start() {
        return auto_start;
    }

    public void setAuto_start(boolean auto_start) {
        this.auto_start = auto_start;
    }

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    public boolean isCleaned() {
        return cleaned;
    }

    public void setCleaned(boolean cleaned) {
        this.cleaned = cleaned;
    }


    public String getE_name() {
        return e_name;
    }

    public void setE_name(String e_name) {
        this.e_name = e_name;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getE_teacher() {
        return e_teacher;
    }

    public void setE_teacher(String e_teacher) {
        this.e_teacher = e_teacher;
    }

    public String getE_exam() {
        return e_exam;
    }

    public void setE_exam(String e_exam) {
        this.e_exam = e_exam;
    }

    public boolean isIs_end() {
        return is_end;
    }

    public void setIs_end(boolean is_end) {
        this.is_end = is_end;
    }

    public boolean isIs_start() {
        return is_start;
    }

    public void setIs_start(boolean is_start) {
        this.is_start = is_start;
    }

}
