package com.hspedu.interface_;

public class ExtendVsInterface {
    public static void main(String[] args) {
        LittleMonkey littleMonkey = new LittleMonkey("弼马温");
        //只要是单继承就知道可以继承使用climbing()
        littleMonkey.climbing();
        littleMonkey.swimming();
        littleMonkey.flying();
    }
}

//接口
interface Fish{
    void swimming();
}
interface Bird{
    void flying();
}

//猴子
class Monkey{
    private String name;

    public Monkey(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void climbing(){
        System.out.println("猴子会爬树");

        //私有的名字 提供get方法方便获取

    }
}
//总结：当子类继承父类的时候  就自动拥有了父类的功能
//     如果子类需要扩展功能  可以通过接口来去实现扩展
class LittleMonkey extends Monkey implements Fish,Bird{
    public LittleMonkey(String name) {
        super(name);
    }

    @Override
    public void swimming() {
        //补充机制
        System.out.println("弼马温通过学习实现鱼儿游泳的能力" +getName());
    }

    @Override
    public void flying() {
        System.out.println("弼马温通过学习实现鸟儿飞翔的能力" + getName());
    }
}