package com.hspedu.abstract_;

public class AA extends Template{
    @Override
    //去实现父类的抽象方法 父类没完成的理想儿子实现的意思
    //1+.....+10000
    public void job(){
        //快捷键:10000.for
      /*  得到开始时间
        long start = System.currentTimeMillis();
        //在此之前要得到开始时间*/
        int num = 0;
        for (int i = 0; i < 10000; i++) {
            num += i;
        }
     /*   得到结束时间
        long end = System.currentTimeMillis();
        System.out.println("执行时间是多久：结束时间-开始时间" + (end - start) );*/
    }
    //弊端代码复用性及不好  需要改进 怎么改进呢？？ 引出模板模式
}
