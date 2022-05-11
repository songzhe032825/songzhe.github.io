package com.hsp.edu.enum_;

/**
 * @author 宋哲
 * @version 1.0
 */
public class EnumExercise02 {
    /*1.声明Week枚举类 其中包含星期一至星期日的定义：MONDAY TUESDAY WEDNESDAY
    THURSDAY FRIDAY SATURDAY SUNDAY
      2.使用values 返回所有的枚举数组并遍历 输出结果
    * */
    public static void main(String[] args) {
        //Enum枚举类是在成员方法是在主方法下返回
        //直接用枚举类去调用成员方法values() 返回Week数组
        Week[] values = Week.values();
        for (Week week:values) {
            System.out.println("week =" + week);//根据enum中的toString()去重写输出

        }
    }
    enum Week {
       MONDAY("周一","不开心"), TUESDAY("周二","疲软"),
        WEDNESDAY("周三","穷哈哈"),THURSDAY("星期四","你叉叉"),
        FRIDAY("周五","要放假了"),SATURDAY("周六","撸王者"),
        SUNDAY("周日","睡懒觉");
       private String name;
       private String desc;

        private Week(String name, String desc) {
            this.name = name;
            this.desc = desc;
        }

        public String getName() {
            return name;
        }

        public String getDesc() {
            return desc;
        }

        @Override
        public String toString() {
            return "Week{" +
                    "name='" + name + '\'' +
                    ", desc='" + desc + '\'' +
                    '}';
        }
    }
}
