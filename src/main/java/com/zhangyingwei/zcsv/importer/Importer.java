package com.zhangyingwei.zcsv.importer;

import com.zhangyingwei.zcsv.annotation.HandlerType;

import java.util.List;

/**
 * Created by zhangyw on 2017/8/7.
 */
public interface Importer {
    <E> E importCsv(HandlerType type, Class... classes) throws Exception;
}
