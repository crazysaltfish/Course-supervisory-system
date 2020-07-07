package com.system.po;

public class Coursedetails {
    private Integer courseid;

    private String teacher;

    private String stepid;

    private String file1;

    private String file2;

    private String file3;

    private String mark;

    public Integer getCourseid() {
        return courseid;
    }

    public void setCourseid(Integer courseid) {
        this.courseid = courseid;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher == null ? null : teacher.trim();
    }

    public String getStepid() {
        return stepid;
    }

    public void setStepid(String stepid) {
        this.stepid = stepid == null ? null : stepid.trim();
    }

    public String getFile1() {
        return file1;
    }

    public void setFile1(String file1) {
        this.file1 = file1 == null ? null : file1.trim();
    }

    public String getFile2() {
        return file2;
    }

    public void setFile2(String file2) {
        this.file2 = file2 == null ? null : file2.trim();
    }

    public String getFile3() {
        return file3;
    }

    public void setFile3(String file3) {
        this.file3 = file3 == null ? null : file3.trim();
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark == null ? null : mark.trim();
    }
}