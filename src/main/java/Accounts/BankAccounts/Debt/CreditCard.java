package Accounts.BankAccounts.Debt;

public class CreditCard extends DebtAccounts {

    public CreditCard(String ID, String cusID, double balance, String openDate){
        super(ID, cusID, balance, openDate);
    }

    /*
    each card has a limit
    each purchase checks to make sure it doesnt go over limit
    a record of each purchase is saved
    bill sent out each month, payable until the 10th
    each bill consists of a finance charge and a total for that month
    if total is payed no finance charge
    payments can be made any time
    the finance charge is calculated on the average balance through out the month
     */

}
