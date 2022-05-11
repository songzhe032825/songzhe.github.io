package annotation;

/**
 * @author 宋哲
 * @version 1.0
 */
public class Override_ {
    public static void main(String[] args) {

    }
}
//@Override 限定某个方法 是重写父类的方法 该注解只能用于方法
class Father{
    public void fly(){
        System.out.println("Father fly..");
    }
    public void say(){

    }
}

class Son extends Father{
    //1.@Override 注解放在fly方法上 表示子类的fly是重写了父类的fly()
    //2.这里没有写@Override 依旧是重写父类的方法
    //3.如果你写了@Override 注解 编译器接回去检查该方法是否真的重写了父类的
    //方法  如果的确重写了，则编译通过，如果没有构成重写，则编译错误
    //4.看看@Override的定义
    //解读： 如果发现@interface 表示一个注解类
    /*
    *   @Target(ElementType.METHOD)
    *   @Retention(RetentionPolicy.SOURCE)
    *   public @interface Override {}
    * */
    @Override
    public void fly() {
        super.fly();
        System.out.println("Son fly...");
    }
    @Override
    public void say(){

    }
}
