package Accounts.BankAccounts.Debt;

public class ShortTermLoan extends DebtAccounts {

    public ShortTermLoan(String ID, String cusID, double balance, String openDate,String lastDayInterestCompounded){
        super(ID, cusID,balance,openDate, lastDayInterestCompounded);
    }

    /*
    5 years
    fixed rate, fixed payment plan
    if late +$75 fee
    if missed payment, account is flagged as problem account
    extra payments can be made
     */

}
