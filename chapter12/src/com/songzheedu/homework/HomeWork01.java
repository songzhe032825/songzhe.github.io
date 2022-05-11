package com.songzheedu.homework;

import java.util.ArrayList;

/**
 * @author 宋哲
 * @version 1.0
 */
public class HomeWork01 {
    public static void main(String[] args) {
        /*封装一个 新闻类 包含标题和内容属性 提供get set 方法 重写toString方法
        *打印对象时只打印标题
        *2.只提供一个带参数的构造器 实例化对象时 只初始化标题 并且实例化两个对象;
           新闻一：新冠确诊病例超过超千万 数百万印度民众担忧
           新闻二：男子突然想起2个月前调的鱼还在网兜里 捞起一看赶紧发生
         3.将新闻对象添加到ArrayList集合中 并且进行倒序遍历
         4.在遍历集合过程中 对新闻标题进行处理 超过15个字的只保留前15个 然后在后边加
         *5在控制台打印遍历过程经过处理的新闻标题
        * */
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Press("新冠确诊病例超过超千万 数百万印度民众担忧"));
        arrayList.add(new Press("男子突然想起2个月前调的鱼还在网兜里 捞起一看赶紧发生"));
        //遍历倒序
        int size = arrayList.size();
        for (int i = size-1; i >= 0; i++) {
            //System.out.println(arrayList.get(i));
            Press press = (Press)arrayList.get(i);
            System.out.println(processTitle(press.getTitle()));
        }
    }
    //写一个方法专门处理新闻标题
    public static String processTitle(String title){
        if(title == null){
            return  "";
        }
        if(title.length() >=15){
            return title.substring(0,15) + "......";
        }else{
            return title;
        }
    }
}
class Press{
    private String title;
    private String content;

    public Press(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Press{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}













