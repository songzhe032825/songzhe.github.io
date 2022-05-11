package annotation;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/**
 * @author 宋哲
 * @version 1.0
 */
public class Homework04 {
        /*1.计算机接口具体work方法 功能是运算 有一个手机类Cellphone 定义方法
        * testWork 测试计算功能  调用计算接口的work方法
        * 2.要求调用CellPhone对象的testWork() 使用上匿名内部类
        * */
        public static void main(String[] args) {
            //要求调用CellPhone对象的testWork() 使用上匿名内部类
            //匿名内部类最最经典的场景就是可以将参数传进去！！！！
            Cellphone cellphone = new Cellphone();
            cellphone.testWork(new ICalculate() {
                @Override
                public double work(double n1, double n2) {
                    return n1 + n2;
                //前面加个逗号 然后传两个实参值 同时还是一个对象
                //iCalculate他的编译类型是 ICalculate 运行类型就是匿名内部类
                }
            },1.2,4.5);
        }
}
interface ICalculate{
    //work方法是完成计算 但是题没有具体要求 所以自己设计
    public double work(double n1,double n2);
}
class  Cellphone {
    //testWork 测试计算功能  调用计算接口的work方法 我打算去调用接受接口
    //核心部分
    //老师解读：将匿名内部类高亮的部分(懂的)传到iCalculate这里,然后调用work方法
    //然后动态绑定的反向回到主方法的匿名内部类在调用work方法
    public void testWork(ICalculate iCalculate, double n1 ,double n2){
        double result = iCalculate.work(n1, n2);
        System.out.println("计算和的结果是 =" + result);
    }
}

