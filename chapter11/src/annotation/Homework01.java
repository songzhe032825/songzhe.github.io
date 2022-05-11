package annotation;

/**
 * @author 宋哲
 * @version 1.0
 */

public class Homework01 {
    public static void main(String[] args) {
        Car c = new Car();
        Car c1 = new Car(100);
        System.out.println(c); //9 red
        System.out.println(c1); //100 red
    }
}
/*回归以前的知识点
1.当创建对象Car之前  先静态属性初始化 类加载
2.当再一次创建C1的时候  类加载就不执行了，因为只执行一次 并且
 static String color = "white";这行代码保存的不是 "white" 而是“red”
*/
class Car{
    double price = 10;
    static String color = "white";
    public String toString(){
        return price + "\t" + color;
    }

    public Car(){
        this.price =9;
        this.color = "red";
    }

    public Car(double price) {
        this.price = price;
    }

}