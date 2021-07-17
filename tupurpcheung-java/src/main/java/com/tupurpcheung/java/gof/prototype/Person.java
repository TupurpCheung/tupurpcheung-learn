package com.tupurpcheung.java.gof.prototype;

import java.io.*;
import java.util.Objects;

public class Person implements Serializable,Cloneable {
    private String name = "张抚州";
    private int age = 24;
    private String sex = "男";

    private Mobile mobile;

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Mobile getMobile() {
        return mobile;
    }

    public void setMobile(Mobile mobile) {
        this.mobile = mobile;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name) &&
                Objects.equals(sex, person.sex) &&
                Objects.equals(mobile, person.mobile);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, sex, mobile);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", mobile=" + mobile +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object obj = null;
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(this);
            oos.flush();
            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);
            obj = ois.readObject();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return obj;
    }
}
