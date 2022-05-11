package threaduse;

/**
 * @author 宋哲
 * @version 1.0
 * 演示二 通过实现接口Runnable 开发线程
 */
public class Thread02 {
    public static void main(String[] args) {
        //请编写程序 该程序可以每隔1秒 在控制台输出hi  当输出10次之后  自动退出
        //请使用实现Runnable 接口的方式实现
        Dog dog = new Dog();
        //这样写不可以  不能直接调用run 否则就是普通方法
        //dog.start();这里无法直接调用start 方法 怎么实现？？
        //去创建了thread对象 把dog对象(实现Runnable)放进去 然后调用start
        Thread thread = new Thread(dog);
        //底层设计模式 - 静态代理模式解决  代码模拟实现Runnable接口开发线程机制
        thread.start();//调用底层start0;
    }
}
//静态代理模式接口实现
class Proxy implements Runnable{//把Proxy 看成Thread类

    private Runnable target = null;//属性 类型就是 Runnable接口

    @Override
    public void run() {
        if(target != null){
            target.run();
        }
    }

    public Proxy(Runnable target) {
        this.target = target;
    }
    //真正实现多线程的方法 start0() 核心方法
    public void start(){
        start0();
    }
    public void start0(){
        run();
    }
}


class Dog implements Runnable{ //通过Runnable接口开发线程
    int count = 0;
    @Override
    public void run() {
        while(true){
            //线程名称
            System.out.println("小狗汪汪叫 hi" + (++count)+ Thread.currentThread().getName());
            //休眠1秒
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (count  ==  10){
                break;
            }
        }
    }
}