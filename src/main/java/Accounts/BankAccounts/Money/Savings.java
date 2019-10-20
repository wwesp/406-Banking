package Accounts.BankAccounts.Money;

public abstract class Savings extends MoneyAccounts {
    double interestRate;


    public Savings(String ID, String cusID, double balance, String openDate,double interestRate){
        super(ID, cusID,balance,openDate);
        this.interestRate = interestRate;
    }



}
