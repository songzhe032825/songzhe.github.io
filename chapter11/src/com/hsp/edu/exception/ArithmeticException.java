package com.hsp.edu.exception;

/**
 * @author 宋哲
 * @version 1.
 */
public class ArithmeticException {
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 0;
        //1.num1 / num2 => 10 / 0
        //2.当执行到num1 / num2 因为 num2 = 0,
        // 程序就会出现(抛出)异常 : ArithmeticException 算数异常
        //3.当抛出异常后 程序就崩溃了 下面的代码将不再执行
        //4.大家想一想 这样得程序合理吗？不应该出现了一个不算得致命得问题
        //导致整个系统崩溃
        //5.java设计者提供异常处理机制 解决问题  try-catch
        //表示：如果程序员 认为一段代码可能出现异常/问题 可以使用try-catch异常处理
        //机制来解决 ：将该代码块选中 CRTl + alt + t

        try {
            int res = num1 / num2;
        } catch (Exception e) {
            System.out.println("出现的异常 =" + e.getMessage());//输出异常信息
        }
        System.out.println("程序继续运行.....");
    }
}
