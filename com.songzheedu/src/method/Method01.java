package method;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/**
 * @author 宋哲
 * @version 1.0
 */
public class Method01 {
    public static void main(String[] args) throws InterruptedException {

        T t = new T();
        t.setName("laohan");
        //优先级设置最低
        t.setPriority(Thread.MIN_PRIORITY);
        t.start();//启动子线程

        //主线程输出5个 hi 然后就中断子线程的休眠
        for (int i = 0; i <5 ; i++) {
            System.out.println("hi~~~");
            Thread.sleep(1000);
            System.out.println("hi =" +i);
        }
        t.interrupt();//当执行这里就会中断 t 休眠
    }
}
class T extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "打屁股");
        }
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            //InterruptedException  是捕获到一个中断异常
            e.printStackTrace();
            System.out.println(Thread.currentThread().getName() + "被 Interrupt了");
        }
    }
}
