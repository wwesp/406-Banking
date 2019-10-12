package Accounts;


import org.json.JSONException;
import org.json.JSONObject;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;



abstract public class MoneyAccounts {

    private String accountNumber;
    private String routingNumber;
    private double balence;
    String SSN;
    private LinkedHashMap<Integer, String> history;


    private static Lock lock = new ReentrantLock();



    public MoneyAccounts(String SSN,String accountNumber, String routingNumber, double balence, LinkedHashMap<Integer, String> history){
        this.SSN=SSN;
        history=new LinkedHashMap<>();
        this.accountNumber=accountNumber;
        this.routingNumber=routingNumber;
        this.balence=balence;
        this.history=history;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getRoutingNumber() {
        return routingNumber;
    }

    public double getBalence() {
        return balence;
    }

    public LinkedHashMap<Integer, String> getHistory() {
        return history;
    }

    private void changeBalence(double amt){
        //amt if positive is adding funds, amt if negative removes funds

        try{
            lock.lock();
            Thread.sleep(5);
            balence+=amt;
            lock.unlock();
        }
        catch (InterruptedException ex){

        }


    }//end of changeBalence

    public boolean authorizePayment(double amt){
        //if return true it worked, false is a fail authorized
        if(doIHave(amt)){
            changeBalence(amt);
            catalog();
            return true;
        }
        else{
            return false;
        }


    }//end of authpayment

    public boolean doIHave(double amt){
        //do I have x amt
        //seperate from authorize since that is going though with the whole payment
        return amt<balence;
    }
    public String getSSN(){
        return SSN;
    }

    public JSONObject getJSON() {
        //the toString on this method is made for the database

        JSONObject obj = new JSONObject();
        try {
            obj.put("SSN", getSSN());
            obj.put("AccountNumber", getAccountNumber());
            obj.put("RoutingNumber", getRoutingNumber());
            obj.put("Balence", getBalence());
            obj.put("History",getHistory());
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return obj;
    }

    @Override
    public String toString(){


        //new line and :-=-: seperate data, and :=: seperate data in each datapool
        return  getSSN()+":=:"+
                getAccountNumber()+":=:"+
                getRoutingNumber()+":=:"+
                getBalence()+":=:"+
                getHistory().toString()+":-=-:\n";
    }

    private void catalog(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        history.put(history.size()+1, dtf.format(now) + " :: "+ balence);
    }




}//end of moneyAccounts
