package SystemHelper;

import Accounts.BankAccounts.Money.*;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;
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


        return truncOrRound(value-sub,1);

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


}
