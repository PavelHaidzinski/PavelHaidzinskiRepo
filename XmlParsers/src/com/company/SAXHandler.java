package com.company;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pavel_Haidzinski on 8/24/2017.
 */
public class SAXHandler extends DefaultHandler {

    List<Employee> empList = new ArrayList<>();
    Employee emp = null;
    String content = null;

    @Override
    public void startElement (String uri, String localName, String qName, Attributes attributes){
        switch (qName){
            case "employee":
                //Create new employee object when start tag is found.
                emp = new Employee();
                emp.id = attributes.getValue("id");
                break;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName){
        switch (qName){
            case "employee":
                empList.add(emp);
                break;
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

    @Override
    public void characters(char[] ch, int start, int length){
        content = String.copyValueOf(ch, start, length).trim();
    }
}
