package annotation;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 宋哲
 * @version 1.0
 */

public class SuppressWarnings_ {
    //出现六个黄色警告
    //1.我不希望看到这些警告的时候 可以使用@SuppressWarnings
    // 注解来抑制警告信息
    //2.{""} 中，可以写入你希望抑制(不显示)警告信息
    //比如 ：字符串中放入 all null super 等等
    //3.关于@SuppressWarnings 作用范围是和你放置的位置有关
    //4.比如@SuppressWarnings放在 main方法,那么作用抑制警告的范围就是main方法
    //5.通常放在语句 或方法 或 类上就可以抑制警告
    @SuppressWarnings({"rawtypes","unchecked","unused"})
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("jack");
        list.add("tom");
        list.add("mary");
        int i;
        System.out.println(list.get(1));
    }
    public void f1(){
        @SuppressWarnings({"rawtypes"})
        List list = new ArrayList();
        list.add("jack");
        list.add("tom");
        list.add("mary");
        @SuppressWarnings({"unchecked"})
        int i;
        System.out.println(list.get(1));
    }
}
