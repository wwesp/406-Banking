package Accounts.BankAccounts.Debt;

//same as long term loan just diff object

public class ShortTermLoan extends LongTermLoan {

    public ShortTermLoan(String ID, String cusID, double balance, String openDate,
                         String lastDayInterestCompounded ,char flag, String lengthOfLoan){
        super(ID, cusID,balance,openDate, lastDayInterestCompounded,flag, lengthOfLoan);
    }

    /*
    5 years
    fixed rate, fixed payment plan
    if late +$75 fee
    if missed payment, account is flagged as problem account
    extra payments can be made
     */

}
