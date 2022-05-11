package com.songzheedu.set_;

/**
 * @author 宋哲
 * @version 1.0
 */
public class HashSedStructure {
    public static void main(String[] args) {
        //模拟一个HashSet 的底层机构 其实就是在学HashMap的底层原理
        //1.创建一个数组 数组类型是Node[]
        //2.Node[]数组又叫table表 定义大小位16
        //下断点
        Node[] table = new Node[16];
        System.out.println("table=" + table);
        //3.创建结点
        Node john = new Node("john",null);

        table[2]= john;
        System.out.println("table=" + table);

        Node jack = new Node("jack",null);
        john.next = jack; //将jack 结点挂载到John后面

        Node rose = new Node("rose",null);
        jack.next = rose;//将rose 结点挂载到Jack后面
    }
}
class Node{ //结点 存储数据并且可以指向下(上)一个结点 从而形成链表
    Object item; //存放数据
    Node next; //指向下一个结点
   //Node pre;  //指向上一个结点

    public Node(Object item, Node next) {
        this.item = item;
        this.next = next;
    }
}
