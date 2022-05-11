package com.hspedu.tankgame4;

import java.util.Vector;

/**
 * @author 宋哲
 * @version 1.0
 * 敌人的坦克
 * 让敌人的坦克类也能发射子弹（可以多子弹）
 * 1.在敌人坦克类 使用Vector 保存多个Shot
 * 2.在每个创建一个敌人坦克对象 给该敌人坦克对象初始化一个Shot对象 同时启动Shot
 * 3.再绘制敌人坦克时 需要变量敌人坦克对象Vector 绘制所以的子弹 挡子弹isLive == false
 * 时移除
 *
 * 如何实现敌方坦克自由移动
 * 思路分析：
 * 1.因为要求敌人的坦克 可以自由的移动 因此需要将敌人的坦克当作线程使用
 * 2.我们需要EnemyTank extends Tank implements Runnable
 * 3.再run方法写写业务代码 自由移动
 * 4.最后启动线程
 */
@SuppressWarnings({"all"})
public class EnemyTank extends Tank implements Runnable{
    //在敌人坦克类 使用Vector 保存多个Shot
    Vector<Shot> shots = new Vector<>();
    Vector<EnemyTank> enemyTanks = new Vector<>();
    boolean isLive = true;
    public EnemyTank(int x, int y) {
        super(x, y);
    }

    //提供一个方法 可以将MyPanel的成员设置到 EnemyTank的成员
    public void setEnemyTanks(Vector<EnemyTank> enemyTanks){
        this.enemyTanks = enemyTanks;
    }

    //编写方法  判断当前的这个敌人坦克是否和 enemyTanks 中的其他坦克发生的重叠或者碰撞
    public boolean isTouchEnemyTank(){
        //判断当前敌人坦克(this) 方向
        switch (this.getDirect()){
            case 0:
                //让当前敌人坦克和其他所有的敌人坦克比较
                for (int i =0; i< enemyTanks.size();i++){
                    EnemyTank enemyTank = enemyTanks.get(i);
                    //不和自己比较
                    if(enemyTank != this){
                        //如果敌人坦克上下
                        if(enemyTank.getDirect() == 0 || enemyTank.getDirect() == 2){
                            //..
                        } //如果敌人坦克左右
                        if(enemyTank.getDirect() == 1 || enemyTank.getDirect() == 3){
                            //..
                            if(this.getX() >= enemyTank.getY()){

                            }
                        }
                    }
                }
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
        }
        return false;
    }
    @Override
    public void run() {
        //再run方法写写业务代码 自由移动
        while (true){

            //如果判断shots size() = 0 , 创建一颗子弹放入到
            //shots集合 并启动
            if(isLive && shots.size() == 0 ){
                Shot s = null;
                //判断坦克的方向对应的子弹
                switch (getDirect()){
                    case 0:
                        s = new Shot(getX() + 20,getY(),0);
                        break;
                    case 1:
                        s = new Shot(getX() + 60,getY() + 20,1);
                        break;
                    case 2:
                        s = new Shot(getX() + 20,getY() + 60,2);
                        break;
                    case 3:
                        s = new Shot(getX() ,getY() + 20,3);
                        break;
                }
                shots.add(s);
                //启动
                new Thread(s).start();
            }
            //根据坦克方向继续移动
            switch (getDirect()){
                case 0:
                    //让坦克保存一个方向 走30步
                    for (int i = 0; i < 30; i++) {
                        if (getY() > 0){
                            moveUp(); //上
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    //case 语句后不写break 会出现穿透现象
                    break;
                case 1://右
                    //让坦克保存一个方向 走30步
                    for (int i = 0; i < 30; i++) {
                        if(getX() + 60 < 1000){
                            moveRight();//上
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 2://下
                    for (int i = 0; i < 30; i++) {
                        if(getY() + 60 < 750){
                            moveDown();//上
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 3://左
                    for (int i = 0; i < 30; i++) {
                        if(getX()> 0){
                            moveLeft();//上
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
            }

            //然后随机改变方向: 0-3
            setDirect((int) Math.random() * 4);//[0-4)
            //（很重要）只要设计到多线程 并发程序一定要考虑到何时退出多线程！！
            if(isLive == false){
                //退出线程
                break;
            }
        }
    }
}
