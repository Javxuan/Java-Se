package com.worldly.charstream;

import java.io.*;

/**
 * 字符流的reader处理api
 *
 * @author Worldly
 * @create 2017-04-11 21:24
 **/
public class ReaderApi {

    public static void main(String [] args){
        ReaderApi ra = new ReaderApi();
        File file  = new File("d:\\logs\\result.txt");
        ra.readOne(file);

        ra.readArry(file);

    }

    /**
     * 读取单个字符
     * @param file
     */
    public void readOne(File file ){
        Reader reader=null;
        try {
            reader = new FileReader(file);
            FileWriter fw = new FileWriter("d:\\logs\\char.txt");
            int len = -1;
            while((len = reader.read())!=-1){
                fw.write(len);
                fw.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 读取一个字符数组
     * @param file
     */
    public void readArry(File file) {
        Reader reader = null;
        try {
            reader = new FileReader(file);
            FileWriter fw = new FileWriter("d:\\logs\\char.txt");
            char [] ch = new char[10];
            int len = -1;
            while ((len = reader.read(ch)) != -1) {
                fw.write(ch,0,len);
                fw.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
