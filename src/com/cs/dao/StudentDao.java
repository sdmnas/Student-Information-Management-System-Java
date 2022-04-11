package com.cs.dao;

import com.cs.model.Student;
import com.cs.util.StringUtil;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentDao {
    public int add(Connection con, Student stu)throws Exception{
        String sql="insert into t_student values(null,?,?,?,?,?)";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setString(1,stu.getStudentName());
        pstmt.setString(2,stu.getYears());
        pstmt.setString(3,stu.getSex());
        pstmt.setDouble(4,stu.getHeight());
        pstmt.setString(5,stu.getPs());
        return pstmt.executeUpdate();
    }

    public ResultSet list(Connection con,Student stu)throws Exception{
        StringBuffer sb = new StringBuffer("select * from t_student b");
        if(StringUtil.isNotEmpty(stu.getStudentName())){
            sb.append(" where b.name like '%").append(stu.getStudentName()).append("%'");
        }
        if(StringUtil.isNotEmpty(stu.getYears())){
            sb.append(" and b.year like '%").append(stu.getYears()).append("%'");
        }
        PreparedStatement pstmt=con.prepareStatement(sb.toString());
        return pstmt.executeQuery();
    }   //学生信息查询

    public static int delete(Connection con, String id)throws Exception{
        String sql="delete from t_student where id=?";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setString(1,id);
        return pstmt.executeUpdate();
    }  //学生信息删除

    public static int update(Connection con, Student stu)throws Exception{
        String sql="update t_student set name=?,year=?,sex=?,height=?,ps=? where id=?";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setString(1,stu.getStudentName());
        pstmt.setString(2,stu.getYears());
        pstmt.setString(3,stu.getSex());
        pstmt.setDouble(4,stu.getHeight());
        pstmt.setString(5, stu.getPs());
        pstmt.setInt(6,stu.getId());
        return pstmt.executeUpdate();
    }  //学生信息修改
}
