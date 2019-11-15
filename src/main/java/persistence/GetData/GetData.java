package persistence.GetData;

import Accounts.BankAccounts.Debt.CreditCard;
import Accounts.BankAccounts.Debt.LongTermLoan;
import Accounts.BankAccounts.Debt.ShortTermLoan;
import Accounts.BankAccounts.Money.CDs;
import Accounts.BankAccounts.Money.Checking;
import Accounts.BankAccounts.Money.RegSavings;
import Accounts.People.Customer;
import Accounts.People.Managment;
import Accounts.People.Teller;
import com.google.gson.Gson;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class GetData {
//date fomrated at MM-dd-yyyy
    public Customer getCustomerBySSN(String SSN){

        ArrayList<Customer> x = new ArrayList<>();

        Gson gson = new Gson();
        File CustFile = new File("src/main/java/persistence/DataBases/Customers.txt");

        try{
            Scanner scan= new Scanner(CustFile);

            while(scan.hasNextLine()){

                x.add(gson.fromJson(scan.nextLine(), Customer.class));

            }

        } catch (Exception ex){
            ex.printStackTrace();
        }

        for (Customer y:x){
            if (y.getSsn().equals(SSN)){
                return y;
            }
        }
        return null;
    }

    public Customer getCustomerByATM(String ATMNum){

        ArrayList<Customer> x = new ArrayList<>();

        Gson gson = new Gson();
        File CustFile = new File("src/main/java/persistence/DataBases/Customers.txt");

        try{
            Scanner scan= new Scanner(CustFile);

            while(scan.hasNextLine()){

                x.add(gson.fromJson(scan.nextLine(), Customer.class));

            }

        } catch (Exception ex){
            ex.printStackTrace();
        }

        for (Customer y :x){
            if (y.getAtmCard().equals(ATMNum)){
                return y;
            }
        }
        return null;

    }

    public Managment getManager(String SSN){

        ArrayList<Managment> x= new ArrayList<>();
        Gson gson = new Gson();
        File ManagFile = new File("src/main/java/persistence/DataBases/Managment.txt");

        try{
            Scanner scan= new Scanner(ManagFile);

            while(scan.hasNextLine()){

                x.add(gson.fromJson(scan.nextLine(), Managment.class));

            }

        } catch (Exception ex){
            ex.printStackTrace();
        }

        for (Managment y :x){
            if (y.getSsn().equals(SSN)){
                return y;
            }
        }
        return null;

    }

    public Teller getTeller(String SSN){

        ArrayList<Teller> x= new ArrayList<>();
        Gson gson = new Gson();
        File TellerFile = new File("src/main/java/persistence/DataBases/Teller.txt");

        try{
            Scanner scan= new Scanner(TellerFile);

            while(scan.hasNextLine()){

                x.add(gson.fromJson(scan.nextLine(), Teller.class));

            }

        } catch (Exception ex){
            ex.printStackTrace();
        }

        for (Teller y :x){
            if (y.getSsn().equals(SSN)){
                return y;
            }
        }
        return null;

    }

    public ArrayList<CDs> getCD(String CustomerSSN){
        ArrayList<CDs> x = new ArrayList<>();
        Gson gson = new Gson();
        File CDsFile = new File("src/main/java/persistence/DataBases/CD.txt");

        try{
            Scanner scan= new Scanner(CDsFile);

            while(scan.hasNextLine()){

                x.add(gson.fromJson(scan.nextLine(), CDs.class));

            }

        } catch (Exception ex){
            ex.printStackTrace();
        }

        ArrayList<CDs> returnable = new ArrayList<>();
        for (CDs y :x){
            if (y.getCusID().equals(CustomerSSN)){
                returnable.add(y);
            }
        }
        if(returnable.isEmpty()){
            return null;
        }

        return returnable;

    }

    public ArrayList<RegSavings> getRegSavings(String CustomerSSN){
        ArrayList<RegSavings> x = new ArrayList<>();
        Gson gson = new Gson();
        File SavingFile = new File("src/main/java/persistence/DataBases/RegSaving.txt");

        try{
            Scanner scan= new Scanner(SavingFile);

            while(scan.hasNextLine()){

                x.add(gson.fromJson(scan.nextLine(), RegSavings.class));

            }

        } catch (Exception ex){
            ex.printStackTrace();
        }

        ArrayList<RegSavings> returnable = new ArrayList<>();
        for (RegSavings y :x){
            if (y.getCusID().equals(CustomerSSN)){
                returnable.add(y);
            }
        }

        if(returnable.isEmpty()){
            return null;
        }

        return returnable;

    }

    public ArrayList<Checking> getCheckingBySSN(String CustomerSSN){
        ArrayList<Checking> x = new ArrayList<>();
        Gson gson = new Gson();
        File CheckingFile = new File("src/main/java/persistence/DataBases/Checking.txt");

        try{
            Scanner scan= new Scanner(CheckingFile);

            while(scan.hasNextLine()){

                x.add(gson.fromJson(scan.nextLine(), Checking.class));

            }

        } catch (Exception ex){
            ex.printStackTrace();
        }

        ArrayList<Checking> returnable = new ArrayList<>();
        for (Checking y :x){
            if (y.getAtmCard().equals(CustomerSSN)){
                returnable.add(y);
            }
        }

        if(returnable.isEmpty()){
            return null;
        }

        return returnable;

    }

    public ArrayList<Checking> getCheckingByATMCard(String card){
        ArrayList<Checking> x = new ArrayList<>();
        Gson gson = new Gson();
        File CheckingFile = new File("src/main/java/persistence/DataBases/Checking.txt");

        try{
            Scanner scan= new Scanner(CheckingFile);

            while(scan.hasNextLine()){

                x.add(gson.fromJson(scan.nextLine(), Checking.class));

            }

        } catch (Exception ex){
            ex.printStackTrace();
        }

        ArrayList<Checking> returnable = new ArrayList<>();
        for (Checking y :x){
            if (y.getAtmCard().equals(card)){
                returnable.add(y);
            }
        }
        if(returnable.isEmpty()){
            return null;
        }

        return returnable;

    }

    public ArrayList<LongTermLoan> getLongLoan(String SSN){
        ArrayList<LongTermLoan> x = new ArrayList<>();
        Gson gson = new Gson();
        File LongLoanFile = new File("src/main/java/persistence/DataBases/LongTermLoan.txt");

        try{
            Scanner scan= new Scanner(LongLoanFile);

            while(scan.hasNextLine()){

                x.add(gson.fromJson(scan.nextLine(), LongTermLoan.class));

            }

        } catch (Exception ex){
            ex.printStackTrace();
        }

        ArrayList<LongTermLoan> returnable = new ArrayList<>();
        for (LongTermLoan y :x){
            if (y.getCusID().equals(SSN)){
                returnable.add(y);
            }
        }

        if(returnable.isEmpty()){
            return null;
        }

        return returnable;

    }

    public ArrayList<ShortTermLoan> getShortLoan(String SSN){
        ArrayList<ShortTermLoan> x = new ArrayList<>();
        Gson gson = new Gson();
        File ShortLoanFile = new File("src/main/java/persistence/DataBases/ShortTermLoan.txt");

        try{
            Scanner scan= new Scanner(ShortLoanFile);

            while(scan.hasNextLine()){

                x.add(gson.fromJson(scan.nextLine(), ShortTermLoan.class));

            }

        } catch (Exception ex){
            ex.printStackTrace();
        }

        ArrayList<ShortTermLoan> returnable = new ArrayList<>();
        for (ShortTermLoan y :x){
            if (y.getCusID().equals(SSN)){
                returnable.add(y);
            }
        }

        if(returnable.isEmpty()){
            return null;
        }

        return returnable;

    }

    public ArrayList<CreditCard> getCC(String SSN){
        ArrayList<CreditCard> x = new ArrayList<>();
        Gson gson = new Gson();
        File CCFile = new File("src/main/java/persistence/DataBases/CreditCard.txt");

        try{
            Scanner scan= new Scanner(CCFile);

            while(scan.hasNextLine()){

                x.add(gson.fromJson(scan.nextLine(), CreditCard.class));

            }

        } catch (Exception ex){
            ex.printStackTrace();
        }

        ArrayList<CreditCard> returnable = new ArrayList<>();
        for (CreditCard y :x){
            if (y.getCusID().equals(SSN)){
                returnable.add(y);
            }
        }

        if(returnable.isEmpty()){
            return null;
        }

        return returnable;

    }



}
