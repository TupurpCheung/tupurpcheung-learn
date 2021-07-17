package com.tupurpcheung.java.gof.factory.method;

import com.tupurp.learn.gof.factory.model.HpMouse;
import com.tupurp.learn.gof.factory.model.Mouse;

public class HpMouseFactory implements MouseFactory {
    @Override
    public Mouse getInstance() {
        return new HpMouse();
    }
}
