package com.hsp.edu.enum_;

/**
 * @author 宋哲
 * @version 1.0
 */
public class Enumeration03 {
    public static void main(String[] args) {
        System.out.println(Season.SPRING);
        System.out.println(Season.SUMMER);
        System.out.println(Season.AUTUMN);
        System.out.println(Season.WINTER);
    }
}

//演示使用enum关键字类实现枚举类
enum Season2{ //类
    //[作用域：在Season内部] 直接创建固定的对象  SPRING 枚举对象名必须大写
    //定义了四个常量池 固定的对象 可以优化底层代码 加final修饰符
  /*  public final static Season SPRING = new Season2("春天","温暖");
    public final static Season SUMMER = new Season2("夏天","炎热");
    public final static Season AUTUMN = new Season2("秋天","凉爽");
    public final static Season WINTER = new Season2("夏天","寒冷");*/
   //重点来了 ：如果使用了enum 来实现枚举类
    //1.使用了关键字enum 代替 class
    //2.public final static Season SPRING = new Season2("春天","温暖");
    //直接替换成 SPRING("春天","温暖"); 常量名 +（“构造器的实参列表”）
    //3.如果有多个常量(对象) 使用 ”，“ 号间隔即可
    //4.如果使用enum来实现枚举 常量参数列表写在最前面
    //如果我们使用无参构造器,创建常量对象 可以使用What() 则可以省略
    SPRING("春天","温暖"),WINTER("冬天","寒冷"),
    AUTUMN("秋天","寒冷"),SUMMER("夏天","炎热"),What();
    //这里放入Season2的私有属性
    private String name;
    private String desc;

    //1. 将构造器私有化 目的防止直接被new
    //2. 去掉所以set方法 只能读 不能修改  目的防止属性被修改
    //3. 在Season内部 直接创建固定的对象
    private Season2(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    //set方法必须全部删掉
    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return "Season{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
    //加个What()就调用无参构造器
    private Season2() {//无参构造器
    }
}
