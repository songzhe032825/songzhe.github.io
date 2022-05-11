
package com.hspedu.smallchange;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SmallChangeSys {
    public static void main(String[] args) {

        //化繁为简
        //1.先完成显示菜单  并可以选择菜单，给出对应提示信息  菜单思路：运用switch语句
        //2.完成零钱通明细
        //定义相关的变量
        boolean loop = true;
        //接受输入
        Scanner scanner = new Scanner(System.in);
        String key = "";
        //2.完成零钱通明细
        //老韩思路 ：1.可以把收益入账和消费 保存到数组  2. 可以使用对象  3.简单的话可以使用String 拼接
        String details = "----------------零钱通明细--------------";
        //3.完成收益入账  完成功能趋同程序员增加新的变化和代码
        //老韩思路,定义新的变量
        double money = 0;  //收益入账
        double balance = 0;//余额
        Date date =null; //date 是 java.util.Date 类型 表示日期
        //用于日期格式化
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        //4.消费
        //定义新变量  保存新变量的原因
        String note = "";
        do{

            System.out.println("========零钱通菜单========");
            System.out.println("\t\t\t1.零钱通");
            System.out.println("\t\t\t2.收益入账");
            System.out.println("\t\t\t3.消费");
            System.out.println("\t\t\t4.退出");

            System.out.println("请选择： (1-4)");
            key =scanner.next();
            //使用switch  分支控制
            switch (key){
                case "1" :
                    System.out.println(details);
                    break;
                case "2" :
                    System.out.println("收益入账金额:");
                    money = scanner.nextDouble();
                    //money 的范围应该有校验
                    //在收益入账和消费时 判断金额是否合理  并给出相应的提示
                    //思路  编程思想：找出不正确的金额的条件 然后给出提示即可，不要找不正确的金额条件(老韩20年的编程思维，这个思维相当重要)
                    //当收益入账金额范围 就表示不正确
                    if(money <= 0 ){
                        System.out.println("当收益入账金额大于等于0");
                        break;
                    }
                    balance += money;
                    //拼接收益入账信息到details
                    date = new Date();//获取当前日期
                    details += "\n收益入账\t" + money + "\t"+sdf.format(date)+ "\t" + balance;
                    break;
                case "3" :
                    System.out.println("消费金额：");
                    money = scanner.nextDouble();
                    //money 的值范围应该被校验
                    //当消费金恩入账金额范围 就表示不正确  或者消费金额比余额还多
                    //老韩独创校验方式 : 过关斩将校验方式  以后开发经常用到
                     if(money <= 0 || money> balance){
                        System.out.println("当消费金额应该在 0-"  + balance);
                        break;
                    }
                    System.out.println("消费说明：");
                    note = scanner.next();
                    balance -= money;
                    date = new Date();//重新获取当前日期
                    details += "\n消费入账\t" + note +"\t-" + money + "\t"+sdf.format(date)+ "\t" + balance;
                    break;
                case "4" :
                    System.out.println("4  退出");
                    //变量变false 就退出
                    //用户输入4退出时 给出提示”你确定要退出吗“  y/n  必须输入正确的y/n
                    //否则循环输入指令 直到输入y  或者  n
                    //老韩思路分析 ：
                    /*1.定义一个变量  choice 接受的用户的输入
                    * 2.使用while + break 的组合  来处理接受的收到的输入 y 或者  n
                    * 3.接受到之后y/n当用户退出while  再判断到底是y 还是 n 就确定是否退出
                    * 4.建议一段代码  完成一个小功能 尽量别混在一起

                 *    * */
                    String choice = "";
                    //while 用户必须接受y 或者 n
                    while(true){
                        System.out.println("你确定要退出吗  y/n");
                        choice =scanner.next();
                        if("y".equals(choice) || "n".equals(choice)){
                            break;
                        }
                    }
                    //接受到之后y/n当用户退出while  再判断到底是y 还是 n 就确定是否退出
                    if(choice.equals("y")){
                        loop = false;
                    }
                    break;
                default:
                    System.out.println("选择有误  请重新选择");
            }
        }while(loop);

        System.out.println("======退出了零钱通项目======");
    }
}
