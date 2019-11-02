package AccountsTests.Debt.Credit;

import Accounts.BankAccounts.Debt.CreditCard;
import Accounts.BankAccounts.Debt.LongTermLoan;
import Accounts.BankAccounts.Money.Checking;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class PaymentTest {

    @Test
    public void PurchaseT1() {

        CreditCard cred= new CreditCard("","",30,0.02,"12","2",
                0,' ',"00-00-0000",5,null,null,100);


        assertEquals(true,cred.makeCreditPurchase(30));


    }
    @Test
    public void PurchaseT2() {

        CreditCard cred= new CreditCard("","",30,0.02,"12","2",
                0,' ',"00-00-0000",5,null,null,100);


        assertEquals(true,cred.makeCreditPurchase(100));


    }
    @Test
    public void PurchaseT3() {

        CreditCard cred= new CreditCard("","",30,0.02,"12","2",
                0,' ',"00-00-0000",5,null,null,100);


        assertEquals(false,cred.makeCreditPurchase(100.01));


    }
    @Test
    public void paymentT1() {

        CreditCard cred= new CreditCard("","",30,0.02,"12","2",
                0,' ',"00-00-0000",5,null,null,100);

        cred.makePayment(5);

        assertEquals(0,cred.getFees(),0.001);


    }
    @Test
    public void paymentT2() {

        CreditCard cred= new CreditCard("","",30,0.02,"12","2",
                0,' ',"00-00-0000",5,null,null,100);

        cred.makePayment(6);

        assertEquals(29,cred.getBalancef(),0.001);


    }
    @Test
    public void paymentT3() {

        CreditCard cred= new CreditCard("","",30,0.02,"12","2",
                0,' ',"00-00-0000",5,null,null,100);



        assertEquals(1,cred.makePayment(36),0.001);


    }

    @Test
    public void paymentT4() {

        CreditCard cred= new CreditCard("","",30,0.02,"12","2",
                0,' ',"00-00-0000",5,null,null,100);


        cred.makePayment(36);

        assertEquals(0,cred.getCurrentPaymentDue(),0.001);


    }

    @Test
    public void paymentT5() {

        CreditCard cred= new CreditCard("","",30,0.02,"12","2",
                5,' ',"00-00-0000",5,null,null,100);


        cred.makePayment(40);

        assertEquals(0,cred.getCurrentPaymentDue(),0.001);


    }
    @Test
    public void paymentT6() {

        CreditCard cred= new CreditCard("","",30,0.02,"12","2",
                5,' ',"00-00-0000",5,null,null,100);





        assertEquals(2,cred.makePayment(42),0.001);


    }
    @Test
    public void paymentT7() {

        CreditCard cred= new CreditCard("","",0,0.02,"12","2",
                5,' ',"00-00-0000",5,null,null,100);





        assertEquals(2,cred.makePayment(12),0.001);


    }






}
