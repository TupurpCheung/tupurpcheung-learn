package com.tupurpcheung.java.gof.factory.abstracts;

import com.tupurp.learn.gof.factory.model.KeyBoard;
import com.tupurp.learn.gof.factory.model.Mouse;

public interface PcFactory {

    Mouse createMouse();

    KeyBoard createKeyBoard();
}
