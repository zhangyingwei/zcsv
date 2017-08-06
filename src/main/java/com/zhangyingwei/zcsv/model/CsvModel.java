package com.zhangyingwei.zcsv.model;

import com.zhangyingwei.zcsv.config.CsvConfig;

import java.util.ArrayList;
import java.util.List;
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
    public List<String> getPages(){
        List<String> pages = new ArrayList<String>();
        int pageSize = this.config.getPageSize();
        if(pageSize == -1){
            List<String> pageLines = rows.stream().map(line -> line.getLineOfString()).collect(Collectors.toList());
            String page = String.join("\n", pageLines);
            pages.add(page);
            return pages;
        }else{
            int index = 0;
            List<String> page = new ArrayList<String>();
            for (int i = 0; i < rows.size(); i++) {
                index += 1;
                if (index <= this.config.getPageSize()) {
                    page.add(rows.get(i).getLineOfString());
                }else{
                    pages.add(String.join("\n",page));
                    page.clear();
                    index = 0;
                }
            }
        }
        return pages;
    }
}
