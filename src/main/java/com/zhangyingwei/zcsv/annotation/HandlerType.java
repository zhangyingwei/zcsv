package com.zhangyingwei.zcsv.annotation;

import com.zhangyingwei.zcsv.handler.MapHandler;
import com.zhangyingwei.zcsv.handler.ObjectHandler;

/**
 * Created by zhangyw on 2017/8/7.
 */
public enum HandlerType {
    DEFAULTHANDLER(DefaultHandler.class),
    MAPHANDLER(MapHandler.class);
//    OBJECTHANDLER(ObjectHandler.class);

    private Class name;
    HandlerType(Class name) {
        this.name = name;
    }
    public void setName(Class name) {
        this.name = name;
    }

    public Class getName() {
        return name;
    }
}
