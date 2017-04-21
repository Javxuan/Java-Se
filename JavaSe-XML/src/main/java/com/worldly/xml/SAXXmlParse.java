package com.worldly.xml;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.InputStream;
import java.util.List;

/**
 * sax解析xml
 * sax 解析xml 的基本思路就是
 * 读一行解析一行
 *  解析的时候通过触发事件来回调 函数
 *  主要有5 个函数
 *  1.startDocument 开始文档触发的事件
 *  2.startElement 开始元素触发的事件
 *  3.endElements 结束元素触发的事件
 *  4.if(tag!=null)charactor 文本触发的事件
 *  5.结束文档触发的事件。
 *  6.因为 文本触发事件的时候没判断标记所以要定义一个额外的标记变量 tag
 *    然后再执行不同的触发事件里面 给tag 赋值
 * @author Worldly
 * @create 2017-04-21 21:17
 **/
public class SAXXmlParse {
    public static void main(String [] args ){
        /**
         * 1.先同sax解析器对象工厂来 创建工厂对象
         * 2. 通过工厂对象来生产解析对象
         * 3.开始解析
         */
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            //加载xml配置文件到内存里
            InputStream in =  Thread.currentThread().getContextClassLoader().getResourceAsStream("book.xml");
            BookHandler bookHandler = new BookHandler();
            saxParser.parse(in,bookHandler);
            List<Book> list =bookHandler.getBooks();
            for(Book book:list){
                System.out.println(book.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
