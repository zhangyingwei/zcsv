package com.zhangyingwei.zcsv.exporter;

import com.zhangyingwei.zcsv.config.CsvConfig;
import com.zhangyingwei.zcsv.handler.DefaultHandler;
import com.zhangyingwei.zcsv.handler.MapHandler;
import com.zhangyingwei.zcsv.handler.ObjectHandler;
import com.zhangyingwei.zcsv.model.CsvModel;
import com.zhangyingwei.zcsv.model.TestModel;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by zhangyw on 2017/8/7.
 */
public class CsvExporterTest {
    @Test
    public void export() throws Exception {
        List<String[]> list = this.bulidBigList();
        CsvExporter exporter = new CsvExporter(new CsvConfig()
                .setBasePath("csv")
                .setPageSize(90)
                .setFileName("listcsv")
                .setSpliter("@@")
        );
        exporter.export(new DefaultHandler(list));
    }

    @Test
    public void testMapExport(){
        Map<String, String> map = new HashMap<String,String>(){
            {
                put("key1", "value1");
                put("key2", "value2");
                put("key3", "value3");
                put("key4", "value4");
                put("key5", "value5");
            }
        };

        CsvExporter exporter = new CsvExporter(new CsvConfig().setFileName("map").setBasePath("csv"));
        exporter.export(new MapHandler(map));
    }

    @Test
    public void textObjectExporter(){
        new CsvExporter(new CsvConfig().setSpliter("@").setBasePath("csv").setFileName("obj").setPageSize(2)).export(new ObjectHandler(new ArrayList(){
            {
                add(new TestModel("zhangsan",10));
                add(new TestModel("zhangsan",10));
                add(new TestModel("zhangsan",10));
                add(new TestModel("zhangsan",10));
                add(new TestModel("zhangsan",10));
            }
        }));
    }

    private List<String[]> bulidBigList() {
        List<String[]> result = new ArrayList<String[]>();
        for (int i = 0;i<180;i++){
            result.add(new String[]{"a", "b"});
        }
        return result;
    }

}