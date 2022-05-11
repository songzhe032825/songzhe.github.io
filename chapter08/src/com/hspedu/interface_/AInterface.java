package com.hspedu.interface_;

public interface AInterface {
    //写属性
    public int n1 = 10;
    //写方法  在接口中抽象abstract 关键字可以省略
    public void hi();

    //在jdk 8.0后可以用静态方法
    public static void cry(){
        System.out.println("哭了");
    }
}
