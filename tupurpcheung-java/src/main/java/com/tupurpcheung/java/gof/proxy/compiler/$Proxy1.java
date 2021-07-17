package com.tupurpcheung.java.gof.proxy.compiler;





import com.tupurpcheung.java.gof.proxy.Animal;

import java.lang.reflect.Method;

public class $Proxy1 implements Animal {
    InvocationHandler h;
    public $Proxy1(InvocationHandler h) {
        this.h = h;
    }
    @Override
    public void shout() {
        try{
            Method md = Animal.class.getMethod("shout");
            h.invoke(this, md);
        }catch(Exception e){e.printStackTrace();}
    }

    @Override
    public void run() {
        try{
            Method md = Animal.class.getMethod("run");
            h.invoke(this, md);
        }catch(Exception e){e.printStackTrace();}
    }
}