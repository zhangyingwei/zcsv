package com.zhangyingwei.zcsv.utils;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by zhangyw on 2017/8/7.
 */
public class FileUtils {

    public static void writePage(String path, String page) throws IOException {
        FileOutputStream out = new FileOutputStream(path);
        FileChannel channel = out.getChannel();
        int bytes = channel.write(ByteBuffer.wrap(page.getBytes()));
        channel.close();
        out.close();
    }

    public static void createPath(String fielBasePath) {
        if(fielBasePath != null){
            File file = new File(fielBasePath);
            if(!file.exists()){
                file.mkdirs();
            }
        }
    }

    public static String readPage(String path){
        StringBuffer result = new StringBuffer();
        FileInputStream in = null;
        try {
            in = new FileInputStream(path);
            FileChannel channel = in.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            if (channel.read(byteBuffer) != -1) {
                byteBuffer.flip();
                result.append(new String(byteBuffer.array()));
                byteBuffer.compact();
            }
            return result.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
