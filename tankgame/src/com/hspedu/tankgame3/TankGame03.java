package com.hspedu.tankgame3;

import javax.swing.*;

/**
 * @author 宋哲
 * @version 1.0
 */
public class TankGame03 extends JFrame {
    //定义MyPanel
    MyPanel mp = null;
    public static void main(String[] args) {
        TankGame03 tankGame01 = new TankGame03();

    }
    public TankGame03(){//构造器的固定模式
        mp = new MyPanel();
        //将mp放入到Thread 并启动
        Thread thread = new Thread(mp);//底层时静态代理模式
        thread.start();
        this.add(mp);//把面板(游戏的绘图区域)添加进去
        this.setSize(1000,750);//设置大小
        this.addKeyListener(mp);//增加键盘的监听事件
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置关闭窗口
        this.setVisible(true);
    }
}
