package com.hspedu.OOP_.Homework08;

public class BankAccount {
    /*要求
    1.在上面类的基础上扩展  新类的CheckingAccount 对每次存款和取款都收取1美元的手续费
    2.扩展前一个练习的BankAccount类 新类的SavingMonthly每个月都有利息产生
    (earnMonthlyInterest 方法被调用) 并且有每个月三次免手续费的存款或取款 在
    earnMonthlyInterest方法中重置交易计数
    3.体会重写的好处
    * */
    private int balance; //余额

    public BankAccount(int initialBalance) {
        this.balance =  initialBalance;
    }
    //存款
    public void deposit(double amount){
        balance += amount;
    }
    //取款
    public void withdraw(double amount){
        balance -= amount;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
