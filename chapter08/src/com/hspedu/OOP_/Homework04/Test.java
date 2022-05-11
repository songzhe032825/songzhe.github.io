package com.hspedu.OOP_.Homework04;

public class Test {
    public static void main(String[] args) {
        //定义并初始化普通员工对象  调用打印工资方法输入工资  定义并初始化部门经理对象
        //调用打印工资方法输入工资
        Manager manager = new Manager("嘎吱",3100,12,1);
        Staff staff = new Staff("贾斯丁",2353,76,2);
        //设置奖金
        manager.setBonus(30000);
        //打印经理的工资情况
        manager.printSal();

        //设置普工的奖金
        staff.setBonus(234456);
        //打印普工的工资情况
        staff.printSal();
    }
}
