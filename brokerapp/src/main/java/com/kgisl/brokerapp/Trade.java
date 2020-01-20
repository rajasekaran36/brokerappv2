package com.kgisl.brokerapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Trade{
    String customerId;
    String symbol;
    Integer qty;
    Double rate;
    String date;
    

    public Trade(String customerId, String symbol, Integer qty, Double rate, String date) {
        this.customerId = customerId;
        this.symbol = symbol;
        this.qty = qty;
        this.rate = rate;
        this.date = date;
    }

    
    public String getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Integer getQty() {
        return this.qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Double getRate() {
        return this.rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

   

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "{" +
            " customerId='" + getCustomerId() + "'" +
            ", symbol='" + getSymbol() + "'" +
            ", qty='" + getQty() + "'" +
            ", rate='" + getRate() + "'" +
            ", date='" + getDate() + "'" +
            "}";
    }
    public static ArrayList<Trade> loadTradeInfoFromFile(String filePath){
        ArrayList<Trade> listOfTrades = new ArrayList<Trade>();
        File tradeFile = new File(filePath);
        try{
            Scanner fileReader = new Scanner(tradeFile);
            fileReader.nextLine();
            while(fileReader.hasNextLine()){
                String curTradeString = fileReader.nextLine();
                String[] tradeInfo = curTradeString.split(",");
                listOfTrades.add(new Trade(tradeInfo[0], tradeInfo[1], Integer.parseInt(tradeInfo[2]), Double.parseDouble(tradeInfo[3]), tradeInfo[4]));
            }
            fileReader.close();
        }
        catch(FileNotFoundException fnf){
            System.out.println("Cannot Find Trade File");
        }
        return listOfTrades;
    }
}