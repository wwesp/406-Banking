package SystemHelper;

import Accounts.BankAccounts.Debt.CreditCard;
import Accounts.BankAccounts.Debt.LongTermLoan;
import Accounts.BankAccounts.Debt.ShortTermLoan;
import Accounts.BankAccounts.Money.*;
import persistence.GetData.GetAllData;
import persistence.SaveData.SaveData;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;


public class SystemHelper {

    public double truncOrRound(double x, int roundType){
        DecimalFormat df = new DecimalFormat("#.##");
        if (roundType==0){
            df.setRoundingMode(RoundingMode.DOWN);
        }
        else{
            df.setRoundingMode(RoundingMode.UP);
        }

        String s = df.format(x);
        return Double.parseDouble(s);
    }

    //will truncate all doubles to .## values
    public double perciseSubtract(double value, double sub){


        return truncOrRound(value-sub,0);

    }
    public double perciseAddition(double value, double sub){
        return truncOrRound(value+sub,0);

    }


    public String makeRandomId(){
        Random objGenerator = new Random();
        String randoms="";
        for (int iCount = 0; iCount< 10; iCount++){
            int randomNumber = objGenerator.nextInt(9);
            randoms+=randomNumber;
        }
        return randoms;
    }


    public void updateAllDataInfo(){

        GetAllData help = new GetAllData();
        SaveData save = new SaveData();

        ArrayList<RegSavings> regSavings= help.getRegSavings();
        ArrayList<CDs> cDs = help.getAllCDs();
        ArrayList<CreditCard> creditCards =help.getCC();
        ArrayList<ShortTermLoan> shortTermLoans = help.getShortLoan();
        ArrayList<LongTermLoan> longTermLoans= help.getLongLoan();
        ArrayList<Checking> checkings = help.getChecking();



        regSavings.forEach(RegSavings::dailyInterest);

        cDs.forEach(CDs::dailyInterest);

        creditCards.forEach(CreditCard::paymentDue);

        shortTermLoans.forEach(ShortTermLoan::paymentDue);

        longTermLoans.forEach(LongTermLoan::paymentDue);

        checkings.forEach(Checking::dailyInterest);

        save.saveCheckAndSave(regSavings,checkings);
        save.saveCD(cDs);
        save.saveCC(creditCards);
        save.saveShortLoan(shortTermLoans);
        save.saveLongLoan(longTermLoans);




    }





}
