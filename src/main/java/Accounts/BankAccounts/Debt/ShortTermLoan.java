package Accounts.BankAccounts.Debt;

//same as long term loan just diff object

import java.util.ArrayList;
import java.util.HashMap;

public class ShortTermLoan extends LongTermLoan {

    public ShortTermLoan(String ID, String cusID, double balance, double interestRate, String datePaymentDue,
                         String notifyDate, double currentPaymentDue, char missedPaymentflag, String lastPaymentDate,
                         char yearType, double fees, HashMap<String, Double> missedPayment,
                         HashMap<String, Double> paymentHistory , ArrayList<String> extraPayMentHistory ){

        super(ID, cusID, balance, interestRate, datePaymentDue, notifyDate, currentPaymentDue, missedPaymentflag,
                lastPaymentDate, yearType, fees, missedPayment, paymentHistory, extraPayMentHistory);
    }

    /*
    5 years
    fixed rate, fixed payment plan
    if late +$75 fee
    if missed payment, account is flagged as problem account
    extra payments can be made
     */

}
