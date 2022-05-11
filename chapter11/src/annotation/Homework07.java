package annotation;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * @author 宋哲
 * @version 1.0
 */
public class Homework07 {
    /*内部类的练习
     * 有一个Car2类 有属性temperature(温度) 车内有Air(空调)类 有吹风的功能
     * flow,Air会监视车内的温度 如果温度超过40则吹冷空气。如果温度低于0度则
     * 吹暖气 如果在这之前则关掉空调 实例化具有不同的温度的Car2对象 调用空调的
     * flow方法 测试空调吹的风是否正确
     * */
    public static void main(String[] args) {
        Car2 car2 = new Car2();
        car2.getAir().flow();
    }
}

class Car2{
    private double temperature;
    //内部类
    class Air{
        public void flow(){
            if (temperature > 40){
                System.out.println("温度超过40则吹冷空气");
            } else if(temperature < 0){
                System.out.println("温度低于0则吹暖空气");
            } else {
                System.out.println("之前则关掉空调");
            }
        }
    }
    //提供一个方法拿到Air对象 以前讲过
    public Air getAir(){
        return new Air();
    }
}

