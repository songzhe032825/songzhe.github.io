package com.hspedu.interface_;

//phone 这个类要实现这个接口
//即 phone 类需要实现  UsbInterface接口/声明的方法
public class Phone implements UsbInterface{
    @Override
    public void start() {
        System.out.println("手机开始工作");
    }

    @Override
    public void stop() {
        System.out.println("手机停止工作");
    }
}
