package com.hspedu.pkg;
//一个类中最多只有一句package

//import指令  位置放在package的下面 在类定义前面 可以有多句且没有顺序要求
import java.util.Arrays;
import java.util.Scanner;

public class PkgDetail {
    public static void main(String[] args) {
        /*
        * 注意事项和使用细节
        * 1.package 的作用是声明当前类所在的包 需要放在类的最上面
        * 2.import指令位置放在package的下面  在类定义前面 可以有很多句且没有
        * 顺序要求
        * */
        Scanner scanner = new Scanner(System.in);
        int[] arr = {0,-1,33,777};
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + "\t");
        }
    }
}
