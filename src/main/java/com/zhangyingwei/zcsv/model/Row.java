package com.zhangyingwei.zcsv.model;

import java.util.List;

/**
 * @author: zhangyw
 * @date: 2017/8/6
 * @time: 下午9:34
 * @desc:
 */
public class Row {
    private List<String> items;
    private String spliter;

    public Row(List<String> items, String spliter) {
        this.items = items;
        this.spliter = spliter;
    }

    public String getLineOfString(){
        return String.join(this.spliter, items);
    }
}
