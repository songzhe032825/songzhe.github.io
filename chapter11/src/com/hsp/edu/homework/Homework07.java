package com.hsp.edu.homework;

/**
 * @author 宋哲
 * @version 1.0
 */
public class Homework07 {
    /*输入字符串 判断里面有多少个大写字母 多少个小写字母 多少个数字
    *思路分析 ：
    * 1.遍历字符串 ，如果char 在 ‘0’~‘9’就是一个数字
    * 2.如果char 在‘a’~‘z’ 就是小写字母
    * 3.如果char 在‘A’~‘Z’ 就是大写字母
    * 4.(使用三个变量来保存) 使用三个数据来记录统计结果
    * */
    public static void main(String[] args) {
        String str = "1234 U shangHai";
        judgeName(str);
    }
    public static void judgeName(String str){
        //1.首先判断是否为空 为空就不玩了
        if(str == null){
            System.out.println("输入的字符串不能空的");
            return;
        }
        //2.遍历
        //先拿到str类型的数组长度 进行遍历
        int strLength = str.length();
        int numCount = 0;  //初始化数字
        int lowerCount = 0; //初始化字母小写
        int upperCount = 0; //初始化字母大写
        int otherCount = 0; //初始化其他
        for (int i = 0; i <strLength; i++) {
            //str.charAt(i)细节说明不能写成str[] 数组形式 只能转成charAt形式
            //charAt形式里面的值的某个位置只能取 不能改 因为是final类型
            if(str.charAt(i) >= '0' && str.charAt(i) <= '9'){
                numCount++;
            } else if(str.charAt(i) >= 'a' && str.charAt(i) <= 'z'){
                lowerCount++;
            } else if(str.charAt(i) >= 'A' && str.charAt(i) <= 'Z'){
                upperCount++;
            } else {
                otherCount++;
            }
        }
        System.out.println("数字有" + numCount);
        System.out.println("小写字母有" +lowerCount);
        System.out.println("大写字母有" + upperCount);
        System.out.println("其他有" +otherCount);
    }
}
