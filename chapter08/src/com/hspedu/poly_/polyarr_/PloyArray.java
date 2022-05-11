package com.hspedu.poly_.polyarr_;

public class PloyArray {
    //多态应用之一 ：多态数组
    public static void main(String[] args) {
        Person[] persons =  new Person[5];
        persons[0] = new Person("jack" ,20);
        persons[1] = new Student("rose",18,100);
        persons[2] = new Student("Cater",18,35);
        persons[3] = new Teacher("Kobe",37,3500);
        persons[4] = new Teacher("Jordan",48,2509);
        //循环遍历数组调用say()
        for (int i = 0; i < persons.length ; i++) {
            //person[i] 编译类型是  Person 运行类型是根据实际情况JVM来判断
            System.out.println(persons[i].say());//动态绑定机制
            //报错的原因就是父类没有该方法 怎么办呢 这里大家就要用到方法判断运行类型是否是学生/老师
            /*persons[i].teach();
            persons[i].study();*/
            if( persons[i] instanceof  Student){
                Student student =(Student)persons[i];
                student.study();
            //或者另一种写法((Student)persons[i]).study();
            }else if( persons[i] instanceof Teacher ){
                ((Teacher) persons[i]).teach();
            }else if(persons[i] instanceof Person){
                System.out.println("你的类型无变化");
            }else {
                System.out.println("你的类型有误");
            }
        }
    }
}
