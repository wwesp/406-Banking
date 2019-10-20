package AccountsTests.Checkingtests;

import Accounts.BankAccounts.Money.Checking;
import Accounts.BankAccounts.Money.RegSavings;
import Accounts.BankAccounts.Money.Savings;
import org.junit.*;

import static org.junit.Assert.assertEquals;
import Accounts.BankAccounts.*;

import java.util.ArrayList;

public class CheckingWithdrawlATMTesting {

    @Test public void ToManyWithdrawls() {

        Checking c1 = new Checking("123","000000000",10,"10-10-2010",0,"321","555",null, null,null,null,"");
        RegSavings rs1 = new RegSavings("321","000000000", 10, "10-10-2010",0.05,"");

        ArrayList<RegSavings> x = new ArrayList<>();
        x.add(rs1);
        c1.authorizeWithdrawlATM(1, x, false);
        c1.authorizeWithdrawlATM(1, x, false);
        boolean checker= c1.authorizeWithdrawlATM(1, x, false);


        assertEquals(checker,false);

    }

    @Test public void OldDateRemoved() {

        ArrayList<String> his = new ArrayList<>();
        his.add("09-19-2019");
        Checking c1 = new Checking("123","000000000",10,"10-10-2010",0,"321","555",his, null,null,null,"");
        RegSavings rs1 = new RegSavings("321","000000000", 10, "10-10-2010",0.05,"");

        ArrayList<RegSavings> x = new ArrayList<>();
        x.add(rs1);
        c1.authorizeWithdrawlATM(1, x, false);
        boolean checker= c1.authorizeWithdrawlATM(1, x, false);


        assertEquals(checker,true);

    }

    @Test public void historySizeCheckT1() {

        ArrayList<String> his = new ArrayList<>();
        his.add("09-19-2019");
        Checking c1 = new Checking("123","000000000",10,"10-10-2010",0,"321","555",his, null,null,null,"");
        RegSavings rs1 = new RegSavings("321","000000000", 10, "10-10-2010",0.05,"");

        int size=c1.getAtmHistory().size();


        assertEquals(size,0);

    }

    @Test public void historySizeCheckT2() {

        ArrayList<String> his = new ArrayList<>();

        Checking c1 = new Checking("123","000000000",10,"10-10-2010",0,"321","555",his, null,null,null,"");
        RegSavings rs1 = new RegSavings("321","000000000", 10, "10-10-2010",0.05,"");

        int size=c1.getAtmHistory().size();


        assertEquals(size,0);

    }

    @Test public void historySizeCheckT3() {

        ArrayList<String> his = new ArrayList<>();
        his.add("09-19-2019");
        Checking c1 = new Checking("123","000000000",10,"10-10-2010",0,"321","555",his, null,null,null,"");
        RegSavings rs1 = new RegSavings("321","000000000", 10, "10-10-2010",0.05,"");
        ArrayList<RegSavings> x = new ArrayList<>();
        x.add(rs1);

        c1.authorizeWithdrawlATM(1,x, false);

        int size=c1.getAtmHistory().size();

        assertEquals(size,1);

    }

    @Test public void historySizeCheckT4() {

        ArrayList<String> his = new ArrayList<>();
        his.add("09-19-2019");
        Checking c1 = new Checking("123","000000000",10,"10-10-2010",0,"321","555",his, null,null,null,"");
        RegSavings rs1 = new RegSavings("321","000000000", 10, "10-10-2010",0.05,"");
        ArrayList<RegSavings> x = new ArrayList<>();
        x.add(rs1);

        c1.authorizeWithdrawlATM(1,x, false);
        c1.authorizeWithdrawlATM(1,x, false);

        int size=c1.getAtmHistory().size();

        assertEquals(size,2);

    }


    @Test public void historySizeCheckT5() {

        ArrayList<String> his = new ArrayList<>();
        his.add("09-19-2019");
        Checking c1 = new Checking("123","000000000",10,"10-10-2010",0,"321","555",his, null,null,null,"");
        RegSavings rs1 = new RegSavings("321","000000000", 10, "10-10-2010",0.05,"");
        ArrayList<RegSavings> x = new ArrayList<>();
        x.add(rs1);

        c1.authorizeWithdrawlATM(1,x,false);
        c1.authorizeWithdrawlATM(1,x,false);
        c1.authorizeWithdrawlATM(1,x,false);

        int size=c1.getAtmHistory().size();

        assertEquals(size,2);

    }



}
