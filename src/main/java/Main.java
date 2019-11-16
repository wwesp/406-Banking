import Accounts.BankAccounts.Money.Checking;
import Accounts.BankAccounts.Money.RegSavings;
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

        ArrayList<Checking> h=x.getCheckingByATMCard("2899653222933490");

        for (Checking y:h
             ) {
            System.out.println(y.getAtmCard());
        }





    }
}



