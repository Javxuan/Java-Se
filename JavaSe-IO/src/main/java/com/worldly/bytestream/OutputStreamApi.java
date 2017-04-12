package com.worldly.bytestream;

import jdk.internal.util.xml.impl.Input;

import java.io.*;

/**
 * outputstream的api
 *
 * @author Worldly
 * @create 2017-04-11 21:05
 **/
public class OutputStreamApi {

    public static void main(String [] args){
        OutputStreamApi osa = new OutputStreamApi();
        File file = new File("d:\\logs\\result.txt");
        osa.writeOneByte(file);
        osa.writeArray(file);
    }

    /**
     * 写入单个字节
     */
    public void writeOneByte(File file){
        OutputStream os=null;
        try {
            InputStream in = new FileInputStream(file);
            os = new FileOutputStream("d:\\logs\\testOut.log");
            int i =-1;
            while((i=in.read())!=-1){
                os.write(i);
                os.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                os.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 写入一个字节
     * @param file
     */
    public void writeArray(File file){
        OutputStream os=null;
        try {
            InputStream in = new FileInputStream(file);
            os = new FileOutputStream("d:\\logs\\testOut.log");
            byte [] by= new byte[1024];
            int i =-1;
            while((i=in.read(by))!=-1){
                os.write(by,0,i);
                os.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                os.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
