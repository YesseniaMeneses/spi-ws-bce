package com.cobiscorp.ecobis.spi.service.impl;

import java.io.Serializable;
import java.util.List;


public class Request implements Serializable {



    /*List<Transaction> transactions;

    @Override
    public String toString() {
        return "Request{" +
                "transactions=" + transactions +
                '}';
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }*/

    String xmlStr;
    String bceSecuential;

    public String getBceSecuential() {
        return bceSecuential;
    }

    public void setBceSecuential(String bceSecuential) {
        this.bceSecuential = bceSecuential;
    }


    public String getXmlStr() {
        return xmlStr;
    }

    public void setXmlStr(String xmlStr) {
        this.xmlStr = xmlStr;
    }

    @Override
    public String toString() {
        return "Request{" +
                "xmlStr='" + xmlStr + '\'' +
                ", bceSecuential='" + bceSecuential + '\'' +
                '}';
    }
}
