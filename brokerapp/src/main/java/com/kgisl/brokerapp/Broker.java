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
    
    
    public void settle(Customer x){
        x.customerTrades = getCustomerSpecificTrades(x);
        HashMap<String,ArrayList<Trade>> catog = new HashMap<String,ArrayList<Trade>>();
        for(Trade t:x.customerTrades){
            String tradeSymbol = t.getSymbol();
            catog.put(tradeSymbol, new ArrayList<Trade>());
        }
        for(Trade t:x.customerTrades){
            String tradeSymbol = t.getSymbol();
            catog.get(tradeSymbol).add(t);
        }
        for(ArrayList<Trade> al:catog.values()){
            Settlement s= new Settlement();
            s.setCustomer(x);
            Double marketAm=0.0;
            for(Trade l:al){
                s.setTrade(l);
                marketAm = marketAm+l.amount;
                System.out.println(l.toString());
            }
            s.marketAmount=marketAm;
            s.computeCharges();
            settlements.add(s);
            System.out.println("-------------------------------------");
        }
    }
    public void getSettlement(){
        for(Settlement s:settlements){
            System.out.println("-------------------------");
            String[] de = s.toString().split(",");
            System.out.println("Client ID   :"+de[0]);
            System.out.println("Symbol      :"+de[1]);
            //System.out.println("Total Qty   :"+de[2]);
            //System.out.println("Total Rate  :"+de[3]);
            System.out.println("Market Rate :"+de[2]);
            System.out.println("Brock Charge:"+de[3]);
            System.out.println("GST         :"+de[4]);
            System.out.println("STT Amount  :"+de[5]);
            System.out.println("Stampduty   :"+de[6]);
            System.out.println("Trans Charge:"+de[7]);
            System.out.println("SEBI Fee    :"+de[8]);
            System.out.println("Total NET   :"+de[9]);
            System.out.println("-------------------------");
        }
    }

}
