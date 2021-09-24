package org.tupurpcheung.learn.jdk.gof.factory.abstracts;


import org.tupurpcheung.learn.jdk.gof.factory.model.KeyBoard;
import org.tupurpcheung.learn.jdk.gof.factory.model.Mouse;

public interface PcFactory {

    Mouse createMouse();

    KeyBoard createKeyBoard();
}
