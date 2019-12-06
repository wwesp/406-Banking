package Accounts.BankAccounts.Debt;

import Accounts.BankAccounts.Accounts;


import java.text.SimpleDateFormat;
import java.util.*;

public abstract class DebtAccounts extends Accounts {
    protected double interestRate;
    protected String datePaymentDue;
    protected String notifyDate;
    protected double currentPaymentDue;
    protected char missedPaymentFlag;
    protected String lastPaymentDate;
    protected double fees;




    //payment history key is (date+balence+dueOfPaid),currentpaymentdue the other hash part is just
    // balence, sperated like date::balence::dateofPaid
    protected HashMap<String, Double> paymentHistory;


    public DebtAccounts(String ID, String cusID, double balance, double interestRate, String datePaymentDue,
                        String notifyDate, double currentPaymentDue, char missedPaymentflag,
                        String lastPaymentDate, double fees,
                        HashMap<String, Double> paymentHistory) {
        super(ID, cusID, balance);

        this.interestRate = interestRate;
        this.datePaymentDue = datePaymentDue;
        this.notifyDate = notifyDate;
        this.currentPaymentDue = currentPaymentDue;
        this.missedPaymentFlag = missedPaymentflag;
        this.lastPaymentDate = lastPaymentDate;
        this.fees = fees;




        if (paymentHistory == null) {
            this.paymentHistory = new HashMap<String, Double>();
        } else {
            this.paymentHistory = paymentHistory;
        }


    }

    public boolean isNotiifyDate(){
        Date today = getTodayDateAsDate();
        SimpleDateFormat simpleDateformat = new SimpleDateFormat("MM");
        String month=simpleDateformat.format(today);
        simpleDateformat= new SimpleDateFormat("yyyy");
        String year= simpleDateformat.format(today);
        String notformat= month+"-"+notifyDate+"-"+year;
        String dueformat= month+"-"+datePaymentDue+"-"+year;

        Date notDate= convertStringToDate(notformat);
        Date dateDue= convertStringToDate(dueformat);

        //flag
        int flag= 0;

        if (today.after(notDate)&&today.before(dateDue)){
            //now see if its been paid
            for (String x: paymentHistory.keySet()){
                String[] y= x.split("::",3);
                String temp=y[2];
                Date paid= convertStringToDate(temp);
                if(paid.after(today)){
                    flag=1;
                }
            }
            if(flag==0){
                return true;
            }
        }
        return false;
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

    public HashMap<String, Double> getPaymentHistory() {
        return paymentHistory;
    }

}
