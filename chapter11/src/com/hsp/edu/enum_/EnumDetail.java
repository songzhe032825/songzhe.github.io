package com.hsp.edu.enum_;

/**
 * @author 宋哲
 * @version 1.0
 */
public class EnumDetail {
    /*1.使用enum关键字后 就不能再继承其他类了，因为enum会隐式继承Enum
    * 而Java是单继承机制
    * 2.枚举类和普通类一样 可以实现接口 如下形式：
    * enum 类名 implements 接口1,接口2{}
    * */
    public static void main(String[] args) {
        //去调用Son类实现的接口方法
        Son.CLASSICMUISC.playing();
    }
}
//1.使用enum关键字后 就不能再继承其他类了，因为enum会隐式继承Enum
//而Java是单继承机制
/*
enum Son extends A{

}*/
//2.enum实现的枚举类 仍然是一个类 所以既然是类那就能够实现接口
interface IPlaying{
    void playing();
}
enum Son implements IPlaying{
    CLASSICMUISC;
    @Override
    public void playing() {
        System.out.println("好听的音乐");
    }
}
