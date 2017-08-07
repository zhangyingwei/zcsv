package com.zhangyingwei.zcsv.handler;

import com.zhangyingwei.zcsv.config.CsvConfig;
import com.zhangyingwei.zcsv.model.CsvModel;
import com.zhangyingwei.zcsv.model.Row;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by zhangyw on 2017/8/7.
 */
public class MapHandler extends DefaultHandler {
    public MapHandler() {
    }

    public MapHandler(Map<String,String> mapPage) {
        super(trans(mapPage));
    }

    private static List<String[]> trans(Map<String, String> mapPage) {
        return mapPage.entrySet().stream().map(entity -> {
            return new String[]{entity.getKey(), entity.getValue()};
        }).collect(Collectors.toList());
    }

    @Override
    public <E> E tramslate(List<String[]> items, Class... resultClass) {
        Map<String, String> resultMap = new HashMap<String,String>();
        items.stream().forEach(item -> resultMap.put(item[0],item[1]));
        return (E) resultMap;
    }
}
