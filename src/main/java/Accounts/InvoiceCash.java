package Accounts;

public class InvoiceCash implements Runnable{
    double amt;
    MoneyAccounts acc;
    public InvoiceCash(double amt, MoneyAccounts acc){
        this.amt=amt;
        this.acc=acc;
    }

    public void run() {
        acc.authorizePayment(amt);
    }
}
