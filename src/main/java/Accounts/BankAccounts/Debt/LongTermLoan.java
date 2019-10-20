package Accounts.BankAccounts.Debt;

public class LongTermLoan extends DebtAccounts {

    public LongTermLoan(String ID, String cusID, double balance, String openDate,String lastDayInterestCompounded){
        super(ID, cusID,balance,openDate, lastDayInterestCompounded);
    }

    /*
    15 or 30 year loans
    fixed rate, fixed payment plan
    if late +$75 fee
    if missed payment, account is flagged as problem account
    extra payments can be made
     */

}
