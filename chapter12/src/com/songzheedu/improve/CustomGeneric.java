package com.songzheedu.improve;

/**
 * @author 宋哲
 * @version 1.0
 */
public class CustomGeneric {
    public static void main(String[] args) {

    }
}

//老汉解读  自定义泛型
/*1.Tiger后面有泛型  我们把Tiger就成为自定义泛型类
*2.T R M 自定义泛型标识符 一般大写字母 标识符可以有多个
*3.普通成员可以有泛型
* 4.泛型数组无法初始化  但是定义可以 很重要的知识点
* 5.静态方法中不能使用类的泛型
* */
class Tiger<T,R,M>{
    String name;
    //小写 r m t 是属性 大写 R M T是泛型
    T t;
    R r;
    M m;
    T[] ts;
    //不允许数组初始化  因为T类型无法确定 内存大小空间不确定
     //T[] ts = new T[8];
    public Tiger(String name, T t, R r, M m) {
        this.name = name;
        this.t = t;
        this.r = r;
        this.m = m;
    }
    /*//静态方法跟对象无关 跟类加载有关系 对象还没有创建 而泛型是在对象创建的时候才有的
    public static void m1(M m){

    }*/
    //方法使用泛型  比如 get set  返回类型也可以使用泛型

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public R getR() {
        return r;
    }

    public void setR(R r) {
        this.r = r;
    }

    public M getM() {
        return m;
    }

    public void setM(M m) {
        this.m = m;
    }
}

interface IA extends IUsb<String,Double>{

}
//1.当我们去实现IA接口时候，因为IA在继承IUsu接口时候 指定了U为String R为Double
//在实现IUsu接口的方法时候  使用String替换U 是Double 替换R
class AA implements IA{

    @Override
    public Double get(String s) {
        return null;
    }

    @Override
    public void hi(Double aDouble) {

    }

    @Override
    public void Run(Double ri, Double r2, String u1, String u2) {

    }
}
//自定义接口名称<>{}
interface IUsb<U,R>{
    //普通方法中 可以使用泛型
    R get(U u);
    void hi(R r);
    void Run(R ri, R r2, U u1, U u2);
    //jdk 8.0中 可以在接口使用默认发方法
    default R method(U u){
        return null;
    }
}
//2.实现接口可以直接泛型接口得到类型
// 同样道理Integer替代 U  String 替代 R
class BB implements IUsb<Integer,String>{

    @Override
    public String get(Integer integer) {
        return null;
    }

    @Override
    public void hi(String s) {

    }

    @Override
    public void Run(String ri, String r2, Integer u1, Integer u2) {

    }
}

