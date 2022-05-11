package com.hspedu.interface_;

public class Interface01 {
    public static void main(String[] args) {
        //1.USB  既可以接受Camera 又可以接受Phone 体现了接口的多态参数特性
        //Camera 实现了 USB 接口
        Camera camera = new Camera();
        //Phone 实现了 USB 接口
        Phone phone = new Phone();
        Computer computer = new Computer();
        computer.work(phone);//把手机接入到计算机
        computer.work(camera);//把相机接入到计算机
    }
}
