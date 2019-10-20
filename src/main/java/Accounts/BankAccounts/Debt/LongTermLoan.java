package Accounts.BankAccounts.Debt;

import java.util.ArrayList;
import java.util.HashMap;

public class LongTermLoan extends DebtAccounts {
    ArrayList<String> PaymentPlan;


    char yearType;




    public LongTermLoan(String ID, String cusID, double balance,String interestRate, String datePaymentDue,
                        String notifyDate, double currentPaymentDue, char missedPaymentflag, String lastPaymentDate,
                        char yearType,double fees, HashMap<String, Double> missedPayment,
                        HashMap<String, Double> paymentHistory  ){

        super(ID, cusID, balance, interestRate, datePaymentDue, notifyDate, currentPaymentDue, missedPaymentflag,
                lastPaymentDate,fees,missedPayment,paymentHistory);
        this.yearType=yearType;




    }

    private void developPaymentPlan(){
        //payment plans are dynamic due to extra payments possible


    }







    /*
    15 or 30 year loans
    fixed rate, fixed payment plan
    if late +$75 fee
    if missed payment, account is flagged as problem account
    extra payments can be made
     */

}
