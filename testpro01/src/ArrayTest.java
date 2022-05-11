import java.util.Scanner;

public class ArrayTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = {1, -4, 23, 777, 43, 56, 90};
        MyTools myTools = new MyTools();
        myTools.bubble(arr);
        //输出后引用传递
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
    }
}
//如果想看Person 继承关系   Ctrl + H
 class Person{
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
//创建一个类MyTools 编写一个方法  可以完成对int数组冒泡排序的功能
class MyTools {
    public void bubble(int[] arr) {
        //冒泡排序
        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {//外层循环
            for (int j = 0; j < arr.length - 1 - i; j++) {//内层循环
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}