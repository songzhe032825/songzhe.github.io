package com.bjpowernode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author 宋哲
 * @version 1.0
 */
public class TestHelloMaven {
    @Test
    public void testAdd(){
        System.out.println("测试add");
        HelloMaven helloMaven = new HelloMaven();
        int res = helloMaven.add(10, 20);
        //判断结果是否正确
        Assert.assertEquals(30,res);
    }
}
