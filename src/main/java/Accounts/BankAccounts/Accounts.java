package Accounts.BankAccounts;

import org.json.JSONException;
import org.json.JSONObject;

public class Accounts {
    protected int cusID;
    protected double balancef;
    protected String openDate;
    protected String ID;

    public  Accounts(String ID, int cusID, double balance, String openDate){
        this.cusID = cusID;
        this.balancef = balance;
        this.openDate = openDate;
        this.ID=ID;
    }

    public int getCusID() {
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



}
