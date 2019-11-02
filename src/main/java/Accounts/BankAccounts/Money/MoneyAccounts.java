package Accounts.BankAccounts.Money;

import Accounts.BankAccounts.Accounts;
import SystemHelper.SystemHelper;



abstract class  MoneyAccounts extends Accounts {
    protected String lastDayInterestCompounded;
    protected String openDate;

    public MoneyAccounts(String ID, String cusID, double balance, String openDate,String lastDayInterestCompounded){
        super(ID,cusID,balance);
        this.openDate=openDate;
        this.lastDayInterestCompounded=lastDayInterestCompounded;
    }



    protected void addBalence(double x){
        System.out.println("Before :"+balancef);
        balancef=new SystemHelper().perciseAddition(balancef,x);
        System.out.println("After :"+balancef);
    }

    protected void subBalence(double x){
        System.out.println("Before :"+balancef);
        balancef=new SystemHelper().perciseSubtract(balancef,x);
        System.out.println("After :"+balancef);
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

    public boolean moneyTransfer(MoneyAccounts y, double amt){
        if(y.getBalancef()<amt){
            return false;
        }
        else{
            addBalence(amt);
            y.subBalence(amt);
            return true;
        }

    }


}