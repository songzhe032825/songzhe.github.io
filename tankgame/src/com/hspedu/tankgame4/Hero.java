package com.hspedu.tankgame4;

import java.util.Vector;

/**
 * @author 宋哲
 * @version 1.0
 * 敌人的坦克
 * 增加功能：
 * 1.让敌人的坦克也能够发射子弹（可以有多颗子弹）
 * 2.当我方坦克击中敌人坦克时 敌人的坦克就消失 如果能够做出爆炸效果更好
 * 3.让敌人的坦克也可以放入自由随机的上下左右移动
 * 4.控制我方的坦克和敌人的坦克在规定的范围内移动
 */
@SuppressWarnings({"all"})
public class Hero extends Tank {
    Shot shot = null;
    boolean isLive = true;
    Vector<Shot> shots =new Vector<>();
    public Hero(int x, int y) {
        super(x, y);
    }
    //射击
    public void shotEnemyTank(){
        //根据当前hero对象位置和方向来创建Shot
        switch (getDirect()){  //得到hero方向
            case 0: //上
                shot = new Shot(getX() + 20,getY(), 0);
                break;
            case 1: //右
                shot = new Shot(getX() + 60, getY()+20, 1);
                break;
            case 2: //下
                shot = new Shot(getX() + 20, getY()+60, 2);
                break;
            case 3: //左
                shot = new Shot(getX() , getY() +20, 3);
                break;
        }
        //把新创建的shot放入到shots
        shots.add(shot);
        //启动我们的shot线程
        new Thread(shot).start();
    }
}
