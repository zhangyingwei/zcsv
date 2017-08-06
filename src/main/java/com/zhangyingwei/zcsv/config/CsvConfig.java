package com.zhangyingwei.zcsv.config;

/**
 * @author: zhangyw
 * @date: 2017/8/6
 * @time: 下午9:42
 * @desc:
 */
public class CsvConfig {
    private static final String SPLITER_DEFAULT = ",";
    private static final int PAGESIZE_DEFAULT = -1;
    private static final String FILESUFFIX_DEFAULT = ".csv";
    private String spliter = SPLITER_DEFAULT;
    private int pageSize = PAGESIZE_DEFAULT;
    private String fileSuffix = FILESUFFIX_DEFAULT;
    private String fileName;

    public String getSpliter() {
        return spliter;
    }

    public CsvConfig setSpliter(String spliter) {
        this.spliter = spliter;
        return this;
    }

    public int getPageSize() {
        return pageSize;
    }

    public CsvConfig setPageSize(int pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public String getFileSuffix() {
        return fileSuffix;
    }

    public CsvConfig setFileSuffix(String fileSuffix) {
        this.fileSuffix = fileSuffix;
        return this;
    }

    public String getFileName() {
        return fileName;
    }

    public CsvConfig setFileName(String fileName) {
        this.fileName = fileName;
        return this;
    }
}
