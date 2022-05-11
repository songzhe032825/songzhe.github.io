package com.songzheedu.set_;

import java.util.HashSet;

/**
 * @author 宋哲
 * @version 1.0
 */
public class HashSetIncrement {
    public static void main(String[] args) {
        /*
        *HashSet 底层是 HashMap 第一次添加 table 数组扩容到16
        *临界值(threshold) 是 16*加载因子(loadFactor)是0.75 =12
        *rug table 数组使用到了临界值12 就会扩容到16 * 2 =32 新的临界值
        * 就是32  * 0.75 =24;依次类推
        * */
        HashSet hashSet = new HashSet();
        for (int i = 0; i <=100; i++) {//n =1 2 3 4 ......
            hashSet.add(new A(i));//保证equals方法每次都不一样 因为循环n不一样
        }
        System.out.println("hashSet =" + hashSet);


        /*
        *    当我们向hashset增加一个元素， -> Node  -> 加入table 就算是增加一个size++
        *
        * */
        for (int i = 0; i <=7 ; i++) {//在table的另外一条链表上添加了 7个B对象
            hashSet.add(new B(i));
        }


    }
}
//触发条件：满足hashcode一样并且equals 内容不一样 就会形成让他所有数据放在同一个链表上而且不冲突
//满足单链表为8 并且 table表 >= 64 Node(链表形式) --->>>>树化TreeNode(红黑树) 不会扩容
class A{
    private int n;

    public A(int n) {
        this.n = n;
    }
    //除了equals方法不一样 还要保证hashcode必须一致
    //重写hashcode方法 返回100
    @Override
    public int hashCode() {
        //return Objects.hash(n);
        return 100;//目的：所有的A对象返回的HashCode就是100
    }
}

class B{
    private int n;

    public B(int n) {
        this.n = n;
    }


    @Override
    public int hashCode() {
        return 200;
    }
}
