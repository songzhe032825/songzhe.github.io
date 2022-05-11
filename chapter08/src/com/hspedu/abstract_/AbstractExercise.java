package com.hspedu.abstract_;

public class AbstractExercise {
    public static void main(String[] args) {
        /*编写一个Employee 类 声明为抽象类  包含如下三个属性 name id salary
        提供必要的构造器和抽象方法:work() 对于manager类来说  它既是员工
        还具有奖金bonus的属性 请使用继承的思想 设计CommonEmployee类和Manager
        要求类中提供必要的方法进行属性访问  实现work() 提示“经理/普通员工  名字
        工作中....
        * */
        Manager manager = new Manager("JACK",999,50000);
        manager.setBonus(2444);
        manager.work();

        CommonEmployee mary = new CommonEmployee("Mary", 888, 333333);
        mary.work();
    }
}
