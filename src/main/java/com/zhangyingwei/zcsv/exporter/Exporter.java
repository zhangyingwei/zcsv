package com.zhangyingwei.zcsv.exporter;

import com.zhangyingwei.zcsv.handler.CsvHandler;

/**
 * Created by zhangyw on 2017/8/7.
 */
public interface Exporter {
    void export(CsvHandler handler);
}
