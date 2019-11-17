package com.company.parsers;

import com.company.FactoryMethod.DomParserFactory;
import com.company.FactoryMethod.Parser;
import com.company.FactoryMethod.ParserFactory;

public class Main {

    public static void main(String[] args) {
        ParserFactory parserFactory = new DomParserFactory();
        Parser parser = parserFactory.createParser();

        parser.doParse();
    }
}
