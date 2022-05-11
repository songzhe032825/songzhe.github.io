package com.hspedu.interface_;

/*演示“多态传递”现象
*
*
* */

public class InterfacePolyPass {
    public static void main(String[] args) {
        //接口类型的变量可以实现该接口的类的对象的实例
        IG ig =new Teacher();
        //Teacher 并没有实现 IH接口 所以报错怎么办呢？ 让IG继承IH 接口即可
        //这样Teacher 也继承IH 接口  实现多态传递效果
        IH ih =new Teacher();
    }
}
interface IH{}

interface IG extends IH{}

class Teacher implements IG {}