package annotation;

/**
 * @author 宋哲
 * @version 1.0
 */
public class Homework08 {
    /*枚举类
    * 1.创建一个Color枚举类
    * 2.有RED BLUE BLACK YELLOW GREEN 这个五个枚举值/对象
    * 3.Color有三个属性redValue greenValue blueValue
    * 4.创建构造方法 参数包括这三个属性
    * 5.每个枚举值都要给这三个属性赋值 三个属性对应的值分别是
    * 6：red:255,0,0 blue:0,0,255 black:0,0,0 yellow:255,255,0
    * green:0,255,0
    * 7:定义接口，里面有方法show,要求Color实现该接口
    * 8.show方法中显示三属性的值
    * 9.将枚举对象在switch语句中匹配使用
    * */
    public static void main(String[] args) {
        //Color2.GREEN 这里可以切换其他颜色输出效果
        Color2 color2 = Color2.GREEN;
        color2.show();

        //enum 在switch中使用
        //如何使用就是switch 里放枚举对象color2 然后进行比较
        switch (color2){
            case GREEN:
                System.out.println("匹配的绿色");
                break;
            case RED:
                System.out.println("匹配的红色");
                break;
            case BLACK:
                System.out.println("匹配的黑色");
                break;
            case YELLOW:
                System.out.println("匹配的黄色");
                break;
            case BLUE:
                System.out.println("匹配的蓝色");
                break;
            default:
                System.out.println("没有匹配到");
        }
    }
}
//枚举
enum Color2 implements ICu{
    RED(255,0,0 ),
    BLUE(0,0,255),
    BLACK(0,0,0),
    YELLOW(255,255,0),
    GREEN(0,255,0);

    private int redValue;
    private int greenValue;
    private int blueValue;

    private Color2(int redValue, int greenValue, int blueValue) {
        this.redValue = redValue;
        this.greenValue = greenValue;
        this.blueValue = blueValue;
    }

    public int getRedValue() {
        return redValue;
    }

    public int getGreenValue() {
        return greenValue;
    }

    public int getBlueValue() {
        return blueValue;
    }

    @Override
    public void show() {
        System.out.println("redValue=" + redValue + "greenValue ="+
                greenValue + "blueValue" + blueValue);
    }
}
