package com.tupurpcheung.java.gof.factory.abstracts;

import com.tupurp.learn.gof.factory.model.HpKeyBoard;
import com.tupurp.learn.gof.factory.model.HpMouse;
import com.tupurp.learn.gof.factory.model.KeyBoard;
import com.tupurp.learn.gof.factory.model.Mouse;

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
