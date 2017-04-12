package com.worldly.bufferstream;

import java.io.*;

/**
 * 带缓冲的字节流api
 *  1. 和InputStream,OutputStream的api没什么太大的区别
 * @author Worldly
 * @create 2017-04-12 9:08
 **/
public class BufferStream {

    public static void main(String [] args){
        String file = "d:\\logs\\result.txt";
        try {
            InputStream in = new FileInputStream(file);
            BufferStream bs = new BufferStream();
            //调用带缓冲的输入字节流
            bs.bufferInputStream(in);
            in = new FileInputStream(file);
            //调用代缓冲的输出字节流
            bs.bufferOutputStream(in);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 代缓冲的读取流
     * @param inputStream
     */
    public void bufferInputStream(InputStream inputStream){
        BufferedInputStream bis=null;
        try {
            bis = new BufferedInputStream(inputStream);

            byte [] by =new byte[1024];
            int len =-1;
            while((len = bis.read(by))!=-1){
                show(by);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 代缓冲的输出流
     * @param inputStream
     */
    public void bufferOutputStream(InputStream  inputStream){
        BufferedInputStream bis=null;
        BufferedOutputStream bos = null;
        try {
            bis = new BufferedInputStream(inputStream);
            bos = new BufferedOutputStream(new FileOutputStream("d:\\logs\\bufferdstream.txt"));
            byte [] by =new byte[1024];
            int len =-1;
            while((len = bis.read(by))!=-1){
                bos.write(by,0,len);
                bos.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void show(byte[] by){
        for(byte b:by){
            System.out.print(b+" ");
        }
    }

}
