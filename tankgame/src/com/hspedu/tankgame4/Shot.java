package com.hspedu.tankgame4;

/**
 * @author 宋哲
 * @version 1.0
 * 射击子弹
 *
 * 思路分析：如何实现当用户按下J键 我们的坦克就发射一颗子弹
 * 1. 当发射一颗子弹后 就相当于启动一个线程
 * 2. Hero有子弹的对象 当按下J时 我们就启动一个发射行为（线程）让子弹不停的移动，形成发射效果
 * 3. 我们MyPanel 需要不停的重绘子弹 才能出现该效果
 * 4。当子弹移动到面板的边界时  就应该销毁（把启动的子弹的线程销毁）
 */
@SuppressWarnings({"all"})
public class Shot implements Runnable{
     int x; //子弹x坐标
     int y; //子弹y坐标
     int direct = 0; //子弹随着炮筒方向而改变
     int speed = 2; //子弹速度
    //加一个属性记录子弹是否存活
    boolean isLive =true;

    public Shot(int x, int y, int direct, int speed) {
        this.x = x;
        this.y = y;
        this.direct = direct;
        this.speed = speed;
    }

    public Shot(int x, int y, int direct) {
        this.x = x;
        this.y = y;
        this.direct = direct;
    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDirect() {
        return direct;
    }

    public void setDirect(int direct) {
        this.direct = direct;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public void run() {//射击行为  目的：改变子弹的横纵坐标
        //肯定是while循环 什么时候射击行为消失？
        //思路分析第4条：当子弹移动到面板的边界时 就应该销毁
        //当子弹碰到敌人时候 也应该结束结束线程
        while (true){
            //需要休眠一下 画一颗子弹！！
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //根据方向来改变x,y坐标  switch语句
            switch (direct){
                case 0:  //上
                    y -= speed;
                    break;
                case 1:  //右
                    x += speed;
                    break;
                case 2:  //下
                    y += speed;
                    break;
                case 3:  //左
                    x -= speed;
                    break;
            }
            //测试 看效果输出x,y坐标
            System.out.println("子弹 x=" + x + "y=" + y);
            //判断当子弹移动到面板的边界时 就应该销毁
            if(!(x>=0 && x<=1000 && y>=0 && y<= 750 && isLive)){
                //isLive跟线程课程变量loop一样
                isLive = false;
                //此时碰到边界了 需要break退出子弹线程
                break;
            }
        }
    }
}
