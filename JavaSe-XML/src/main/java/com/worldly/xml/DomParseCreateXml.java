package com.worldly.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * dom解析生成xml
 *
 * @author Worldly
 * @create 2017-04-22 10:37
 **/
public class DomParseCreateXml {

    public List<Dog> domParseXml(String fileName) {
        /**
         * 先新建 解析器工厂对象
         */
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();

        /**
         * 1.然后通过解析器工厂对象 创建解析器
         *  这个解析器的作用就是把xml文件一句一句的加载到内存，有了这个解析器就 不用我们自定义流去解析
         */
        DocumentBuilder documentBuilder = null;
        try {
            documentBuilder = documentBuilderFactory.newDocumentBuilder();
            /**
             * 通过解析器去解析xml文件
             * 可以直接 解析文件
             *  也可以解析流
             */
            //documentBuilder.parse("dog.xml");
            InputStream ins = Thread.currentThread().getContextClassLoader()
                    .getResourceAsStream(fileName);
            //通过解析流来，把xml从流中形成文档树对象
            Document document = documentBuilder.parse(ins);
            //==========================================Node=====================================
            /**
             * 文档树对象里面 有Node 节点
             * 可以通过标签名来获取
             */
            NodeList nodeList = document.getElementsByTagName("dog");
            /**
             * 循环遍历节点集合来得到每个节点对象
             * 然后根据节点对象来获取里面的节点对象，
             * 里面的节点对象在获取文件节点 然后再获取文本节点值
             * 》
             * 一个节点只能管到 他的下一个子节点， 不能操作 子节点的子节点。
             * 》
             * 文本树对象就是通过把xml里的标签解析成 元素Node ,文本值解析成文本Node
             * 再通过操作对象的形式来获取想关的值
             */
            //遍历根节点下的元素集合，每个对象。
            List<Dog> dogList = new ArrayList<Dog>();
            for (int i = 0; i < nodeList.getLength(); i++) {
                NodeList nodeList1 = nodeList.item(i).getChildNodes();
                Dog dog = new Dog();
                //遍历每个对象下面的属性集合
                for (int j = 0; j < nodeList1.getLength(); j++) {
                    //遍历每个属性成子节点，然后再将里面的值遍历出来给属性设值
                    if ("name".equals(nodeList1.item(j).getNodeName())) {
                        Node node = nodeList1.item(j).getFirstChild();
                        //name 的值
                        String dogName = node.getNodeValue();
                        dog.setName(dogName);
                    } else if ("age".equals(nodeList1.item(j).getNodeName())) {
                        int age = Integer.parseInt(nodeList1.item(j).getTextContent());
                        dog.setAge(age);
                    }
                }
                dogList.add(dog);
            }
            return dogList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void domCreateXml(String xmlPath) {
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
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
            book.setAttribute("id", "1");
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
            PrintWriter printWriter = new PrintWriter(new FileOutputStream("src/main/resources/" + xmlPath));
            StreamResult streamResult = new StreamResult(printWriter);

            transformer.transform(domSource, streamResult);
            System.out.println("xml文件生成成功");
            printWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        DomParseCreateXml dpcx = new DomParseCreateXml();
        List<Dog> dogs = dpcx.domParseXml("dog.xml");
        for (Dog dog : dogs) {
            System.out.println(dog);
        }


          dpcx.domCreateXml("dom.xml");


    }
}
