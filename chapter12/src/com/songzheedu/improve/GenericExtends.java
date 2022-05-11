package com.songzheedu.improve;

/**
 * @author 宋哲
 * @version 1.0
 */
public class GenericExtends {
    public static void main(String[] args) {
        Object o = new String("xx");

        //但是 泛型不具备继承关系<Object>
        //List<Object> list = new ArrayList<String>(); //报错
        //List<Object> list = new ArrayList<>();//没问题
    }
    
    class AA {

    }

    class BB extends AA {

    }

    class F extends BB {

    }
}