package com.hsp.edu.Wrapper;

/**
 * @author 宋哲
 * @version 1.0
 */
public class WrapperVSString {
    public static void main(String[] args) {
        //包装类型  转换成 String类型
        Integer i = 100;//这行代码是自动装箱
        //方式一： toString
        String s1 =i.toString();
        //方式二：String.ValueOf
        String s2 = String.valueOf(i);
        //方式三：拼接字符串
        String s3 = i + " ";

        //String类型 转换成 包装类
        //方式一 ：创建包装类把String对象让包装类去接收
         String s4 = "14442";
         Integer j1 = new Integer(s4);
         //方式二： 还是底层代码 Integer.ValueOf()方法
         Integer j2 = Integer.valueOf(s4);
    }
}
