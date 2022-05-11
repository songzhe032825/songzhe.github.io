package com.Eccap01;

public class Encapsulation01{
    public static void main(String[] args) {
        //如果要使用快捷键运行  需要先配置主类  没有第一次用鼠标 后面可以使用
        Person person = new Person();
        person.setName("songzhewww");
        person.setAge(230);
        person.setSal(3356.7);
        person.setJob("ChengXuYuan");
        System.out.println(person.info());
        System.out.println(person.getSal());

    }
}

class Person {
    /*
    * 封装的实现步骤
    * 1.将属性进行私有化private [不能直接修改属性]
    * 2.提供一个公共的public  set方法  用于对属性判断并复制
    * public void  setXxx*(类型  参数名){  //Xxx表示某个属性
    *         //加入数据的验证的业务逻辑
    *
    * }
    * 3.提供一个公共的get方法 用于获取属性的值
    * 3.提供一个公共的get方法 用于获取属性的值
    * public 数据类型  getXxx(){
    *       return xx;
    * }
    * }
    *那么在java中如何实现这种类似的控制呢？
    * 请大家看一个小程序com.hspedu.encap:Encapsulation01.java
    * 不能随便查看个人的年龄 工资等隐私 并地设置的年龄进行合理的验证  年龄合理就设置
    * 否则给默认年龄  必须在1-120  年龄  工资不能直接查看  name的长度 2-6字符 之间
    *
    *  */
     //快捷键 Alt + insert
     //然后完善代码
    public String name;
    private int age;
    private double sal;
    private String job;

    //构造器
    //知识点：如果在构造器中也要防护属性 就加入setXxx结合即可

    public Person(){

    }

    public Person(String name,int age,double sal,String job){
       /* this.name = name;
        this.age = age;
        this.sal =sal;
        this.job =job;*/
        //这样不行的原因是数据无法被防护
        //我们可以将set方法写在构造器中，我们仍然可以防护数据
        setJob(job);
        setSal(sal);
        setName(name);
        setAge(age);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        //加入对数据的判断校验 相当于增加业务逻辑
        if (name.length() >= 2 && name.length() <= 6) {
            this.name = name;
        } else {
            System.out.println("名字的长度不对需要（2-6）个字符 默认名字");
            this.name = "无名";
        }
    }
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        //判断
        if (age >= 1 && age <= 120) {//合理范围
            this.age = age;
        } else {
            System.out.println("你设置年龄不对, 需要在(1-120),给默认年龄18");
            this.age = 18; //给一个默认年龄
        }
    }

    public double getSal() {
        //可以在这里增加对前面对象的权限判断
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    //写一个方法 返回属性信息
    public String info(){
        return "信息为  name = " + name  + "age =" + age + "薪水 =" + sal;
    }
}
