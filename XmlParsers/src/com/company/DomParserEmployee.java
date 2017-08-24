package com.company;

import com.sun.org.apache.bcel.internal.util.ClassLoader;
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

public class DomParserEmployee {

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {

        //Dom Parser ----------------------------------------------------------------------------------------------
        // resource: https://sanaulla.info/2013/05/23/parsing-xml-using-dom-sax-and-stax-parser-in-java/
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = builder.parse(ClassLoader.getSystemResourceAsStream("resources/employees.xml"));

        List<Employee> empList = new ArrayList<>();

        NodeList nodeList = document.getDocumentElement().getChildNodes();

        for(int i = 0; i < nodeList.getLength(); i ++){
            Node node = nodeList.item(i);
            if(node instanceof Element){
                Employee emp = new Employee();
                emp.id = node.getAttributes().getNamedItem("id").getNodeValue();
                NodeList childNodes = node.getChildNodes();
                for (int j = 0; j < childNodes.getLength(); j ++){
                    Node cNode = childNodes.item(j);

                    if(cNode instanceof Element){
                        String content = cNode.getLastChild().getTextContent().trim();
                        switch(cNode.getNodeName()){
                            case "firstName":
                                emp.firstName = content;
                                break;
                            case "lastName":
                                emp.lastName = content;
                                break;
                            case "location":
                                emp.location = content;
                                break;
                        }
                    }
                }
                empList.add(emp);
            }
        }
        for(Employee emp: empList){
            System.out.println(emp.toString());
        }


    }
}
