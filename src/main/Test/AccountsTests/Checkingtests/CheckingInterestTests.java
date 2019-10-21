package AccountsTests.Checkingtests;

import Accounts.BankAccounts.Money.Checking;
import Accounts.BankAccounts.Money.RegSavings;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class CheckingInterestTests {

    @Test
    public void interestT1() {

        ArrayList<String> his = new ArrayList<>();
        his.add("09-19-2019");
        Checking c1 = new Checking("123","000000000",1000.00,"10-10-2010",1,"321","555",his, null,null,null,"",null);
        RegSavings rs1 = new RegSavings("321","000000000", 10, "10-10-2010",0.05,"");

        ArrayList<RegSavings> x = new ArrayList<>();
        x.add(rs1);

        c1.dailyInterest();

        assertEquals(1005,c1.getBalancef(),0.001);

    }
    @Test
    public void goldbelow1000() {

        ArrayList<String> his = new ArrayList<>();
        his.add("09-19-2019");
        Checking c1 = new Checking("123","000000000",999.00,"10-10-2010",1,"321","555",his, null,null,null,"",null);
        RegSavings rs1 = new RegSavings("321","000000000", 10, "10-10-2010",0.05,"");

        ArrayList<RegSavings> x = new ArrayList<>();
        x.add(rs1);

        c1.dailyInterest();

        assertEquals(999.0,c1.getBalancef(),0.001);

    }

}
