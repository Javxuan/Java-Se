package com.worldly.sockets;

import java.io.*;
import java.net.*;

/**
 * 套接字的服务端
 *  1.serverSocket来建立server套接字 并且定义 该服务器上的某个端口来响应相关的应用程序。
 *  2.建立 输入流 来接收 client 发送的消息。
 *  3.关闭输入流 来关闭阻塞。
 *  4.建立 输出流 来发送 server 响应信息。
 *  5.关闭相关的流。
 *
 * @author xiaoqixuan
 * @create 2017/5/22 15:56
 */
public class MyServerSocket {
    public static void main(String [] args) throws Exception{
        //创建带端口的套接字。
        ServerSocket serverSocket = new ServerSocket(10086);
        //等待10086端口的tcp通信。
        Socket socket = serverSocket.accept();

        //通过socket对象来获取client端的相关内容。
        InputStream ins = socket.getInputStream();
        //将client的字节流转换化为带缓冲的字符流
        InputStreamReader isr = new InputStreamReader(ins);
        BufferedReader br = new BufferedReader(isr);

        String line = "";
        while((line=br.readLine())!=null){
            System.out.print(line);
        }
        socket.shutdownInput();

        //响应客户端 同样是利用 socket来建立流
        OutputStream outputStream = socket.getOutputStream();
        PrintWriter pw =  new PrintWriter(outputStream);
        pw.write("server:小王啊，我是隔壁老王！");
        pw.flush();

        //关闭资源
        outputStream.close();
        pw.close();
        ins.close();
        isr.close();
        br.close();
        socket.close();
        serverSocket.close();
    }
}
