package com.worldly.stream2char;

import java.io.*;

/**
 * 字节转字符api
 * 1.先定义一个字节流
 * 2.再定义一个字节转换流 把字符流放进去
 *
 * @author Worldly
 * @create 2017-04-12 10:03
 **/
public class Stream2CharApi {

    public static void main(String [] args){
        String file = "d:\\logs\\error.log";
        try {
            InputStream in = new FileInputStream(file);
            Stream2CharApi s2a = new Stream2CharApi();
            s2a.stream2CharReader(in);

            String file2 = "d:\\logs\\stream2charwriter.txt";
            s2a.stream2charWriter(file2);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 字节流转字符流
     * @param in
     */
    public void stream2CharReader(InputStream in ){
        //定义一个字节2字符的转换流
        InputStreamReader  isr = new InputStreamReader(in);
        //定义一个字符读取流
        BufferedReader br = new BufferedReader(isr);

        String len = "";
        try {
            while((len = br.readLine())!=null){
                System.out.println(len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 字节转字符流后输出
     * @param file
     */
    public void  stream2charWriter(String file){
        //定义一个字节输出流
        OutputStream os=null;
        try {
            os= new FileOutputStream(file);
            //定义一个字节转字符的输出流
            OutputStreamWriter osw = new OutputStreamWriter(os);

            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("d:\\logs\\error.log")));
            String len = "";
            while((len=br.readLine())!=null){
                osw.write(len,0,len.length());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
