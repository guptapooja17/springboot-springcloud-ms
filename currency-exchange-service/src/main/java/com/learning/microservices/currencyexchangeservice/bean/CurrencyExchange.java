package com.learning.microservices.currencyexchangeservice.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
@Entity
public class CurrencyExchange {
    @Id
    private int id;
    @Column(name= "currency_from")
    private String from;
    @Column(name = "currency_to")
    private  String to;
    private BigDecimal conversionMultiple;
    private String environment;

    public CurrencyExchange() { }
    public CurrencyExchange(int id, String from, String to, BigDecimal conversationMultiple) {
        super();
        this.id = id;
        this.from = from;
        this.to = to;
        this.conversionMultiple = conversationMultiple;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public BigDecimal getConversionMultiple() {
        return conversionMultiple;
    }

    public void setConversionMultiple(BigDecimal conversationMultiple) {
        this.conversionMultiple = conversationMultiple;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environmet) {
        this.environment = environmet;
    }
}
