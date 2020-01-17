package com.kgisl.brokerapp;
public class Customer{
    private String id;
    private String panID;
    private boolean onBoard;
    Customer(){
        this.id = "not yet";
        this.panID="no info";
        this.onBoard = false;
    }
    public boolean setId(String id){
        this.id = id;
        return true;
    }
    public boolean setPanId(String panID){
        this.panID = panID;
        return true;
    }
    public boolean makeOnBoard(boolean onBoard){
        this.onBoard = onBoard;
        return true;
    }
    public String toString(){
        return this.id+"\t"+this.panID+"\t"+this.onBoard;
    }
    public String getId(){
        return this.id;
    }
}