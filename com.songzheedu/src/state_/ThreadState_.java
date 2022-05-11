package state_;

/**
 * @author 宋哲
 * @version 1.0
 */
public class ThreadState_ {
    public static void main(String[] args) throws InterruptedException {
        H h = new H();
        System.out.println(h.getName() + "此时的状态" +h.getState());
        h.start();
        //while循环不停的看状态的变化 直到线程终止 再打印看看此时的状态
        while (Thread.State.TERMINATED!=h.getState()){
            System.out.println(h.getName() + "现在的状态" + h.getState());
            Thread.sleep(1000);
        }
        System.out.println(h.getName() + "状态" + h.getState());
    }
}
class H extends Thread{
    @Override
    public void run() {
        while (true){
            for (int i = 0; i <10 ; i++) {
                System.out.println("hi" + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            break;
        }
    }
}
