package com.songzheedu.homework;

import java.util.*;

/**
 * @author 宋哲
 * @version 1.0
 */
public class Dao<T>{
    private Map<String,T> mp = new HashMap<>();

    //保存 T 类型的对象到Map成员变量中
    public void save(String id, T entity){
        System.out.println("保存T 类型对象到Map成员变量中");
        mp.put(id,entity);
    }

    //从Map中获取id 对应的对象
    public T get(String id){
        return mp.get(id);
    }
    //替换map中key 为id内容 改为entity 对象
    public void update(String id ,T entity){
        mp.put(id,entity);
    }
    //返回map中存放的所有T对象  把value封装到ArrayList成T遍历 进行返回
    public List<T> list(){
        //创建ArrayList
       List<T> list = new ArrayList<>();
       //遍历  map常使用keySet方法
        Set<String> keySet = mp.keySet();
        for (String s : keySet) {
            //记住返回的是User 放在ArrayList
            list.add(get(s));
        }
        return list;
    }
    //删除指定id 对象
    public void delete(String id){
        mp.remove(id);
    }
}
