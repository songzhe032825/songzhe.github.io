package com.hsp.edu.stringbuffer_;

/**
 * @author 宋哲
 * @version 1.0
 */
public class StringAndStringBuffer {
    public static void main(String[] args) {
        //在开发中，我们经常要将String 和 StringBuffer互相转换
        //1.String -->> StringBuffer
        //方式一：使用构造器直接new
        String str = "hello";
        //老汉解读：这里返回的才是StringBuffer的对象  对于String类型本身无影响
        StringBuffer stringBuffer01 = new StringBuffer(str);
        //方式二：运用append方法  先创建空的StringBuffer对象再调用append方法去接受
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer = stringBuffer.append(str);

        //2.StringBuffer -->> String
        //方式一：toString方法转字符串
        StringBuffer stringBuffer02 = new StringBuffer("韩顺平");
        //使用StringBuffer提供的toString 方法
        String s = stringBuffer02.toString();
        //方式二： 使用构造器直接new String把stringBuffer对象放进去即可
        String s1 = new String(stringBuffer02);

    }
}
