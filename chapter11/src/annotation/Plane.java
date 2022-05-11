package annotation;

/**
 * @author 宋哲
 * @version 1.0
 */
public class Plane implements Vehicles{
    @Override
    public void work() {
        System.out.println("唐僧使用飞机 过火焰山");
    }
}
