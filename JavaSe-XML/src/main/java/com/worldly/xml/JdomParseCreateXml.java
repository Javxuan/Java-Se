package com.worldly.xml;

import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * jdom解析xml
 *  1.jdom 解析采用那个解析器就 实例化那个解析器
 *  2.然后 实例化Document
 *  3.根据 getRootElement ,getChildren  getChild ,getAttribute 等方法得到 相关的节点
 *  4. 根据子节点.getChildText("子节点名") 就可以获得该子节点的value;
 * @author Worldly
 * @create 2017-04-22 8:42
 **/
public class JdomParseCreateXml {

    public static void main(String []args){
        JdomParseCreateXml jpx = new JdomParseCreateXml();
        File file = new File("book.xml");
        List<Book> books = jpx.jdomParseXml(file);
        for(Book book :books){
            System.out.println(book);
        }

        InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("jdom.xml");
        jpx.jdomCreateXml(in);
    }

    /**
     * 1.getRootElement表示 获取根节点
     * 2.getChildren表示获取该节点下的所有子节点
     * 3.getChild 表示获取该节点的子节点
     * 4.getChildText可以获得元素属性的值
     *
     * 使用jdom解析xml
     * @param file
     */
    public List<Book> jdomParseXml(File file){
        SAXBuilder saxBuilder = new SAXBuilder();
        try {
            List<Book> books = new ArrayList<Book>();
            Document document = saxBuilder.build(file);
            org.jdom.Element rootElement = document.getRootElement();
            //获取根元素下面的字节点
            List<?> bookList = rootElement.getChildren("book");
           for(int i=0;i<bookList.size();i++){
               Book book = new Book();
               org.jdom.Element  bookElement = (org.jdom.Element) bookList.get(i);

               //根元素读取属性
               book.setId(bookElement.getAttribute("id").getIntValue());
               book.setName(bookElement.getChildText("name"));
               book.setPrice(Double.parseDouble(bookElement.getChildText("price")));
               books.add(book);
           }
           return books;
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据jdom生成 xml
     * @param in
     */
    public void jdomCreateXml(InputStream in ){
        SAXBuilder saxBuilder  = new SAXBuilder();
        try {
            Document document = saxBuilder.build(in);
            org.jdom.Element rootElement = new org.jdom.Element("books");
            document.setRootElement(rootElement);
            org.jdom.Element bookElement = new org.jdom.Element("book");
            bookElement.setAttribute("id","1");
            org.jdom.Element nameElement = new org.jdom.Element("name");
            nameElement.setText("Think in Java");
            org.jdom.Element priceElement = new org.jdom.Element("price");
            priceElement.setText("23");

            bookElement.addContent(nameElement);
            bookElement.addContent(priceElement);
            rootElement.addContent(bookElement);

            XMLOutputter xmlOutputter = new XMLOutputter();
            xmlOutputter.output(document,new PrintWriter("src/main/resources/jdom.xml"));

        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
