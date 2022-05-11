package com.hsp.edu.try_;

/**
 * @author 宋哲
 * @version 1.0
 */
public class TryCatchDetail {
    public static void main(String[] args) {

        //ctrl + alt + t
        try {
            //可以代码 将异常生成对应的异常对象 传递个Catch
            String str = "123";
            //1.这行代码出现异常信息直接进入catch语句输出System.out.println("数字格式异常信息");
            // 而不是System.out.println("数字:" + a );不执行输出不出来
            int a = Integer.parseInt(str);//异常信息传到catch
            System.out.println("数字:" + a );
        } catch (NumberFormatException e) {//异常
            //对异常进行处理
            System.out.println("数字格式异常信息");
        } finally {
            //不管是否发生异常 始终要执行finally 如果try里面有重要资源
            //并且保证资源要关闭的话 可以放在finally内部即可 比如：
            //文件关闭 数据库关闭 网络关闭
        }
    }
}
