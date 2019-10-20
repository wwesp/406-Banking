package Accounts.BankAccounts;

import org.json.JSONException;
import org.json.JSONObject;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

abstract public class Accounts {
    protected String cusID;
    protected double balancef;
    protected String openDate;
    protected String ID;
    protected String lastDayInterestCompounded;

    public  Accounts(String ID, String cusID, double balance, String openDate,String lastDayInterestCompounded){
        this.cusID = cusID;
        this.balancef = balance;
        this.openDate = openDate;
        this.ID=ID;
        this.lastDayInterestCompounded=lastDayInterestCompounded;
    }

    //helper method
    protected String getTodaysDate(){
        SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy");
        return format.format(new Date());
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

    public String getOpenDate() {
        return openDate;
    }

    public JSONObject getJSON(){
        JSONObject obj = new JSONObject();

        try{
            obj.put("CusID", cusID);
            obj.put("Balence", balancef );
            obj.put("openDate", openDate);
        }
        catch (JSONException e){
            e.printStackTrace();
        }
        return obj;
    }

    //this is for any type of interest
    //round up roundType 1
    //round down roundType 0
    protected double parseDouble(double x, int roundType){
        DecimalFormat df = new DecimalFormat("#.##");
        if (roundType==1){
            df.setRoundingMode(RoundingMode.DOWN);
        }
        else{
            df.setRoundingMode(RoundingMode.UP);
        }

        String s = df.format(x);
        return Double.parseDouble(s);
    }

}
