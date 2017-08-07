package com.zhangyingwei.zcsv.handler;

import com.zhangyingwei.zcsv.config.CsvConfig;

import java.util.List;
import java.util.Map;

/**
 * Created by zhangyw on 2017/8/7.
 */
public interface ICsvHandler {
    Map<String, String> listPages(CsvConfig config);
    <E> E tramslate(List<String[]> items,Class... resultClass);
}
