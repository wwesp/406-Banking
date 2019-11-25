package persistence.SaveData;

import Accounts.BankAccounts.Debt.CreditCard;
import Accounts.BankAccounts.Debt.LongTermLoan;
import Accounts.BankAccounts.Debt.ShortTermLoan;
import Accounts.BankAccounts.Money.CDs;
import Accounts.BankAccounts.Money.Checking;
import Accounts.BankAccounts.Money.RegSavings;
import Accounts.Interest;
import Accounts.People.Customer;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class SaveData {

    public void saveCheckAndSave(ArrayList<RegSavings> x, ArrayList<Checking> y){
        saveSaving(x);
        saveChecking(y);
    }

    public void saveChecking(ArrayList<Checking> x){
        if(x==null)return;
        for(Iterator<Checking> n = x.iterator(); n.hasNext();) {
            Checking acc = n.next();

            for(Checking account:x){
                if(acc == null){
                    n.remove();
                }
            }
        }


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


        newSave.addAll(z);

        for(Iterator<Checking> i = newSave.iterator(); i.hasNext();) {
            Checking acc = i.next();
            //Do Something

            for(Checking account:x){
                if(acc.getID().equals(account.getID())){
                    i.remove();
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
        if(x==null)return;

        for(Iterator<RegSavings> n = x.iterator(); n.hasNext();) {
            RegSavings acc = n.next();

            for(RegSavings account:x){
                if(acc == null){
                    n.remove();
                }
            }
        }

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

        newSave.addAll(z);
        for(Iterator<RegSavings> i = newSave.iterator(); i.hasNext();) {
            RegSavings acc = i.next();
            //Do Something

            for(RegSavings account:x){

                if(acc.getID().equals(account.getID())){
                    i.remove();
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
        if(x==null)return;
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
        if(x==null)return;
        for(Iterator<CDs> n = x.iterator(); n.hasNext();) {
            CDs acc = n.next();

            for(CDs account:x){
                if(acc == null){
                    n.remove();
                }
            }
        }

        ArrayList<CDs> z = new ArrayList<>();

        Gson gson = new Gson();
        File CDsFile = new File("src/main/java/persistence/DataBases/CD.txt");

        try {
            Scanner scan = new Scanner(CDsFile);

            while (scan.hasNextLine()) {

                z.add(gson.fromJson(scan.nextLine(), CDs.class));

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        ArrayList<CDs> newSave = new ArrayList<>();

        newSave.addAll(z);
        for(Iterator<CDs> i = newSave.iterator(); i.hasNext();) {
            CDs acc = i.next();
            //Do Something

            for(CDs account:x){
                if(acc.getID().equals(account.getID())){
                    i.remove();
                }
            }
        }

        newSave.addAll(x);

        try(FileWriter writer = new FileWriter(CDsFile)) {
            for(CDs y:newSave) {
                gson.toJson(y, writer);
                writer.write("\n");
            }

        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void saveLongLoan(ArrayList<LongTermLoan> x){
        if(x==null)return;
        for(Iterator<LongTermLoan> n = x.iterator(); n.hasNext();) {
            LongTermLoan acc = n.next();

            for(LongTermLoan account:x){
                if(acc == null){
                    n.remove();
                }
            }
        }

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

        newSave.addAll(z);
        for(Iterator<LongTermLoan> i = newSave.iterator(); i.hasNext();) {
            LongTermLoan acc = i.next();
            //Do Something

            for(LongTermLoan account:x){
                if(acc.getID().equals(account.getID())){
                    i.remove();
                }
            }
        }

        newSave.addAll(x);

        try(FileWriter writer = new FileWriter(LongLoanFile)) {
            for(LongTermLoan y:newSave) {
                gson.toJson(y, writer);
                writer.write("\n");
            }

        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void saveShortLoan(ArrayList<ShortTermLoan> x){
        if(x==null)return;
        for(Iterator<ShortTermLoan> n = x.iterator(); n.hasNext();) {
            ShortTermLoan acc = n.next();

            for(ShortTermLoan account:x){
                if(acc == null){
                    n.remove();
                }
            }
        }

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

        newSave.addAll(z);
        for(Iterator<ShortTermLoan> i = newSave.iterator(); i.hasNext();) {
            ShortTermLoan acc = i.next();
            //Do Something

            for(ShortTermLoan account:x){
                if(acc.getID().equals(account.getID())){
                    i.remove();
                }
            }
        }

        newSave.addAll(x);

        try(FileWriter writer = new FileWriter(ShortLoanFile)) {
            for(ShortTermLoan y:newSave) {
                gson.toJson(y, writer);
                writer.write("\n");
            }

        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void saveCC(ArrayList<CreditCard> x){
        if(x==null)return;
        for(Iterator<CreditCard> n = x.iterator(); n.hasNext();) {
            CreditCard acc = n.next();

            for(CreditCard account:x){
                if(acc == null){
                    n.remove();
                }
            }
        }

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

        newSave.addAll(z);
        for(Iterator<CreditCard> i = newSave.iterator(); i.hasNext();) {
            CreditCard acc = i.next();
            //Do Something

            for(CreditCard account:x){
                if(acc.getID().equals(account.getID())){
                    i.remove();
                }
            }
        }

        newSave.addAll(x);

        try(FileWriter writer = new FileWriter(CCFile)) {
            for(CreditCard y:newSave) {
                gson.toJson(y, writer);
                writer.write("\n");
            }

        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void saveInterest(Interest x){
        if(x==null)return;
        Gson gson = new Gson();
        File intFile = new File("src/main/java/persistence/DataBases/interest.txt");

        try (FileWriter writer = new FileWriter(intFile)) {

            gson.toJson(x, writer);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
