package com.hspedu.extend_.exercise;

public class PC extends Computer{
    //这里爆红的原因是 Computer没有无参构造器
    private String brand;
    /*这里是IDEA 根据继承的规则  自动把构造器的调用写好
    *这里也体现：继承设计的基本思想 父类的构造器完成父类属性初始化
    * 子类的构造器完成子类属性初始化
    * */
    public PC(String CPU,int memory,int disk,String brand){
        super(CPU,memory,disk);
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
    public void printInfo(){
        System.out.println("pc 信息如下 =");
        //System.out.println(CPU); 不可以是因为是私有的
        //老韩解读  直接调用父类getDetail() 得到父类的相关属性
        System.out.println(getDetail( )  + "brand" + brand);
    }
}
