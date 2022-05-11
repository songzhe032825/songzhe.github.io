package homework;

import javax.xml.namespace.QName;
import java.util.Locale;
import java.util.Scanner;

/**
 * @author 宋哲
 * @version 1.0
 * 1.在main方法中启动两个线程
 * 2.第一个线程循环随机打印100以内的整数
 * 3.直到第二个线程从键盘读取了“Q” 命令
 */
public class Homework01 {
    public static void main(String[] args) {
        A a = new A();
        B b = new B(a);//一定要传入A对象才行 ！！
        a.start();
        b.start();
    }
}
//如果继承别的类就有implements 简单的话就是extends
class A extends Thread{
    private boolean loop = true;
    @Override
    public void run() {
        //在这里修改loop的变量把true 改成false 提供setLoop方法
      while (loop){
          //1-100的整数
          System.out.println((int)(Math.random() *100 + 1));
          //休眠一秒
          try {
              Thread.sleep(1000);
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
      }
    }
//如何修改loop变量将true 变成false?
//面向对象中set方法将修改私有的变量loop即可
    public void setLoop(boolean loop) {//该方法可以修改loop变量
        this.loop = loop;
    }
}
//直到第二个线程从键盘读取了“Q” 命令
class B extends Thread{
    private A a;
    private Scanner scanner = new Scanner(System.in);
//构造器中传入A 类对象
    public B(A a) {
        this.a = a;
    }

    public void setA(A a) {
        this.a = a;
    }

    @Override
    public void run() {
        while (true){
        //接收到用户输入
        System.out.println("请输入你的指令(Q)表示退出：");
        char c = scanner.next().toUpperCase().charAt(0);
        if (c == 'Q') {
            //已通知方式结束A线程
            a.setLoop(false);
            System.out.println("b线程退出");
            break;
        }
        }
    }
}