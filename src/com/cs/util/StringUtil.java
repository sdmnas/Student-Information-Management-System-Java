package com.cs.util;

/**
 * 字符串工具类
 */
public class StringUtil {
    public static boolean isEmpty(String str) {
        if (str == null || "".equals(str.trim())) {
            return true;
        } else {
            return false;
        }
    }//判断是否为空


    public static boolean isNotEmpty(String str) {
        if (str != null && "".equals(str.trim())) {
            return false;
        } else {
            return true;
        }
    }//判断是否不为空
}

