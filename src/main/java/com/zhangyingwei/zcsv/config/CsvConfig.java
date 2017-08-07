package com.zhangyingwei.zcsv.config;

import com.zhangyingwei.zcsv.utils.FileUtils;

import java.util.Date;
import java.util.UUID;

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
    private boolean defaultName = true;
    private static final String FILEBASEPATH_DEFAULT = "./";
    private String fielBasePath = FILEBASEPATH_DEFAULT;

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
        if(this.fileName == null){
            this.setFileName(new Date().getTime() + "-" + UUID.randomUUID());
        }
        return fileName;
    }

    public CsvConfig setFileName(String fileName) {
        this.defaultName = false;
        this.fileName = fileName;
        return this;
    }

    public boolean isDefaultName() {
        return defaultName;
    }

    public String getBasePath() {
        if (!(fielBasePath.endsWith("/") || fielBasePath.endsWith("\\"))) {
            fielBasePath += "/";
        }
        return fielBasePath;
    }

    public CsvConfig setBasePath(String fielBasePath) {
        FileUtils.createPath(fielBasePath);
        this.fielBasePath = fielBasePath;
        return this;
    }

    public String bulidFilePath() {
        return this.bulidFilePath(-1);
    }

    public String bulidFilePath(int part) {
        String path = this.getBasePath();
        String name = this.getFileName();
        String suffix = this.getFileSuffix();
        if(part != -1){
            name = String.format("%s%s%d",name,"-part",part);
        }
        return String.format("%s%s%s", path, name, suffix);
    }
}
