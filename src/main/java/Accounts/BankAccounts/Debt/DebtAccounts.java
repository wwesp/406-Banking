package Accounts.BankAccounts.Debt;

import Accounts.BankAccounts.Accounts;


import java.text.SimpleDateFormat;
import java.util.*;

public abstract class DebtAccounts extends Accounts{
    protected double interestRate;
    protected String datePaymentDue;
    protected String notifyDate;
    protected double currentPaymentDue;
    protected char missedPaymentFlag;
    protected String lastPaymentDate;
    protected double fees;

    //this wont be in the database
    protected double feeAmt;
    //date, amt
    protected HashMap<String, Double> missedPayment;

    //payment history key is (date+balence+dueOfPaid),currentpaymentdue the other hash part is just
    // balence, sperated like date::balence::dateofPaid
    protected HashMap<String, Double> paymentHistory;

    //formatted like Date::AMT
    protected ArrayList<String> extraPayMentHistory;


    public DebtAccounts(String ID, String cusID, double balance,double interestRate, String datePaymentDue,
                        String notifyDate, double currentPaymentDue, char missedPaymentflag,
                        String lastPaymentDate, double fees , HashMap<String, Double> missedPayment,
                        HashMap<String, Double> paymentHistory,ArrayList<String> extraPayMentHistory,double feeAMt ){
        super(ID, cusID, balance);
        this.feeAmt=feeAMt;
        this.interestRate=interestRate;
        this.datePaymentDue=datePaymentDue;
        this.notifyDate=notifyDate;
        this.currentPaymentDue=currentPaymentDue;
        this.missedPaymentFlag=missedPaymentflag;
        this.lastPaymentDate=lastPaymentDate;
        this.fees=fees;


        if (missedPayment==null){
            this.missedPayment=new HashMap<String,Double>();
        }
        else{
            this.missedPayment=missedPayment;
        }

        if (paymentHistory==null){
            this.paymentHistory=new HashMap<String,Double>();
        }
        else {
            this.paymentHistory=paymentHistory;
        }


        if(extraPayMentHistory==null){
            this.extraPayMentHistory=new ArrayList<String>();

        }
        else{
            this.extraPayMentHistory=extraPayMentHistory;
        }

    }



    public double getInterestRate() {
        return interestRate;
    }

    public String getDatePaymentDue() {
        return datePaymentDue;
    }

    public String getNotifyDate() {
        return notifyDate;
    }

    public double getCurrentPaymentDue() {
        return currentPaymentDue;
    }

    public char getMissedPaymentFlag() {
        return missedPaymentFlag;
    }

    public String getLastPaymentDate() {
        return lastPaymentDate;
    }

    public double getFees() {
        return fees;
    }

    public double getFeeAmt() {
        return feeAmt;
    }

    public HashMap<String, Double> getMissedPayment() {
        return missedPayment;
    }

    public HashMap<String, Double> getPaymentHistory() {
        return paymentHistory;
    }

    public ArrayList<String> getExtraPayMentHistory() {
        return extraPayMentHistory;
    }
}