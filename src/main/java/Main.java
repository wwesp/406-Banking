

import Accounts.BankAccounts.*;

import Accounts.BankAccounts.Money.CDs;
import org.json.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;


public class Main {

    public static void main(String[] args) throws Exception {
        CDs x = new CDs("3","4",500,"","05-20-2020",1.005,"");
        System.out.println(x.pastEndDate());

    }
}



