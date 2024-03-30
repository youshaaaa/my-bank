package com.yousha.mongo;

import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.core.convert.converter.Converter;

import java.util.Date;

public class TransactionReadConverter implements Converter<Document, Transaction> {

    public Transaction convert(Document source) {
        Transaction t = new Transaction();
        t.setAmount((Double) source.get("amount"));
        t.setId((String) source.get("_id"));
        t.setReference((String) source.get("reference"));
        t.setBankSlogan((String) source.get("bankSlogan"));
        t.setTime((Date) source.get("time"));

        return t;
    }
}

