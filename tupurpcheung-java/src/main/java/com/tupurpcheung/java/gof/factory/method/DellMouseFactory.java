package com.tupurpcheung.java.gof.factory.method;


import com.tupurpcheung.java.gof.factory.model.DellMouse;
import com.tupurpcheung.java.gof.factory.model.Mouse;

public class DellMouseFactory implements MouseFactory {
    @Override
    public Mouse getInstance() {
        return new DellMouse();
    }
}
