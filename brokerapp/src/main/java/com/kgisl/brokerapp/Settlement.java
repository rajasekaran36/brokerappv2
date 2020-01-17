package com.kgisl.brokerapp;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

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
    Settlement(){}

    public void computeCharges(){ 
        this.marketAmount = rounder(this.totalQty*this.waitAvg);
        Double oneper = rounder(this.marketAmount/100);
        this.brokerageAmount = rounder(oneper*2.5);
        this.gst = rounder(oneper*18);
        this.sttAmount = rounder(oneper*0.017);
        this.stampDuty = rounder(oneper*0.005);
        this.transCharge = rounder(oneper*0.00325);
        this.sebiFee = rounder(oneper*0.002);
        this.totalnet = this.marketAmount+this.brokerageAmount+this.gst+this.sttAmount+this.stampDuty+this.transCharge+this.sebiFee;
    }
    public void setCustomer(Customer c){
        this.aCustomer = c;
    }
    public void setTrade(Trade t){
        this.aTrade = t;
    }
    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append(this.aCustomer.getId()+",");
        sb.append(this.aTrade.getSymbol()+",");
        sb.append(this.totalQty+",");
        sb.append(this.waitAvg+",");
        sb.append(this.marketAmount+",");
        sb.append(this.brokerageAmount+",");
        sb.append(this.gst+",");
        sb.append(this.sttAmount+",");
        sb.append(this.stampDuty+",");
        sb.append(this.transCharge+",");
        sb.append(this.sebiFee+",");
        sb.append(this.totalnet);
        return sb.toString();
    }
    public Double rounder(Double val){
        DecimalFormat df = new DecimalFormat("0.00");
        //System.out.println(val+"ffff"+Double.valueOf(df.format(val)));      
        return new BigDecimal(val).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }
}