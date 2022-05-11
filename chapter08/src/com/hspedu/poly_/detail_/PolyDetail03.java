package com.hspedu.poly_.detail_;

public class PolyDetail03 {
    public static void main(String[] args) {
        BB bb = new BB();
        //instanceof 比较操作符 用于判断的对象【运行类型】是否为XX类型 或者 XX 类型的子类型
        System.out.println(bb instanceof BB); //true
        System.out.println(bb instanceof AA); //true
    }
}

class AA{}

class BB extends AA{

}
