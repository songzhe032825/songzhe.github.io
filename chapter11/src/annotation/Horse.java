package annotation;

/**
 * @author 宋哲
 * @version 1.0
 */
public class Horse implements Vehicles{
    @Override
    public void work() {
        System.out.println("一般情况,使用骏马前进");
    }
}
