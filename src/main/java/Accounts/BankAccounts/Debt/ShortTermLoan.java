package Accounts.BankAccounts.Debt;

public class ShortTermLoan extends DebtAccounts {

    public ShortTermLoan(String ID, int cusID, double balance, String openDate){
        super(ID, cusID,balance,openDate);
    }

    /*
    5 years
    fixed rate, fixed payment plan
    if late +$75 fee
    if missed payment, account is flagged as problem account
    extra payments can be made
     */

}
