package com.zhangyingwei.zcsv.handler;

import com.zhangyingwei.zcsv.model.CsvModel;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by zhangyw on 2017/8/7.
 */
public class ObjectHandlerTest {

    @Test
    public void testFields(){
        Object obj = new CsvModel(null);
        Class clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        Arrays.stream(fields).forEach(f -> {
            System.out.println(f.getName());
        });
    }

}