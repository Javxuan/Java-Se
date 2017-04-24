package com.worldly.xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * 解析bookxml配置文件的处理器
 *
 * @author Worldly
 * @create 2017-04-21 21:26
 **/
public class BookHandler extends DefaultHandler {
    private String tag=null;
    private List<Book> books=null;
    private Book book=null;
    public BookHandler() {
        super();
    }

    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
        books = new ArrayList<Book>();
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("xml文件解析完毕");
    }

    /**
     *
     * @param uri 包名
     * @param localName 不带前缀的标签<teacher>
     * @param qName 带前缀的标签<aa:teacher></aa:teacher>
     * @param attributes 属性集合
     * @throws SAXException
     */
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if("book".equals(qName)){
            book = new Book();
            int length = attributes.getLength();
            for(int i=0;i<length;i++){
                book.setId(Integer.parseInt(attributes.getValue(i)));
            }
        }else if("name".equals(qName )){
            tag = qName;
        }else if("price".equals(qName)){
            tag=qName;
        }

    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if("book".equals(qName)){
            books.add(book);
        }
        tag= null;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if(tag!=null){
            if(tag.equals("name"))
                book.setName(new String(ch,start,length));
            if(tag.equals("price"))
                book.setPrice(Double.parseDouble(new String(ch,start,length)));
        }
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
