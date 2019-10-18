package Accounts.People;

public class Teller extends People {

    public Teller(String ssn,String fName, String lName){
        super(ssn,fName,lName);
    }

    /*
    has access to account balances, recent debits,and account status
    can credit any account (except CD's)
    can debit checking and saving accounts(give cash)
    can transfer money between checking and saving accounts
     */

}
