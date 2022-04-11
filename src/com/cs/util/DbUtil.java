package com.cs.util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 工具类
 */

public class DbUtil {
    private String dbUrl = "jdbc:mysql://localhost:3306/db_student";
    private String dbUsrName = "root";
    private String dbPassword = "";
    //private String jdbcName="com.mysql.jdbc.Driver";

    public static void main(String[] args) {
        DbUtil dbUtil = new DbUtil();
        try {
            dbUtil.getCon();
            System.out.println("数据库链接成功");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("数据库链接失败");
        }
    }

    public Connection getCon() throws Exception {
        //Class.forName(jdbcName);
        Connection con = DriverManager.getConnection(dbUrl, dbUsrName, dbPassword);
        return con;
    }//链接数据库

    public void closeCon(Connection con) throws Exception {
        if (con != null) {
            con.close();
        }
    }//关闭数据库
}

