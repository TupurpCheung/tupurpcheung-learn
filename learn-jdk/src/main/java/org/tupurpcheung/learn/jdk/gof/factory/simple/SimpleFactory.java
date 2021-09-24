package org.tupurpcheung.learn.jdk.gof.factory.simple;


import org.tupurpcheung.learn.jdk.gof.factory.model.DellMouse;
import org.tupurpcheung.learn.jdk.gof.factory.model.HpMouse;
import org.tupurpcheung.learn.jdk.gof.factory.model.Mouse;

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
