package org.tupurpcheung.learn.jdk.gof.factory.method;


import org.tupurpcheung.learn.jdk.gof.factory.model.HpMouse;
import org.tupurpcheung.learn.jdk.gof.factory.model.Mouse;

public class HpMouseFactory implements MouseFactory {
    @Override
    public Mouse getInstance() {
        return new HpMouse();
    }
}
