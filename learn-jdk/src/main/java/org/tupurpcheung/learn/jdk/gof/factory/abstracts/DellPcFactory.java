package org.tupurpcheung.learn.jdk.gof.factory.abstracts;


import org.tupurpcheung.learn.jdk.gof.factory.model.DellKeyBoard;
import org.tupurpcheung.learn.jdk.gof.factory.model.DellMouse;
import org.tupurpcheung.learn.jdk.gof.factory.model.KeyBoard;
import org.tupurpcheung.learn.jdk.gof.factory.model.Mouse;

public class DellPcFactory implements PcFactory {
    @Override
    public Mouse createMouse() {
        return new DellMouse();
    }

    @Override
    public KeyBoard createKeyBoard() {
        return new DellKeyBoard();
    }
}
