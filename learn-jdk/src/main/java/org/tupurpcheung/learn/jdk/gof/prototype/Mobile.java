package org.tupurpcheung.learn.jdk.gof.prototype;

import java.io.Serializable;
import java.util.Objects;

public class Mobile implements Serializable,Cloneable {
    private String model = "苹果7";

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mobile mobile = (Mobile) o;
        return Objects.equals(model, mobile.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model);
    }

    @Override
    public String toString() {
        return "Mobile{" +
                "model='" + model + '\'' +
                '}';
    }

    @Override
    protected Object clone()throws CloneNotSupportedException{
        return super.clone();
    }

}
