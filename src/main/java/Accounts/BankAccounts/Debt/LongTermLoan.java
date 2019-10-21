package Accounts.BankAccounts.Debt;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class LongTermLoan extends DebtAccounts {
    ArrayList<String> PaymentPlan;

    char yearType;

    public LongTermLoan(String ID, String cusID, double balance,String interestRate, String datePaymentDue,
                        String notifyDate, double currentPaymentDue, char missedPaymentflag, String lastPaymentDate,
                        char yearType,double fees, HashMap<String, Double> missedPayment,
                        HashMap<String, Double> paymentHistory ,ArrayList<String> extraPayMentHistory ){

        super(ID, cusID, balance, interestRate, datePaymentDue, notifyDate, currentPaymentDue, missedPaymentflag,
                lastPaymentDate,fees,missedPayment,paymentHistory,extraPayMentHistory,75);
        this.yearType=yearType;
    }

    private void developPaymentPlan(){
        //payment plans are dynamic due to extra payments possible
    }

    /*
    15 or 30 year loans
    fixed rate, fixed payment plan
    if late +$75 fee
    if missed payment, account is flagged as problem account
    extra payments can be made
     */
    public JSONObject getJSON(){
        JSONObject obj = new JSONObject();

        try{
            obj.put("ID",ID);
            obj.put("cusID",cusID);
            obj.put("balance",balancef);
            obj.put("interestRate",interestRate);
            obj.put("datePaymentDue",datePaymentDue);
            obj.put("notifyDate",notifyDate);
            obj.put("currentPaymentDue",currentPaymentDue);
            obj.put("missedPaymentFlag",missedPaymentFlag);
            obj.put("lastPaymentDue",lastPaymentDate);
            obj.put("fees",fees);
            obj.put("missedPayment",missedPayment);
            obj.put("paymentHistory",paymentHistory);
            obj.put("extraPaymentHistory",extraPayMentHistory);
            obj.put("yearType",yearType);

        }
        catch (JSONException e){
            e.printStackTrace();
        }
        return obj;
    }
}
