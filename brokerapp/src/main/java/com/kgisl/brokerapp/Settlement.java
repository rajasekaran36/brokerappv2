package com.kgisl.brokerapp;

public class Settlement{
    String customerId;
    String symbol;
    Double brokerCharge;
    Integer totalqty;
    Double marketAmount;
    Double brokerageAmount;
    Double gst;
    Double sttAmount;
    Double stampDuty;
    Double transCharge;
    Double sebiFee;
    Double totalnet;
    Charges charges;

    public Settlement(String customerId, String symbol,Integer totalqty, Double marketAmount,Double brokerCharge,Charges charges) {
        this.customerId = customerId;
        this.symbol = symbol;
        this.totalqty = totalqty;
        this.marketAmount = marketAmount;
        this.brokerCharge = brokerCharge;
        this.charges = charges;
    }

    public void computeSettlement(){
        this.brokerageAmount = (this.marketAmount/100)*this.brokerCharge;
        Double onePercentOfBrokerAmount = this.getBrokerageAmount()/100;
        this.gst = onePercentOfBrokerAmount*this.charges.getGstCharge();
        this.sttAmount = onePercentOfBrokerAmount*this.charges.getSttCharge();
        this.stampDuty = onePercentOfBrokerAmount*this.charges.getStampDutyCharge();
        this.transCharge = onePercentOfBrokerAmount*this.charges.getTransactionCharge();
        this.sebiFee = onePercentOfBrokerAmount*this.charges.getSebiCharges();
        this.totalnet = this.marketAmount+this.brokerageAmount+this.gst+this.sttAmount+this.stampDuty+this.transCharge+this.sebiFee;
    }

    public String getCustomerId() {
        return this.customerId;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public Double getBrokerCharge() {
        return this.brokerCharge;
    }

    public Integer getTotalqty() {
        return this.totalqty;
    }
    public Double getMarketAmount() {
        return this.marketAmount;
    }

    public Double getBrokerageAmount() {
        return this.brokerageAmount;
    }

    public Double getGst() {
        return this.gst;
    }

    public Double getSttAmount() {
        return this.sttAmount;
    }

    public Double getStampDuty() {
        return this.stampDuty;
    }

    public Double getTransCharge() {
        return this.transCharge;
    }

    public Double getSebiFee() {
        return this.sebiFee;
    }

    public Double getTotalnet() {
        return this.totalnet;
    }


    @Override
    public String toString() {
        return "{" +
            " customerId='" + getCustomerId() + "'" +
            ", symbol='" + getSymbol() + "'" +
            ", brokerCharge='" + getBrokerCharge() + "'" +
            ", totalqty='" + getTotalqty() + "'" +
            ", marketAmount='" + getMarketAmount() + "'" +
            ", brokerageAmount='" + getBrokerageAmount() + "'" +
            ", gst='" + getGst() + "'" +
            ", sttAmount='" + getSttAmount() + "'" +
            ", stampDuty='" + getStampDuty() + "'" +
            ", transCharge='" + getTransCharge() + "'" +
            ", sebiFee='" + getSebiFee() + "'" +
            ", totalnet='" + getTotalnet() + "'" +
            "}";
    }

} 