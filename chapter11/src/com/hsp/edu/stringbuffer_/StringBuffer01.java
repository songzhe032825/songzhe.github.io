package com.hsp.edu.stringbuffer_;

/**
 * @author 宋哲
 * @version 1.0
 */
public class StringBuffer01 {
    public static void main(String[] args) {
        //1.StringBuffer 直接父类收AbstractStringBuffer
        //2.StringBuffer 实现了可串行化的接口Serializable 即StringBuffer的
        //对象也可以串行化
        //3.hello字符串存放在哪里？ 阅读底层代码我们知道：
        //在父类中用一个属性 char[] value 但不是final类型 该value数组存放字符串内容 因此存放
        //在堆中 而不是常量池中了
        //4.StringBuffer 他是一个final类 不能被继承
        StringBuffer stringBuffer = new StringBuffer("hello");//hello放在哪里
    }
}
