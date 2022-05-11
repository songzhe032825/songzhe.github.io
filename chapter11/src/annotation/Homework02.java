package annotation;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/**
 * @author 宋哲
 * @version 1.0
 */
public class Homework02 {
    /*
    1.在Frock类中声明私有的静态属性currentNum[int类型]  初始值为100000  作为
    衣服出厂的序列号超始值
    2.声明公有的静态方法getNextNum 作为生成上衣唯一序列号的方法 每调用一次，将
    currenNum增加100 并作为返回值
    3.在TestFrock类的main 方法中 分两次调用getNextNum方法 获取序列号并打印输出
    4.在Frock类中声明serialNumber(序列号)属性 并提供对应的get方法
    5.在Frock类的构造器中 通过调用getNextNum方法为Frock对象获取唯一序列号 赋给
    serialNumber 属性
    6.在TestFrock类的main方法中  分别创建三个Frock 并打印三个对象的序列号 验证
    是否为按100递增
    */
}
class Frock{
    private  static int currentNum = 100000;
    public int serialNumber;
    /*声明公有的静态方法getNextNum 作为生成上衣唯一序列号的方法 每调用一次，将
    currenNum增加100 并作为返回值*/
    public static int getNextNum(){
            currentNum+=100;
            return currentNum;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public Frock() {
        //通过调用getNextNum方法为Frock对象获取唯一序列号 赋给
        //serialNumber 属性
        serialNumber = getNextNum();
    }
}
class TestFrock{
    public static void main(String[] args) {
       //6.在TestFrock类的main方法中分别创建三个Frock 并打印三个对象的序列验证
       //是否为按100递增
        int  currentNum= Frock.getNextNum();
        System.out.println(currentNum);
        int  currentNum1 = Frock.getNextNum();
        System.out.println(currentNum1);
        Frock frock = new Frock();//100300
        Frock frock1 = new Frock();//100400
        Frock frock2 = new Frock();//100500
        System.out.println(frock.getSerialNumber());
        System.out.println(frock1.getSerialNumber());
        System.out.println(frock2.getSerialNumber());
    }
}
