package com.hsp.edu.stringbuffer_;

/**
 * @author 宋哲
 * @version 1.0
 */
public class StringBufferExercise01 {
    public static void main(String[] args) {
        //练习String 与 StringBuffer之间的转换
        String str =null; //ok
        StringBuffer sb = new StringBuffer(); //ok
        sb.append(str); //要学会看源代码
        /*private AbstractStringBuilder appendNull() {
        int c = count;
        ensureCapacityInternal(c + 4);
        final char[] value = this.value;
        value[c++] = 'n';
        value[c++] = 'u';
        value[c++] = 'l';
        value[c++] = 'l';
        count = c;
        return this;
    }
        *  解读底层原码的 调用了父类AbstractStringBuilder的appendNull() 将null以字符串
        * 存放再final char[] value 数组中  长度肯定是4
        * */
        System.out.println(sb.length());  //4

        System.out.println(sb); //null
        StringBuffer sb1 = new StringBuffer(str);
        /*
        public StringBuffer(String str) {
        super(str.length() + 16); //调用父类的替换成null.length() + 16
        append(str);
        }*
        *
        * */
        //这行的StringBuffer构造器直接接受了str的空字符
        //肯定报NullPointerException
        System.out.println(sb1);//不执行
    }
}
