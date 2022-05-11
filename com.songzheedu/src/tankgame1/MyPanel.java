package tankgame1;

import javax.swing.*;
import java.awt.*;

/**
 * @author 宋哲
 * @version 1.0\
 * 坦克大战的绘图区域
 * @param "x" 坦克的左上角x坐标
 * @param "y" 坦克左上角的y坐标
 * @param "g" 画笔
 * @param "direct" 坦克方向（上下左右）
 * @param "type" 坦克类型（敌我类型）
 */
public class MyPanel extends JPanel {
    //定义自己的坦克 提供自己的构造器并初始化
    Hero hero = null;
    public MyPanel(){
        hero = new Hero(100,100);//初始化位置
    }
    //定义paint方法

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        //做填充矩形  默认黑色
        g.fillRect(0,0,1000,750);


        //画出坦克- 封装方法
        drawTank(hero.getX(),hero.getY(),g,0,0);
    }
    //编写方法  画出坦克 x , y 坦克坐标 以这个为参考点 direct :坦克方向
    public void drawTank(int x , int y ,Graphics g, int direct,int type){
        //根据不同类型的坦克 ，设置不同的颜色
        switch (type){
            case 0://我方坦克
                g.setColor(Color.cyan);
                break;
            case 1://敌方坦克
                g.setColor(Color.red);
                break;
        }
        //根据坦克方向来绘制坦克
        switch (direct){
            case 0:
                g.fill3DRect(x,y,10,60,false);//左轮字
                g.fill3DRect(x+30,y,10,60,false);//左轮字
                g.fill3DRect(x+10,y+10,20,40,false);//坦克盖子
                g.fillOval(x+10,y+20,20,20);//坦克圆形盖子
                g.drawLine(x+20,y+30,x+20,y);//坦克炮筒
                break;
            default:
                System.out.println();
        }
    }
}
