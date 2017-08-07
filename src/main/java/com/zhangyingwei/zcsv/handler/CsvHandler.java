package com.zhangyingwei.zcsv.handler;

import com.zhangyingwei.zcsv.config.CsvConfig;
import com.zhangyingwei.zcsv.model.CsvModel;
import com.zhangyingwei.zcsv.model.Row;

import java.util.List;
import java.util.Map;

/**
 * Created by zhangyw on 2017/8/7.
 */
public abstract class CsvHandler implements ICsvHandler {
    private CsvModel csvModel;
    private List<String[]> page;

    public CsvHandler() {
    }

    public CsvHandler(List<String[]> page) {
        this.page = page;
    }

    abstract CsvModel bulidCsvModels(List<String[]> page, CsvConfig config);

    @Override
    public Map<String, String> listPages(CsvConfig config){
        return bulidCsvModels(this.page, config).getPages();
    }

}
