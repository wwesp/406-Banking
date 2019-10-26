package AccountsTests.Debt.LongAndShortTermLoan;

import Accounts.BankAccounts.Accounts;
import Accounts.BankAccounts.Debt.LongTermLoan;
import Accounts.BankAccounts.Money.Checking;
import Accounts.BankAccounts.Money.RegSavings;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class Notify {

    @Test
        public void notifyDateT1() {
        Checking y = new Checking("123","000000000",10,"10-10-2010",0,"321","555",null, null,null,null,"",null);
        String endDate;
        String notDate;
        Date end = y.getTodayDateAsDate();
        Calendar cal = Calendar.getInstance();
        cal.setTime(end);

        cal.add(Calendar.DAY_OF_MONTH, 1);
        Date newend = cal.getTime() ;
        SimpleDateFormat format = new SimpleDateFormat("dd");
        endDate=format.format(newend);

        cal.add(Calendar.DAY_OF_MONTH,-2);
        newend = cal.getTime() ;
        format = new SimpleDateFormat("dd");
        notDate=format.format(newend);



        LongTermLoan loan1 = new LongTermLoan("1","01",6000,0.12,endDate,
                notDate,100,'f',"09-09-2019",'3',0,
                null,null,null);



        assertEquals(true,loan1.isNotiifyDate());


    }

    @Test
    public void notifyDateT2() {
        Checking y = new Checking("123","000000000",10,"10-10-2010",0,"321","555",null, null,null,null,"",null);
        String endDate;
        String notDate;
        Date end = y.getTodayDateAsDate();
        Calendar cal = Calendar.getInstance();
        cal.setTime(end);

        cal.add(Calendar.DAY_OF_MONTH, 10);
        Date newend = cal.getTime() ;
        SimpleDateFormat format = new SimpleDateFormat("dd");
        endDate=format.format(newend);

        cal.add(Calendar.DAY_OF_MONTH,2);
        newend = cal.getTime() ;
        format = new SimpleDateFormat("dd");
        notDate=format.format(newend);



        LongTermLoan loan1 = new LongTermLoan("1","01",6000,0.12,endDate,
                notDate,100,'f',"09-09-2019",'3',0,
                null,null,null);



        assertEquals(false,loan1.isNotiifyDate());


    }

    @Test
    public void notifyDateT3() {
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

        cal.add(Calendar.DAY_OF_MONTH,2);
        newend = cal.getTime() ;
        format = new SimpleDateFormat("dd");
        notDate=format.format(newend);



        LongTermLoan loan1 = new LongTermLoan("1","01",6000,0.12,endDate,
                notDate,100,'f',"09-09-2019",'3',0,
                null,null,null);



        assertEquals(false,loan1.isNotiifyDate());


    }


    @Test
    public void notifyDateT4() {
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

        cal.add(Calendar.DAY_OF_MONTH,-4);
        newend = cal.getTime() ;
        format = new SimpleDateFormat("dd");
        notDate=format.format(newend);



        LongTermLoan loan1 = new LongTermLoan("1","01",6000,0.12,endDate,
                notDate,100,'f',"09-09-2019",'3',0,
                null,null,null);



        assertEquals(false,loan1.isNotiifyDate());


    }

    @Test
    public void notifyDateT5() {
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

        cal.add(Calendar.DAY_OF_MONTH,-4);
        newend = cal.getTime() ;
        format = new SimpleDateFormat("dd");
        notDate=format.format(newend);



        LongTermLoan loan1 = new LongTermLoan("1","01",6000,0.12,endDate,
                notDate,100,'f',"09-09-2019",'3',0,
                null,null,null);



        assertEquals(false,loan1.isNotiifyDate());


    }








}
