package annotation;

/**
 * @author 宋哲
 * @version 1.0
 */
public class Boat implements Vehicles{
    @Override
    public void work() {
        System.out.println("过河时候使用小船");
    }
}
