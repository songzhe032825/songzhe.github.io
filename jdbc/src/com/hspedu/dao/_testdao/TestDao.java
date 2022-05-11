package com.hspedu.dao._testdao;

import com.hspedu.dao._dao.ActorDao;
import com.hspedu.dao._domain.Actor;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

/**
 * @author 宋哲
 * @version 1.0
 * 测试ActorDao对actor表的crud操作
 */
public class TestDao {
    @Test
    public void testActorDao() throws SQLException {
        ActorDao actorDao = new ActorDao();
        //1.指定sql语句
        //2.指定实体类的具体的类型
        //3.传入实参
        //1.查询多行记录结果
        List<Actor> actors = actorDao.queryMulti("select*from hsp_actor where id>= ?", Actor.class, 1);
        //增强for循环测试查询结果
        for (Actor actor: actors) {
            System.out.println(actor);
        }

        //2.查询单行记录结果
        Actor actor = actorDao.querySingle("select*from hsp_actor where id = ?", Actor.class, 6);
        System.out.println("查询单行信息结果");
        System.out.println(actor);

        //3.查询单行单列
        Object o = actorDao.queryScalar("select name  from hsp_actor where id = ?", 2);
        System.out.println("查询单行单列信息");
        System.out.println(o);

        //4.dml操作
        int update = actorDao.update("insert into hsp_actor values (null,?,?,?,?)", "张无忌", "男", "2000-11-11", "999");

        System.out.println(update > 0 ? "执行成功" : "执行失败");
    }
}
