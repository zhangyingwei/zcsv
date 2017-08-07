package com.zhangyingwei.zcsv.model;

import com.zhangyingwei.zcsv.config.CsvConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author: zhangyw
 * @date: 2017/8/6
 * @time: 下午9:39
 * @desc:
 */
public class CsvModel {
    private List<Row> rows;
    private CsvConfig config;
    public CsvModel(List<Row> rows, CsvConfig config) {
        this.rows = rows;
        this.config = config;
    }

    public CsvModel(CsvConfig config) {
        this.config = config;
    }

    public CsvModel addRow(Row row){
        if(this.rows == null){
            this.rows = new ArrayList<Row>();
        }
        rows.add(row);
        return this;
    }

    public Map<String, String> getPages(){
        Map<String,String> pages = new HashMap<String,String>();
        int pageSize = this.config.getPageSize();
        System.out.println("INFO: total:" + rows.size());
        if(pageSize == -1){
            List<String> pageLines = rows.stream().map(line -> line.getLineOfString()).collect(Collectors.toList());
            String page = String.join("\n", pageLines);
            pages.put(config.bulidFilePath(), page);
            return pages;
        }else{
            int size = 0;
            int part = 0;
            List<String> page = new ArrayList<String>();
            for (int i = 0; i < rows.size(); i++) {
                size ++;
                page.add(rows.get(i).getLineOfString());
                if (size == this.config.getPageSize() || i + 1 == rows.size()) {
                    pages.put(config.bulidFilePath(part++), String.join("\n", page));
                    page.clear();
                    size = 0;
                }
            }
        }
        return pages;
    }
}
