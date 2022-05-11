package com.songzheedu.list_;

/**
 * @author 宋哲
 * @version 1.0
 */
public class NodeExercise {
    public static void main(String[] args) {
        //模拟一个简单的双向链表
        Node jack = new Node("Jack");
        Node tom = new Node("tom");
        Node lsp = new Node("lsp");

        //连接三个毫无关联的结点 形成双向链表
        //jack -> tom -> lsp
        jack.next = tom;//"jack“ 这个结点正指向 ”tom“
        tom.next = lsp;
        //反向结点连接代码  lsp -> tom -> jack
        lsp.pre = tom;
        tom.pre = jack;

        //让first引用指向jack 就是双向链表的头部 首结点
        Node first = jack;
        //让last尾结点指向lsp
        Node last = lsp;

        //演示遍历  从头到尾进行
        while (true){
            if(first == null){
                break;
            }
            //输出first信息
            System.out.println(first);
            //指向下一个结点
            first = first.next;
        }

        //演示 从尾到头遍历
        while(true){
            if(last == null){
                break;
            }
            System.out.println(last);
            last = last.pre;
        }
        //演示链表的添加对象/数据  是多么方便
        //需求：在tom 和 lsp 之间插入一个对象 ”sz“

        //1.先创建一个Node结点
        Node sz = new Node("sz");
        //只需要改变四个节点指向即可 很方便
        sz.next = lsp;
        sz.pre =  tom;
        lsp.pre = sz;
        tom.next =sz;

        //遍历
        first =  jack;
        while (true) {
            if(first == null){
                break;
            }
            System.out.println(first);
            first = first.next;
    }

}
//定义一个Node类 Node对象表示双向链表的一个结点
static class Node{
    public Object item;//真正存放数据的地方
    public Node next;//指向下一个结点
    public Node pre;//指向上一个结点

    public Node(Object name) {
        this.item = name;
    }
    }

}
