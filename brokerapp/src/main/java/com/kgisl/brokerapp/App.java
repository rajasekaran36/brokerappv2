package com.kgisl.brokerapp;
import java.util.*;
public class App{
    public static void main(String[] args) {
        Broker b = new Broker();
        b.addCustomer("CITIBNPPARIA", "TESTPAN001");
        b.addCustomer("STANBACAMALI", "TESTPAN002");
        b.addCustomer("STAN00000263", "TESTPAN003");
        b.addCustomer("CITI00001488", "TESTPAN002");
        b.addCustomer("CITIMACQBANK", "TESTPAN002");
        /* for(Customer a:b.customers.values()){
            System.out.println(a.toString());
        } */
        b.addTradeDetails("src/main/java/resources/tradefile-1.csv");
        
       /*  for(Trade a:b.allTrades)
            System.out.println(a.toString()); */
        b.settle();
    }
}