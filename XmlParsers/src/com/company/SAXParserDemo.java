package com.company;

import com.sun.org.apache.xml.internal.resolver.readers.SAXParserHandler;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Created by Pavel_Haidzinski on 8/17/2017.
 */
public class SAXParserDemo {

    public static void main(String[] args) throws ParserConfigurationException, SAXException {

        SAXParserFactory parserFactory = SAXParserFactory.newInstance();
        SAXParser parser = parserFactory.newSAXParser();
//        SAXHandler handler = new SAXHandler();

    }
}
