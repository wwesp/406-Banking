package Accounts.BankAccounts.Money;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CDs extends Savings {
    private String endDate;
    public CDs(String ID, String cusID, double balance, String openDate, String endDate, double interestRate,String lastDayInterestCompounded){
        super(ID, cusID,balance,openDate,interestRate, lastDayInterestCompounded);
        this.endDate=endDate;

    }

    //returns money from the cd after this it nukes all data in the object
    //automatically fines. if the cd does not cover then they are fined and must pay
    //$50 fee for ending it early
    public double authorizeWithdraw(){
        double moneyBack=balancef;


        cusID=null;
        balancef=0;
        openDate=null;

        interestRate=0;
        lastDayInterestCompounded=null;


        if(pastEndDate()){
            endDate=null;
            return moneyBack;
        }else{
            endDate=null;
            return moneyBack-50;
        }

    }

    public void dailyInterest(){
        if (pastEndDate()) {
            //addes one month to the endDate
            try {
                Date end = new SimpleDateFormat("MM-dd-yyyy").parse(endDate);
                Calendar cal = Calendar.getInstance();
                cal.setTime(end);
                cal.add(Calendar.MONTH, 1);
                Date newend = cal.getTime() ;
                SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy");
                endDate=format.format(newend);
            }
            catch (ParseException x){
                x.printStackTrace();
            }
        }
        String today = getTodaysDate();
        if (!today.equals(lastDayInterestCompounded)) {
            //compound interest
            //.5 percent interest
            //make sure it stays at two decimal places
            balancef = parseDouble(balancef * interestRate, 0);
            lastDayInterestCompounded = today;
        }

    }

    public boolean pastEndDate(){
        String to=getTodaysDate();
        try {
            Date today = new SimpleDateFormat("MM-dd-yyyy").parse(to);
            Date end = new SimpleDateFormat("MM-dd-yyyy").parse(endDate);
            return today.after(end);
        }
        catch (ParseException x){
            x.printStackTrace();
        }
       return false;

    }

    public String getEndDate() {
        return endDate;
    }
}
