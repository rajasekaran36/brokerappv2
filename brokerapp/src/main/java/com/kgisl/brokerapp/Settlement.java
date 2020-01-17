package com.kgisl.brokerapp;

public class Settlement{
    Customer aCustomer;
    Trade aTrade;
    Integer totalQty;
    Double waitAvg;
    Double marketAmount;
    Double brokerageAmount;
    Double gst;
    Double sttAmount;
    Double stampDuty;
    Double transCharge;
    Double sebiFee;
    Double totalnet;
    Settlement(Customer aCustomer, Trade aTrade,Integer totalQty, Double waitAvg){
        this.aCustomer = aCustomer;
        this.aTrade = aTrade;
        this.totalQty = totalQty;
        this.waitAvg = waitAvg;
        computeCharges();
    }
    void computeCharges(){ 
        this.marketAmount = this.totalQty*this.waitAvg;
        Double oneper = this.marketAmount/100;
        this.brokerageAmount = oneper*2.5;
        this.gst = oneper*18;
        this.sttAmount = oneper*0.017;
        this.stampDuty = oneper*0.005;
        this.transCharge = oneper*0.00325;
        this.sebiFee = oneper*0.002;
        this.totalnet = this.marketAmount+this.brokerageAmount+this.gst+this.sttAmount+this.stampDuty+this.transCharge+this.sebiFee;
    }
}