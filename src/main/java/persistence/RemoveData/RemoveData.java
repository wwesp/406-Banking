package persistence.RemoveData;

import Accounts.BankAccounts.Debt.CreditCard;
import Accounts.BankAccounts.Debt.LongTermLoan;
import Accounts.BankAccounts.Debt.ShortTermLoan;
import Accounts.BankAccounts.Money.CDs;
import Accounts.BankAccounts.Money.Checking;
import Accounts.BankAccounts.Money.RegSavings;
import Accounts.Interest;
import Accounts.People.Customer;
import com.google.gson.Gson;
import persistence.SaveData.SaveData;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class RemoveData {


    public void rmCheckAndSave(ArrayList<RegSavings> x, ArrayList<Checking> y,String Id){
        rmSaving(x,Id);
        rmChecking(y);
    }

    public void rmChecking(ArrayList<Checking> x){

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

    public void rmSaving(ArrayList<RegSavings> x, String Id) {

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



        try(FileWriter writer = new FileWriter(SavingsFile)) {
            for(RegSavings y:newSave) {
                gson.toJson(y, writer);
                writer.write("\n");
            }

        }
        catch (Exception ex){
            ex.printStackTrace();
        }




        ArrayList<Checking> allChecking = new ArrayList<>();
        Gson gson2 = new Gson();
        File CheckingFile = new File("src/main/java/persistence/DataBases/Checking.txt");

        try{
            Scanner scan= new Scanner(CheckingFile);

            while(scan.hasNextLine()){

                allChecking.add(gson2.fromJson(scan.nextLine(), Checking.class));

            }

        } catch (Exception ex){
            ex.printStackTrace();
        }

        for(Checking f: allChecking){

            if(f.getBackupAcc().equals(Id)){
                f.setBackupAcc("");
            }

        }
        SaveData saveData = new SaveData();
        saveData.saveChecking(allChecking);








    }

    public void rmCustomer(Customer x){

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

    public void rmCD(ArrayList<CDs> x) {

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

    public void rmLongLoan(ArrayList<LongTermLoan> x){

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

    public void rmShortLoan(ArrayList<ShortTermLoan> x){

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

    public void rmCC(ArrayList<CreditCard> x){

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






}
