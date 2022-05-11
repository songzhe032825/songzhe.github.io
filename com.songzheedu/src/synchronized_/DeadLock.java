package synchronized_;

/**
 * @author 宋哲
 * @version 1.0
 * 模拟线程死锁
 */
public class DeadLock {
    public static void main(String[] args) {
        DeadLoadDemo A = new DeadLoadDemo(true);
        A.setName("A线程");
        DeadLoadDemo B = new DeadLoadDemo(false);
        B.setName("B线程");
        A.start();
        B.start();
    }
}
//同步线程死锁的案例代码
class DeadLoadDemo extends Thread{
    static Object o1 = new Object();//保证多线程共享一个对象 这里使用static
    static Object o2 = new Object();
    boolean flag; //true or false

    public DeadLoadDemo(boolean flag){//构造器
        this.flag = flag;
    }

    @Override
    public void run() {
        //下面业务逻辑有什么问题？
        //1.如果flag 为true  线程A就会得到/持有o1对象锁 然后尝试获取o2对象锁
        //2.但是拿不到o2对象锁就是一直处于一个Blocked 堵塞状态
        //3.如果flag 为false  线程B就会得到/持有o2对象锁 然后尝试获取o1对象锁
        //4.但是拿不到o1对象锁就是处于一个Blocked 堵塞状态
        //5.这两种写法是风险极高的写法效果 这种现象就是死锁现象 程序员要避免这种写法
        if(flag){
            //线程A:
                synchronized (o1){//对象互斥锁  下面就是同步代码
                    System.out.println(Thread.currentThread().getName()+"进入1");
                synchronized (o2){
                    System.out.println(Thread.currentThread().getName()+"进入2");
                }
            }
        }else{
            //线程B:
            synchronized (o2){
                System.out.println(Thread.currentThread().getName()+ "进入3");
            synchronized (o1){
                System.out.println(Thread.currentThread().getName() + "进入4");
            }
            }
        }
    }
}
