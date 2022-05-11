package com.hspedu.encap;

public class AccountTest {
    public static void main(String[] args) {
        Account account = new Account();
        account.setBalance(33333333.4);
        account.setName("song");
        account.setPwd("920328");
        System.out.println(account.info());
    }
}
