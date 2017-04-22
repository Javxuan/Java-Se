package com.worldly.xml;

import org.dom4j.*;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.jdom.Attribute;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * dom4j来解析与生成xml 文件
 *
 * @author Worldly
 * @create 2017-04-22 10:55
 **/
public class Dom4jParseCreateXml {
    public static void main(String []args){
        Dom4jParseCreateXml dpxc = new Dom4jParseCreateXml();
        List<Dog> dogs = dpxc.dom4jParseXml("dog.xml");
        for(Dog dog:dogs){
            System.out.println(dog);
        }

        Dog dog = new Dog(1,"小白",230);
        Dog dog2 = new Dog(2,"彩彩",30);
        Dog dog3 = new Dog(3,"空空",24);
        List<Dog> dogs2 = new ArrayList<Dog>();
        dogs2.add(dog);
        dogs2.add(dog2);
        dogs2.add(dog3);


        dpxc.dom4jCreateXml(dogs2,"dom4j.xml");

    }

    /**
     * dom4j来解析xml文件
     * 1.先通过document.getRootElement()获取根节点
     * 2.在通过根节点.elements()获取子元素
     * 3.通过遍历 子元素 的 dogIterator()
     * 4.有属性的话遍历属性 attrIterator();
     *  一直遍历就可以
     * @param fileName
     * @return
     */
    public List<Dog> dom4jParseXml(String fileName){
        SAXReader saxReader = new SAXReader();
        InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
        try {
            Document document = saxReader.read(in);
            Element rootElement = document.getRootElement();

            List<Dog> dogList = new ArrayList<Dog>();
            //获取子元素
            List<Element> dogs = rootElement.elements();
            Iterator<Element> dogsIterator = dogs.iterator();

            while(dogsIterator.hasNext()){
                Element dog = dogsIterator.next();
                //获取dog的属性
                Iterator attrIt = dog.attributeIterator();
                Dog dog2 = new Dog();
                while(attrIt.hasNext()){
                    org.dom4j.Attribute attr = (org.dom4j.Attribute) attrIt.next();
                    if("id".equals(attr.getName())){
                        dog2.setId(Integer.parseInt(attr.getValue()));
                    }
                }
                //获取dog的子节点
                List<Element>  els = dog.elements();
                Iterator elsIterator= els.iterator();
                while(elsIterator.hasNext()){
                    //将dog里面的name 和age 转换为 Element
                    Element element1 = (Element) elsIterator.next();

                    if("name".equals(element1.getName())){
                        dog2.setName(element1.getText());
                    }else if("age".equals(element1.getName())) {
                        dog2.setAge(Integer.parseInt(element1.getText()));
                    }
                }
                //将遍历好的dog添加到集合
                dogList.add(dog2);
            }
            return dogList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 通过dom4j写入到数据库
     * 1.生成文档树对象 document = DocumentHelper.createDocument()
      * 2.添加根节点  document.addElement(dogs)
     *   addAttribute();
     * 3.根节点添加子节点
     *   Element name = dogElement.addElement("name");
     *    dogElement.addElement(name);
     *    name.setText("属性值");
     *
     *
     * @param xmlPath
     */
    public void dom4jCreateXml(List<Dog> dogs,String xmlPath) {

        //生成文档数对象
        Document document = DocumentHelper.createDocument();
        //根节点
        Element rootElement = document.addElement("dogs");

        for(Dog dog:dogs){
            Element dogElement = rootElement.addElement("dog");
            dogElement.addAttribute("id",+dog.getId()+"");

            Element nameElement = dogElement.addElement("name");
            nameElement.setText(dog.getName());

            Element ageElement = dogElement.addElement("age");
            ageElement.setText(dog.getAge()+"");

        }
        //将树对象写xml 文件中
        try {
            XMLWriter xmlWriter = new XMLWriter(new FileWriter(new File("src/main/resources/"+xmlPath)));
            xmlWriter.write(document);
            xmlWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
