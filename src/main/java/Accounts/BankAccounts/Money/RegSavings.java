package Accounts.BankAccounts.Money;

import org.json.JSONException;
import org.json.JSONObject;

public class RegSavings extends  Savings{


    public RegSavings(String ID, String cusID, double balance, String openDate,double interestRate,String lastDayInterestCompounded){
        super(ID, cusID,balance,openDate,interestRate,lastDayInterestCompounded);
    }

    public boolean authorizeWithdraw(double x){
        //boolean since a withdrawl can fail and we would want the returnie to know

        if(balancef<x){
            return false;
        }
        balancef=balancef-x;
        return true;
    }

    public void authorizeDeposit(double x){
        balancef=balancef+x;
    }

    public double endRegSavings(){
        double endbal=balancef;


        cusID=null;
        balancef=0;
        openDate=null;
        interestRate=0;
        lastDayInterestCompounded=null;

        return endbal;
    }


    }

