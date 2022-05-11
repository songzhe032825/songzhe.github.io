package com.hspedu.satitic;

public class StaticMethod {
    //共享不清楚 类似于生活中的公交车
    public static void main(String[] args) {
        //创建两个学生对象 交学费
        Stu tom = new Stu("Tom");
        //对象调用静态方法
        tom.payFee(100);
        //Stu.payFee(); 效果一样

        Stu nike = new Stu("Nike");
        //对象调用静态方法 两者调用的都是同一个静态变量 fee
        nike.payFee(200);

        //输出当前的总学费
        Stu.showFee();//300
    }
}

class Stu{
    private String name; //普通成员
    // 定义一个静态变量  来累积学生的学费
    private static double fee = 0;

    public Stu(String name) {
        this.name = name;
    }
    //说明：1.当该方法使用了static修饰后 变成了静态方法
    //2.静态方法可以访问静态属性(变量)
    public static void payFee(double fee){
        //如何访问类变量fee ?  通过类名Stu访问
        //代码解析：右边的fee 是传进来的形参double fee  左边的是类变量中的变量
        Stu.fee = fee;
    }

    public static void showFee(){
        System.out.println("总学费有：" +Stu.fee);
    }
}
