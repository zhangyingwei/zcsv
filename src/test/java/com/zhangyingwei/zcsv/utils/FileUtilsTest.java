package com.zhangyingwei.zcsv.utils;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zhangyw on 2017/8/7.
 */
public class FileUtilsTest {
    @Test
    public void raedPage() throws Exception {
        String result = FileUtils.readPage("1502093971243-063b9de6-1db6-4769-8909-edba9ef0497b.csv");
        System.out.println(result);
    }

    @Test
    public void writePage() throws Exception {
        FileUtils.writePage("hello.page","this is hello content\nnihao");
    }

}