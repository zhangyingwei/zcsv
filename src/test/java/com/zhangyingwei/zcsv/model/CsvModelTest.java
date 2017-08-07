package com.zhangyingwei.zcsv.model;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by zhangyw on 2017/8/7.
 */
public class CsvModelTest {
    @Test
    public void hello(){
        System.out.println("hello");
    }

    @Test
    public void joinTest(){
        System.out.println(String.join("\n",new ArrayList<String>(){
            {
                add("a");
                add("b");
                add("c");
                add("d");
            }
        }));
    }
}