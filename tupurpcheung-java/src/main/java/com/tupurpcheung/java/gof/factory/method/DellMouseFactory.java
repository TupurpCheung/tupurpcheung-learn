package com.tupurpcheung.java.gof.factory.method;

import com.tupurp.learn.gof.factory.model.DellMouse;
import com.tupurp.learn.gof.factory.model.Mouse;

public class DellMouseFactory implements MouseFactory {
    @Override
    public Mouse getInstance() {
        return new DellMouse();
    }
}
