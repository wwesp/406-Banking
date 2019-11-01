package Accounts.BankAccounts.Money;

import Accounts.BankAccounts.Accounts;
import SystemHelper.SystemHelper;
import org.json.JSONException;
import org.json.JSONObject;


abstract class  MoneyAccounts extends Accounts {
    protected String lastDayInterestCompounded;
    protected String openDate;

    public MoneyAccounts(String ID, String cusID, double balance, String openDate,String lastDayInterestCompounded){
        super(ID,cusID,balance);
        this.openDate=openDate;
        this.lastDayInterestCompounded=lastDayInterestCompounded;
    }

    public JSONObject getJSON(){
        JSONObject obj = new JSONObject();

        try{
            obj.put("ID",openDate);
            obj.put("cusID",openDate);
            obj.put("balance",balancef);
            obj.put("openDate",openDate);
            obj.put("lastDayInterestCompound",lastDayInterestCompounded);
        }
        catch (JSONException e){
            e.printStackTrace();
        }
        return obj;
    }

    protected void addBalence(double x){

        balancef=new SystemHelper().perciseAddition(balancef,x);

    }

    protected void subBalence(double x){

        balancef=new SystemHelper().perciseSubtract(balancef,x);

    }

    protected void dailyInterest(){
        return;
    }

    protected void authorizeWithdrawl(double x){
        return;
    }

    public String getOpenDate() {
        return openDate;
    }

    public String getLastDayInterestCompounded() {
        return lastDayInterestCompounded;
    }
}