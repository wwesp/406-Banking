package AccountsTests.Checkingtests;

import Accounts.BankAccounts.Money.Checking;
import Accounts.BankAccounts.Money.RegSavings;
import Accounts.BankAccounts.Money.Savings;
import org.junit.*;

import static org.junit.Assert.assertEquals;
import Accounts.BankAccounts.*;

import java.util.ArrayList;
import java.util.HashMap;

public class CheckingCheckTests {

    @Test
    public void addBalenceOverdraft() {

        ArrayList<String> his = new ArrayList<>();
        his.add("09-19-2019");

        HashMap<String,Double> pending= new HashMap<>();
        pending.put("100",5.0);

        Checking c1 = new Checking("123","000000000",50,"10-10-2010",0,"321",
                "555",his, pending,null,null,"",null);
        RegSavings rs1 = new RegSavings("321","000000000", 100, "10-10-2010",0.05,"");

        ArrayList<RegSavings> x = new ArrayList<>();
        x.add(rs1);



        c1.authPayCheck("100",x);


        assertEquals(44.50,c1.getBalancef(),0.001);

    }

    @Test
    public void ispaidMovedToAccepted() {

        ArrayList<String> his = new ArrayList<>();
        his.add("09-19-2019");

        HashMap<String,Double> pending= new HashMap<>();
        pending.put("100",5.0);

        Checking c1 = new Checking("123","000000000",50,"10-10-2010",0,"321",
                "555",his, pending,null,null,"",null);
        RegSavings rs1 = new RegSavings("321","000000000", 100, "10-10-2010",0.05,"");

        ArrayList<RegSavings> x = new ArrayList<>();
        x.add(rs1);



        c1.authPayCheck("100",x);

        //TODO:FIX
        //assertEquals(true,c1.getAcceptedChecks().containsKey("100"));

    }
    @Test
    public void isStoppedMovedtoDenied() {

        ArrayList<String> his = new ArrayList<>();
        his.add("09-19-2019");

        HashMap<String,Double> pending= new HashMap<>();
        pending.put("100",5.0);

        Checking c1 = new Checking("123","000000000",50,"10-10-2010",0,"321",
                "555",his, pending,null,null,"",null);
        RegSavings rs1 = new RegSavings("321","000000000", 100, "10-10-2010",0.05,"");

        ArrayList<RegSavings> x = new ArrayList<>();
        x.add(rs1);



        c1.authStopCheck("100",x);


        assertEquals(true,c1.getDeniedChecks().containsKey("100"));

    }
    @Test
    public void didStopFine() {

        ArrayList<String> his = new ArrayList<>();
        his.add("09-19-2019");

        HashMap<String,Double> pending= new HashMap<>();
        pending.put("100",5.0);

        Checking c1 = new Checking("123","000000000",50,"10-10-2010",0,"321",
                "555",his, pending,null,null,"",null);
        RegSavings rs1 = new RegSavings("321","000000000", 100, "10-10-2010",0.05,"");

        ArrayList<RegSavings> x = new ArrayList<>();
        x.add(rs1);



        c1.authStopCheck("100",x);


        assertEquals(35,c1.getBalancef(),0.001);

    }




}
