package draw;

import javax.swing.*;
import java.awt.*;

/**
 * @author 宋哲
 * @version 1.0
 * 演示如何在面板上画圆
 */
public class DrawCircle extends JFrame{  //对应一个窗口 可以理解成是画框
    private MyPanel mp = null;
    public static void main(String[] args) {
        //如何运用 1.继承JFrame(框架)
        new DrawCircle();
    }
        //建立一个构造器
    public DrawCircle(){
        //初始话一个面板
         mp = new MyPanel();
         //把面板放在窗口内(画框)
        this.add(mp);
        //设置窗口大小 400,300 像素
        this.setSize(400,300);
        //当点击窗口小叉 程序真正完全退出
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
        this.setVisible(true);//可以显示
    }
}
/*1.先定义一个面板MyPanel 继承JPanel 画图形 就在面板上画
*
*
* */
class MyPanel extends JPanel {
    //老汉说明：1.MyPanel就是一个画板
    //2.Graphics 理解成一只画笔
    //3.Graphics idea提供很多绘图方法
    @Override
    public void paint(Graphics g) {
        //绘图一个方法  调用父类的方法完成初始化
        super.paint(g);
        //画一个圆形方法 x:绘制椭圆的左上角X坐标 y:绘制椭圆的左上角Y坐标
        //width: 绘制椭圆的宽度 height：绘制椭圆的高度 像素
        g.drawOval(10,10,100,100);

        //演绎绘制不同的图形 常用方法
         //画直线： drawLine
         g.drawLine(10,10,100,100);
         //画矩形边框 drawRect
         g.drawRect(10,10,100,100);
        //设置画笔颜色
        g.setColor(Color.blue);
        //填充矩形
        g.fillRect(10,10,100,100);
        //填充椭圆
        g.fillOval(10,10,100,100);
        g.setColor(Color.green);
        //画图片 1.加载图片资源
        //2.图片粘贴到out下的根目录(com.songzheedu)
        //3.写图片路径前面前加一个/ 再写图片名称
        Image image = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/WIN_20220125_10_45_45_Pro.jpg"));
        g.drawImage(image,10,10,1280,720,this);
        //画字符串  就是写字 一般给画笔设计颜色
        g.setColor(Color.red);
        //设置画笔的字体
        g.setFont(new Font("宋体",Font.BOLD,50));
        g.drawString("北京你好",100,100);
    }
}