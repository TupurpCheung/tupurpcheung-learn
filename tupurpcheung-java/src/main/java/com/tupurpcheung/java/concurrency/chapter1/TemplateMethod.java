package com.tupurpcheung.java.concurrency.chapter1;

/**
 * @author @tupurp
 * @date 2019/2/27 16:59
 * 模板方法
 */
public abstract class TemplateMethod {

    public final void print(String message){
        System.out.println("######################");
        wrapPrint(message);
        System.out.println("######################");

    }

    protected  void wrapPrint(String message){

    }

    public static  void main(String[] args){
        TemplateMethod tm = new TemplateMethod(){
            @Override
            protected void wrapPrint(String message){
                System.out.println("**" + message + "**");
            }
        };
        tm.print("hello tm");

        TemplateMethod tm2 = new TemplateMethod(){
            @Override
            protected void wrapPrint(String message){
                System.out.println("++" + message + "++");
            }
        };
        tm2.print("hello tm2");


    }
}
