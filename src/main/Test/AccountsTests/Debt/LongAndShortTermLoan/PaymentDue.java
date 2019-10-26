package AccountsTests.Debt.LongAndShortTermLoan;

import Accounts.BankAccounts.Debt.LongTermLoan;
import Accounts.BankAccounts.Money.Checking;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class PaymentDue {
    //if a payment is due that means it was not paid and is coming up, if its overdue then it will
    //be sent to overduepayments
    @Test
    public void DueDateT1() {
        Checking y = new Checking("123","000000000",10,"10-10-2010",0,"321","555",null, null,null,null,"",null);
        String endDate;
        String notDate;
        Date end = y.getTodayDateAsDate();
        Calendar cal = Calendar.getInstance();
        cal.setTime(end);

        cal.add(Calendar.DAY_OF_MONTH, 2);
        Date newend = cal.getTime() ;
        SimpleDateFormat format = new SimpleDateFormat("dd");
        endDate=format.format(newend);

        cal.add(Calendar.DAY_OF_MONTH,-4);
        newend = cal.getTime() ;
        format = new SimpleDateFormat("dd");
        notDate=format.format(newend);



        LongTermLoan loan1 = new LongTermLoan("1","01",6000,0.12,endDate,
                notDate,100,'f',"09-09-2019",'3',0,
                null,null,null);



        assertEquals(true,loan1.paymentDue());


    }


    @Test
    public void DueDateT2() {
        Checking y = new Checking("123","000000000",10,"10-10-2010",0,"321","555",null, null,null,null,"",null);
        String endDate;
        String notDate;
        Date end = y.getTodayDateAsDate();
        Calendar cal = Calendar.getInstance();
        cal.setTime(end);

        cal.add(Calendar.DAY_OF_MONTH, -1);
        Date newend = cal.getTime() ;
        SimpleDateFormat format = new SimpleDateFormat("dd");
        endDate=format.format(newend);

        cal.add(Calendar.DAY_OF_MONTH,-4);
        newend = cal.getTime() ;
        format = new SimpleDateFormat("dd");
        notDate=format.format(newend);



        LongTermLoan loan1 = new LongTermLoan("1","01",6000,0.12,endDate,
                notDate,100,'f',"09-09-2019",'3',0,
                null,null,null);



        assertEquals(false,loan1.paymentDue());


    }
    @Test
    public void DueDateT3() {
        Checking y = new Checking("123","000000000",10,"10-10-2010",0,"321","555",null, null,null,null,"",null);
        String endDate;
        String notDate;
        Date end = y.getTodayDateAsDate();
        Calendar cal = Calendar.getInstance();
        cal.setTime(end);

        cal.add(Calendar.DAY_OF_MONTH, 2);
        Date newend = cal.getTime() ;
        SimpleDateFormat format = new SimpleDateFormat("dd");
        endDate=format.format(newend);
        format=new SimpleDateFormat("MM-dd-yyyy");

        String fakePayment= "non::non::"+format.format(newend);

        cal.add(Calendar.DAY_OF_MONTH,-4);
        newend = cal.getTime() ;
        format = new SimpleDateFormat("dd");
        notDate=format.format(newend);



        HashMap<String, Double> f= new HashMap<>();
        f.put(fakePayment,0.0);


        LongTermLoan loan1 = new LongTermLoan("1","01",6000,0.12,endDate,
                notDate,100,'f',"09-09-2019",'3',0,
                null,f,null);




        assertEquals(false,loan1.paymentDue());


    }

    @Test
    public void makePayment() {
        Checking y = new Checking("123","000000000",10,"10-10-2010",0,"321","555",null, null,null,null,"",null);
        String endDate;
        String notDate;
        Date end = y.getTodayDateAsDate();
        Calendar cal = Calendar.getInstance();
        cal.setTime(end);

        cal.add(Calendar.DAY_OF_MONTH, 2);
        Date newend = cal.getTime() ;
        SimpleDateFormat format = new SimpleDateFormat("dd");
        endDate=format.format(newend);
        format=new SimpleDateFormat("MM-dd-yyyy");


        cal.add(Calendar.DAY_OF_MONTH,-4);
        newend = cal.getTime() ;
        format = new SimpleDateFormat("dd");
        notDate=format.format(newend);






        LongTermLoan loan1 = new LongTermLoan("1","01",6000,0.12,endDate,
                notDate,100,'f',"09-09-2019",'3',0,
                null,null,null);

        loan1.makePayment();


        assertEquals(false,loan1.paymentDue());


    }

    @Test
    public void makePaymentoverdue() {
        Checking y = new Checking("123","000000000",10,"10-10-2010",0,"321","555",null, null,null,null,"",null);
        String endDate;
        String notDate;
        Date end = y.getTodayDateAsDate();
        Calendar cal = Calendar.getInstance();
        cal.setTime(end);

        cal.add(Calendar.DAY_OF_MONTH, -2);
        Date newend = cal.getTime() ;
        SimpleDateFormat format = new SimpleDateFormat("dd");
        endDate=format.format(newend);
        format=new SimpleDateFormat("MM-dd-yyyy");


        cal.add(Calendar.DAY_OF_MONTH,-4);
        newend = cal.getTime() ;
        format = new SimpleDateFormat("dd");
        notDate=format.format(newend);






        LongTermLoan loan1 = new LongTermLoan("1","01",6000,0.12,endDate,
                notDate,100,'f',"09-09-2019",'3',0,
                null,null,null);

        loan1.makePayment();

        assertEquals(false,loan1.makePayment());


    }

    @Test
    public void makeextrapayment() {
        Checking y = new Checking("123","000000000",10,"10-10-2010",0,"321","555",null, null,null,null,"",null);
        String endDate;
        String notDate;
        Date end = y.getTodayDateAsDate();
        Calendar cal = Calendar.getInstance();
        cal.setTime(end);

        cal.add(Calendar.DAY_OF_MONTH, -2);
        Date newend = cal.getTime() ;
        SimpleDateFormat format = new SimpleDateFormat("dd");
        endDate=format.format(newend);
        format=new SimpleDateFormat("MM-dd-yyyy");


        cal.add(Calendar.DAY_OF_MONTH,-4);
        newend = cal.getTime() ;
        format = new SimpleDateFormat("dd");
        notDate=format.format(newend);






        LongTermLoan loan1 = new LongTermLoan("1","01",6000,0.12,endDate,
                notDate,100,'f',"09-09-2019",'3',0,
                null,null,null);


        loan1.makeExtaPayment(30);

        assertEquals(5970,loan1.getBalancef(),0.001);


    }






}
