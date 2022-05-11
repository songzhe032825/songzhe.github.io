package com.hspedu.singleton;

public class SingleTon01 {
    public static void main(String[] args) {
        //单例模式： 目的就是不创建对象就可以调用方法 getInstance()
        //所以用方法获取对象
        GirlFriend instance = GirlFriend.getInstance();
        System.out.println(instance);
    }
}
//饿汉式的单例模式

class GirlFriend {
    private String name;
    //为了能够在静态方法中  返回gf对象  需要将其修饰为static

    //2.在类的内部直接创建对象(该对象是static)
    private static GirlFriend gf = new GirlFriend("小灰灰");
    //如何保证我们只能创建一个GirlFriend 对象
    //步骤[单例模式-饿汉式]
    /*1.将构造器私有化
    * 2.在类的内部直接创建对象(该对象是static)
    * 3.提供一个公共的static方法  返回gf对象
    * 4.饿汉式如果造成创建对象不使用 造成资源浪费
    * */

    private GirlFriend(String name){
        //System.out.println("构造器被调用");
        this.name = name;
    }


    //提供一个公共的静态方法  不能是私有访问类型
    //返回对象GirlFriend
    public static GirlFriend getInstance(){
        return gf;//返回对象名
    }
//必须重写 否则无法输出：小灰灰
    @Override
    public String toString() {
        return "GirlFriend{" +
                "name='" + name + '\'' +
                '}';
    }
}
