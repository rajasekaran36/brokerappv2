package com.kgisl.brokerapp;

public class App{
    public static void main(String[] args) {
        Broker b = new Broker();
        b.mapCustomers(Customer.loadCustomerInfoFromFile("src/main/java/resources/clientinfo.csv"));
        System.out.println(b.getCustomerDetails());
        b.trades = Trade.loadTradeInfoFromFile("src/main/java/resources/tradefile-1.csv");
        for(Customer aCustomer:b.customers.values()){
            System.out.println(aCustomer.getCustomerID());
            System.out.println("--------------------------------------");
            b.doSettlement(aCustomer.getCustomerID());
            System.out.println("Settlement Done For:"+aCustomer.getCustomerID());
        }
        b.getSettlement();
        
        //b.doSettlement("CITIBNPPARIA");
        //b.getSettlement();

        /* System.out.println(b.addCustomer("CITIBNPPARIA", "TESTPAN001",true));
        System.out.println(b.addCustomer("STANBACAMALI", "TESTPAN002",true));
        System.out.println(b.addCustomer("STAN00000263", "TESTPAN003",true));
        System.out.println(b.addCustomer("CITI00001488", "TESTPAN002",true));
        System.out.println(b.addCustomer("CITIMACQBANK", "TESTPAN002",true)); */
       /* 
        b.addTradeDetails("src/main/java/resources/tradefile-1.csv");
        
       for(Trade a:b.allTrades)
            System.out.println(a.toString());
        b.settle(b.customers.get("CITIBNPPARIA"));
        b.getSettlement(); */

        /* for(Trade aTrade:Trade.fileToTrades("src/main/java/resources/tradefile-1.csv")){
            System.out.println(aTrade.toString());
        } */
    }
}