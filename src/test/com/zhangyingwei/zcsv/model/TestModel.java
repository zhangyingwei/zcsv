package com.zhangyingwei.zcsv.model;

/**
 * Created by zhangyw on 2017/8/7.
 */
public class TestModel {
    private String name;
    private int age;

    public TestModel() {
    }

    public TestModel(String name, int age) {
        this.name = name;
        this.age = age;
    }

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
}
