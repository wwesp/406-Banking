package SystemHelper;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;

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



}
