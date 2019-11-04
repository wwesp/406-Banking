package Accounts.BankAccounts.Debt;

import SystemHelper.SystemHelper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class CreditCard extends DebtAccounts {
    protected double creditLine;
    public CreditCard(String ID, String cusID, double balance, double interestRate, String datePaymentDue,
                      String notifyDate, double currentPaymentDue, char missedPaymentflag,
                      String lastPaymentDate, double fees , HashMap<String, Double> paymentHistory, double creditLine){
        super(ID, cusID, balance, interestRate, datePaymentDue, notifyDate, currentPaymentDue, missedPaymentflag,
                lastPaymentDate, fees, paymentHistory);
        this.creditLine=creditLine;

    }

    public double endAccount(){
        double endbal=balancef;

        cusID=null;
        balancef=0;
        interestRate=0;
        datePaymentDue=null;
        notifyDate=null;
        currentPaymentDue=0;
        missedPaymentFlag=' ';
        lastPaymentDate=null;
        fees=0;
        paymentHistory=null;
        creditLine=0;


        return endbal;
    }

    public boolean makeCreditPurchase(double amt){
        SystemHelper h =new SystemHelper();
        if(creditLine<h.perciseAddition(currentPaymentDue,amt)){
            return false;

        }
        else{
            currentPaymentDue=h.perciseAddition(currentPaymentDue,amt);
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

    //TODO:PAYMENTD UE


    //this is for managers to see if its over due
    public void paymentDue(){
        Date today = getTodayDateAsDate();
        SimpleDateFormat simpleDateformat = new SimpleDateFormat("MM");
        String month=simpleDateformat.format(today);
        simpleDateformat= new SimpleDateFormat("yyyy");
        String year= simpleDateformat.format(today);
        String dueformat= month+"-"+datePaymentDue+"-"+year;
        Date dateDue= convertStringToDate(dueformat);


        




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
