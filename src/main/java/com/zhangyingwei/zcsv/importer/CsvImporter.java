package com.zhangyingwei.zcsv.importer;

import com.zhangyingwei.zcsv.annotation.HandlerType;
import com.zhangyingwei.zcsv.config.CsvConfig;
import com.zhangyingwei.zcsv.handler.CsvHandler;
import com.zhangyingwei.zcsv.handler.DefaultHandler;
import com.zhangyingwei.zcsv.handler.MapHandler;
import com.zhangyingwei.zcsv.handler.ObjectHandler;
import com.zhangyingwei.zcsv.utils.FileUtils;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by zhangyw on 2017/8/7.
 */
public class CsvImporter implements Importer {

    private CsvConfig config;

    public CsvImporter(CsvConfig config) {
        this.config = config;
    }

    @Override
    public <E> E importCsv(HandlerType type, Class... resultClass) throws Exception {
        CsvHandler handler = bulidHandler(type);
        List<File> files = listFiles();
        List<String[]> list = files.stream().map(file -> {
            return FileUtils.readPage(file.getPath());
        }).flatMap(page -> Stream.of(page.split("\n"))).map(line -> line.split(this.config.getSpliter())).collect(Collectors.toList());
        return handler.tramslate(list,resultClass);
    }

    private List<File> listFiles() {
        return Arrays.stream(new File(this.config.getBasePath()).listFiles())
                .filter(file -> file.isFile())
                .filter(file -> file.getName().endsWith(this.config.getFileSuffix()))
                .filter(file -> {
                    String name = file.getName().replace(this.config.getFileSuffix(), "");
                    if(this.config.isDefaultName()){
                        this.config.setFileName("(.*)");
                    }
                    Pattern pattern = Pattern.compile(this.config.getFileName());
                    Matcher matcher = pattern.matcher(name);
                    return matcher.find();
                }).collect(Collectors.toList());
    }

    private CsvHandler bulidHandler(HandlerType type) throws Exception {
        CsvHandler handler = null;
        if(HandlerType.DEFAULTHANDLER.equals(type)){
            handler = (DefaultHandler) type.getName().newInstance();
        }else if(HandlerType.MAPHANDLER.equals(type)){
            handler = (MapHandler) type.getName().newInstance();
        }
        return handler;
    }
}
