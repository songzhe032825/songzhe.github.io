package ticket;

/**
 * @author 宋哲
 * @version 1.0
 * 使用多线程  模拟三个窗口同时售票
 */
public class SellTicket01 {
    //售票系统 ：编程模拟三个销售窗口100 分别使用继承 Thread 和实现方式Runnable分析
    public static void main(String[] args) {
        //三个窗口  还是会出现超卖现象 因为三个线程同时进行 怎么解决炒卖问题？？？
        //后面会将Synchronized 来解决同步互斥问题
        SellTicket ticket = new SellTicket();
        new Thread(ticket).start();//第一个窗口
        new Thread(ticket).start();//第二个窗口
        new Thread(ticket).start();//第三个窗口
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
