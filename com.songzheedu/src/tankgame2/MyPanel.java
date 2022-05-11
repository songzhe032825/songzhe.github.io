package tankgame2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
public class MyPanel extends JPanel implements KeyListener {
    //定义自己的坦克 提供自己的构造器并初始化
    Hero hero = null;
    public MyPanel(){

        hero = new Hero(100,100);//初始化位置

        hero.setSpeed(3);//速度倍数
    }
    //定义paint方法

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        //做填充矩形  默认黑色
        g.fillRect(0,0,1000,750);


        //画出坦克- 封装方法
        drawTank(hero.getX(),hero.getY(),g,hero.getDirect(),1);
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
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
