package com.hspedu.dao._domain;

import java.util.Date;

/**
 * @author 宋哲
 * @version 1.0
 * Actor对象和hsp_actor表的记录一一对应
 */
@SuppressWarnings({"all"})
public class Actor {
    private Integer id;
    private String name;
    private String sex;
    private Date bordate;
    private String phone;

    public Actor() {
    }

    public Actor(Integer id, String name, String sex, Date bordate, String phone) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.bordate = bordate;
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBordate() {
        return bordate;
    }

    public void setBordate(Date bordate) {
        this.bordate = bordate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "\nActor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", bordate=" + bordate +
                ", phone='" + phone + '\'' +
                '}';
    }
}
