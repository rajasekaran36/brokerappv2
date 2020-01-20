package com.kgisl.brokerapp;

import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Customer{
    String customerID;
    String panNumber;
    Boolean onBoard;
    Double brokerCharges;

    public Customer(String customerID, String panNumber, Boolean onBoard, Double brokerCharges) {
        this.customerID = customerID;
        this.panNumber = panNumber;
        this.onBoard = onBoard;
        this.brokerCharges = brokerCharges;
    }
    
    public Customer gCustomer(){
        return this;
    }
    public String getCustomerID() {
        return this.customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getPanNumber() {
        return this.panNumber;
    }

    public void setPanNumber(String panNumber) {
        this.panNumber = panNumber;
    }

    public Boolean isOnBoard() {
        return this.onBoard;
    }

    public Boolean getOnBoard() {
        return this.onBoard;
    }

    public void setOnBoard(Boolean onBoard) {
        this.onBoard = onBoard;
    }

    public Double getBrokerCharges() {
        return this.brokerCharges;
    }

    public void setBrokerCharges(Double brokerCharges) {
        this.brokerCharges = brokerCharges;
    }
    

    @Override
    public String toString() {
        return "{" +
            " customerID='" + getCustomerID() + "'" +
            ", panNumber='" + getPanNumber() + "'" +
            ", onBoard='" + isOnBoard() + "'" +
            ", brokerCharges='" + getBrokerCharges() + "'" +
            "}";
    }
    
    public static ArrayList<Customer> loadCustomerInfoFromFile(String filePath){
        ArrayList<Customer> listOfCustomers = new ArrayList<Customer>();
        File tradeFile = new File(filePath);
        try{
            Scanner fileReader = new Scanner(tradeFile);
            fileReader.nextLine();
            while(fileReader.hasNextLine()){
                String curCustomerString = fileReader.nextLine();
                String[] customerinfo = curCustomerString.split(",");
                listOfCustomers.add(new Customer(customerinfo[0],customerinfo[1],Boolean.parseBoolean(customerinfo[2]),Double.parseDouble(customerinfo[3])));
            }
            fileReader.close();
        }
        catch(FileNotFoundException fnf){
            System.out.println("Cannot Find Customer Info File");
        }
        return listOfCustomers;
    }
}
   