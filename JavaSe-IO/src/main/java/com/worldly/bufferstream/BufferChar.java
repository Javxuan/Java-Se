package com.worldly.bufferstream;

import java.io.*;

/**
 * 带缓冲的字符流api
 *
 * @author Worldly
 * @create 2017-04-12 9:36
 **/
public class BufferChar {

    public static void main(String[] args){
        String file = "d:\\logs\\result.txt";
        BufferChar bc = new BufferChar();
        try {
            Reader reader = new FileReader(file);
            bc.buffReader(reader);

            reader = new FileReader(file);
            bc.bufferWriter(reader);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
        }


    }

    /**
     * 带缓冲的字符读入流
     * @param reader
     */
    public void buffReader(Reader reader){
        BufferedReader br = new BufferedReader(reader);
        br = new BufferedReader(reader);
        String len = "";
        try {
            while((len = br.readLine())!=null){ //可以读取一行来 提高读取效率
                System.out.println(len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 带缓冲的字符输出流
     * @param reader
     */
    public void bufferWriter(Reader reader){
        BufferedReader br = new BufferedReader(reader);
        br = new BufferedReader(reader);
        String len = "";
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("d:\\logs\\bufwriter.txt"));
            while((len = br.readLine())!=null){
                bw.write(len);  //可以写入一行
                bw.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
