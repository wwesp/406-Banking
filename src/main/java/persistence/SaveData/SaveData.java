package persistence.SaveData;

import Accounts.BankAccounts.Debt.CreditCard;
import Accounts.BankAccounts.Debt.LongTermLoan;
import Accounts.BankAccounts.Debt.ShortTermLoan;
import Accounts.BankAccounts.Money.CDs;
import Accounts.BankAccounts.Money.Checking;
import Accounts.BankAccounts.Money.RegSavings;
import Accounts.People.Customer;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class SaveData {

    public void saveCheckAndSave(ArrayList<RegSavings> x, ArrayList<Checking> y){
        saveSaving(x);
        saveChecking(y);
    }

    public void saveChecking(ArrayList<Checking> x){
        ArrayList<Checking> z = new ArrayList<>();

        Gson gson = new Gson();
        File CheckingFile = new File("src/main/java/persistence/DataBases/Checking.txt");

        try {
            Scanner scan = new Scanner(CheckingFile);

            while (scan.hasNextLine()) {

                z.add(gson.fromJson(scan.nextLine(), Checking.class));

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        ArrayList<Checking> newSave = new ArrayList<>();

        for (Checking checking : z) {
            for (Checking x1 : x) {
                if (!checking.getCusID().equals(x1.getCusID())) {
                    newSave.add(checking);
                }
            }
        }

        newSave.addAll(x);

        try(FileWriter writer = new FileWriter(CheckingFile)) {
            for(Checking y:newSave) {
                gson.toJson(y, writer);
                writer.write("\n");
            }

        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void saveSaving(ArrayList<RegSavings> x) {
        ArrayList<RegSavings> z = new ArrayList<>();

        Gson gson = new Gson();
        File SavingsFile = new File("src/main/java/persistence/DataBases/RegSaving.txt");

        try {
            Scanner scan = new Scanner(SavingsFile);

            while (scan.hasNextLine()) {

                z.add(gson.fromJson(scan.nextLine(), RegSavings.class));

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        ArrayList<RegSavings> newSave = new ArrayList<>();

        for (RegSavings regSavings : z) {
            for (RegSavings x1 : x) {
                if (!regSavings.getCusID().equals(x1.getCusID())) {
                    newSave.add(regSavings);
                }
            }
        }

        newSave.addAll(x);

        try(FileWriter writer = new FileWriter(SavingsFile)) {
            for(RegSavings y:newSave) {
                gson.toJson(y, writer);
                writer.write("\n");
            }

        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void saveCustomer(Customer x){

        ArrayList<Customer> z = new ArrayList<>();

        Gson gson = new Gson();
        File CustFile = new File("src/main/java/persistence/DataBases/Customers.txt");

        try{
            Scanner scan= new Scanner(CustFile);

            while(scan.hasNextLine()){

                z.add(gson.fromJson(scan.nextLine(), Customer.class));

            }

        } catch (Exception ex){
            ex.printStackTrace();
        }

        ArrayList<Customer> newSave = new ArrayList<>();

        for(Customer y:z){
            if (!y.getSsn().equals(x.getSsn())){
                newSave.add(y);
            }
        }
        newSave.add(x);

        try(FileWriter writer = new FileWriter(CustFile)) {
            for(Customer y:newSave) {
                gson.toJson(y, writer);
                writer.write("\n");
            }

        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void saveCD(ArrayList<CDs> x) {

        ArrayList<CDs> z = new ArrayList<>();

        Gson gson = new Gson();
        File CDFile = new File("src/main/java/persistence/DataBases/CD.txt");

        try {
            Scanner scan = new Scanner(CDFile);

            while (scan.hasNextLine()) {

                z.add(gson.fromJson(scan.nextLine(), CDs.class));

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        ArrayList<CDs> newSave = new ArrayList<>();

        for (CDs cDs : z) {
            for (CDs x1 : x) {
                if (!cDs.getCusID().equals(x1.getCusID())) {
                    newSave.add(cDs);
                }
            }
        }

        newSave.addAll(x);

        try (FileWriter writer = new FileWriter(CDFile)) {
            for (CDs y : newSave) {
                gson.toJson(y, writer);
                writer.write("\n");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void saveLongLoan(ArrayList<LongTermLoan> x){
        ArrayList<LongTermLoan> z = new ArrayList<>();

        Gson gson = new Gson();
        File LongLoanFile = new File("src/main/java/persistence/DataBases/LongTermLoan.txt");

        try {
            Scanner scan = new Scanner(LongLoanFile);

            while (scan.hasNextLine()) {

                z.add(gson.fromJson(scan.nextLine(), LongTermLoan.class));

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        ArrayList<LongTermLoan> newSave = new ArrayList<>();

        for (LongTermLoan Loan : z) {
            for (LongTermLoan x1 : x) {
                if (!Loan.getCusID().equals(x1.getCusID())) {
                    newSave.add(Loan);
                }
            }
        }

        newSave.addAll(x);

        try (FileWriter writer = new FileWriter(LongLoanFile)) {
            for (LongTermLoan y : newSave) {
                gson.toJson(y, writer);
                writer.write("\n");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void saveShortLoan(ArrayList<ShortTermLoan> x){
        ArrayList<ShortTermLoan> z = new ArrayList<>();

        Gson gson = new Gson();
        File ShortLoanFile = new File("src/main/java/persistence/DataBases/ShortTermLoan.txt");

        try {
            Scanner scan = new Scanner(ShortLoanFile);

            while (scan.hasNextLine()) {

                z.add(gson.fromJson(scan.nextLine(), ShortTermLoan.class));

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        ArrayList<ShortTermLoan> newSave = new ArrayList<>();

        for (ShortTermLoan Loan : z) {
            for (ShortTermLoan x1 : x) {
                if (!Loan.getCusID().equals(x1.getCusID())) {
                    newSave.add(Loan);
                }
            }
        }

        newSave.addAll(x);

        try (FileWriter writer = new FileWriter(ShortLoanFile)) {
            for (ShortTermLoan y : newSave) {
                gson.toJson(y, writer);
                writer.write("\n");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void saveCC(ArrayList<CreditCard> x){
        ArrayList<CreditCard> z = new ArrayList<>();

        Gson gson = new Gson();
        File CCFile = new File("src/main/java/persistence/DataBases/CreditCard.txt");

        try {
            Scanner scan = new Scanner(CCFile);

            while (scan.hasNextLine()) {

                z.add(gson.fromJson(scan.nextLine(), CreditCard.class));

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        ArrayList<CreditCard> newSave = new ArrayList<>();

        for (CreditCard CC : z) {
            for (CreditCard x1 : x) {
                if (!CC.getCusID().equals(x1.getCusID())) {
                    newSave.add(CC);
                }
            }
        }

        newSave.addAll(x);

        try (FileWriter writer = new FileWriter(CCFile)) {
            for (CreditCard y : newSave) {
                gson.toJson(y, writer);
                writer.write("\n");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
