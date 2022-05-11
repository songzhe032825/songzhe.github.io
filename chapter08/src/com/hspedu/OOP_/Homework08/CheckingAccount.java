package com.hspedu.OOP_.Homework08;

public class CheckingAccount extends BankAccount{
    //在上面类的基础上扩展  新类的CheckingAccount
    // 对每次存款和取款都收取1美元的手续费
    public CheckingAccount(int initialBalance) {
        super(initialBalance);
    }
//存款
    @Override
    public void deposit(double amount) {
        super.deposit(amount - 1);//巧妙运用父类的deposit
        //1块钱转入银行账号
    }
//取款
    @Override
    public void withdraw(double amount) {
        super.withdraw(amount + 1);
    }
}
