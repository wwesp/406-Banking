package Accounts.BankAccounts.Debt;

import java.util.ArrayList;

public class LongTermLoan extends DebtAccounts {
    ArrayList<String> PaymentPlan;
    //last day interest compounded will be last payday
    private String lengthOfLoan;
    private char flag;



    public LongTermLoan(String ID, String cusID, double balance, String openDate,
                        String lastDayInterestCompounded, char flag, String lengthOfLoan){
        super(ID, cusID,balance,openDate, lastDayInterestCompounded);
        this.flag=flag;
        this.lengthOfLoan=lengthOfLoan;
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
