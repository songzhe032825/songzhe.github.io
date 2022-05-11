package com.hspedu.extend_.exercise;

public class Test {
    public static void main(String[] args) {
        PC pc = new PC("intel",500,23,"IBM");
        pc.printInfo();
        NotePad notePad = new NotePad("intel",500,23,"白色");
        notePad.printInfo();
    }
}
