package com.zhangyingwei.zcsv.exporter;

import com.zhangyingwei.zcsv.config.CsvConfig;
import com.zhangyingwei.zcsv.handler.CsvHandler;
import com.zhangyingwei.zcsv.utils.FileUtils;
import java.io.IOException;
import java.util.Map;

/**
 * Created by zhangyw on 2017/8/7.
 */
public class CsvExporter implements Exporter {


    private CsvConfig config;

    public CsvExporter(CsvConfig config) {
        this.config = config;
    }

    @Override
    public void export(CsvHandler handler) {
        Map<String,String> pages = handler.listPages(this.config);
        System.out.println("INFO: page-size: "+ this.config.getPageSize());
        System.out.println("INFO: page-count: "+ pages.size());
        pages.entrySet().stream().forEach(entity -> {
            try {
                FileUtils.writePage(entity.getKey(), entity.getValue());
                System.out.println("INFO: export success - " + entity.getKey());
            } catch (IOException e) {
                System.out.println("ERROR: write content into page error");
                e.printStackTrace();
            }
        });
    }
}
