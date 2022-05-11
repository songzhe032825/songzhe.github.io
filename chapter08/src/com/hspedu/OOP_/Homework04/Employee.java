package com.hspedu.OOP_.Homework04;

public class Employee{
    /*父类 ： 员工
    * 子类 ： 部门经理类  普通员工类
    * 1.部门经理工资 = 1000 + 单日工资 * 天数 * 等级(1.2)
    * 2.普通员工工资 = 单日工资 * 天数 * 等级(1.0);
    * 3.员工属性 ： 姓名  单日工资  工作天数
    * 4.员工方法 ： (打印工资)
    * 5.普通员工及部门经理都是员工子类 需要重写打印工资方法
    * 6.定义并初始化普通员工对象  调用打印工资方法输入工资  定义并初始化部门经理对象
    * 调用打印工资方法输入工资
    * */
    private String name;
    private double DateSal;
    private int day;
    private int grade;

    public Employee(String name, double dateSal, int day, int grade) {

        this.name = name;
        DateSal = dateSal;
        this.day = day;
        //分析出还有一个属性等级
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDateSal() {
        return DateSal;
    }

    public void setDateSal(double dateSal) {
        DateSal = dateSal;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public void printSal(){
        //奖金
        System.out.println(name +  "工资 ="  + DateSal * day *grade );

    }
}
