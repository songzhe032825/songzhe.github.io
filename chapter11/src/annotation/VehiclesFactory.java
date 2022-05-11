package annotation;

/**
 * @author 宋哲
 * @version 1.0
 */
//3.创建交通工具工厂类  有两个方法分别获得交通工具 Horse和Boat
//因为工厂类 不想创建VehiclesFactory 所以用static最合适 直接用
// VehiclesFactory去调getHorse() 返回Horse()即可
public class VehiclesFactory {
    //得到一匹马最简单方式就是返回创建一匹马
    // 始终只有一匹马就够了 不用再创建新的马 怎么修改优化呢？
    //引出单例模式  饿汉式 将构造器私有化
    private static Horse horse = new Horse();//饿汉式
    //构造器私有化 不要创建新对象
    private VehiclesFactory(){}
    public static Horse getHorse(){
        return horse;
    }
    //得到交通工具最简单方式就是返回创建工具
    //一路上船儿可以有不同的 比如游艇 泰坦尼克号阿等等 可以创建
    public static Boat getBoat(){
        return new Boat();
    }

    //飞机
    public static Plane getPlane(){

        return new Plane();
    }
}
