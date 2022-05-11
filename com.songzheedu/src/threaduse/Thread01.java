package threaduse;

/**
 * @author 宋哲
 * @version 1.0
 * 演示一  通过继承Thread 类开发线程
 */
public class Thread01 {
    public static void main(String[] args) throws InterruptedException {
        //接下来我要实例化Cat
        Cat cat = new Cat();
        cat.start();//启动线程  为什么调用start方法而不是run方法？？何必绕一圈呢？？？
        //理由：如果直接调用run方法 相当于主线程运行了一个方法而已不会执行  “我需要将猫咪休眠一秒钟”
        //并且for循环无法交替执行了并没有真正的启动一个线程，就会把这个run方法执行完后才执行
        // start 代理了线程
        // 说明：当main线程启动一个子线程  Thread-0 主线程不会堵塞 会继续执行
        //此时主线程 和 子线程交替执行

        //start 底层实现机制  重点！！！！！

        /*1. public synchronized void start() {
        *        start0();
        * }
        *
        * start0(); 是本地方法  是JVM 调用 底层是c/c++实现
        * 真正实现线程效果的 是 start0(); 而不是 run();
        * 2. private native void start0();
        *
        * */


        System.out.println("主线程继续执行 =" + Thread.currentThread().getName());//名字main
        for (int i = 0; i < 60; i++) {
            System.out.println("主线程 i=" + i);
            //让主线程休眠
            Thread.sleep(1000);
        }
    }
}
/*1.请编写程序  开启一个线程 该线程每隔一秒 在控制台输出 “喵喵  我是一只猫咪“
* 2.对上题改进 当输出80次  ”喵喵 我是小猫咪“ 结束该进程
* 3.使用JConsole 监控线程执行情况  并画出程序示意图
* */

//先让cat继承Thread 线程类 重写run 方法
class Cat extends Thread{
    //定义次数变量  让猫咪报数
    int times = 0;
    @Override
    public void run() {
        //加入while循环
        while (true) {
            System.out.println("我需要将猫咪休眠一秒钟" + (++ times) +Thread.currentThread() .getName());
            //我需要将猫咪休眠一秒钟 sleep 方法单位是毫秒
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //2.当输入80次 我让停止线程
            if(times == 80){
                break;
            }
        }
    }
}