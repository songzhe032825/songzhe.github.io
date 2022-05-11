package com.hspedu.interface_;

public class Computer {
    //编写一个方法  计算机工作
    //1.UsbInterface usbInterface 形参是接口类型 UsbInterface
    //2.当参数可以接受传递实现的UsbInterface接口类的对象实例
    public void work(UsbInterface usbInterface){//表示手机还是相机都可以通过usbInterface
        //传进来 通过接口的对象调用相机和手机的方法
        usbInterface.start();
        usbInterface.stop();
    }
}
