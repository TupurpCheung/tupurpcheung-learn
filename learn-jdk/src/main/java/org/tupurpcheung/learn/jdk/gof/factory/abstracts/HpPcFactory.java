package org.tupurpcheung.learn.jdk.gof.factory.abstracts;


import org.tupurpcheung.learn.jdk.gof.factory.model.HpKeyBoard;
import org.tupurpcheung.learn.jdk.gof.factory.model.HpMouse;
import org.tupurpcheung.learn.jdk.gof.factory.model.KeyBoard;
import org.tupurpcheung.learn.jdk.gof.factory.model.Mouse;

public class HpPcFactory implements PcFactory {
    @Override
    public Mouse createMouse() {
        return new HpMouse();
    }

    @Override
    public KeyBoard createKeyBoard() {
        return new HpKeyBoard();
    }
}
