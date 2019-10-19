package Accounts.BankAccounts.Money;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static java.lang.Math.abs;

public class Checking extends MoneyAccounts {
    private String atmCard;
    private ArrayList<String> atmHistory;
    private int accType;
    //only one backup per checking
    private String backupAcc;

    public Checking(String ID, String cusID, double balance, String openDate, int accType, String backupAcc, String atmCard, ArrayList<String> atmHistory){
        super(ID, cusID, balance, openDate);
        this.accType = accType;
        this.backupAcc = backupAcc;
        this.atmCard=atmCard;
        if(atmHistory==null){
            ArrayList<String> his = new ArrayList<>();
            this.atmHistory=his;
        }
        else{
            this.atmHistory=atmHistory;
        }


    }
    private String getTodaysDate(){
        SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy");
        return format.format(new Date());
    }

    public void atmHistoryUpdate(){
        ArrayList<String> newAtmHistory=new ArrayList<>();
        String today=getTodaysDate();
        for(int i=0;i<atmHistory.size();i++){
            if(atmHistory.get(i).equals(today)){
                newAtmHistory.add(atmHistory.get(i));
            }
        }
        atmHistory=newAtmHistory;
    }

    public boolean authorizeWithdrawlATM(double x, ArrayList<RegSavings> y ){
        atmHistoryUpdate();
        if(atmHistory.size()>=2){
            return false;
        }

        authorizeWithdrawl(x,y);
        atmHistory.add(getTodaysDate());
        return true;
    }

    public void authorizeWithdrawl(double x, ArrayList<RegSavings> y) {
        double needForSavin;
        //look for backup
        RegSavings savingsAcc = null;




        for(RegSavings savin: y){

            if (savin.getID().equals(backupAcc)){
                savingsAcc=savin;
                break;
            }
        }


        //payment

        if (balancef>=x){
            subBalence(x);
        }
        else{
            if(backupAcc==null){
                subBalence(x);
                subBalence(25);
            }
            else if(backupAcc!=null && savingsAcc==null){
                System.out.println("Wrong input to AuthWith");
            }
            else{

                needForSavin=abs(getBalancef()-x);

                if(savingsAcc.getBalancef()>=needForSavin){
                    balancef=0;
                    savingsAcc.subBalence(x);
                }
                else{
                    //the savings account did not have enough so you have overdrawn
                    subBalence(x);
                    subBalence(25);
                }
                //TODO: finish this
            }
        }



    }

    public String getAtmCard() {
        return atmCard;
    }

    public ArrayList<String> getAtmHistory() {
        atmHistoryUpdate();
        return atmHistory;
    }

    public int getAccType() {
        return accType;
    }

    public String getBackupAcc() {
        return backupAcc;
    }


    /*
    two types of checking accounts. TMB and gold/diamond
    TMB: $0.50 per transaction (deposit and withdraw)
         $0.75 monthly transfers (mortgages, payments of bills, or transfers money to other accounts
         no minimum balance

    gold/diamond: minimum balance of $1000.00
                  no charge for transaction if min balance is maintained
                  earns interest on average balance
                  flexible interest rate changes daily and 0.5% of the savings account

    services:
        1) stop payment
            cancels a check by the check number $15 fee
        2) overdraft
            returns check unpaid and charges a %20 fee
            if savings account is a "overdraft" account then it can be used to cover check
    */

}
