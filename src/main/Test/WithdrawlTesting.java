import Accounts.BankAccounts.Money.Checking;
import Accounts.BankAccounts.Money.RegSavings;
import Accounts.BankAccounts.Money.Savings;
import org.junit.*;

import static org.junit.Assert.assertEquals;
import Accounts.BankAccounts.*;

import java.util.ArrayList;

public class WithdrawlTesting {
    //objects to test with


    @Test public void perfectWithdrawl() {
        Checking c1 = new Checking("123","000000000",10,"10-10-2010",0,"321","555",null);
        RegSavings rs1 = new RegSavings("321","000000000", 10, "10-10-2010",0.05);

        ArrayList<RegSavings> x = new ArrayList<>();
        x.add(rs1);
        c1.authorizeWithdrawl(20, x);


        assertEquals(0,c1.getBalancef(),0.001);

    }

    @Test public void noNeedforSavings() {
        Checking c1 = new Checking("123","000000000",10,"10-10-2010",0,"321","555",null);
        RegSavings rs1 = new RegSavings("321","000000000", 10, "10-10-2010",0.05);

        ArrayList<RegSavings> x = new ArrayList<>();
        x.add(rs1);
        c1.authorizeWithdrawl(10, x);


        assertEquals(0,c1.getBalancef(),0.001);

    }

    @Test public void SavingsNotEnough() {
        Checking c1 = new Checking("123","000000000",10,"10-10-2010",0,"321","555",null);
        RegSavings rs1 = new RegSavings("321","000000000", 10, "10-10-2010",0.05);

        ArrayList<RegSavings> x = new ArrayList<>();
        x.add(rs1);
        c1.authorizeWithdrawl(50, x);


        assertEquals(-65,c1.getBalancef(),0.001);

    }

    @Test public void DoesNotHaveSavingsNonOverDraw() {
        Checking c1 = new Checking("123","000000000",10,"10-10-2010",0,null,"555",null);


        ArrayList<RegSavings> x = new ArrayList<>();

        c1.authorizeWithdrawl(10, x);


        assertEquals(0,c1.getBalancef(),0.001);

    }

    @Test public void DoesNotHaveSavingsOverDraw() {
        Checking c1 = new Checking("123","000000000",10,"10-10-2010",0,null,"555",null);


        ArrayList<RegSavings> x = new ArrayList<>();

        c1.authorizeWithdrawl(20, x);


        assertEquals(-35,c1.getBalancef(),0.001);

    }
    @Test public void DoesNotHaveSavingsNonOverDrawT2() {
        Checking c1 = new Checking("123","000000000",10,"10-10-2010",0,null,"555",null);


        ArrayList<RegSavings> x = new ArrayList<>();

        c1.authorizeWithdrawl(8, x);


        assertEquals(2,c1.getBalancef(),0.001);

    }


    @Test public void doubleTestingT1() {
        Checking c1 = new Checking("123","000000000",10,"10-10-2010",0,"321","555",null);
        RegSavings rs1 = new RegSavings("321","000000000", 10, "10-10-2010",0.05);

        ArrayList<RegSavings> x = new ArrayList<>();
        x.add(rs1);
        c1.authorizeWithdrawl(7.34, x);


        assertEquals(2.66,c1.getBalancef(),0.001);

    }
    @Test public void doubleTestingT2() {
        Checking c1 = new Checking("123","000000000",10,"10-10-2010",0,"321","555",null);
        RegSavings rs1 = new RegSavings("321","000000000", 10, "10-10-2010",0.05);

        ArrayList<RegSavings> x = new ArrayList<>();
        x.add(rs1);
        c1.authorizeWithdrawl(73.34, x);


        assertEquals(-88.34,c1.getBalancef(),0.001);

    }






}
