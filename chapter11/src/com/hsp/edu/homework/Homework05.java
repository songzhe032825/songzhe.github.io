package com.hsp.edu.homework;

/**
 * @author 宋哲
 * @version 1.0
 */
public class Homework05 {
    /*输入用户名 密码 邮箱 如果信息录入正确 则提示注册成功 否则生成异常对象
    * 要求：
    * 1.用户名长度为2，3，4
    * 2.密码长度为6 要求全是数字
    * 3.邮箱中包含@和. 并且@在.前面 isDigital(数字化)
    * */
    public static void main(String[] args) {
        String name = "Jack";
        String pwd = "888888";
        String email = "Jack@souhu.com";
        //这里可能会抛出异常
        try {
            UserRegister(name,pwd,email);
            //没抛出异常 打印一句话
            System.out.println("恭喜你,注册成功！");
        } catch (Exception e) {
            //e.getMessage()把信息打印出来
            System.out.println(e.getMessage());
        }
    }
    /*思路分析
    1.先编写方法UserRegister(String name, String pwd,String email){}
    2.针对输入的内容进行校验———非常重要 取反思维 如果有问题就抛出异常 给出提示
    3.单独写一个方法 判断密码 是否 全是数字字符 返回boolean
    */

    public static void UserRegister(String name, String pwd,String email){

        //再加入一些校验
        if(!(name != null && pwd != null && email != null)){
            throw new RuntimeException("参数不能为null");
        }

        //过关方法
        //第一关.校验名字
        int userLength = name.length();
        //先写正确情况名字长度在范围2~4之间后去反 再抛出异常即可
        if(!(userLength >=2 && userLength <=4)){
            throw  new RuntimeException("用户名长度要求不对");
        }
        //第二关 校验密码  除了判断长度必须是6并且全部是数字(不能是其他的)

        if(!(pwd.length() == 6 && isDigital(pwd))){
            throw new RuntimeException("密码长度为6并且要求全数字");
        }
        //第三关 :获取@ 和 .所在的位置
        int i = email.indexOf("@");
        int j = email.indexOf(".");
        //拿到位置后进行校验 i的索引要 > 0才表示有位置的 并且 j > i 因为@在.前面
        if(!(i > 0 && j > i)){
            throw new RuntimeException("邮箱中不包含@和.");
        }
    }
    public static boolean isDigital(String str){//括号里接受字符串的参数
        //用到以前老套路：先把字符串转成char[]类型
        // 再然后for循环即可
        char [] chars = str.toCharArray();
        for (int i = 0; i <chars.length ; i++) {
            if(chars[i] < '0' || chars[i] >'9'){
                System.out.println("(ASCII表 0~9 是数字哦)说明这个不是数字");
                return false;
            }
        }
        return true;
    }
}
