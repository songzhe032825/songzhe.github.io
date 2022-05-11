package annotation;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

/**
 * @author 宋哲
 * @version 1.0
 */
public class Homework05 {
    /*内部类：
    * 1.编一个类C 在类中定义局部内部类D D中有一个私有常量name 有一个方法show()
    * 打印常量name 进行测试
    * 2.进阶：C中也定义一个私有的变量name 在show方法中打印测试
    * */
    public static void main(String[] args) {
        C c = new C();
        c.f1();
    }
}
class C{
    private String NAME= "小妖怪";

    public void f1(){
        //局部内部类
        class D{
            private final String NAME = "函数弄";
            public void show(){
                System.out.println("NAME=" +NAME + "外部类的name=" +
                        C.this.NAME);
            }
        }
        D d = new D();
        d.show();
    }
}

