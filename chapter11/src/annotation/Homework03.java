package annotation;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/**
 * @author 宋哲
 * @version 1.0
 */
public class Homework03 {
    /*1.动物类Animal包含了抽象方法
    * 2.Cat类继承了Animal 并实现方法shout 打印“猫会喵喵叫”
    * 3.Dog类继承了Animal 并实现方法shout 打印“狗会汪汪叫”
    * 4.在测试类中实例化对象 Animal cat = new Cat() 并调用cat的shout方法
    * 5.在测试类中实例化对象Animal dog = new Dog() b并调用dog()的shout方法
    * */

    public static void main(String[] args) {
        Animal cat = new Cat();
        cat.shout();
        Animal dog = new Dog();
        dog.shout();
    }
}
abstract class  Animal{
    abstract void shout();
}
//Cat类继承了Animal 并实现方法shout 打印“猫会喵喵叫”
class Cat extends Animal{

    @Override
    void shout() {
        System.out.println("猫会喵喵叫");
    }
}
//Dog类继承了Animal 并实现方法shout 打印“狗会汪汪叫
class Dog extends Animal{

    @Override
    void shout() {
        System.out.println("狗会汪汪叫");
    }
}

