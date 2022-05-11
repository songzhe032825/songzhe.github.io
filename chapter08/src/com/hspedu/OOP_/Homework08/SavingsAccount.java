package com.hspedu.OOP_.Homework08;

public class SavingsAccount extends BankAccount{
    //set 方法修改  get方法查看
    //扩展前一个练习的BankAccount类 新类的SavingMonthly每个月都有利息产生
    //(earnMonthlyInterest 方法被调用) 并且有每个月三次免手续费的存款或取款 在
    //earnMonthlyInterest方法中重置交易计数
    //增加属性
    private int count =3;  //次数
    private double rate =0.01;//利率

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public SavingsAccount(int initialBalance) {
        super(initialBalance);
    }

    @Override
    public void deposit(double amount) {
        //判断是否可以免手续费用
        if(count > 0){
            super.deposit(amount);
        }else {
            super.deposit(amount - 1); //把一块钱转入账号
        }
        count --; //减去一次
    }

    @Override
    public void withdraw(double amount) {
        //判断是否可以免手续费用
        if (count > 0) {
            super.withdraw(amount);
        } else {
            super.withdraw(amount + 1);//把一块钱转入账号
        }
        count --;
    }
    //每个月初 我们统计上个月的利息 同时将count = 3 重置
    public void earnMonthlyInterest(){
        count = 3; //
        //余额存款乘以利率
        super.deposit(getBalance() * rate);
    }
}
