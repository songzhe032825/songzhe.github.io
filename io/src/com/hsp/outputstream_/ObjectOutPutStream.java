package com.hsp.outputstream_;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author 宋哲
 * @version 1.0
 * 演绎ObjectOutPutStream的使用  完成数据的可序列化
 *
 */
public class ObjectOutPutStream {
    public static void main(String[] args) throws Exception{
        //序列化后 保存的文件格式 不是存文本格式（代表乱码） 而是按照他的格式保存
        String filePath = "d:\\data.txt";
        ObjectOutputStream oos= new ObjectOutputStream(new FileOutputStream(filePath,true));
        //序列化数据保存到"d:\\data.txt"中
        oos.writeInt(100);//int 底层自动装箱 Integer(实现了Serializable)
        oos.writeBoolean(true);//boolean 底层自动装箱 Boolean(实现了Serializable)
        oos.writeChar('a');//char -- Character
        oos.writeDouble(9.5);//double -- Double
        oos.writeUTF("韩顺平教育");//String 直接实现(实现了Serializable)
        //保存dog对象  并且new Dog("旺财",10)会包运行时异常 ：NotSerializableException
        //怎么办?在Dog 类加序列化接口
        oos.writeObject(new Dog("旺财",10));
        oos.close();
        System.out.println("数据保存完毕,序列号形式保存");
    }
}
//如果需要序列化某个类的对象 必须实现可序列化的Serializable
class Dog implements Serializable {
    private String name;
    private int age;
    //添加一个属性 hobby
    private String hobby;//serialVersionUID序列化的版本号的存在只会认为是dog升级版
    //serialVersionUID序列化的版本号 提高序列化的兼容性
    private static final long serialVersionUID = 1L;
    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}