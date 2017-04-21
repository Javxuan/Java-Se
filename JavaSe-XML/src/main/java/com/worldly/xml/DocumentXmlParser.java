package com.worldly.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * xml文件之dom解析器
 * 1.DocumentBuilderFactory工厂 ---》工厂对象
 * 2.通过工厂对象 --------》生成解析器对象 DcumentBuilder
 * 3.通过解析器的parse()方法
 * 4.然后通过一些 api来获取 Node, 元素节点 ，文本节点。
 * 
 * @author Worldly
 * @create 2017-04-20 15:00
 **/
public class DocumentXmlParser {
    /**
     * 先新建 解析器工厂对象
     */
    DocumentBuilderFactory  documentBuilderFactory = DocumentBuilderFactory.newInstance();

    public List<Dog> parses(String name){
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
            InputStream  in = Thread.currentThread().getContextClassLoader().getResourceAsStream(name);
            //通过解析流来，把xml从流中形成文档树对象
            Document document  = documentBuilder.parse(in);
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
           for(int i =0;i<nodeList.getLength();i++){
               NodeList nodeList1 = nodeList.item(i).getChildNodes();
               Dog dog = new Dog();
               //遍历每个对象下面的属性集合
               for(int j=0;j<nodeList1.getLength();j++){
                   //遍历每个属性成子节点，然后再将里面的值遍历出来给属性设值
                   if("name".equals(nodeList1.item(j).getNodeName())){
                       Node node = nodeList1.item(j).getFirstChild();
                       //name 的值
                       String dogName= node.getNodeValue();
                       dog.setName(dogName);
                   }else if("age".equals(nodeList1.item(j).getNodeName())){
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

    public static void main(String [] args ){
        DocumentXmlParser dxp = new DocumentXmlParser();
        List<Dog> dogs = dxp.parses("dog.xml");
        for(Dog dog :dogs){
            System.out.println(dog.toString());
        }
    }
}
