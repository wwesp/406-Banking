package Accounts.BankAccounts.Money;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import static java.lang.Math.abs;

public class Checking extends MoneyAccounts {
    private String atmCard;
    private ArrayList<String> atmHistory;
    //acctype gold=1, tmb = 0
    private int accType;
    //only one backup per checking
    private String backupAcc;

    private HashMap<String, Double> pendingChecks;
    private HashMap<String, String> acceptedChecks;
    private HashMap<String, String> deniedChecks;
    private ArrayList<String> overDraftHistory;

    public JSONObject getJSON(){
        JSONObject obj = new JSONObject();

        try{
            obj.put("atmHistory",atmHistory);
            obj.put("atmCard",atmCard);
            obj.put("accType",accType);
            obj.put("backupAcc",backupAcc);
            obj.put("pendingChecks",pendingChecks);
            obj.put("acceptedChecks",acceptedChecks);
            obj.put("deniedChecks",deniedChecks);
            obj.put("overDraftHistory",overDraftHistory);
        }
        catch (JSONException e){
            e.printStackTrace();
        }
        return obj;
    }


    public Checking(String ID, String cusID, double balance, String openDate, int accType, String backupAcc,
                    String atmCard, ArrayList<String> atmHistory,HashMap<String, Double> pendingChecks,
                    HashMap<String, String> acceptedChecks, HashMap<String, String> deniedChecks,
                    String lastDayInterestCompounded, ArrayList<String> overDraftHistory){

        super(ID, cusID, balance, openDate, lastDayInterestCompounded);
        this.lastDayInterestCompounded=lastDayInterestCompounded;
        this.accType = accType;
        this.backupAcc = backupAcc;
        this.atmCard=atmCard;

        if(atmHistory==null){
            this.atmHistory=new ArrayList<String>();
        }
        else{
            this.atmHistory=atmHistory;
        }
        if(pendingChecks==null){
            this.pendingChecks=new HashMap<String,Double>();
        }else{
            this.pendingChecks=pendingChecks;
        }

        if(acceptedChecks==null){
            this.acceptedChecks=new HashMap<String,String>();
        }else{
            this.acceptedChecks=acceptedChecks;
        }
        if(deniedChecks==null){
            this.deniedChecks=new HashMap<String,String>();
        }else{
            this.deniedChecks=deniedChecks;
        }

        if(overDraftHistory==null){
            this.overDraftHistory=new ArrayList<String>();
        }
        else {
            this.overDraftHistory=overDraftHistory;
        }


    }


    public void dailyInterest(){
        String today=getTodaysDate();
        if (!today.equals(lastDayInterestCompounded)){

            //that they are gold and that they still have their benefits
            if(accType==1&&getBalancef()>=1000){
                //compound interest
                //.5 percent interest
                //make sure it stays at two decimal places
                balancef=parseDouble(balancef*1.005,0);
            }
            lastDayInterestCompounded=today;
        }

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

    public boolean authorizeWithdrawlATM(double x, ArrayList<RegSavings> y,boolean monthlyTrans ){
        atmHistoryUpdate();
        if(atmHistory.size()>=2){
            return false;
        }

        authorizeWithdrawl(x,y, monthlyTrans);
        atmHistory.add(getTodaysDate());
        return true;
    }

    //true for monthly is yes it is (.75 fee instead of .50)
    //sets up withdrawl
    public void authorizeWithdrawl(double x, ArrayList<RegSavings> y, boolean monthlyTrans) {
        //if gold
        if(accType==1&&getBalancef()>=1000){
            transactionwithdrawl(x,y,0.0);
        }
        else{
            if(!monthlyTrans) {
                transactionwithdrawl(x+0.50, y, 20);
                overDraftHistory.add(getTodaysDate()+":: 0.50");

            }
            else{
                transactionwithdrawl(x+0.75, y, 20);
                overDraftHistory.add(getTodaysDate()+":: 0.75");
            }
        }
    }
    //does the withdral with given penalty
    private void transactionwithdrawl(double x,ArrayList<RegSavings> y, double penalty ){
        double needForSavin;
        //look for backup
        RegSavings savingsAcc = null;

        if(y!=null) {



            for (RegSavings savin : y) {

                if (savin.getID().equals(backupAcc)) {
                    savingsAcc = savin;
                    break;
                }
            }
        }

        //payment

        if (balancef>=x){
            subBalence(x);
        }
        else{
            if(backupAcc==null){
                subBalence(x);
                subBalence(penalty);
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
                    subBalence(penalty);
                }

            }
        }



    }



    public void addBalence(double x,ArrayList<RegSavings> y){
        if(accType==1){
            balancef=balancef+x;
        }else{
            balancef=balancef+x;
            transactionwithdrawl(0.50,y,20);
            overDraftHistory.add(getTodaysDate()+":: 0.50");
        }
    }


    //false means that there is not a check matching anypending checks
    public boolean authStopCheck(String checkNum, ArrayList<RegSavings> y){
        Double doesExist= pendingChecks.get(checkNum);
        if(doesExist==null){
            return false;
        }

        deniedChecks.put(checkNum,getTodaysDate()+"::"+doesExist);
        //15 charge, 14.5 so minus .5 takes away transaction charge
        //transaction charge should not happen on a fine
        authorizeWithdrawl(14.5,y,false);
        pendingChecks.remove(checkNum);

        return true;
    }
    //false means that there is not a check matching anypending checks
    public boolean authPayCheck(String checkNum,ArrayList<RegSavings> y){
        Double doesExist= pendingChecks.get(checkNum);

        if(doesExist==null){
            return false;
        }

        deniedChecks.put(checkNum,getTodaysDate()+"::"+doesExist);
        authorizeWithdrawl(doesExist,y,false);
        pendingChecks.remove(checkNum);
        return true;
    }

    public double endChecking(){
        double endbal=balancef;


        cusID=null;
        balancef=0;
        openDate=null;
        accType=0;
        backupAcc=null;
        atmCard=null;
        atmHistory=null;
        pendingChecks=null;
        acceptedChecks=null;
        deniedChecks=null;
        lastDayInterestCompounded=null;

        return endbal;
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

    public HashMap<String, Double> getPendingChecks() {
        return pendingChecks;
    }

    public HashMap<String, String> getAcceptedChecks() {
        return acceptedChecks;
    }

    public HashMap<String, String> getDeniedChecks() {
        return deniedChecks;
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
