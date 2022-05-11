package com.hspedu.encap;
/*创建程序,在其中定义两个类：AccountTest和 Account类体会Java的封装性
*1.Account类要求具有属性：姓名(长度为2位 3位 或4位)，余额（必须>20）
* 密码（必须是六位）,如果不满足，则给出提示信息，并给默认值
* 2.通过setXxx的方法给Account 的属性赋值
* 3.在AccountTest中测试
* 知识点： 封装要找set方法才行 不要找get
* */
public class Account {
    private String name;
    private double balance;//余额
    private String pwd;

    public Account() {
    }

    public Account(String name, double balance, String pwd) {
          this.setBalance(balance);
          this.setPwd(pwd);
          this.setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        int len = name.length();
        if(len >= 2 && len <= 4){
           this.name = name;
        } else {
            System.out.println("名字长度不对需要(2-4) 默认名字无名 " );
            this.name = "无名";
        }
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if( balance > 20 ){
            this.balance = balance;
        } else {
            System.out.println("余额不足，默认为0");
            this.balance = 0;
        }
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        int len = pwd.length();
        if(len == 6){
            this.pwd = pwd;
        }else{
            System.out.println("密码长度不够，必须重新输入");
            this.pwd = "000000";
        }
    }
//显示账号下的信息
    public String info(){
        //可以增加权限的校验 后面会讲
        return "信息为  name=" + name + "余额为 balance=" + balance + "密码为 pwd= " + pwd;
    }
}
