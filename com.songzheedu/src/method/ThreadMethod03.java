package method;

/**
 * @author 宋哲
 * @version 1.0
 */
public class ThreadMethod03 {
    //一般情况下 主线程执行完毕 子线程即使无限循环也不会退出 也就不是子线程
    //我的要求是：希望做成子线程是个守护线程 当主线程结束的时候 子线程也跟着结束
    public static void main(String[] args) throws InterruptedException {
        //Daemon 守护
        MyDaemonThread myDaemonThread = new MyDaemonThread();
        //希望做成子线程是个守护线程 当主线程结束的时候 子线程也跟着结束
        //先设置好守护线程 再启动 顺序不能错
        myDaemonThread.setDaemon(true);
        myDaemonThread.start();
        for (int i = 0; i < 5; i++) {
            System.out.println("我很强");
            Thread.sleep(1000);
        }
    }
}
//类似于监护人  场景：多线程中希望有一个线程可以监控其他线程或者获取其他线程的信息
//就可以用到守护线程，利于对多线程的管理 ------垃圾回收机制
class MyDaemonThread extends Thread{
    @Override
    public void run() {
        for (; ;) { //无限循环
            try {
                Thread.sleep(1000); //休眠50 毫秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("我很快乐~~~");
        }
    }
}
