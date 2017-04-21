package com.worldly.xml;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileOutputStream;
import java.io.PrintWriter;

/**
 * 利用document生成xml文件
 *首先是创建DOM树（即规定XML文件中的内容）：

 创建DocumentBuilderFactory对象
 通过DocumentBuilderFactory对象创建DocumentBuilder对象
 通过DocumentBuilder对象的newDocument()方法创建一个Document对象，该对象代表一个XML文件
 通过Document对象的createElement()方法创建根节点
 通过Document对象的createElement()方法创建N个子节点，并为他们赋值，再将这些子节点添加到根节点下
 将根节点添加到Document对象下

 其次是将DOM树转换为XML文件：

 创建TransformerFactory类的对象
 通过TransformerFactory创建Transformer对象
 使用Transformer对象的transform()方法将DOM树转换为XML文件。（该方法有两个参数，第一个参数为源数据，需要创建DOMSource对象并将Document加载到其中；第二个参数为目的文件，即要生成的XML文件，需要创建StreamResult对象并指定目的文件）

 *
 *
 * @author Worldly
 * @create 2017-04-21 11:18
 **/
public class DocumentCreateXmlApi {

    private DocumentBuilderFactory  documentBuilderFactory = DocumentBuilderFactory.newInstance();

    public void createXml(){
        try {
            /**
             * 1、创建Dom对象
             *    Dom对象生成工厂 ----》dom工厂对象DomcumentBuilder---------》dom对象
             * 2、通过dom对象api 来添加节点
             */
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();

            /**
             * 通过createElement方法来创建节点，和字节点
             * 然后将子节点 添加到 根节点
             *       根节点 添加到 dom对象里
             */
            Element books = document.createElement("books");
            Element book = document.createElement("book");
            book.setAttribute("id","1");
            Element name = document.createElement("name");
            name.setTextContent("小人书");
            Element price = document.createElement("price");
            price.setTextContent("23.00");
            book.appendChild(name);
            book.appendChild(price);

            books.appendChild(book);
            document.appendChild(books);

            /**
             * 1.借助源码转换为结果树对象的对象来 将文档树对象 的源树转换为结果树
             * 2.要把 Document对象-------》转换为DOMSource
             * 3.然后在通过Transformer对象 通过transform(源树，结果对象);
             */
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);

            /**
             * 生成结果对象
             *  通过StreamResult 对象
             *  将字符流作为参数传给StreamResult
             *  字符流(将结果对象存到哪里)
             */
            PrintWriter printWriter = new PrintWriter(new FileOutputStream("book.xml"));
            StreamResult streamResult = new StreamResult(printWriter);

            transformer.transform(domSource,streamResult);
            System.out.println("xml文件生成成功");
            printWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String []args){
        DocumentCreateXmlApi documentCreateXmlApi = new DocumentCreateXmlApi();
        documentCreateXmlApi.createXml();
    }
}
