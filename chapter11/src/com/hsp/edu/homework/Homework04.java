package com.hsp.edu.homework;

/**
 * @author 宋哲
 * @version 1.0
 */
public class Homework04 {
    //1.讲字符串指定部分进行反转 比如将"abcdef" 反转为"aedcbf"
    //2.编写方法 public static String reverse(String str, int start,int end)搞定
    public static void main(String[] args) {
        String str = "abcdef";
        System.out.println("====交换前=====");
        System.out.println(str);
        //校验一下 实现try -catch
        String reverse = null;
        try {
            reverse = reverse(str, 1, 4);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            //不想走下面代码 直接return方法就行
            return;
        }
        //下面代码不执行了
        System.out.println("===交换后====");
        System.out.println(reverse);
    }
    public static String reverse(String str, int start,int end){

        //加需求  我们对输入的参数做防护  因此做一个校验 即可
        /*老韩独门思想 ：重要的技巧分享 就是正确会很难 逆向思维 那就找不正确的就行！！！！！
        //这样写不会晕
        (1)写出正确的情况
        (2)然后取反即可
        * */
        if(!(str != null && start >=0 && end > start && end< str.length())){
            //抛出异常
            throw new RuntimeException("参数不正确");
        }

        //1.先方法定义 已经有了
        //2.字符串本身是final类型无法修改 先将String类型转换成char[]数组 因为char[]
        //元素可以交换位置的 长度可以遍历循环
        char[] chars = str.toCharArray();
        //变成数组如何交换？ 红色箭头所索引位置大于黄色的索引位置
        //3.根据分析图代码实现  b站0493
        char temp = ' ';
        for (int i = start , j=end; i<j;i++,j--) {
            temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
        //使用chars 重新构建一个String 返回即可
        return  new String(chars);
    }
}
