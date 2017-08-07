package com.zhangyingwei.zcsv.utils;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by zhangyw on 2017/8/7.
 */
public class ObjectUtils {

    public static String[] getValues(Object obj) {
        if(obj == null){
            return new String[0];
        }
        Class clazz = obj.getClass();
        Method[] methods = clazz.getMethods();
        return getValuesByMethods(obj,clazz,methods);
    }

    private static String[] getValuesByMethods(Object obj, Class clazz, Method[] methods) {
        List<String> fs = Arrays.stream(clazz.getDeclaredFields()).map(field -> field.getName()).collect(Collectors.toList());
        List<String> result = new ArrayList<String>();
        Arrays.stream(methods)
                .filter(method -> method.getName().startsWith("get"))
                .filter(method -> fs.stream().map(f -> f.toLowerCase()).collect(Collectors.toList()).contains(method.getName().replaceFirst("get","").toLowerCase()))
                .forEach(method -> {
                    try {
                        Object mRes = method.invoke(obj);
                        result.add(mRes==null?"":mRes.toString());
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                });
        return result.toArray(new String[result.size()]);
    }
}
