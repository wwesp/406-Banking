package AccountsTests;

import Accounts.BankAccounts.Money.Checking;
import Accounts.BankAccounts.Money.RegSavings;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/*
* The purpose of the general test are basic tests that can prove useful for
* the creator of the different aspects of each part of design of the project,
* such as objects,data, and gui
* */
public class GeneralTests {

    @Test
    public void parseDoubleT1() {

        Checking c1 = new Checking("123","000000000",1000.00,"10-10-2010",1,"321","555",null, null,null,null,"",null);
        double x= c1.parseDouble(3.028,0);


        assertEquals(3.02,x,0.001);

    }

    @Test
    public void parseDoubleT2() {

        Checking c1 = new Checking("123","000000000",1000.00,"10-10-2010",1,"321","555",null, null,null,null,"",null);
        double x= c1.parseDouble(3.028,1);


        assertEquals(3.03,x,0.001);

    }
}
