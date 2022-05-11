package com.hspedu.OOP_.Homework05;

public class Test {
    public static void main(String[] args) {
        Worker worker = new Worker("云缨",3198,31,12);
        //灵活修改带薪日期 活灵活用
        worker.setDay(12);
        worker.printSal();
        Peasant peasant = new Peasant("高渐离",32323233,21,3);
        peasant.setDay(13);
        peasant.printSal();
        Scientist scientist = new Scientist("诸葛亮",54545,44,5);
        scientist.printSal();
        Teacher teacher = new Teacher("嫦娥",9999,323,4);
        teacher.printSal();
        Waiter waiter = new Waiter("蒙恬",77777,22,5);
        waiter.printSal();
    }
}
