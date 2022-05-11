package com.hspedu.abstract_;

abstract public class Template {
    //重点来了 ：抽象类  模板设计模式

    public abstract void job();//抽象方法

    //写一个计算方法
    public void calculateTimes(){// 实现方法 调用job方法
        //设计模式的好处就是把公用的部分拿出来了 需要的方法写进去也方便添加修改
        //比如job()
        job();//动态绑定
        //得到开始时间
        long start = System.currentTimeMillis();
        //得到结束时间
        long end = System.currentTimeMillis();
        System.out.println("AA执行时间是多久：结束时间-开始时间" + (end - start) );
    }
}
