package com.hsp.edu.enum_;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/**
 * @author 宋哲
 * @version 1.0
 */
public class EnumMethod {
    public static void main(String[] args) {
        //使用Season2 枚举类 来演示各种方法
        Season2 autumn = Season2.AUTUMN;
        //1.name(): 输出枚举对象的名字 AUTUMN
        System.out.println(autumn.name());
        //2.ordinal(): 输出的是该枚举对象的次序/编号 从0开始编号 因为AUTUMN在第三个
        //所以输出的标号是2
        System.out.println(autumn.ordinal());//2
        //3.values() :从反编译javap可以看到 values方法，返回的是一个数组Season2[]
        // 而且values()被隐藏起来了
        //含有定义的所有的枚举对象
        Season2[] values = Season2.values();
        for (Season2 season: values) { //表示增强for循环 表示values数组
            // 每次取一个值给Season2传进去
            System.out.println(season);//然后根据toString方法输出
        }
        int[] num = {1,2,66};
        //传统普通for循环
        for (int i = 0; i < num.length ; i++) {
            System.out.println("======普通for循环==========");
        }
        System.out.println("=========增强for循环=========");
        //foreach 增强for循环
        for (int i : num) {
            //表示num数组每次取值交给i传值 直到退出for
            System.out.println("i=" + i);
        }
        //4.valueOf:将字符串转换成枚举对象 要求字符串必须VT为已有的常量名 否则报错
        //执行流程 ：1.根据你输入的"AUTUMN" 到 Season2的枚举对象去查找
        //2.如果找到就返回 如果没有找到就报错
        //autumn 和 season2 就是同一对象
        Season2 season2 = Season2.valueOf("AUTUMN");
        System.out.println("season2 =" + season2);
        System.out.println(autumn == season2); //true

        //5.compare to: 比较两个枚举常量 比较的是编号
        //解析： AUTUMN这个枚举对象编号 与 SUMMER的编号进行比较
        //Season2.AUTUMN的编号[2] - Season2.SUMMER的编号[3] = -1
        System.out.println(Season2.AUTUMN.compareTo(Season2.SUMMER));//-1
    }
}
