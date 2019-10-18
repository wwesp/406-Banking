package Accounts.BankAccounts.Debt;

public class LongTermLoan extends DebtAccounts {

    public LongTermLoan(String ID, int cusID, double balance, String openDate){
        super(ID, cusID,balance,openDate);
    }

    /*
    15 or 30 year loans
    fixed rate, fixed payment plan
    if late +$75 fee
    if missed payment, account is flagged as problem account
    extra payments can be made
     */

}
