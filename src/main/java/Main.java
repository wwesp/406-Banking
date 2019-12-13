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



    }
}



