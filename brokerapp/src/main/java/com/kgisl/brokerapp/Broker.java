package com.kgisl.brokerapp;
import java.util.ArrayList;
import java.util.HashMap;

public class Broker{
    HashMap<String,Customer> customers;
    ArrayList<Trade> trades;
    Charges tradeCharges;
    ArrayList<Settlement> settlements;
    Broker(){
        this.customers = new HashMap<String,Customer>();
        this.trades = new ArrayList<Trade>();
        this.tradeCharges = new Charges(18.0, 0.017, 0.005, 0.00325, 0.002);
        settlements = new ArrayList<Settlement>();
    }
    public boolean addCustomer(String customerID, String panNumber, boolean onBoard,Double brokerCharge){
        if(!customerID.equals(null)&&!panNumber.equals(null)){
            Customer aCustomer = new Customer(customerID, panNumber, onBoard,brokerCharge);
            customers.put(aCustomer.getCustomerID(), aCustomer);
            return true;
        }
        else
            return false;
    }

    public String checkCustomer(String customerID){
    
        return customers.get("customerID").toString();
    }

    public void mapCustomers(ArrayList<Customer> listOfCustomers){
        for(Customer aCustomer:listOfCustomers)
            customers.put(aCustomer.getCustomerID(), aCustomer);
    }

    public String getCustomerDetails(){
        String customerInfo = "";
        for(Customer aCustomer:customers.values())
            customerInfo = customerInfo+aCustomer.toString()+"\n";
        return customerInfo;
    }

    public String getTradeDetails(ArrayList<Trade> listOfTrades){
        String tradeInfo = "";
        for(Trade aTrade:listOfTrades){
            tradeInfo = tradeInfo+aTrade.toString()+"\n";
        }
        return tradeInfo;
    }
    public void doSettlement(String customerID){
        ArrayList<Trade> tradesByCustomer = new ArrayList<Trade>();
        for(Trade aTrade:trades){
            if(aTrade.getCustomerId().equals(customerID)){
                tradesByCustomer.add(aTrade);
                //System.out.println("Cus Match");
            } 
        }
        HashMap<String,ArrayList<Trade>> customerTradesGroup = new HashMap<String,ArrayList<Trade>>();
        
        for(Trade aTrade:tradesByCustomer){customerTradesGroup.put(aTrade.getSymbol(), new ArrayList<Trade>());}

        for(Trade aTrade:tradesByCustomer){
            customerTradesGroup.get(aTrade.getSymbol()).add(aTrade);
        }

        for(ArrayList<Trade> customerTradeSpecficToSymbol:customerTradesGroup.values()){
            Double marketAmount = 0.0;
            Integer totalqty = 0;
            String customerIDF = null;
            String symbol = null;
            Double brokerCharge =0.0;

            for(Trade aTrade:customerTradeSpecficToSymbol){
                customerIDF = aTrade.getCustomerId();
                symbol = aTrade.getSymbol();
                brokerCharge = customers.get(customerIDF).getBrokerCharges();
                marketAmount = marketAmount + (aTrade.getQty()*aTrade.getRate());
                totalqty = totalqty + aTrade.getQty();
                
            }
            Settlement x = new Settlement(customerIDF, symbol, totalqty, marketAmount, brokerCharge, this.tradeCharges);
            x.computeSettlement();
            settlements.add(x);
        }

    }

    public void getSettlement(){
        for(Settlement aContract:settlements){
            System.out.println(aContract.toString()+"\n");
        }
    }

   /*  public boolean isRateChanging(ArrayList<Trade> listOfTrades){
        if
        for()
        return false;
    } */
    /* public ArrayList<Trade> getCustomerSpecificTrades(Customer a){
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
    } */
}