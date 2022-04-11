package com.cs.model;

import com.sun.org.apache.xpath.internal.objects.XString;

/**
 * 用户实体
 */
public class User {
    private int id;
    private String userName;
    private String passWord;

    public User() {
        super();
    }
    public User(String userName, String passWord) {
        super();
        this.userName = userName;
        this.passWord = passWord;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
