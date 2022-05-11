package exit;

/**
 * @author 宋哲
 * @version 1.0
 * 启动一个线程t,要求在main线程中去停止线程  请编程实现
 */
public class ThreadExit {
    public static void main(String[] args) {
        //主线程通知线程结束 如何实现？

        T t = new T();
        t.start();
        //如果希望main线程控制 t线程的让其结束 希望控制loop变量来实现效果 setLoop方法即可
        //让t 退出run方法 从而终止 t线程 -> 通知终止
        //先让main线程休息10秒  在通知t1线程退出
        try {
            Thread.sleep(10 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.setLoop(false);
    }
}
class T extends Thread{
    //设置一个控制变量 可以私有的
    private boolean loop = true;
    @Override
    public void run() {
        while(loop){
            try {
                Thread.sleep(50);
                System.out.println("休眠50 毫秒");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("AThread 运行中....");
        }
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }
}
