package Accounts.BankAccounts.Money;

import org.json.JSONException;
import org.json.JSONObject;

public abstract class Savings extends MoneyAccounts {
    double interestRate;


    public Savings(String ID, String cusID, double balance, String openDate,double interestRate,String lastDayInterestCompounded){
        super(ID, cusID,balance,openDate,lastDayInterestCompounded);
        this.interestRate = interestRate;
    }
    public JSONObject getJSON(){
        JSONObject obj = new JSONObject();

        try{
            obj.put("ID",ID);
            obj.put("cusID",cusID);
            obj.put("balance",balancef);
            obj.put("openDate",openDate);
            obj.put("lastDayInterestCompounded",lastDayInterestCompounded);
            obj.put("interestRate",interestRate);
        }
        catch (JSONException e){
            e.printStackTrace();
        }
        return obj;
    }


    public void dailyInterest(){

        String today=getTodaysDate();
        if (!today.equals(lastDayInterestCompounded)){
            //compound interest
            //.5 percent interest
            //make sure it stays at two decimal places
            balancef=parseDouble(balancef*interestRate,0);
            lastDayInterestCompounded=today;
        }


    }

    public double getInterestRate() {
        return interestRate;
    }
}
