package tankgame1;

import javax.swing.*;

/**
 * @author 宋哲
 * @version 1.0
 */
public class TankGame01 extends JFrame {
    //定义MyPanel
    MyPanel mp = null;
    public static void main(String[] args) {
        TankGame01 tankGame01 = new TankGame01();

    }
    public TankGame01(){//构造器的固定模式
        mp = new MyPanel();
        this.add(mp);//把面板(游戏的绘图区域)添加进去
        this.setSize(1000,750);//设置大小
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置关闭窗口
        this.setVisible(true);
    }
}
