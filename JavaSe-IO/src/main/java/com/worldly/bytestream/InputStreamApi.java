package com.worldly.bytestream;

import java.io.*;

/**
 * inputstream的api
 *
 * @author Worldly
 * @create 2017-04-11 17:22
 **/
public class InputStreamApi {

    public static void main(String [] args){
        String file = "d:\\logs\\error.log";

        InputStreamApi isa = new InputStreamApi();
        //isa.readOne(file);

        File file1 = new File("d:\\logs\\test.log");
        isa.readArray(file1);

    }


    /**
     *  读取单个字节
     *  读一个字节往磁盘里写一个字节速度比较慢
     * @param file
     */
    public void readOne(String file ){
        InputStream  in = null;
        try {
            in = new FileInputStream(file);
            StringBuilder sb = new StringBuilder();
            int len = -1;
            while((len=in.read())!=-1){ //一次读一个字节，当读取的字节为-1的时候就说明读完了。
                sb= sb.append((char)in.read());
            }
            System.out.println(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(in !=null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 读取一个字符数组
     * 先将字节读取到某个一字节数组里面存储，当字节数组里面存满了就往磁盘写入
     * @param file
     */
    public void readArray(File file){
        InputStream in = null;
        try {
            OutputStream os = new FileOutputStream("d:\\logs\\result.txt");
            in = new FileInputStream(file);
            byte[] by = new byte[10];
            int len =-1;
            while((len = in.read(by))!=-1){//从内存字节流中读取一定长度的字节数组，当读到-1 的时候 就结束
                os.write(by,0,len); //读取到内存中的字节数组 写入到磁盘，读多少写多少
                os.flush(); //将字节从流中输出到文件里
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }



}
