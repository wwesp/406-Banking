import Accounts.BankAccounts.Money.Checking;
import Accounts.BankAccounts.Money.RegSavings;
import Accounts.Interest;
import SystemHelper.SystemHelper;
import persistence.DataBomb.DataBomb;
import persistence.GetData.GetData;
import persistence.SaveData.SaveData;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {

        GetData x = new GetData();
        DataBomb f = new DataBomb();
        f.CCLoanBomb();
        f.CDBomb();
        f.CheckBomb();
        f.CustBomb();
        f.LongLoanBomb();
        f.ManagBomb();
        f.SaveBomb();
        f.ShortLoanBomb();
        f.TellerBomb();
        f.intrestBomb();

        ArrayList<Checking> h=x.getCheckingBySSN("423-14-8894");
        System.out.println("Main :"+h);
        for (Checking y:h
             ) {
            System.out.println(y.getAtmCard());
        }


        Interest intre = new GetData().getIntRates();

        System.out.println("Rate "+ intre.getCDInterest());




    }
}



