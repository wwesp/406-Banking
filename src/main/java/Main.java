

import Accounts.*;



import java.util.ArrayList;


public class Main {

    public static void main(String[] args) {




        System.out.println("Hello World");


        ArrayList<MoneyAccounts> y= new ArrayList<MoneyAccounts>();

        CheckingAccount x = new CheckingAccount("000-00-0000","231", "21324", 900,null);
        SavingsAccount z= new SavingsAccount("000-00-0000","654332", "6543234567", 30, null);

        AccountHolder jeff = new AccountHolder("000-00-0000","Jeff", "A134B0", null);


        jeff.addAccount("231",x);
        jeff.addAccount("654332",z);
        //System.out.println(jeff.accounts);

        jeff.accounts.forEach((s,f)->System.out.println(f));
        System.out.println(jeff.accounts.get("231"));

        System.out.println(jeff.toString());









    }
}



