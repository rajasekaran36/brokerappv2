package com.kgisl.brokerapp;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.*;
import java.io.*;

public class Broker{
    HashMap<String,Customer> customers;
    ArrayList<Trade> allTrades;
    ArrayList<Settlement> settlements;
    Broker(){
        this.customers = new HashMap<String,Customer>();
        this.allTrades = new ArrayList<Trade>();
        settlements = new ArrayList<Settlement>();
    }
    public boolean addCustomer(String id, String pan){
        if(!id.equals(null)&&!pan.equals(null)){
            Customer aCustomer = new Customer();
            aCustomer.setId(id);
            aCustomer.setPanId(pan);
            aCustomer.makeOnBoard(true);
            customers.put(id, aCustomer);
            System.out.println("Customer Added");
            return true;
        }
        else
            return false;
    }

    public void addTradeDetails(String fileName){
        try{
            File aFile = new File(fileName);
            Scanner inFile = new Scanner(aFile);
            inFile.nextLine();
            while(inFile.hasNextLine()){
                String[] aTradeString = inFile.nextLine().split(",");
                Trade aTrade = new Trade(customers.get(aTradeString[0]), aTradeString[1], Integer.parseInt(aTradeString[2]), Double.parseDouble(aTradeString[3]));
                allTrades.add(aTrade);
                //System.out.println("---Done--");
            }
        }
        catch(FileNotFoundException nf){
            nf.printStackTrace();
        }
    }

    public ArrayList<Trade> getCustomerSpecificTrades(Customer a){
        ArrayList<Trade> al = new ArrayList<Trade>();
        for(Trade aTrade:allTrades){
            if(aTrade.aCustomer.getId()==a.getId()){
                al.add(aTrade);
            }
        }
        return al;
    }
    public ArrayList<Trade> getCustomerSpecificSymbolTrades(Customer a, String symbol){
        ArrayList<Trade> al = new ArrayList<Trade>();
        for(Trade aTrade:allTrades){
            if(aTrade.aCustomer.getId()==a.getId()&&aTrade.getSymbol()==symbol){
                al.add(aTrade);
            }
        }
        return al;
    }
    public void settle(){
        for(Customer x:customers.values()){
            ArrayList<Trade> cusTrades = getCustomerSpecificTrades(x);
            Set<String> symbols = new HashSet<String>();
            for(Trade s:cusTrades){
                symbols.add(s.getSymbol());
            }
            String setS = String.join(",", symbols);
            System.out.println(setS);
            for(String s:(String[])setS.split(",")){
                for(Trade t:cusTrades){
                    if(t.getSymbol()==s)
                        System.out.println(t.toString());
                }
            }
        }
    }
}
