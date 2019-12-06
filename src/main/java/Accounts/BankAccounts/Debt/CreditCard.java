package Accounts.BankAccounts.Debt;

import SystemHelper.SystemHelper;
import persistence.GetData.GetData;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class CreditCard extends DebtAccounts {
    protected double creditLine;
    protected HashMap<String,String> paymentHistoryDescription;
    protected HashMap<String,String> paymentHistoryDate;

    public CreditCard(String ID, String cusID, double balance, double interestRate, String datePaymentDue,
                      String notifyDate, double currentPaymentDue, char missedPaymentflag,
                      String lastPaymentDate, double fees , HashMap<String, Double> paymentHistory, double creditLine,
                        HashMap<String,String> paymentHistoryDescription, HashMap<String,String> paymentHistoryDate){

        super(ID, cusID, balance, interestRate, datePaymentDue, notifyDate, currentPaymentDue, missedPaymentflag,
                lastPaymentDate, fees,paymentHistory);
        this.creditLine=creditLine;


        if(paymentHistoryDescription==null){

            this.paymentHistoryDescription= new HashMap<>();
        }
        else{
            this.paymentHistoryDescription=paymentHistoryDescription;
        }

        if(paymentHistoryDate==null){

            this.paymentHistoryDate= new HashMap<>();
        }
        else{
            this.paymentHistoryDate=paymentHistoryDate;
        }



    }


    public CreditCard(String cusID,double creditLine){
        this("","",0,0,"","",0,' ',
                "",0,null,0,null,null);

        this.cusID=cusID;
        this.datePaymentDue="15";
        this.notifyDate="1";
        this.creditLine=creditLine;
        this.interestRate= new GetData().getIntRates().getCreditCardInterest();
        this.ID=new SystemHelper().makeRandomId();

    }


    public HashMap<String, String> getPaymentHistoryDate() {
        return paymentHistoryDate;
    }

    public double endAccount(){
        SystemHelper h =new SystemHelper();
        double endbal=h.perciseSubtract(balancef,fees);
        endbal = h.perciseSubtract(endbal,currentPaymentDue);
        endbal=endbal*-1;
        //-1*balancef-fees-currentPaymentDue;

        cusID="";
        balancef=0;
        interestRate=0;
        datePaymentDue="";
        notifyDate="";
        currentPaymentDue=0;
        missedPaymentFlag=' ';
        lastPaymentDate="";
        fees=0;
        paymentHistory=null;
        creditLine=0;


        return endbal;
    }

    public boolean makeCreditPurchase(double amt, String item){
        SystemHelper h =new SystemHelper();
        if(creditLine<h.perciseAddition(currentPaymentDue,amt)){
            return false;

        }
        else{
            currentPaymentDue=h.perciseAddition(currentPaymentDue,amt);
            String ran= h.makeRandomId();
            paymentHistory.put(ran, amt);
            paymentHistoryDescription.put(ran, item);
            paymentHistoryDate.put(ran,getTodaysDate());

            return true;
        }
    }

    public double makePayment(double amtP){
        double amt;
        SystemHelper h =new SystemHelper();
        if(fees>0){
            if(amtP>fees){
                amt=h.perciseSubtract(amtP,fees);
                fees=0;
            }
            else{
                fees=h.perciseSubtract(fees,amtP);
                return 0;
            }
        }
        else{
            amt=amtP;
        }
        if(balancef>0){
            double need= h.perciseSubtract(balancef,amt);
            if(need<0){

                need=Math.abs(need);
                balancef=0;
                if(need>=currentPaymentDue){
                    System.out.println(need);
                    need=h.perciseSubtract(need,currentPaymentDue);
                    System.out.println(need);
                    currentPaymentDue=0;
                    return need;
                }
                else{
                    currentPaymentDue=h.perciseSubtract(currentPaymentDue,need);
                    return 0.0;
                }
            }
            else{
                balancef=h.perciseSubtract(balancef,amt);
                return 0;
            }
        }
        else{

            if(currentPaymentDue==0.0){
                return amt;
            }
            else{
                double need= h.perciseSubtract(currentPaymentDue,amt);
                //still owe
                if(need>=0){
                    currentPaymentDue= h.perciseSubtract(currentPaymentDue,amt);
                    return 0;
                }
                else{
                    currentPaymentDue=0.0;
                    return Math.abs(need);
                }
            }
        }
    }




    //this is for managers to see if its over due
    public void paymentDue(){
        Date today = getTodayDateAsDate();
        SimpleDateFormat simpleDateformat = new SimpleDateFormat("MM");
        String month=simpleDateformat.format(today);
        simpleDateformat= new SimpleDateFormat("yyyy");
        String year= simpleDateformat.format(today);


        String dueformat= month+"-"+datePaymentDue+"-"+year;
        Date dateDue= convertStringToDate(dueformat);

        String not= month+"-"+notifyDate+"-"+year;
        Date notDate= convertStringToDate(not);




        if(today.after(notDate) && today.before(dateDue)){
            System.out.println("In credit card: Hey, "+cusID+" you owe this month: "+ currentPaymentDue );

        }
        else if(today.before(notDate)){
            return;
        }
        else if(today.after(dateDue)){
            //add current into main balence
            System.out.println("In credit card: Hey, "+cusID+" this amount is getting added to acruable balence: "+ currentPaymentDue );
            balancef= new SystemHelper().perciseAddition(balancef, currentPaymentDue);
            currentPaymentDue=0;
        }
        else{
            System.out.println("I should never happen!");

        }

    }

    public double getCreditLine() {
        return creditLine;
    }

    public HashMap<String, String> getPaymentHistoryDescription() {
        return paymentHistoryDescription;
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
