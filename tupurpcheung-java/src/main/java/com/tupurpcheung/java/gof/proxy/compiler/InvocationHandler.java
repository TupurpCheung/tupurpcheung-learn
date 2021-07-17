package com.tupurpcheung.java.gof.proxy.compiler;

import java.lang.reflect.Method;

/*
* 调用处理器
*
* 通过反射调用被代理对象的方法，并在前后增加自己的逻辑
* */
public interface InvocationHandler {

    /*
    * @param proxy 代理对象
    * @param method 被代理的方法
    *
    * */
    Object invoke(Object proxy, Method method) throws Exception;
}
