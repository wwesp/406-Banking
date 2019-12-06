package Accounts.BankAccounts;


import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

abstract public class Accounts {
    protected String cusID;
    protected double balancef;

    protected String ID;


    public  Accounts(String ID, String cusID, double balance){
        this.cusID = cusID;
        this.balancef = balance;
        this.ID=ID;
    }



    public String getCusID() {
        return cusID;
    }

    public String getID() {
        return ID;
    }

    public double getBalancef() {
        return balancef;
    }




    //this is for any type of interest
    //round up roundType 1
    //truncate roundType 0
    public double parseDouble(double x, int roundType){
        DecimalFormat df = new DecimalFormat("#.##");
        if (roundType==0){
            df.setRoundingMode(RoundingMode.DOWN);
        }
        else{
            df.setRoundingMode(RoundingMode.UP);
        }

        String s = df.format(x);
        return Double.parseDouble(s);
    }


    //helper method
    protected String getTodaysDate(){
        SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy");
        return format.format(new Date());
    }


    //looks to see if today is past a date
    public boolean isXafterToday(String x){
        String to=getTodaysDate();
        try {
            Date today = new SimpleDateFormat("MM-dd-yyyy").parse(to);
            Date end = new SimpleDateFormat("MM-dd-yyyy").parse(x);
            return today.after(end);
        }
        catch (ParseException f){
            f.printStackTrace();
        }
        return false;

    }

    public boolean isXDateAfterYdate(String x,String y){

        try {
            Date datex = new SimpleDateFormat("MM-dd-yyyy").parse(x);
            Date datey = new SimpleDateFormat("MM-dd-yyyy").parse(y);
            return datex.after(datey);
        }
        catch (ParseException f){
            f.printStackTrace();
        }
        return false;

    }

    public Date convertStringToDate(String x){
        try {
            Date datex = new SimpleDateFormat("MM-dd-yyyy").parse(x);
            return datex;
        }
        catch (ParseException f){
            f.printStackTrace();
        }

        return null;
    }

    public Date getTodayDateAsDate(){
        String to=getTodaysDate();
        try {
            Date datex = new SimpleDateFormat("MM-dd-yyyy").parse(to);
            return datex;
        }
        catch (ParseException f){
            f.printStackTrace();
        }

        return null;
    }

    public String convertDateToString(Date x){
        SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy");
        return format.format(x);

    }



}
