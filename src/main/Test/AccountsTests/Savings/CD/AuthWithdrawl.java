package AccountsTests.Savings.CD;

import Accounts.BankAccounts.Money.CDs;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class AuthWithdrawl {
    @Test
    public void withdrawNoPenalty() {
        CDs x = new CDs("3","4",500,"","05-19-2019",1.005,"");
        double y= x.authorizeWithdraw();
        //today should be false
        assertEquals(500,y,0.001);

    }
    @Test
    public void withdrawPenalty() {
        //tests if today is the end date, it must get though its last day!
        SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy");
        String today=format.format(new Date());
        CDs x = new CDs("3","4",500,"",today,1.005,"");
        double y= x.authorizeWithdraw();
        //today should be false
        assertEquals(500,y,0.001);

    }
}
