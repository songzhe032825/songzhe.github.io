package com.songzheedu.homework;

import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author 宋哲
 * @version 1.0
 */
@SuppressWarnings({"all"})
public class JUnit {
    public static void main(String[] args) {
        /*定义一个泛型类DAO<T> 在其中定义一个Map成员变量 Map的键为String类型 值为T类型
        * 分别创建以下方法：
        * 1.public void save(String id,T entity)：保存T类型的对象到Map成员变量
        * 2.public T get(String id): 从Map中获取id 对应的对象
        * 3.public void update(String id,T entity):替换map 中key为id的内容 改为entity
        * 对象
        * 4.public List<T> list(): 返回map 中存放的所有T对象
        * 5.public void delete (String id):删除指定id 对象

        * 定义一个User类：
        * 该类包括： private 成员变量(int 类型) id age ; (String 类型) name
        * 创建 Dao类的对象 分别调用其save get update list delete 方法开操作User对象
        * 使用Junit 单元测试类进行测试
        * */

    }
    @Test
    public void testList() {
        //这里我们给T 指定类型是User
        Dao<User> userDao = new Dao<>();
        userDao.save("001",new User(1,10,"JACK"));
        userDao.save("002",new User(2,20,"MCK"));
        userDao.save("003",new User(3,40,"QUINE"));

        List<User> list = userDao.list();
        System.out.println(list);

        userDao.update("002",new User(3,32,"milan"));

        userDao.delete("002");
    }
}



