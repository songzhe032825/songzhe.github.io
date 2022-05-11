package homework;

/**
 * @author 宋哲
 * @version 1.0
 * 1.有两个用户分别从同一个卡上取钱（总额：1000）
 * 2.每次取出1000 当余额不足的时候  就无法取款
 * 3.不能出现超取现象 》》》》》线程同步问题synchronized
 */
public class homework02 {
    public static void main(String[] args) {
        ticketSell ticketSell = new ticketSell();
        new Thread(ticketSell).start();//用户1
        new Thread(ticketSell).start();//用户2
    }
}
//这里为何要用实现接口方式 因为是多线程共享资源的问题
class ticketSell implements Runnable{
    private int money = 10000;
    //定义属性是否.....
    private boolean loop = true;
    public synchronized void balance(){
        //1.这里使用synchronized 线程同步
        //2.当多个线程执行到这里的时候 就会去争夺this对象锁、
        //3.哪个线程争夺到(获取) this对象,前提是this对象必须是同一个对象，不是同一个对象不可以
        //4.争夺不到this对象锁 就被堵塞Blocked 准备下次重新争夺
        //5.this对象锁是非公平锁
        synchronized (this){
            //先判断余额是不是不足
            if(money <= 0){
                System.out.println("对不起余额不足");
                //让定义的属性为false
                loop = false;
                return;
            }
            //如果有余额
            money-=1000;
            System.out.println("账户" + Thread.currentThread().getName() + "取出金额"
                    + "余额 =" + money);
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void run() {
        while (loop){
            balance();
        }
    }
}

