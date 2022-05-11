package com.songzheedu.set_;

import java.util.HashSet;
import java.util.Objects;

/**
 * @author 宋哲
 * @version 1.0
 */
public class HashSetExercise02 {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        hashSet.add(new Student("xiaoMing",3444.5,"1992-03-28"));
        hashSet.add(new Student("xiaoGang",2323.3,"1999-04-18"));
        hashSet.add(new Student("xiaoMing",3444.5,"1992-03-28"));
        System.out.println("hashSet=" + hashSet);
    }
}
class Student{
    private String name;
    private double sal;
    private String birthday;

    public Student(String name, double sal, String birthday) {
        this.name = name;
        this.sal = sal;
        this.birthday = birthday;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;

    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                ", birthday='" + birthday + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Double.compare(student.sal, sal) == 0 && Objects.equals(name, student.name) && Objects.equals(birthday, student.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, sal, birthday);
    }
}
