package com.hspedu.extend_01.improve_;

import com.hspedu.extend_01.Graduate;
import com.hspedu.extend_01.Pupil;

public class Extend01 {
    public static void main(String[] args) {
        com.hspedu.extend_01.Pupil pupil = new Pupil();
        pupil.name = "银角大王~";
        pupil.age = 80;
        pupil.testing();
        pupil.setScore(56);
        pupil.showInfo();

        com.hspedu.extend_01.Graduate graduate = new Graduate();
        graduate.name = "金角大王~";
        graduate.age = 39;
        graduate.testing();
        graduate.setScore(100);
        pupil.showInfo();
    }
}
