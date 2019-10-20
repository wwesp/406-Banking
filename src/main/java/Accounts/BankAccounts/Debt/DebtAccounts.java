package Accounts.BankAccounts.Debt;

import Accounts.BankAccounts.Accounts;

import java.text.SimpleDateFormat;
import java.util.*;

public abstract class DebtAccounts extends Accounts{
    protected String interestRate;
    protected String datePaymentDue;
    protected String notifyDate;
    protected double currentPaymentDue;
    protected char missedPaymentFlag;
    protected String lastPaymentDate;
    protected double fees;
    //date, amt
    protected HashMap<String, Double> missedPayment;
    //payment history key is (date+balence+dueOfPaid)(balence is in key to keep unique key) the other hash part is just
    // balence, sperated like date::balence::dateofPaid
    protected HashMap<String, Double> paymentHistory;


    public DebtAccounts(String ID, String cusID, double balance,String interestRate, String datePaymentDue,
                        String notifyDate, double currentPaymentDue, char missedPaymentflag,
                        String lastPaymentDate, double fees , HashMap<String, Double> missedPayment,
                        HashMap<String, Double> paymentHistory){
        super(ID, cusID, balance);
        this.interestRate=interestRate;
        this.datePaymentDue=datePaymentDue;
        this.notifyDate=notifyDate;
        this.currentPaymentDue=currentPaymentDue;
        this.missedPaymentFlag=missedPaymentflag;
        this.lastPaymentDate=lastPaymentDate;
        this.fees=fees;

        HashMap<String,Double> empty=new HashMap<>();
        if (missedPayment==null){
            this.missedPayment=empty;
        }
        else{
            this.missedPayment=missedPayment;
        }

        if (paymentHistory==null){
            this.paymentHistory=empty;
        }
        else {
            this.paymentHistory=paymentHistory;
        }



    }






    public void makePayment(){

    }
    //returns double of amount to be paid
    public double payMissed(){
        //need to find the oldest missed payment and set that payment
        String old="";
        Date oldest= new Date();
        Date current= new Date();
        double amtDue=0;

        if(missedPayment.size()==1){
             for (String x: missedPayment.keySet()){
                 paymentHistory.put(getTodaysDate()+"::"+missedPayment.get(x)+"::"+x,missedPayment.get(x));
                 old=x;
             }
             amtDue=missedPayment.get(old);
             missedPayment.remove(old);
             return amtDue;

        }else {
            int i = 0;
            for (String x : missedPayment.keySet()) {
                current = convertStringToDate(x);
                if (i == 0) {
                    old = x;
                    oldest = current;
                }

                if (current.before(oldest)) {
                    oldest = current;
                    old = x;
                }

                i++;
            }

            paymentHistory.put(getTodaysDate()+"::"+missedPayment.get(old)+"::"+old,missedPayment.get(old));
            amtDue=missedPayment.get(old);
            missedPayment.remove(old);
            return amtDue;

        }




    }



    //returns amt negative means if he had 50 in fee and gave us 100 we would give him back 50. so -50 we give back,
    //50 would be that he still owes 50 in fees
    public double payMissedFees(double x){
        fees=-x;

        if(fees<0){
            double temp=fees;
            fees=0;
            return temp;
        }
        else{
            //x amount you still owe
            return fees;
        }
    }


    public boolean paymentDue(){
        Date today = getTodayDateAsDate();
        SimpleDateFormat simpleDateformat = new SimpleDateFormat("MM");
        String month=simpleDateformat.format(today);
        simpleDateformat= new SimpleDateFormat("yyyy");
        String year= simpleDateformat.format(today);

        String dueformat= month+"-"+datePaymentDue+"-"+year;
        Date dateDue= convertStringToDate(dueformat);


        int flag=0;
        if(today.after(dateDue)){
            //now see if its been paid
            for (String x: paymentHistory.keySet()){
                String[] y= x.split("::",3);
                String temp=y[2];
                Date paid= convertStringToDate(temp);
                if(paid.after(today)){
                    flag=1;
                }

            }

            if(flag==0){
                int flag2=0;
                for (String x: missedPayment.keySet()){

                    Date miss= convertStringToDate(x);

                    if(miss.equals(dateDue)){
                        flag2=1;
                    }
                }
                //payment is missed
                if (flag2==0) {
                    missedPayment.put(convertDateToString(dateDue), currentPaymentDue);
                }


                return true;
            }
        }

        return false;
    }

    public boolean isNotiifyDate(){
        Date today = getTodayDateAsDate();
        SimpleDateFormat simpleDateformat = new SimpleDateFormat("MM");
        String month=simpleDateformat.format(today);
        simpleDateformat= new SimpleDateFormat("yyyy");
        String year= simpleDateformat.format(today);
        String notformat= month+"-"+notifyDate+"-"+year;
        String dueformat= month+"-"+datePaymentDue+"-"+year;

        Date notDate= convertStringToDate(notformat);
        Date dateDue= convertStringToDate(dueformat);



        //flag
        int flag= 0;

        if (today.after(notDate)&&today.before(dateDue)){
            //now see if its been paid
            for (String x: paymentHistory.keySet()){
                String[] y= x.split("::",3);
                String temp=y[2];
                Date paid= convertStringToDate(temp);
                if(paid.after(today)){
                    flag=1;
                }

            }

            if(flag==0){
                return true;
            }


        }


        return false;
    }





}