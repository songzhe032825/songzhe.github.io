package annotation;

/**
 * @author 宋哲
 * @version 1.0
 */
public class Homework06 {
    /*1.有一个交通工具接口类Vehicles 有work接口
    * 2.有Horse类和Boat类分别实现Vehicles
    * 3.创建交通工具工厂类  有两个方法分别获得交通工具 Horse和Boat
    * 4.有Person类 有name和Vehicles属性 在构造器中为两个属性赋值
    * 5.实例化Person对象“唐僧” 要求一般情况下用Horse作为交通工具 遇到大河时
    * 用Boat作为交通工具
    * 6.增加一个情况 如果唐僧过火焰山 使用飞机  程序扩展性 程序结果就跟非常好扩展
    * */
//编程 ：需求 》理解 》代码
    public static void main(String[] args) {
        //new Horse() 这个被浪费了 违背了在构造器中为两个属性赋值的要求
        Person person = new Person("唐僧",new Horse());
        person.common();//一般情况下
        person.passRiver();//过河
        person.common();
        person.passRiver();
        person.sailing();
    }
}
