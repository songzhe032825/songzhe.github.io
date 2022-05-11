package annotation;

/**
 * @author 宋哲
 * @version 1.0
 */
public class Person {
    private String name;
    private Vehicles vehicles;

    //在创建人对象时候，先给他分配交通工具  意味着构造器的属性交通工具赋值没有意义
    //引出下面的思考问题！！！！
    public Person(String name, Vehicles vehicles) {
        this.name = name;
        this.vehicles = vehicles;
    }

    //实例化Person对象“唐僧” 要求一般情况下用Horse作为交通工具 遇到大河时
    // 用Boat作为交通工具
    //核心：把具体的要求封装成方法 不要写在外面去 》这里涉及到编程思想
    //接上面的思考的问题（优化）：如何不浪费在构建对象时传入的交通工具？动脑筋
    //答：不管得船还是得马 首先要判断是否得到了船或马
    public void passRiver() {
        //先得到船  接上面为什么要VehiclesFactory不去创建对象的原因
        //VehiclesFactory去调getHorse() 返回Horse()即可
       /* Boat boat = VehiclesFactory.getBoat();
        boat.work();*/
        //如何防止既要满足交通工具传进来了又要保证不能始终使用的是马儿
        //很简单不就是判断交通工具类型吗？ 相当判断类型 instanceOf
        //vehicles instanceof Boat 是判断vehicles是不是Boat
        //1.vehicles = null : vehicles instanceof Boat => false
        //2.vehicles = 马对象 ：vehicles instanceof Boat => false
        //3.vehicles = 船对象 ：vehicles instanceof Boat => true
        if(!(vehicles instanceof Boat)){
            vehicles = VehiclesFactory.getBoat();
        }
        vehicles.work();
    }
    //同理
    public void common(){
        //得到马儿
        //判断一下 当前的 vehicles 属性是否已经存在
        //如果交通工具是null的 那么就可以获取一匹马;
        if(!(vehicles instanceof Horse)){
            //这里体现多态向上转型的机制
            //Horse horse = VehiclesFactory.getHorse();改成
            //vehicles = VehiclesFactory.getHorse();
            // 这就是接口的解耦的特性
            vehicles = VehiclesFactory.getHorse();
        }
        //这里优化后的代码 调用work方法是通过接口调用 而不是对象调用
        vehicles.work();
    }

    public void sailing(){
        if(!(vehicles instanceof Plane)){
            vehicles = VehiclesFactory.getPlane();
        }
        vehicles.work();
    }
}