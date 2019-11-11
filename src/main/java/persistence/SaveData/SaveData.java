package persistence.SaveData;

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

        for (int i = 0; i < z.size(); i++) {
            for (int j = 0; j < x.size(); j++) {
                if (!z.get(i).getCusID().equals(x.get(j).getCusID())) {
                    Checking y = z.get(i);
                    newSave.add(y);
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

        for (int i = 0; i < z.size(); i++) {
            for (int j = 0; j < x.size(); j++) {
                if (!z.get(i).getCusID().equals(x.get(j).getCusID())) {
                    RegSavings y = z.get(i);
                    newSave.add(y);
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

    public boolean saveCustomer(Customer x){

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

        return false;
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

        for (int i = 0; i < z.size(); i++) {
            for (int j = 0; j < x.size(); j++) {
                if (!z.get(i).getCusID().equals(x.get(j).getCusID())) {
                    CDs y = z.get(i);
                    newSave.add(y);
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
}
