package AccountsTests.Checkingtests;

import Accounts.BankAccounts.Money.Checking;
import Accounts.BankAccounts.Money.RegSavings;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class CheckingDeleteChecking {

    @Test
    public void delwithposbal() {

        Checking c1 = new Checking("123","000000000",10,"10-10-2010",0,"321","555",null, null,null,null,"",null);
        double x = c1.endChecking();

        assertEquals(10,x,0.001);

    }

    @Test
    public void delwitnegbal() {

        Checking c1 = new Checking("123","000000000",-1000,"10-10-2010",0,"321","555",null, null,null,null,"",null);
        double x = c1.endChecking();

        assertEquals(-1000,x,0.001);

    }

}
