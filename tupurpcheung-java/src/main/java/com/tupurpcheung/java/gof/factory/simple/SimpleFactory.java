package com.tupurpcheung.java.gof.factory.simple;

import com.tupurp.learn.gof.factory.model.DellMouse;
import com.tupurp.learn.gof.factory.model.HpMouse;
import com.tupurp.learn.gof.factory.model.Mouse;

/*
*
* 简单工厂
*
* 简单工厂模式不是23种里的一种
* 只是一个专门生产某个产品的类。
*
* */
public class SimpleFactory {

    Mouse getInstance(String mouse){
        switch (mouse){
            case "dell":
                return new DellMouse();

            case "hp":
                return new HpMouse();

            default:
                return null;
        }

    }
}
