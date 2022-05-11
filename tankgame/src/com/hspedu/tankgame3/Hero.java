package com.hspedu.tankgame3;

/**
 * @author 宋哲
 * @version 1.0
 * 自己的坦克
 */
public class Hero extends Tank {

    Shot shot = null;
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
        //启动我们的shot线程
        new Thread(shot).start();
    }
}
