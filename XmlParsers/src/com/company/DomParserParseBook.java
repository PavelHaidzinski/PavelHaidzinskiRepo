package com.company;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pavel_Haidzinski on 8/24/2017.
 */
public class DomParserParseBook {

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = builder.parse(ClassLoader.getSystemResourceAsStream("resources/bookstore.xml"));

        List<Book> books = new ArrayList<Book>();
        ArrayList<String> author;

        NodeList nodes = document.getDocumentElement().getChildNodes();

        for (int i = 0; i < nodes.getLength(); i ++ ){
            Node node =  nodes.item(i);
            Book book = new Book();
            NodeList childNodes = node.getChildNodes();
            if(node instanceof Element && node.getNodeName().equals("book")){
                for (int j=0; j<=childNodes.getLength(); j++) {
                    Node cNode = childNodes.item(j);
                    if (cNode instanceof Element ) {
                        String value = null;
                        String name = null;
                        value = cNode.getTextContent();
                        name = cNode.getNodeName().trim();
                            switch (name) {
                                case "title":
                                    book.setTitle(value);
                                    break;
                                case "author":
                                    book.setAuthor(value);
                                    break;
                                case "year":
                                    book.setYear(value);
                                    break;
                                case "price":
                                    book.setPrice(value);
                                    break;
                            }
                    }
                }
                books.add(book);
                System.out.println(book.toString());
            }
        }
    }

}
