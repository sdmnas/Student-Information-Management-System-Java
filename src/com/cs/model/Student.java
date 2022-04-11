package com.cs.model;

public class Student {

    private int id;  //学生编号
    private String studentName;  //学生姓名
    private String years;  //学生年龄
    private String sex;    //学生性别
    private Double height; //学生身高
    private String ps;     //备注信息

    public Student() {
        super();
    }

    public Student(String studentName, String years, String sex, Double height, String ps) {
        super();
        this.studentName = studentName;
        this.years = years;
        this.sex = sex;
        this.height = height;
        this.ps = ps;
    }

    public Student(int id, String studentName, String years, String sex, Double height, String ps) {
        this.id = id;
        this.studentName = studentName;
        this.years = years;
        this.sex = sex;
        this.height = height;
        this.ps = ps;
    }

    public Student(String studentName, String years) {
        super();
        this.studentName = studentName;
        this.years = years;
    }

    public String getPs() {
        return ps;
    }

    public void setPs(String ps) {
        this.ps = ps;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getYears() {
        return years;
    }

    public void setYears(String years) {
        this.years = years;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }
}

