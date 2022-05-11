package annotation;

/**
 * @author 宋哲
 * @version 1.0
 */
public class Deprecated {
    public static void main(String[] args) {
        A a = new A();
        //中划线表示已经过时了
        a.hi();
        //System.out.println(a.hi(););
    }
}
//1.@Deprecated修饰某个元素 表示A类已经过时了
//2.即不在推荐使用  但是仍然可以使用
//3.查看@Deprecated注解类的源码
//4.可以修饰方法 类 字段 包 参数 等
//5.@Deprecated 可以做版本升级过度使用
@java.lang.Deprecated
class A{
    public int n1 =10;
    @java.lang.Deprecated
    public void hi(){
    }
}