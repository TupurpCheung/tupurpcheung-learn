package com.tupurpcheung.java.gof.factory.abstracts;


import com.tupurpcheung.java.gof.factory.model.KeyBoard;
import com.tupurpcheung.java.gof.factory.model.Mouse;

public interface PcFactory {

    Mouse createMouse();

    KeyBoard createKeyBoard();
}
