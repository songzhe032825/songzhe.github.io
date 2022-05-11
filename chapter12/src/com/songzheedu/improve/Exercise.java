package com.songzheedu.improve;

import java.util.*;

/**
 * @author 宋哲
 * @version 1.0
 */
public class Exercise {
    public static void main(String[] args) {
        /*创建3个学生对象
        * 放入到HashSet中学生对象 使用
        * 放入到 HashMap中 要求Key是String name Value就是学生对象
        * 使用两种方式遍历
        * */
        //1.HashSet泛型
        HashSet<Student> student = new HashSet<Student>();
        student.add(new Student("小明"));
        student.add(new Student("小红"));
        student.add(new Student("小蓝"));

        //遍历
        for (Student student1 :student) {
            System.out.println(student1);
        }
       //2.HashMap泛型 k指定String类型 v指定是student
        HashMap<String, Student> stringStudentHashMap = new HashMap<>();
        stringStudentHashMap.put("小明",new Student("小明"));
        stringStudentHashMap.put("milan",new Student("milan"));
        stringStudentHashMap.put("han",new Student("han"));
        Set<Map.Entry<String, Student>> entries = stringStudentHashMap.entrySet();
        Iterator<Map.Entry<String, Student>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Student> next =  iterator.next();
            System.out.println(next.getKey() + "-" + next.getValue());
        }
        //使用细节  往往实际开发中都简写
        ArrayList<Integer> list = new ArrayList< >();
        ArrayList<Pig> pigs = new ArrayList<Pig>();
    }
}
class Student{
    private String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }
}
class Pig{}