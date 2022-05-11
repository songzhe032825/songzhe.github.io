package com.hspedu.abstract_;

 abstract public class Employee {
  private String name;
  private int id;
  private double salary;

  public Employee(String name, int id, double salary) {
   this.name = name;
   this.id = id;
   this.salary = salary;
  }

  public String getName() {
   return name;
  }

  public void setName(String name) {
   this.name = name;
  }

  public int getId() {
   return id;
  }

  public void setId(int id) {
   this.id = id;
  }

  public double getSalary() {
   return salary;
  }

  public void setSalary(double salary) {
   this.salary = salary;
  }
  //将work() 做成抽象方法 并写两个子类继承该方法
  public abstract void work();
 }
