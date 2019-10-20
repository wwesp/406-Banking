package AccountsTests.Savings.CD;

import Accounts.BankAccounts.Money.CDs;
import Accounts.BankAccounts.Money.Checking;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class CDPastEndDate {

    @Test
    public void datelaterThanToday() {

        CDs x = new CDs("3","4",500,"","05-20-3020",1.005,"");


        assertEquals(false,x.pastEndDate());

    }
    @Test
    public void today() {
        SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy");
        String today=format.format(new Date());
        CDs x = new CDs("3","4",500,"",today,1.005,"");

        //today should be false
        assertEquals(false,x.pastEndDate());

    }
    @Test
    public void datebehind() {
        SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy");
        String today=format.format(new Date());
        CDs x = new CDs("3","4",500,"","05-19-2019",1.005,"");

        //today should be false
        assertEquals(true,x.pastEndDate());

    }

}
