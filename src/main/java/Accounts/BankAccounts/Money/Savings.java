package Accounts.BankAccounts.Money;


import SystemHelper.SystemHelper;

public abstract class Savings extends MoneyAccounts {
    double interestRate;


    public Savings(String ID, String cusID, double balance, String openDate,double interestRate,String lastDayInterestCompounded){
        super(ID, cusID,balance,openDate,lastDayInterestCompounded);
        this.interestRate = interestRate;
    }



    public void dailyInterest(){
        SystemHelper h = new SystemHelper();
        String today=getTodaysDate();
        if (!today.equals(lastDayInterestCompounded)){
            //compound interest
            //.5 percent interest
            //make sure it stays at two decimal places
            balancef=h.truncOrRound(parseDouble(balancef*interestRate+balancef,0),0);
            lastDayInterestCompounded=today;
        }


    }

    public double getInterestRate() {
        return interestRate;
    }
}
