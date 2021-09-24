package org.tupurpcheung.learn.jdk.gof.factory.method;


import org.tupurpcheung.learn.jdk.gof.factory.model.DellMouse;
import org.tupurpcheung.learn.jdk.gof.factory.model.Mouse;

public class DellMouseFactory implements MouseFactory {
    @Override
    public Mouse getInstance() {
        return new DellMouse();
    }
}
