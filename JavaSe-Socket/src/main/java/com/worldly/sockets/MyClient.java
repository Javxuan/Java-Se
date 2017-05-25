package com.worldly.sockets;

import java.io.*;
import java.net.Socket;


/**
 * 自定义client客户端
 * 1.Socket  根据ip地址和端口  来新建立 Socket的实例。
 * 2.建立 输出流 来发送 client 请求消息。
 * 3.关闭 输出流。
 * 4.建立 输入流 来接收 server 响应的结果。
 * 5.关闭相关的流。
 *
 * @author xiaoqixuan
 * @create 2017/5/22 16:35
 */
public class MyClient {
    public static void main(String []args) throws Exception{
        //String ip = "127.0.0.1";
        int port = 10086;
        Socket socket = new Socket("localhost",port);

        //socket获取 输出流 向服务器发送消息
        OutputStream os = socket.getOutputStream();
        PrintWriter pw = new PrintWriter(os);
        pw.write("client：隔壁老王在吗？");
        pw.flush();

        socket.shutdownOutput();

        //socket获取输入流  接收服务端消息
        InputStream is = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String str ="";
        while((str=br.readLine())!=null){
            System.out.print(str);
        }

        //关闭资源
        is.close();
        br.close();
        os.close();
        pw.close();
        socket.close();
    }
}
