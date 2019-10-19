package Accounts.BankAccounts.Money;

import Accounts.BankAccounts.Accounts;


abstract class  MoneyAccounts extends Accounts {


    public MoneyAccounts(String ID, String cusID, double balance, String openDate){
        super(ID,cusID,balance,openDate);
    }

    protected void addBalence(double x){
        balancef=balancef+x;
    }

    public void subBalence(double x){
        balancef=balancef-x;
    }



    protected void authorizeWithdrawl(double x){
        return;
    }



}
