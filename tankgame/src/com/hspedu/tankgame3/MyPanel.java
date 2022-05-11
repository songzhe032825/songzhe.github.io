package com.hspedu.tankgame3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

/**
 * @author 宋哲
 * @version 1.0\
 * 坦克大战的绘图区域
 * @param "x" 坦克的左上角x坐标
 * @param "y" 坦克左上角的y坐标
 * @param "g" 画笔
 * @param "direct" 坦克方向（上下左右）
 * @param "type" 坦克类型（敌我类型）
 *
 *
 */
//为了实现坦克动起来 监听键盘事件  实现keyListener
    //为了让panel不停的重绘子弹 需要将MyPanel实现Runnable 当作线程使用
public class MyPanel extends JPanel implements KeyListener,Runnable{
    //定义自己的坦克 提供自己的构造器并初始化
    Hero hero = null;
    //定义敌人坦克放入Vector中
    Vector<EnemyTank> enemyTanks = new Vector<>();
    int enemyTankSize = 3;
    public MyPanel(){
        //初始化敌人tank
        for (int i = 0; i < enemyTankSize; i++) {
            //创建一个敌人的坦克
            EnemyTank enemyTank = new EnemyTank(100 * (i + 1), 0);
            //设置方向
            enemyTank.setDirect(2);    //敌人炮筒默认向上 该个方向即可
            //加入
            enemyTanks.add(enemyTank);

        }
        hero = new Hero(100,100);//初始化位置

        hero.setSpeed(3);//速度倍数
    }
    //定义paint方法

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        //做填充矩形  默认黑色
        g.fillRect(0,0,1000,750);
        //画出hero发出射击的子弹
        if(hero.shot != null && hero.shot.isLive != false){
            //画矩形
            g.fill3DRect(hero.shot.x,hero.shot.y,1,1,false);
        }

        //画出坦克- 封装方法
        drawTank(hero.getX(),hero.getY(),g,hero.getDirect(),1);
        //画敌人的坦克 for循环Vector
        for (int i = 0; i < enemyTanks.size(); i++) {
            //取出坦克
            EnemyTank enemyTank = enemyTanks.get(i);
            drawTank(enemyTank.getX(),enemyTank.getY(),g,enemyTank.getDirect(),0);
        }
    }
    //编写方法  画出坦克 x , y 坦克坐标 以这个为参考点 direct :坦克方向
    public void drawTank(int x , int y ,Graphics g, int direct,int type){
        //根据不同类型的坦克 ，设置不同的颜色
        switch (type){
            case 0://敌方坦克
                g.setColor(Color.cyan);
                break;
            case 1://我方坦克
                g.setColor(Color.red);
                break;
        }
        //根据坦克方向来绘制对应形状坦克
        //direct：表示方向,分别用0，1，2，3 顺时针方向
        switch (direct){
            case 0://向上方向
                g.fill3DRect(x,y,10,60,false);//左轮字
                g.fill3DRect(x+30,y,10,60,false);//右轮字
                g.fill3DRect(x+10,y+10,20,40,false);//坦克盖子
                g.fillOval(x+10,y+20,20,20);//坦克圆形盖子
                g.drawLine(x+20,y+30,x+20,y);//坦克炮筒
                break;
            case 1://向右方向
                g.fill3DRect(x,y,60,10,false);//上轮字
                g.fill3DRect(x,y+30,60,10,false);//下轮字
                g.fill3DRect(x+10,y+10,40,20,false);//坦克盖子
                g.fillOval(x+20,y+10,20,20);//坦克圆形盖子
                g.drawLine(x+30,y+20,x+60,y+20);//坦克炮筒
                break;
            case 2://向下方向
                g.fill3DRect(x,y,10,60,false);//左轮字
                g.fill3DRect(x+30 , y ,10,60,false);//右轮字
                g.fill3DRect(x+10,y+10,20,40,false);//坦克盖子
                g.fillOval(x+10,y+20,20,20);//坦克圆形盖子
                g.drawLine(x+20,y+30,x+20,y+60);//坦克炮筒

            case 3://向左方向
                g.fill3DRect(x,y,60,10,false);//上轮字
                g.fill3DRect(x,y+30,60,10,false);//下轮字
                g.fill3DRect(x+10,y+10,40,20,false);//坦克盖子
                g.fillOval(x+20,y+10,20,20);//坦克圆形盖子
                g.drawLine(x+30,y+20,x,y+20);//坦克炮筒
            default:
                System.out.println();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    //该方法最常用
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_W){
            //按下W键
            //改变坦克方向
            hero.setDirect(0);//向上
            //修改坦克的坐标 y -= 1;
            hero.moveUp();
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            //按下D键
            hero.setDirect(1);
            hero.moveRight();
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            //按下S键
            hero.setDirect(2);
            hero.moveDown();
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            //按下A键
            hero.setDirect(3);
            hero.moveRight();
        }
        //让面板重绘
        this.repaint();
        //如果用户按下J 就发射
        if(e.getKeyCode() == KeyEvent.VK_J){
            System.out.println("用户按下J 开始射击");
           hero.shotEnemyTank();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {
        //每隔100毫秒 自己重绘区域
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.repaint();//不停刷新绘图区域 子弹就移动 再创建MyPanel的类去启动
    }
}
