package com.tupurpcheung.java.gof.factory.abstracts;

import com.tupurp.learn.gof.factory.model.DellKeyBoard;
import com.tupurp.learn.gof.factory.model.DellMouse;
import com.tupurp.learn.gof.factory.model.KeyBoard;
import com.tupurp.learn.gof.factory.model.Mouse;

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
