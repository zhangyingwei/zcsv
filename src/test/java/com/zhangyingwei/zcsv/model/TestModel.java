package com.zhangyingwei.zcsv.model;

/**
 * Created by zhangyw on 2017/8/7.
 */
public class TestModel {
    private String name;
    private Integer age;

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "TestModel{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
