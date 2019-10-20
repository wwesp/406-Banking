package AccountsTests.Checkingtests;

import Accounts.BankAccounts.Money.Checking;
import Accounts.BankAccounts.Money.RegSavings;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class CheckingAddBalence {


    @Test
    public void addBalenceNoOverdraft() {

        ArrayList<String> his = new ArrayList<>();
        his.add("09-19-2019");
        Checking c1 = new Checking("123","000000000",10,"10-10-2010",0,"321","555",his, null,null,null,"");
        RegSavings rs1 = new RegSavings("321","000000000", 10, "10-10-2010",0.05);

        ArrayList<RegSavings> x = new ArrayList<>();
        x.add(rs1);


        c1.addBalence(1,x);


        assertEquals(c1.getBalancef(),10.50,0.001);

    }
    @Test
    public void addBalenceOverdraft() {

        ArrayList<String> his = new ArrayList<>();
        his.add("09-19-2019");
        Checking c1 = new Checking("123","000000000",0,"10-10-2010",0,"321","555",his, null,null,null,"");
        RegSavings rs1 = new RegSavings("321","000000000", 0, "10-10-2010",0.05);

        ArrayList<RegSavings> x = new ArrayList<>();
        x.add(rs1);


        c1.addBalence(0.01,x);


        assertEquals(c1.getBalancef(),-20.49,0.001);

    }











}
