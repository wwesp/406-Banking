import Accounts.BankAccounts.Money.RegSavings;
import persistence.DataBomb.DataBomb;
import persistence.GetData.GetData;
import persistence.SaveData.SaveData;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {

        DataBomb x= new DataBomb();
        x.SaveBomb();

        GetData y = new GetData();
        ArrayList<RegSavings> temp = y.getRegSavings("423-16-8945");

        System.out.println(temp.get(0).getBalancef());

        for(RegSavings o:temp){
            o.authorizeWithdraw(20.00);
        }

        SaveData z = new SaveData();
        z.saveSaving(temp);

        System.out.println(temp.get(0).getBalancef());
    }
}



