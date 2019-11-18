package com.company.FactoryMethod;

import com.company.singleton.Singleton;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class DomParser implements Parser{
    @Override
    public void doParse() {
        try {
            File inputFile = new File("СиТАиРИС4_1.xml");

            Document doc = Singleton.getInstance();

            NodeList nList = doc.getElementsByTagName("product");

            for (int i = 0; i < nList.getLength(); i++) {
                Node nNode = nList.item(i);
                System.out.println("\nCurrent Element : " + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println("Department : " + eElement.getElementsByTagName("type")
                            .item(0)
                            .getTextContent());
                    System.out.println("Name : " + eElement.getElementsByTagName("name")
                            .item(0)
                            .getTextContent());
                    System.out.println("Price : " + eElement.getElementsByTagName("price")
                            .item(0)
                            .getTextContent());
                    System.out.println("Contests : " + eElement.getElementsByTagName("contests")
                            .item(0)
                            .getTextContent());
                    System.out.println("Producer : " + eElement.getElementsByTagName("producer")
                            .item(0)
                            .getTextContent());


                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
