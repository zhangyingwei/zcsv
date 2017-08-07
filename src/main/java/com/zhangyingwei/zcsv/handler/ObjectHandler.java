package com.zhangyingwei.zcsv.handler;

import com.sun.corba.se.impl.io.TypeMismatchException;
import com.zhangyingwei.zcsv.utils.ObjectUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by zhangyw on 2017/8/7.
 */
public class ObjectHandler extends DefaultHandler {

    public ObjectHandler() {
    }

    public ObjectHandler(List<Object> objects) {
        super(trans(objects));
    }

    private static List<String[]> trans(List<Object> objects) {
        return objects.stream().map(obj -> {
            return ObjectUtils.getValues(obj);
        }).collect(Collectors.toList());
    }

    @Override
    public <E> E tramslate(List<String[]> items,Class... resultClass) {
        if (resultClass == null || resultClass.length == 0 || resultClass[0] == null) {
            throw new TypeMismatchException("返回值类型不存在");
        }
        Class resultType = resultClass[0];
        try {
            List list = new ArrayList();
            Class clazz = resultType;
            for (String[] item : items) {
                Object obj = clazz.newInstance();
                List<Method> methods = Arrays.stream(clazz.getMethods())
                        .filter(method -> method.getName().startsWith("set"))
                        .collect(Collectors.toList());
                for (int i = 0; i < item.length; i++) {
                    try {
                        Parameter[] paras = methods.get(i).getParameters();
                        Class arg0 = paras[0].getType();
                        methods.get(i).setAccessible(true);
                        if("java.lang.String".equals(arg0.getName())){
                            methods.get(i).invoke(obj, item[i]);
                        } else if("int".equals(arg0.getName()) || "java.lang.Integer".equals(arg0.getName())){
                            methods.get(i).invoke(obj, Integer.parseInt(item[i]));
                        }
                    } catch (InvocationTargetException e) {
                        System.out.println("ERROR: "+e.getMessage());
                    }
                }
                list.add(obj);
            }
            return (E) list;
        } catch (IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }
}
