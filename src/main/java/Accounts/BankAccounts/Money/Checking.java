package Accounts.BankAccounts.Money;

import java.util.ArrayList;

public class Checking extends MoneyAccounts {
    int accType;
    ArrayList<String> backupAcc;

    public Checking(String ID, int cusID, double balance, String openDate, int accType, ArrayList<String> backupAcc){
        super(ID, cusID, balance, openDate);
        this.accType = accType;
        this.backupAcc = backupAcc;
    }


    public void authorizeWithdrawl(double x, ArrayList<RegSavings> y) {

        //look for backup
        ArrayList<RegSavings> returnable=new ArrayList<>();
        for(RegSavings savin: y){

            for(int i=0;i<backupAcc.size();i++) {
                if (savin.getID().equals(backupAcc.get(i))){
                    returnable.add(savin);
                }
            }
        }



        //payment
        if (balancef>x){
            subBalence(x);
        }
        else{
            if(backupAcc==null){
                subBalence(x);
                subBalence(25);
            }
            else{
                subBalence(balancef);
                //TODO: finish this
            }
        }



    }

    /*
    two types of checking accounts. TMB and gold/diamond
    TMB: $0.50 per transaction (deposit and withdraw)
         $0.75 monthly transfers (mortgages, payments of bills, or transfers money to other accounts
         no minimum balance

    gold/diamond: minimum balance of $1000.00
                  no charge for transaction if min balance is maintained
                  earns interest on average balance
                  flexible interest rate changes daily and 0.5% of the savings account

    services:
        1) stop payment
            cancels a check by the check number $15 fee
        2) overdraft
            returns check unpaid and charges a %20 fee
            if savings account is a "overdraft" account then it can be used to cover check
    */
}
