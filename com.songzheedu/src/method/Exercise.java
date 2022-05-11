package method;
/**
 * @author 宋哲
 * @version 1.0
 */
public class Exercise {
    public static void main(String[] args) throws InterruptedException {
        /*1.主线程每隔1秒 输出hi 一共10次
        * 2.当输出到hi 5 时 启动一个子线程(要求实现Runnable)每隔1秒输出hello
        * 等该线程输出10次后 退出
        * 3.主线程继续输出hi 直到主线程退出
        *
        * */
        L l = new L();
        Thread thread = new Thread(l);
        for (int i = 1; i <=10; i++) {
            System.out.println("hi  子线程启动" + i);
            if(i == 5){ //说明主线程输出入5次hi 启动子线程L
                thread.start();//启动子线程 输出hello
                thread.join();//立即将L子线程插入到主线程队伍 让L先执行
            }
            Thread.sleep(1000);//输出一次hi  让主线程休眠一秒
        }
    }
}
class L implements Runnable{
    private int count = 0;
    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("hello...." +(++count));
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if( count == 10){
                break;
            }
        }
    }
}

