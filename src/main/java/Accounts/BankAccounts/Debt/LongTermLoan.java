package Accounts.BankAccounts.Debt;



import SystemHelper.SystemHelper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class LongTermLoan extends DebtAccounts {
    ArrayList<String> PaymentPlan;
    ArrayList<String> extraPayMentHistory;
    String yearType;
    double feeAmt;
    //date, amt
    protected HashMap<String, Double> missedPayment;

    public LongTermLoan(String ID, String cusID, double balance,double interestRate, String datePaymentDue,
                        String notifyDate, double currentPaymentDue, char missedPaymentflag, String lastPaymentDate,
                        String yearType,double fees, HashMap<String, Double> missedPayment,
                        HashMap<String, Double> paymentHistory ,ArrayList<String> extraPayMentHistory ){

        super(ID, cusID, balance, interestRate, datePaymentDue, notifyDate, currentPaymentDue, missedPaymentflag,
                lastPaymentDate,fees,paymentHistory);
        this.feeAmt=75;
        this.yearType=yearType;

        if(extraPayMentHistory==null){
            this.extraPayMentHistory=new ArrayList<>();

        }
        else{
            this.extraPayMentHistory=extraPayMentHistory;
        }

        if (missedPayment == null) {
            this.missedPayment = new HashMap<String, Double>();
        } else {
            this.missedPayment = missedPayment;
        }
    }


    public LongTermLoan(String cusId, String datePaymentDue, String notifyDate, String yearType){
        this("",cusId,0,0,datePaymentDue,notifyDate,0,' ', "",yearType,0,null,null,null);
        this.ID=new SystemHelper().makeRandomId();

    }



    public double endAccount(){
        double endbal=-1*balancef-fees ;


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
        feeAmt=0;
        yearType="";






        return endbal;
    }




    private void developPaymentPlan(){
        //TODO:payment plans are dynamic due to extra payments possible
    }

    /*
    15 or 30 year loans
    fixed rate, fixed payment plan
    if late +$75 fee
    if missed payment, account is flagged as problem account
    extra payments can be made
     */




    //will do this months payment
    //false means not payed,or over due
    public boolean makePayment(){
        if(!paymentDue()){
            //either its paid or overdue
            return false;
        }
        else{
            balancef=-currentPaymentDue;

            Date today = getTodayDateAsDate();
            SimpleDateFormat simpleDateformat = new SimpleDateFormat("MM");
            String month=simpleDateformat.format(today);
            simpleDateformat= new SimpleDateFormat("yyyy");
            String year= simpleDateformat.format(today);

            String dueformat= month+"-"+datePaymentDue+"-"+year;
            Date dateDue= convertStringToDate(dueformat);

            paymentHistory.put(getTodaysDate()+"::"+balancef+"::"+convertDateToString(dateDue),currentPaymentDue);


            return true;
        }



    }
    //wont count toward any month
    public void makeExtaPayment(double x){
        balancef=balancef-x;
        extraPayMentHistory.add(getTodaysDate() +"::"+x);
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
                paymentHistory.put(getTodaysDate()+"::"+balancef+"::"+x,missedPayment.get(x));
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

            paymentHistory.put(getTodaysDate()+"::"+balancef+"::"+old,missedPayment.get(old));
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

    //sees if a payment is due for an account, if it is true, if it isnt false, if overdue false
    public boolean paymentDue(){
        Date today = getTodayDateAsDate();
        SimpleDateFormat simpleDateformat = new SimpleDateFormat("MM");
        String month=simpleDateformat.format(today);
        simpleDateformat= new SimpleDateFormat("yyyy");
        String year= simpleDateformat.format(today);

        String dueformat= month+"-"+datePaymentDue+"-"+year;
        Date dateDue= convertStringToDate(dueformat);

        //start of the month
        String startform= month+"-"+1+"-"+year;
        Date start= convertStringToDate(startform);



        if(today.before(dateDue)){
            for (String x: paymentHistory.keySet()){
                String[] y= x.split("::",3);
                String temp=y[2];
                Date paid= convertStringToDate(temp);

                if(paid.after(today)){
                    //means it has been paid for the month since its paid after today
                    return false;
                }

            }
            return true;
        }
        else{
            //look though history

            for (String x: paymentHistory.keySet()){

                String[] y= x.split("::",3);
                String temp=y[2];

                Date paid= convertStringToDate(temp);
                if(paid.after(start)){
                    //return before the missed payment part
                    return false;
                }

            }

            //look through over due
            //if not add to overdue
            int flag=0;
            for (String x: missedPayment.keySet()){

                Date miss= convertStringToDate(x);

                if(miss.equals(dateDue)){
                    flag=1;
                }
            }
            if(flag==0){
                fees+=feeAmt;

                missedPayment.put(convertDateToString(dateDue), currentPaymentDue);

            }

            return false;




        }





    }






    public HashMap<String, Double> getMissedPayment() {
        return missedPayment;
    }


}
