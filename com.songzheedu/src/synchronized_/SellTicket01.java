package synchronized_;

/**
 * @author 宋哲
 * @version 1.0
 * 使用多线程  模拟三个窗口同时售票
 */
@SuppressWarnings({"all"})
public class SellTicket01 {
    //售票系统 ：编程模拟三个销售窗口100 分别使用继承 Thread 和实现方式Runnable分析
    public static void main(String[] args) {
        //三个窗口  还是会出现超卖现象 因为三个线程同时进行 怎么解决炒卖问题？？？
        //后面会将Synchronized 来解决同步互斥问题
       /* SellTicket ticket = new SellTicket();
        new Thread(ticket).start();//第一个窗口
        new Thread(ticket).start();//第二个窗口
        new Thread(ticket).start();//第三个窗口*/
        SellTicket02 sellTicket02 = new SellTicket02();
        //因为有三个线程要判断三次 最后才退出
        new Thread(sellTicket02).start();//第一个窗口
        new Thread(sellTicket02).start();//第二个窗口
        new Thread(sellTicket02).start();//第三个窗口
    }
}

//使用同步方法Synchronized 实现线程同步
//原来的问题是三个线程同时操作run方法 很麻烦！ 所以要解决这个问题
//要在某一个方法上锁即可 来演示代码！这样不会造成多个线程同时判断




class SellTicket02 implements Runnable{

    //同步方法（静态）的锁为当前类的本身
    //1.public synchronized static void m1(){}  锁是加在SellTicket02.class
    //上的 而不是this对象上
    //2.如果在静态方法上实现一个同步代码块 类名.class 因为静态方法没有this对象
    public synchronized static void m1(){}

    public static void m2(){
        //类名.class 因为静态方法是类加载先执行 this是谁调用就是谁 两者不相干
        synchronized (SellTicket02.class){
            System.out.println("m2");
        }
    }

    //让多个线程共享 num
    private  int ticketNum  = 100;
    //加一条控制语句 控制run方法循环 的变量
    private boolean loop = true;
    //老汉说明： 引言：如果不加 synchronized 关键字 会出现售票超卖现象
    //1.public synchronized void sell() 就是同步方法
    //2.锁在this对象上
    //3.如果方法上加锁导致效率不高 还可以在代码块上加锁 就是同步代码块，互斥锁还是
    //在this 对象 演示代码  this 是当前对象
    //第一种：同步方法
    public /*synchronized*/ void sell(){//同步方法，在同一个时刻 只能有一个线程进行操作sell()
        //第二种方法 ：同步代码块
        synchronized (this) {
            if (ticketNum <= 0) {
                System.out.println("没票了");
                loop = false;
                //break;
                return;
            }
            //如果 有票我们就休眠 50毫秒
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("窗口" + Thread.currentThread().getName() + "窗口卖出一张票"
                    + "剩余票数 =" + (--ticketNum));
        }
    }
    @Override
    public void run() {
        while(loop){
            sell();
        }
    }
}

//使用Thread 方式
class SellTicket implements Runnable{

    //让多个线程共享 num
    private  int ticketNum  = 100;
    @Override
    public void run() {
       while(true){
           if(ticketNum <= 0){
               System.out.println("没票了");
               break;
           }
            //如果 有票我们就休眠 50毫秒
           try {
               Thread.sleep(50);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }

           System.out.println("窗口" + Thread.currentThread().getName() + "窗口卖出一张票"
           + "剩余票数 =" + (--ticketNum));

       }
    }
}
