package com.bjpowernode.javaweb.javaben;

import java.util.Objects;

/**
 * @author 宋哲
 * @version 1.0
 * javabean的规范是什么？
 * 1.无参构造
 * 2.属性私有化
 * 3.对外提供getter setter
 * 4.重写toString
 * 5.重写hashcode 和 equals
 * 6.实现java.io.Serializable序列化接口
 */
public class User {
    private String name;
    private int id;

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

}
