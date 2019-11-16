package Accounts.People;

public class Managment extends Teller {


    public Managment(String ssn,String fName, String lName){
        super(ssn,fName,lName);
    }

    /*
    have access to all information on all accounts
    they can credit or debit any account
    they manage loan accounts
    each month they initiate the process that sends the bills out to credit card and mortgage accounts
    initiate the process that sends out the roll over notices for CD's
    they set the interest rates on checking and savings
     */

}
