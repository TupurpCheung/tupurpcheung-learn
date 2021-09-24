package org.tupurpcheung.learn.jdk.gof.factory.model;

public class DellMouse implements Mouse {
    @Override
    public void click() {
        System.out.println("==戴尔鼠标点击==");
    }
}
