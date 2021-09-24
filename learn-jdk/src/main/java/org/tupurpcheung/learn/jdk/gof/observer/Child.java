package org.tupurpcheung.learn.jdk.gof.observer;


import java.util.ArrayList;
import java.util.List;

/**
 * @description: 观察者模式的被观察者
 * @author: tupurp
 * @create: 2020-06-17 01:16
 */
public class Child {

    private List<Observer> observerList = new ArrayList<>();

    public void addObserver(Observer observer){
        observerList.add(observer);
    }

    public void wakeup(){
        System.out.println("婴儿哭了起来");
        Event<Child> event = new WakeUpEvent(this);
        for(Observer observer:observerList){
            observer.actionPerform(event);
        }
    }


    public static void main(String[] args){
        Child child = new Child();
        child.addObserver(new DogObserver());
        child.addObserver(new MomObserver());
        child.wakeup();
    }

}