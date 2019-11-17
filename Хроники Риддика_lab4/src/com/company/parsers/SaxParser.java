package com.company.parsers;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SaxParser {
    private static List<Product> products = new ArrayList<>();

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser();
            XMLHandler handler = new XMLHandler();
            parser.parse(new File("СиТАиРИС4_1.xml"), handler);

            for (Product product : products) {
                System.out.println(product.getType() + " " + product.getName() + " " + product.getPrice() + " " + product.getContests() + " "
                        + product.getProducer());
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    private static class XMLHandler extends DefaultHandler {
        private String type, name, price, contests, producer, lastElementName;

        @Override
        public void startDocument() throws SAXException {
            super.startDocument();
        }

        @Override
        public void endDocument() throws SAXException {
            super.endDocument();
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            lastElementName = qName;
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if ((type != null && !type.isEmpty())
                    && (name != null && !name.isEmpty())
                    && (price != null && !price.isEmpty())
                    && (contests != null && !contests.isEmpty())
                    && (producer != null && !producer.isEmpty())
                    && (price != null && !price.isEmpty())) {
                Product product = new Product();
                product.setType(type);
                product.setName(name);
                product.setPrice(price);
                product.setContests(contests);
                product.setProducer(producer);

                products.add(product);
                type = null;
                name = null;
                price = null;
                contests = null;
                producer = null;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            String information = new String(ch, start, length);
            information = information.replace("\n", "").trim();
            if (!information.isEmpty()) {
                if (lastElementName.equals("type")) {
                    type = information;
                }
                if (lastElementName.equals("name")) {
                    name = information;
                }
                if (lastElementName.equals("price")) {
                    producer = information;
                }
                if (lastElementName.equals("contests")) {
                    price = information;
                }
                if (lastElementName.equals("producer")) {
                    contests = information;
                }
            }
        }

        @Override
        public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
            super.ignorableWhitespace(ch, start, length);
        }
    }

}