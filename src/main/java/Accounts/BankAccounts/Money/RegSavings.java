package Accounts.BankAccounts.Money;


import SystemHelper.SystemHelper;
import persistence.GetData.GetData;

import java.awt.*;

public class RegSavings extends  Savings{


    public RegSavings(String ID, String cusID, double balance, String openDate,double interestRate,String lastDayInterestCompounded){
        super(ID, cusID,balance,openDate,interestRate,lastDayInterestCompounded);
    }
    public RegSavings(String cusId, double initalBalence){
        this("",cusId,initalBalence,"",0,"");
        this.interestRate= new GetData().getIntRates().getCDInterest();
        SystemHelper IamHelper = new SystemHelper();
        this.ID= IamHelper.makeRandomId();
        this.openDate=getTodaysDate();

    }


    public boolean authorizeWithdraw(double x){
        //boolean since a withdrawl can fail and we would want the returnie to know

        if(balancef<x){
            return false;
        }
        balancef=new SystemHelper().perciseSubtract(balancef,x);
        return true;
    }

    public void authorizeDeposit(double x){
        balancef= new SystemHelper().perciseAddition(balancef,x);

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

    public double endAccount(){
        double endbal=balancef;


        cusID="";
        balancef=0;
        openDate="";
        interestRate=0;
        lastDayInterestCompounded="";

        return endbal;
    }


    }

