package com.company;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pavel_Haidzinski on 9/5/2017.
 */
public class STAXParserEmployee {

    public static void main(String[] args) throws XMLStreamException {

        List<Employee> empList = null;
        Employee currEmp = null;
        String tagContent = null;

        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLStreamReader reader = factory.createXMLStreamReader(ClassLoader.getSystemResourceAsStream("resources/employees.xml"));

        while(reader.hasNext()){
            int event = reader.next();

            switch (event){
                case XMLStreamConstants.START_ELEMENT:
                    if("employee".equals(reader.getLocalName())){
                        currEmp = new Employee();
                        currEmp.id = reader.getAttributeValue(0);
                    }
                    if("employees".equals(reader.getLocalName())){
                        empList = new ArrayList<>();
                    }
                    break;

                case XMLStreamConstants.CHARACTERS:
                    tagContent = reader.getText().trim();
                    break;

                case XMLStreamConstants.END_ELEMENT:
                    switch (reader.getLocalName()){
                        case "employee":
                            empList.add(currEmp);
                            break;
                        case "firstName":
                            currEmp.firstName = tagContent;
                            break;
                        case "lastName":
                            currEmp.lastName = tagContent;
                            break;
                        case "location":
                            currEmp.location = tagContent;
                            break;
                    }
                    break;

                case XMLStreamConstants.START_DOCUMENT:
                    empList = new ArrayList<>();
                    break;
            }
        }

        for (Employee emp : empList){
            System.out.println(emp);
        }
    }

}
