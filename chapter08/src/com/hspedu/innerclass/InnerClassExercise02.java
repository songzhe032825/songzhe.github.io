package com.hspedu.innerclass;

public class InnerClassExercise02 {
    /*1.有一个铃声接口Bell,里面哟个ring方法
     * 2.有个手机类Cellphone 具有闹钟功能alarmClock,参数是Bell 类型
     * 3.测试手机类的闹钟功能  通过匿名内部类(对象)作为参数 打印 懒猪起床了
     * 4.再传入另一个匿名内部类(对象) 打印：小伙伴上课了
     * */
    public static void main(String[] args) {
        Cellphone cellphone = new Cellphone();
        //1.匿名内部类可以作为实参的写法  传递的是实现了Bell接口的匿名内部类
        //2.重写了ring 然后实参匿名内部类传到了Cellphone类中的形参Bell
        //3.bell接受到了传过来的实参 编译类型是匿名内部类getClass
        //Debug追踪  cellphone.alarmClock 验证效果
        cellphone.alarmClock(new Bell() {
            @Override
            public void ring() {
                System.out.println("懒猪起床l");
            }
        });
        //再调用一次alarmClock方法
        cellphone.alarmClock(new Bell() {
            @Override
            //5.动态绑定机制来到这里输出语句
            public void ring() {
                System.out.println("小伙伴上课了");
            }
        });
    }
}
    //2.有个手机类Cellphone 具有闹钟功能alarmClock,参数是Bell 类型
   class Cellphone{
        //bell形参接受到了匿名内部类的实参  这个方法才是真正要实现的
        public void alarmClock(Bell bell){
            //4.这里已经调用过了ring方法 实现动态绑定会导致重新回到匿名内部类
            //的ring方法 所以打印懒猪起床了
            bell.ring();
        }
    }

    //1.有一个铃声接口Bell,里面哟个ring方法
    interface Bell{
        void ring();
}
