package com.hspedu.qqcommon;

import java.io.Serializable;

/**
 * @author 宋哲
 * @version 1.0
 * 表示用户/客户信息
 */
//通过对象流来读取对象 需要在类上加上序列化
public class User implements Serializable {
    //保证序列化兼容性
    private static final long serialVersionUID = 11;
    private String userId;
    private String passwd;

    public User(){}
    public User(String userId, String passwd) {
        this.userId = userId;
        this.passwd = passwd;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}
