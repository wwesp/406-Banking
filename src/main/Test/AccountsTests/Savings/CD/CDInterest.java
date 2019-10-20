package AccountsTests.Savings.CD;

import Accounts.BankAccounts.Money.CDs;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class CDInterest {

    @Test
    public void IntT1() {
        CDs x = new CDs("3","4",500,"","11-30-2060",1.02,"");
        x.dailyInterest();

        //today should be false
        assertEquals(510,x.getBalancef(),0.001);

    }
    @Test
    public void IntT2() {
        CDs x = new CDs("3","4",500,"","11-30-2060",1.02,"");
        //calling this twice should result in the same as T1
        x.dailyInterest();
        x.dailyInterest();

        //today should be false
        assertEquals(510,x.getBalancef(),0.001);

    }
    @Test
    public void IntT3() throws Exception{

        SimpleDateFormat f = new SimpleDateFormat("MM-dd-yyyy");
        String t1= f.format(new Date());
        Date t = new SimpleDateFormat("MM-dd-yyyy").parse(t1);
        Calendar c= Calendar.getInstance();
        c.setTime(t);
        c.add(Calendar.DAY_OF_MONTH,-1);
        Date newday= c.getTime();
        SimpleDateFormat f1= new SimpleDateFormat("MM-dd-yyyy");
        String today= f1.format(newday);

        Date end = new SimpleDateFormat("MM-dd-yyyy").parse(today);
        Calendar cal = Calendar.getInstance();
        cal.setTime(end);
        cal.add(Calendar.MONTH, 1);
        Date newend = cal.getTime() ;
        SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy");
        String endDate=format.format(newend);




        CDs x = new CDs("3","4",500,"",today,1.02,"");
        //calling this twice should result in the same as T1
        x.dailyInterest();


        //The new end date should be one month from current time
        assertEquals(endDate,x.getEndDate());

    }


}
