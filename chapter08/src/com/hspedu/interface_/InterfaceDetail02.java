package com.hspedu.interface_;

//接口可以继承其他接口 类可以能实现多个接口
public class InterfaceDetail02 {
    public static void main(String[] args) {
        //老韩证明 接口中的属性是public static final
        System.out.println(IB.n1);//能够用接口名称访问属性就是静态访问属性的根本 说明n1就是static
        //接下来证明n1 是final的
       // IB.n1=30;//n1是final的无法赋值 因此证明n1 是final
    }
}
interface IB{
    //很重要的知识点：只能是final的，并且是public static final 修饰符
    int n1 = 10;//等价public static final int n1 =10;如何证明
    // n1分别被static和final修饰呢?
    void hi();
}
interface IC{
    void say();
}
//接口不能继承其他的“类” ,但是接口可以继承”多个别的接口“！！！！！ 新定义个接口interface ID
interface ID  extends IB,IC{ //不能写implements 实现
}
//一个类同时实现多个接口
//Pig类要同时“实现” 两个接口
class Pig implements IB,IC{

    @Override
    public void hi() {
        System.out.println("hi~");
    }

    @Override
    public void say() {
        System.out.println("say~");
    }
}
