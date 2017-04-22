package com.worldly.xml;

import org.xml.sax.helpers.AttributesImpl;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *  生成解析 xml
 * @author Worldly
 * @create 2017-04-21 21:17
 **/
public class SAXParseCreateXml {
    public static void main(String [] args ){
        SAXParseCreateXml saxXmlParse = new SAXParseCreateXml();
        saxXmlParse.saxParseXml("book.xml");

        Book book = new Book(1,"Think first java",88.00);
        Book book2 = new Book(2,"设计模式",88.00);
        List<Book> books = new ArrayList<Book>();
        books.add(book);
        books.add(book2);

        saxXmlParse.saxCreateXml(books,"src/main/resources/sax.xml");

    }

    public void saxParseXml(String fileName){
        /**
         sax解析xml
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
         */
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            //加载xml配置文件到内存里
            InputStream in =  Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
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

    /**
     * sax生成xml
     * 1.sax创建生成工厂
     * 2.生成xml 的时候还按行来触发 事件
     * 3.首先 先建立 属性集合 impl
     * 4.读每行的时候都要先清空 impl
     * @param xmlPath
     */
    public void saxCreateXml(List<Book> books,String xmlPath){
        try {
            // 创建工厂
            SAXTransformerFactory factory = (SAXTransformerFactory) SAXTransformerFactory.newInstance();
            TransformerHandler handler = factory.newTransformerHandler();
            Transformer info = handler.getTransformer();
            // 是否自动添加额外的空白
            info.setOutputProperty(OutputKeys.INDENT, "yes");
            // 设置字符编码
            info.setOutputProperty(OutputKeys.ENCODING, "utf-8");
            info.setOutputProperty(OutputKeys.VERSION, "1.0");
            // 保存创建的saxbooks.xml
            StreamResult result = new StreamResult(new FileOutputStream(new File(xmlPath)));
            handler.setResult(result);
            // 开始xml
            handler.startDocument();
            AttributesImpl impl = new AttributesImpl();
            impl.clear();
            handler.startElement("", "", "books", impl);
            for(int i=0;i<books.size();i++) {
                Book book = books.get(i);
                impl.clear(); //清空属性
                //生成<book id="xx">
                impl.addAttribute("", "", "id", "", book.getName());//为book元素添加id属性
                handler.startElement("", "", "book", impl);

                //生成<name>Think in java</name>
                impl.clear();
                handler.startElement("", "", "name", impl);
                String nameValue = book.getName();
                handler.characters(nameValue.toCharArray(), 0, nameValue.length());
                handler.endElement("", "", "name");

                //生成<price></price>
                impl.clear();
                handler.startElement("", "", "price", impl);
                String priceValue = book.getPrice() + "";
                handler.characters(priceValue.toCharArray(), 0, priceValue.length());
                handler.endElement("", "", "price");

            }
            //生成</bookstore>
            handler.endElement("", "", "books");
            handler.endDocument();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
