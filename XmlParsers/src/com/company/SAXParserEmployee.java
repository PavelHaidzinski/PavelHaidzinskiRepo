package com.company;

import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Created by Pavel_Haidzinski on 8/17/2017.
 */
public class SAXParserEmployee {

    public static void main(String[] args) throws Exception {

        SAXParserFactory parserFactory = SAXParserFactory.newInstance();
        SAXParser parser = parserFactory.newSAXParser();
        SAXHandler handler = new SAXHandler();

        parser.parse(ClassLoader.getSystemResourceAsStream("resources/employees.xml"), handler);

        for(Employee emp : handler.empList){
            System.out.println(emp);
        }

    }
}
