package com.hspedu.override;

public class Student extends Person{
    private int id;
    private double score;

    public Student (int id , double score){
        this.id =id;
        this.score =score;
    }

    public void setId(int id){
        this.id =id;
    }
    public int  getId(){
        return id;
    }

    public void setScore(double score){
        this.score =score;
    }

    public double getScore(){
        return score;
    }
    //方法重写 区间父子类继承关系  方法名必须一致  参数列表  顺序  类型保持一致
    public String say(){//体现super好处 代码复用
        //这里有个知识点 调用父类super.say() 这样就可以各司其职互不影响
        return  super.say() +"id =" + id + "score =" + score ;
    }
}
