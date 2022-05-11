package com.hspedu.extend_.exercise;

public class ExtendsExercise03 {
    /*编写Computer类 包含CPU 内存 硬盘等属性  getDetails方法用于返回Computer的详细信息
    *编写PC子类  继承Computer类  添加特有属性【品牌brand】
    *编写NotePad子类  继承了Copmputer类 添加特有属性【color】
    *编写Test类  在main方法中创建PC和NotePad对象，分别给对象中特有的属性赋值
    * 以及从Computer 类继承的属性赋值  并使用方法打印输出信息
    * */
}
class Computer {
    private String CPU;
    private int memory;
    private int disk;

    public Computer(String CPU, int memory, int disk) {
        this.CPU = CPU;
        this.memory = memory;
        this.disk = disk;
    }
    //返回Computer 详细信息
    public String getDetail(){
        return " CPU =" + CPU + " memory =" + memory + "disk =" + disk;
    }

    public String getCPU() {
        return CPU;
    }

    public void setCPU(String CPU) {
        this.CPU = CPU;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public int getDisk() {
        return disk;
    }

    public void setDisk(int disk) {
        this.disk = disk;
    }
}
