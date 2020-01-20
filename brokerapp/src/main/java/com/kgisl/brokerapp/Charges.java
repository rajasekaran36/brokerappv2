package com.kgisl.brokerapp;
public class Charges{
    Double gstCharge;
    Double sttCharge;
    Double stampDutyCharge;
    Double transactionCharge;
    Double sebiCharges;

    public Charges(Double gstCharge, Double sttCharge, Double stampDutyCharge, Double transactionCharge, Double sebiCharges) {
        this.gstCharge = gstCharge;
        this.sttCharge = sttCharge;
        this.stampDutyCharge = stampDutyCharge;
        this.transactionCharge = transactionCharge;
        this.sebiCharges = sebiCharges;
    }


    public Double getGstCharge() {
        return this.gstCharge;
    }

    public void setGstCharge(Double gstCharge) {
        this.gstCharge = gstCharge;
    }

    public Double getSttCharge() {
        return this.sttCharge;
    }

    public void setSttCharge(Double sttCharge) {
        this.sttCharge = sttCharge;
    }

    public Double getStampDutyCharge() {
        return this.stampDutyCharge;
    }

    public void setStampDutyCharge(Double stampDutyCharge) {
        this.stampDutyCharge = stampDutyCharge;
    }

    public Double getTransactionCharge() {
        return this.transactionCharge;
    }

    public void setTransactionCharge(Double transactionCharge) {
        this.transactionCharge = transactionCharge;
    }

    public Double getSebiCharges() {
        return this.sebiCharges;
    }

    public void setSebiCharges(Double sebiCharges) {
        this.sebiCharges = sebiCharges;
    }

    @Override
    public String toString() {
        return "{" +
            ", gstCharge='" + getGstCharge() + "'" +
            ", sttCharge='" + getSttCharge() + "'" +
            ", stampDutyCharge='" + getStampDutyCharge() + "'" +
            ", transactionCharge='" + getTransactionCharge() + "'" +
            ", sebiCharges='" + getSebiCharges() + "'" +
            "}";
    }

}