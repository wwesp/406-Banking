package Accounts.BankAccounts.Money;

public class RegSavings extends  Savings{


    public RegSavings(String ID, String cusID, double balance, String openDate,double interestRate){
        super(ID, cusID,balance,openDate,interestRate);
    }

    public boolean authorizeWithdraw(double x){
        //boolean since a withdrawl can fail and we would want the returnie to know

        if(balancef<x){
            return false;
        }
        balancef=balancef-x;
        return true;
    }
    public void authorizeDeposit(double x){
        balancef=balancef+x;
    }




}
