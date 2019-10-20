package AccountsTests.Checkingtests;

import Accounts.BankAccounts.Money.Checking;
import Accounts.BankAccounts.Money.RegSavings;
import Accounts.BankAccounts.Money.Savings;
import org.junit.*;

import static org.junit.Assert.assertEquals;
import Accounts.BankAccounts.*;

import java.util.ArrayList;

public class CheckingWithdrawlTesting {
    //objects to test with


    @Test public void perfectWithdrawl() {
        Checking c1 = new Checking("123","000000000",10,"10-10-2010",0,"321","555",null, null,null,null,"");
        RegSavings rs1 = new RegSavings("321","000000000", 10, "10-10-2010",0.05,"");

        ArrayList<RegSavings> x = new ArrayList<>();
        x.add(rs1);
        //there is $20 but they can only pull 19.25 since there is a 75 cent sir charge
        c1.authorizeWithdrawl(19.25, x, true);


        assertEquals(0,c1.getBalancef(),0.001);

    }

    @Test public void noNeedforSavings() {
        Checking c1 = new Checking("123","000000000",10,"10-10-2010",0,"321","555",null, null,null,null,"");
        RegSavings rs1 = new RegSavings("321","000000000", 10, "10-10-2010",0.05,"");

        ArrayList<RegSavings> x = new ArrayList<>();
        x.add(rs1);
        c1.authorizeWithdrawl(9.25, x, true);


        assertEquals(0,c1.getBalancef(),0.001);

    }

    @Test public void SavingsNotEnough() {
        Checking c1 = new Checking("123","000000000",10,"10-10-2010",0,"321","555",null, null,null,null,"");
        RegSavings rs1 = new RegSavings("321","000000000", 10, "10-10-2010",0.05,"");

        ArrayList<RegSavings> x = new ArrayList<>();
        x.add(rs1);
        c1.authorizeWithdrawl(50, x, true);


        assertEquals(-60.75,c1.getBalancef(),0.001);

    }

    @Test public void DoesNotHaveSavingsNonOverDraw() {
        Checking c1 = new Checking("123","000000000",10,"10-10-2010",0,null,"555",null, null,null,null,"");


        ArrayList<RegSavings> x = new ArrayList<>();

        c1.authorizeWithdrawl(9.25, x, true);


        assertEquals(0,c1.getBalancef(),0.001);

    }

    @Test public void DoesNotHaveSavingsOverDraw() {
        Checking c1 = new Checking("123","000000000",10,"10-10-2010",0,null,"555",null, null,null,null,"");


        ArrayList<RegSavings> x = new ArrayList<>();

        c1.authorizeWithdrawl(20, x, true);


        assertEquals(-30.75,c1.getBalancef(),0.001);

    }
    @Test public void DoesNotHaveSavingsNonOverDrawT2() {
        Checking c1 = new Checking("123","000000000",10,"10-10-2010",0,null,"555",null, null,null,null,"");


        ArrayList<RegSavings> x = new ArrayList<>();

        c1.authorizeWithdrawl(8, x, true);


        assertEquals(1.25,c1.getBalancef(),0.001);

    }


    @Test public void doubleTestingT1() {
        Checking c1 = new Checking("123","000000000",10,"10-10-2010",0,"321","555",null, null,null,null,"");
        RegSavings rs1 = new RegSavings("321","000000000", 10, "10-10-2010",0.05,"");

        ArrayList<RegSavings> x = new ArrayList<>();
        x.add(rs1);
        c1.authorizeWithdrawl(7.34, x, true);


        assertEquals(1.91,c1.getBalancef(),0.001);

    }
    @Test public void doubleTestingT2() {
        Checking c1 = new Checking("123","000000000",10,"10-10-2010",0,"321","555",null, null,null,null,"");
        RegSavings rs1 = new RegSavings("321","000000000", 10, "10-10-2010",0.05,"");

        ArrayList<RegSavings> x = new ArrayList<>();
        x.add(rs1);
        c1.authorizeWithdrawl(73.34, x, true);


        assertEquals(-84.09,c1.getBalancef(),0.001);

    }

    @Test public void monthlyT1() {
        Checking c1 = new Checking("123","000000000",10,"10-10-2010",0,"321","555",null, null,null,null,"");
        RegSavings rs1 = new RegSavings("321","000000000", 10, "10-10-2010",0.05,"");

        ArrayList<RegSavings> x = new ArrayList<>();
        x.add(rs1);
        c1.authorizeWithdrawl(73.34, x, false);


        assertEquals(-83.84,c1.getBalancef(),0.001);

    }

    @Test public void MonthlyT2() {
        Checking c1 = new Checking("123","000000000",10,"10-10-2010",0,null,"555",null, null,null,null,"");


        ArrayList<RegSavings> x = new ArrayList<>();

        c1.authorizeWithdrawl(9.50, x, false);


        assertEquals(0,c1.getBalancef(),0.001);

    }



}
