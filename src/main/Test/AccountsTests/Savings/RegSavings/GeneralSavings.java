package AccountsTests.Savings.RegSavings;

import Accounts.BankAccounts.Money.CDs;
import Accounts.BankAccounts.Money.RegSavings;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GeneralSavings {
    @Test
    public void withdrawUnderBal() {
        RegSavings x = new RegSavings("123","666",2000,"",1.02,"");
        x.authorizeWithdraw(600);
        //today should be false
        assertEquals(1400,x.getBalancef(),0.001);
    }
    @Test
    public void withdrawOverBal() {
        RegSavings x = new RegSavings("123","666",2000,"",1.02,"");
        x.authorizeWithdraw(2001);
        //today should be false
        assertEquals(2000,x.getBalancef(),0.001);
    }
    @Test
    public void removeAccount() {
        RegSavings x = new RegSavings("123","666",2000,"",1.02,"");
        double y=x.endRegSavings();
        //today should be false
        assertEquals(2000,y,0.001);
    }
    @Test
    public void deposit() {
        RegSavings x = new RegSavings("123","666",2000,"",1.02,"");
        x.authorizeDeposit(6000);
        //today should be false
        assertEquals(8000,x.getBalancef(),0.001);
    }
    @Test
    public void interest() {
        RegSavings x = new RegSavings("123","666",2000,"",1.02,"");
        x.dailyInterest();

        //today should be false
        assertEquals(2040,x.getBalancef(),0.001);
    }



}
