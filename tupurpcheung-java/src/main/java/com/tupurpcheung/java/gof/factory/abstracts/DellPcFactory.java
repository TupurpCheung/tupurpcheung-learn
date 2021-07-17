package com.tupurpcheung.java.gof.factory.abstracts;


import com.tupurpcheung.java.gof.factory.model.DellKeyBoard;
import com.tupurpcheung.java.gof.factory.model.DellMouse;
import com.tupurpcheung.java.gof.factory.model.KeyBoard;
import com.tupurpcheung.java.gof.factory.model.Mouse;

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
