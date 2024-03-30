package com.yousha.mongo;

import org.bson.Document;
import org.springframework.core.convert.converter.Converter;


public class TransactionWriteConverter implements Converter<Transaction, Document> {

    public Document convert(Transaction source) {
        Document document = new Document();
        document.put("_id", source.getId());
        document.put("reference", source.getReference());
        document.put("amount", source.getAmount());
        document.put("bankSlogan", source.getBankSlogan());
        document.put("time", source.getTime());
        return document;
    }
}
