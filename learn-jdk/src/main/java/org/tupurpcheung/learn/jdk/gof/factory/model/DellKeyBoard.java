package org.tupurpcheung.learn.jdk.gof.factory.model;

public class DellKeyBoard implements KeyBoard {
    @Override
    public void print() {
        System.out.println("==戴尔键盘输入==");
    }
}
