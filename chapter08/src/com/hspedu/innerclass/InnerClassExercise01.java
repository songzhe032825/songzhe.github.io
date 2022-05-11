package com.hspedu.innerclass;

public class InnerClassExercise01 {
    public static void main(String[] args) {
        //当做实参直接传递 简洁高效  匿名内部类 从（new IL(){...}）匿名内部类做为实参结束
        f1(new IL() {
            @Override
            public void show() {
                System.out.println("这是一幅匿名内部类实参写法");
            }
        });

    }

    //静态方法 形参是接口类型IL
    public static void f1(IL il){
        //这个show()怎么去写完全用程序员来判断
        il.show();
    }
}
//应用场景  把匿名内部类当作实参直接传递

//接口
interface IL{
    void show();
}



