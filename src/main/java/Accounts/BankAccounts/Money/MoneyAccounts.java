package Accounts.BankAccounts.Money;

import Accounts.BankAccounts.Accounts;


abstract class  MoneyAccounts extends Accounts {
    protected String lastDayInterestCompounded;
    protected String openDate;

    public MoneyAccounts(String ID, String cusID, double balance, String openDate,String lastDayInterestCompounded){
        super(ID,cusID,balance);
        this.openDate=openDate;
        this.lastDayInterestCompounded=lastDayInterestCompounded;
    }

    protected void addBalence(double x){
        balancef=balancef+x;
    }

    protected void subBalence(double x){
        balancef=balancef-x;
    }

    protected void dailyInterest(){
        return;
    }

    protected void authorizeWithdrawl(double x){
        return;
    }

    public String getOpenDate() {
        return openDate;
    }

    public String getLastDayInterestCompounded() {
        return lastDayInterestCompounded;
    }
}
