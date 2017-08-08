package com.zhangyingwei.zcsv.importer;

import com.zhangyingwei.zcsv.annotation.HandlerType;
import com.zhangyingwei.zcsv.config.CsvConfig;
import com.zhangyingwei.zcsv.model.TestModel;
import org.junit.Test;
import java.util.List;
import java.util.Map;

/**
 * Created by zhangyw on 2017/8/7.
 */
public class CsvImporterTest {
    @Test
    public void test() throws Exception {
        Importer importer = new CsvImporter(new CsvConfig());
        List<String[]> result = importer.importCsv(HandlerType.DEFAULTHANDLER);
    }

    @Test
    public void testImport() throws Exception {
        CsvImporter importer = new CsvImporter(new CsvConfig().setBasePath("csv").setSpliter("@"));
        List<TestModel> testModels = importer.importCsv(HandlerType.MAPHANDLER, TestModel.class);
        System.out.println(testModels);
    }

    @Test
    public void testMapImport() throws Exception {
        CsvImporter importer = new CsvImporter(new CsvConfig().setBasePath("csv"));
        Map result = importer.importCsv(HandlerType.MAPHANDLER);
        System.out.println(result);
    }
}