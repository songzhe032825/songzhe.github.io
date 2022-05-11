package com.songzheedu.set_;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 宋哲
 * @version 1.0
 */
public class HashSetSource {
    public static void main(String[] args) {
        Set hashSet = new HashSet();
        hashSet.add("java");
        hashSet.add("php");
        hashSet.add("java");
        System.out.println("hashSet=" +hashSet);

        //老韩对HashSet 的源码解读：
        /*1. 执行构造器HashSet
        public HashSet() {
        map = new HashMap<>();
        }
        2.执行add(E e)方法
        public boolean add(E e) { //e = "java"java常量
        //null表示对象没有 恰恰说明添加数据成功了
            return map.put(e, PRESENT)==null;
        }
        3.执行put() 该方法会执行hash(key) 得到key对应的hash值,算法h=key.hashCode();
        //如果面试官问这里hash值是不是hashcode? 肯定不是！实际上h还做了算法处理
        public V put(K key, V value) { // key: "java" value :@Object533
              return putVal(hash(key), key, value, false, true);
        4. 执行putVal()
        final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
                   boolean evict) {
        Node<K,V>[] tab; Node<K,V> p; int n, i;//定义了辅助变量
        //table就是 HaspMap的一个数组(又称属性), 属性类型是Node[]
        //if语句表示如果当前table 是空或者大小等于0 第一次扩容 dao16个空间
        if ((tab = table) == null || (n = tab.length) == 0)
            n = (tab = resize()).length;
        //<1>根据key得到hash 去计算该key应该存放到table表的哪个索引位置
        //<2>并且把该位置对象赋给辅助变量p
        //<3>判断p是否为null
        //<3.1>如果p确实为null 表示还没有存放数据 就创建以个Node(key="java", value=PRESENT);
        //<3.2>如果p不为null
        if ((p = tab[i = (n - 1) & hash]) == null)
            tab[i] = newNode(hash, key, value, null);
        else {
        //开发技巧提示：在需要局部变量(辅助变量)的地方的时候 在创建
            Node<K,V> e; K k;//定义辅助变流
            if (p.hash == hash && //这里的p是指向table表 如果第1钟.当前索引位置链表对应的第一个元素和准备添加的
            //并且满足准备加入的k 和 p 指向的Node结点的key是同一个对象 满足条件之一即可
            //或者不是同一个对象到但是内容相同也可以。p指向的Node结点的key的equals()和准备加入的key比较后相同
            //key的hash值一样
                ((k = p.key) == key || (key != null && key.equals(k))))
                e = p;
             //再判断 p 是不是红黑树
             //第2钟：情况如果是一颗红黑树 就调用putTreeVal来进行添加
            else if (p instanceof TreeNode)
                e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
            else {
            //第3钟：如果当前table对应索引位置已经是一个链表 就是用for循环比较
            //1.依次和该链表的每一个元素比较之后 说明添加的元素都不相同 加入到该链表的最后
            //2.依次和该链表的每一个元素比较之后 如果有相同的情况 就直接break;
                for (int binCount = 0; ; ++binCount) {
                    if ((e = p.next) == null) {
                        p.next = newNode(hash, key, value, null);
                        if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                            treeifyBin(tab, hash);
                        break;
                    }
                    if (e.hash == hash &&
                        ((k = e.key) == key || (key != null && key.equals(k))))
                        break;
                    p = e;
                }
            }
            if (e != null) { // existing mapping for key
                V oldValue = e.value;
                if (!onlyIfAbsent || oldValue == null)
                    e.value = value;
                afterNodeAccess(e);
                return oldValue;
            }
        }
        ++modCount;
        if (++size > threshold)
            resize();
        afterNodeInsertion(evict);
        return null;
    }
    }
         */

    }
}
