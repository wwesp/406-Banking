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


        ArrayList<RegSavings> p = new GetData().getRegSavings("423-45-3245");
        ArrayList<Checking> cu = new GetData().getCheckingBySSN("423-45-3245");
        SaveData save = new SaveData();

        for(RegSavings sav: p){
            System.out.println(sav.getID());
            System.out.println(sav.getBalancef());


            if(sav.getID().equals("1")){

                for(Checking che : cu){

                    if(che.getID().equals("1")){

                        che.moneyTransfer(sav,10.1);

                    }
                }

            }
        }
        //cause problems!
        cu.add(null);
        save.saveCheckAndSave(p,cu);

        ArrayList<RegSavings> newp = new GetData().getRegSavings("423-45-3245");
        ArrayList<Checking> newcu = new GetData().getCheckingBySSN("423-45-3245");

        for(RegSavings he: newp){
            System.out.println("NEW: "+he.getID());
            System.out.println("NEW: "+he.getBalancef());
        }

        for(Checking he: newcu){
            System.out.println("NEW: "+he.getID());
            System.out.println("NEW: "+he.getBalancef());
        }

    }
}



