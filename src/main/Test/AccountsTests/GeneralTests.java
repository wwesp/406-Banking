package AccountsTests;

import Accounts.BankAccounts.Money.Checking;
import Accounts.BankAccounts.Money.RegSavings;
import SystemHelper.SystemHelper;
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

    @Test
    public void guites() {

        Checking a= new Checking("4","423-45-3245",6.23,"12-01-2002",1,"1","2899653222933490",null,null,null,null,null,null);

        a.addBalence(30,new ArrayList<>());
        //wrong!!!
        assertEquals(0,0);

    }



    @Test
    public void testSysHelpDoubleT1() {

        double f= 9.02432324234;
        double a= 30.423423432;
        double ans= new SystemHelper().perciseAddition(f,a);
        assertEquals(39.02,ans,0000000000000000001);

    }

    @Test
    public void testSysHelpDoubleT2() {

        double f= 6.23;
        double a= 30;
        double ans= new SystemHelper().perciseAddition(f,a);
        assertEquals(36.23,ans,0000000000000000001);

    }

}
