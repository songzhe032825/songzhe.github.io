package event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author 宋哲
 * @version 1.0
 * java事件处理机制
 * 演示小球 通过键盘控制上下左右移动 -》 引出知识点：讲解java事件处理机制
 */
public class BallMove extends JFrame{//窗口
     MyPanel mp= null;
    public static void main(String[] args) {
        BallMove ballMove = new BallMove();
    }
    //构造器
    public BallMove(){
        mp = new MyPanel();
        this.add(mp);
        this.setSize(400,300);
        //this代表窗口JFrame 对象可以监听键盘事件监听键盘事件 既可以到面板发生的键盘事件
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
//先写面板 可以画出小球
//KeyListener 监听器 监听键盘事件
class MyPanel extends JPanel implements KeyListener {
    //为了让小球移动 把他的左上角的坐标设置变量 x y 表示左上角的坐标
    int x =10;
    int y = 10;
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillOval(x,y,20,20);//默认黑色
    }


    //有字符输出 该方法就会触发
    @Override
    public void keyTyped(KeyEvent e) {

    }
    //当某个键按下去就会触发
    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println((char) e.getKeyCode() +"被按下...");
        //根基用户按下的不同键位  来处理小球移动 上下左右
        if(e.getKeyCode() == KeyEvent.VK_DOWN){//KeyEvent.VK_DOWN 向下的箭头对应的code值
            y++;
        } else if(e.getKeyCode() == KeyEvent.VK_UP){ //向上的箭头J控制
            y--;
        } else if(e.getKeyCode() == KeyEvent.VK_LEFT) { //向左的箭头控制
            x--;
        } else if(e.getKeyCode() == KeyEvent.VK_RIGHT){//向右的箭头控制
            x++;
        }
        //让面板重新画一次  当第一次在屏幕显示 程序会自动调用
        // 重新触发paint方法三种方式
        /*1.窗口最小化 再最大化
        * 2.窗口的大小发生变化
        * 3.repaint 方法被调用
        * */
        this.repaint();
    }
    //当某个键松开了就会触发 在这里加上处理机制
    @Override
    public void keyReleased(KeyEvent e) {

    }
}
