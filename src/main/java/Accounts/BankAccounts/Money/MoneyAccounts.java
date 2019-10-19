package Accounts.BankAccounts.Money;

import Accounts.BankAccounts.Accounts;


abstract class  MoneyAccounts extends Accounts {


    public MoneyAccounts(String ID, String cusID, double balance, String openDate){
        super(ID,cusID,balance,openDate);
    }

    public void addBalence(double x){
        balancef=balancef+x;
    }


    protected void subBalence(double x){
        balancef=balancef-x;
    }

    protected void authorizeWithdrawl(double x){
        return;
    }



}
