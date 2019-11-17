package com.company.FactoryMethod;

public class DomParserFactory implements ParserFactory{
    @Override
    public Parser createParser() {
        return new DomParser();
    }
}
