package method;

/**
 * @author 宋哲
 * @version 1.0
 * join yield常用方法
 * 如果我让主线程吃5个包子 子线程全部吃完
 */
public class Method02 {
    public static void main(String[] args) throws InterruptedException {
        T2 t2 = new T2();
        t2.start();

        for (int i = 1; i <20 ; i++) {
                Thread.sleep(2000);
                System.out.println("主线程 吃了" + i + "包子");

            if(i==5){
                System.out.println("主线程吃了5个包子 让子线程先吃完 后再自己吃");
                t2.join();//这里相当于让t2线程先执行完毕 注意这里只能向上抛出异常
                System.out.println("子线程先吃，主线程再吃");
            }
        }
    }
}
//让子线程先执行
class T2 extends Thread{
    @Override
    public void run() {
        for (int i = 1; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("子线程吃了=" +i+ "包子");
        }
    }
}