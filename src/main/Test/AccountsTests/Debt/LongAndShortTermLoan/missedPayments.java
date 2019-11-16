package AccountsTests.Debt.LongAndShortTermLoan;

import Accounts.BankAccounts.Debt.LongTermLoan;
import Accounts.BankAccounts.Money.Checking;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class missedPayments {
    @Test
    public void fees() {
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
                notDate,100,'f',"09-09-2019","30",0,
                null,null,null);


        //makes a missed payment
        loan1.makePayment();


        assertEquals(75,loan1.getFees(),0.001);


    }

    @Test
    public void payfees() {
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
                notDate,100,'f',"09-09-2019","30",0,
                null,null,null);


        //makes a missed payment
        loan1.makePayment();
        loan1.payMissedFees(75);

        assertEquals(0,loan1.getFees(),0.001);


    }



    @Test
    public void overPay() {
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
                notDate,100,'f',"09-09-2019","30",0,
                null,null,null);


        //makes a missed payment
        loan1.makePayment();
        loan1.payMissedFees(75);

        assertEquals(0,loan1.getFees(),0.001);


    }
}
