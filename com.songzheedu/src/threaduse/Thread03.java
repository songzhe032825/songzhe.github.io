package threaduse;

/**
 * @author 宋哲
 * @version 1.0
 * 线程使用案例 多线程执行
 * main 线程启动俩个子线程
 */
public class Thread03 {
    public static void main(String[] args) {
        /*请编写一个程序 创建两个线程 一个线程每隔一秒输出“hello world” 输出10句
        * 退出  一个线程每隔一秒输出 hi 输出5次退出
        * */
        T3 t3 = new T3();
        //去创建了thread对象 把t3对象(实现Runnable)放进去 然后调用start
        Thread thread = new Thread(t3);
        thread.start();
        System.out.println("线程继续执行!!!!!!!");

        T4 t4 = new T4();
        Thread thread1 = new Thread(t4);
        thread1.start();
        System.out.println("线程1继续执行~~~~~~~");
    }
}
//用Runnable 实现线程方式
class T3 implements Runnable{
    int times = 0;
    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(1000);
                System.out.println("hello world ="  +( ++ times));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (times ==10){
                break;
            }
        }
    }
}
class T4 implements Runnable{
    int n = 0;
    @Override
    public void run() {
        while (true) {
            //一个线程每隔一秒输出 hi 输出5次退出
            try {
                Thread.sleep(1000);
                System.out.println("hi =" + (++n));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (n == 5) {
                break;
            }
        }
    }
}
