package com.tupurpcheung.java.gof.factory.model;

public class HpMouse implements Mouse {
    @Override
    public void click() {
        System.out.println("==惠普鼠标点击==");
    }
}
