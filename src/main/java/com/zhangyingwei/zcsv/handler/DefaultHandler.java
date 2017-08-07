package com.zhangyingwei.zcsv.handler;

import com.zhangyingwei.zcsv.config.CsvConfig;
import com.zhangyingwei.zcsv.model.CsvModel;
import com.zhangyingwei.zcsv.model.Row;

import java.util.Arrays;
import java.util.List;

/**
 * Created by zhangyw on 2017/8/7.
 */
public class DefaultHandler extends CsvHandler {

    public DefaultHandler() {
    }

    public DefaultHandler(List<String[]> page) {
        super(page);
    }


    CsvModel bulidCsvModels(List<String[]> page, CsvConfig config){
        CsvModel model = new CsvModel(config);
        page.stream().map(line -> {
            return new Row(Arrays.asList(line), config.getSpliter());
        }).forEach(row -> {
            model.addRow(row);
        });
        return model;
    }

    @Override
    public <E> E tramslate(List<String[]> items, Class... resultClass) {
        return (E) items;
    }
}
