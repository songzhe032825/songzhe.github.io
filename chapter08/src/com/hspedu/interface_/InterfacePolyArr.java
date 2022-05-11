package com.hspedu.interface_;

public class InterfacePolyArr {
    public static void main(String[] args) {

        // 多态数组 》接口类型数组
        Usb[] usbs = new Usb[2];
        //可以存放Usb 接口类的实例
        //这里体现了多态的数组 为什么体现？
        //因为多态数组既可以放Phone_()  也可以放Camera_()
        //并且Phone_()  Camera_()都实现了USB 接口
        usbs[0] =new Phone_();
        usbs[1] = new Camera_();

        //遍历  并且遍历的是什么 是数组usbs
        for (int i = 0; i < usbs.length; i++) {
            //调用方法 遍历usbs 数组
            usbs[i].work();//动态绑定
            //想要调用call方法怎么办呢？ 就用到遍历类型判断 向下转型
            //判断他的 运行类型是Phone_
            if(usbs[i] instanceof Phone_ ){
                //((Phone_) usbs[i]) 向下转型  调用call()
                ((Phone_) usbs[i]).call();
            }
        }
    }
}

interface Usb{
    void work();
}
class Phone_ implements Usb{
    public void call(){
        System.out.println("手机可以打电话");
    }

    @Override
    public void work() {
        System.out.println("手机工作中");
    }
}
class Camera_ implements Usb{
    @Override
    public void work() {
        System.out.println("相机工作中");
    }
}
