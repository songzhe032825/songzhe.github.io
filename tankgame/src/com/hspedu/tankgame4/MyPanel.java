package com.hspedu.tankgame4;

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
@SuppressWarnings({"all"})
//为了实现坦克动起来 监听键盘事件  实现keyListener
    //为了让panel不停的重绘子弹 需要将MyPanel实现Runnable 当作线程使用
public class MyPanel extends JPanel implements KeyListener,Runnable{
    //定义自己的坦克 提供自己的构造器并初始化
    Hero hero = null;
    //定义敌人坦克放入Vector中
    Vector<EnemyTank> enemyTanks = new Vector<>();
    //定义一个Vector 用于存放炸弹
    //挡子弹击中坦克的时候 就加入一个Bomb对象到bombs
    Vector<Bomb> bombs = new Vector<>();
    int enemyTankSize = 3;
    //定义三张炸弹图片 用于显示爆炸效果
    Image image1 = null;
    Image image2 = null;
    Image image3 = null;

    public MyPanel(){
        //初始化敌人tank
        for (int i = 0; i < enemyTankSize; i++) {
            //创建一个敌人的坦克
            EnemyTank enemyTank = new EnemyTank(100 * (i + 1), 0);
            //设置方向
            enemyTank.setDirect(2);    //敌人炮筒默认向上 该个方向即可
            //启动敌人线程 动起来
            new Thread(enemyTank).start();
            //给该enemyTank 加入一颗子弹
            Shot shot = new Shot(enemyTank.getX() + 20, enemyTank.getY() + 60, enemyTank.getDirect());
            //将子弹加入到Vector 成员内
            enemyTank.shots.add(shot);
            //立即启动shot对象
            new Thread(shot).start();
            //加入
            enemyTanks.add(enemyTank);

        }
        hero = new Hero(100,100);//初始化位置

        hero.setSpeed(3);//速度倍数

        //初始化图片对象
        image1 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_1.gif"));
        image1 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_2.gif"));
        image1 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_3.gif"));
    }
    //定义paint方法

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        //做填充矩形  默认黑色
        g.fillRect(0,0,1000,750);

        if(hero != null && hero.isLive){
            //画出自己坦克-封装方法
            drawTank(hero.getX(),hero.getY(),g,hero.getDirect(),1);
        }
        //将hero的子弹集合 shots 遍历取出绘制
        for (int i = 0; i <hero.shots.size() ; i++) {
            Shot shot = hero.shots.get(i);
            //画出hero发出射击的子弹
            if(shot != null && shot.isLive != false){
                //画矩形
                g.fill3DRect(shot.x,shot.y,1,1,false);
            } else { //如果该shot对象已经无效 就从shots集合中拿掉
                hero.shots.remove(shot);
            }
        }

        //如果bombs 集合中有对象就画出
        for (int i = 0; i < bombs.size(); i++) {
            //取出炸弹
            Bomb bomb = bombs.get(i);
            //根据当前这个bomb对象的life值去画出对应的图片
            if(bomb.life > 6){
                g.drawImage(image1,bomb.x,bomb.y,60,60,this);
            } else if(bomb.life >3){
                g.drawImage(image2,bomb.x,bomb.y,60,60,this);
            } else {
                g.drawImage(image3,bomb.x,bomb.y,60,60,this);
            }
            //让炸弹生命值减少
            bomb.lifeDown();
            //如果bomb life 为 0,就从bombs 的集合中删除
            if(bomb.life == 0){
                bombs.remove(bomb);
            }
        }

        //画出坦克- 封装方法
        drawTank(hero.getX(),hero.getY(),g,hero.getDirect(),1);
        //画敌人的坦克 for循环Vector
        for (int i = 0; i < enemyTanks.size(); i++) {
            //从Vector取出坦克
            EnemyTank enemyTank = enemyTanks.get(i);
            //判断当前坦克是否还存活
            if (enemyTank.isLive) {//只有敌人坦克存活 才去画坦克
                drawTank(enemyTank.getX(), enemyTank.getY(), g, enemyTank.getDirect(), 0);
                //画出 enemyTank 所有子弹
                for (int j = 0; j < enemyTank.shots.size(); j++) {
                    Shot shot = enemyTank.shots.get(j);
                    //绘制
                    if (shot.isLive) {//isLive == false;
                        g.draw3DRect(shot.x, shot.y, 1, 1, false);
                    } else { // 从vector 移除
                        enemyTank.shots.remove(shot);
                    }
                }
            }
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
    //如果我们的坦克可以发射多个子弹
    //在判断我方子弹是否击中敌人坦克时 就需要吧我们的子弹集中
    //所以的子弹 都取出和敌人的所以坦克 进行判断

    public void hitEnemyTank(){
        //遍历我方的子弹
        for (int j = 0; j<hero.shots.size() ; j++) {
            Shot shot = hero.shots.get(j);
            if(shot != null && shot.isLive){//当我的子弹存活
                //遍历敌人所有的坦克
                for (int i = 0; i < enemyTanks.size(); i++) {
                 EnemyTank enemyTank = enemyTanks.get(i);
                       hitTank(shot,enemyTank);
                }
            }
        }
    }
    //编写方法判断敌人坦克是否集中我方坦克
    public void hitHero(){
     //遍历所有的敌人坦克
        for (int i = 0; i <enemyTanks.size(); i++) {
            EnemyTank enemyTank = enemyTanks.get(i);
            //遍历敌人的所有的子弹
            for (int j = 0; j < enemyTank.shots.size(); j++) {
                //取出当前子弹中的一颗子弹
                Shot shot = enemyTank.shots.get(j);
                //让子弹与我们坦克进行碰撞 也就是shot是不是击中我们
                if(hero.isLive && shot.isLive ){//表示我方坦克以及我方子弹都存在
                    hitTank(shot,hero);
                }
            }
        }
    }
    //编写方法： 判断我方子弹是否集中敌人坦克  hitTank()
    //什么时候击中敌方坦克 run方法
    public void hitTank(Shot s,Tank enemyTank){
        //判断s 击中Tank
        //根据方向判断 想到switch 语句
        switch (enemyTank.getDirect()){
            case 0://坦克向上
            case 2:
                if(s.x > enemyTank.getX() && s.x < enemyTank.getX() + 40
                && s.y > enemyTank.getY() && s.y < enemyTank.getY() + 60){
                    //我方挡子弹存活
                    s.isLive = false;
                    //敌方挡子弹
                    enemyTank.isLive = false;
                    //当我的子弹击中敌人之后 将enemyTank 从 Vector 拿掉
                    enemyTanks.remove(enemyTank);
                    //创建Bomb对象加入到bombs集合中
                    Bomb bomb = new Bomb(enemyTank.getX(), enemyTank.getY());
                    bombs.add(bomb);
                }
                break;
            case 1://坦克向右
            case 3:
                if(s.x > enemyTank.getX() && s.x<enemyTank.getX() + 60
                && s.y > enemyTank.getY() && s.y < enemyTank.getY() + 40){
                    //我方挡子弹存活
                    s.isLive = false;
                    //敌方挡子弹
                    enemyTank.isLive = false;
                }
                break;
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
            if(hero.getY() > 0){
                //修改坦克的坐标 y -= 1;
                hero.moveUp();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            //按下D键
            hero.setDirect(1);
            if(hero.getX() + 60 < 1000){
                hero.moveRight();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            //按下S键
            hero.setDirect(2);
            if(hero.getY() + 60 < 750){
                hero.moveDown();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            //按下A键
            hero.setDirect(3);
            if(hero.getX() > 0){
                hero.moveRight();
            }
        }
        //让面板重绘
        this.repaint();
        //如果用户按下J 就发射
        if(e.getKeyCode() == KeyEvent.VK_J){
            System.out.println("用户按下J 开始射击");
            //判断hero值的是否销毁
            //如果为空 说明没有创建子弹
            if(hero.shot == null || !hero.shot.isLive ){//或者生命周期不为空
                hero.shotEnemyTank();//shotEnemyTank()表示已经创建起来
            }
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
        //判断敌人坦克是否击中了我方
        hitHero();
        //判断是否击中了敌人的坦克
        hitEnemyTank();
        this.repaint();//不停刷新绘图区域 子弹就移动 再创建MyPanel的类去启动
    }
}
