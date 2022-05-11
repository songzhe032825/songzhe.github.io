package com.hspedu.OOP_.Homework08;

public class Test {
    public static void main(String[] args) {
        CheckingAccount checkingAccount = new CheckingAccount(1000);
        checkingAccount.deposit(10);
        System.out.println(checkingAccount.getBalance());
        checkingAccount.withdraw(20);
        System.out.println(checkingAccount.getBalance());

        SavingsAccount savingsAccount = new SavingsAccount(2000);
        //3次存款免利率
        savingsAccount.deposit(100);
        savingsAccount.deposit(100);
        savingsAccount.deposit(100);
        System.out.println(savingsAccount.getBalance());
        savingsAccount.deposit(100);
        System.out.println(savingsAccount.getBalance());

        //月初  定时器的统计余额
        savingsAccount.earnMonthlyInterest();
        System.out.println(savingsAccount.getBalance());
    }
}
