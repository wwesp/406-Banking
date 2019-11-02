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
