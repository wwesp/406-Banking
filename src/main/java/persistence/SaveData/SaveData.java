package persistence.SaveData;

import Accounts.BankAccounts.Money.CDs;
import Accounts.BankAccounts.Money.Checking;
import Accounts.BankAccounts.Money.Savings;
import Accounts.People.Customer;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class SaveData {

    public void saveCheckAndSave(ArrayList<Savings> x, ArrayList<Checking> y){
        saveSaving(x);
        saveChecking(y);
    }
    private void saveChecking(ArrayList<Checking> x){

    }

    private void saveSaving(ArrayList<Savings> x){

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

    public boolean saveCD(ArrayList<CDs> passedIn){

        ArrayList<CDs> z = new ArrayList<>();

        Gson gson = new Gson();
        File CDFile = new File("src/main/java/persistence/DataBases/CD.txt");

        try{
            Scanner scan= new Scanner(CDFile);

            while(scan.hasNextLine()){

                z.add(gson.fromJson(scan.nextLine(), CDs.class));

            }

        } catch (Exception ex){
            ex.printStackTrace();
        }

        ArrayList<CDs> newSave = new ArrayList<>();

        for(CDs db:z) {
            for (CDs y : passedIn) {
                if (!y.getCusID().equals(db.getCusID())) {
                    newSave.add(y);
                }
            }
        }

        newSave.addAll(passedIn);

        try(FileWriter writer = new FileWriter(CDFile)) {
            for(CDs y:newSave) {
                gson.toJson(y, writer);
                writer.write("\n");
            }

        }
        catch (Exception ex){
            ex.printStackTrace();
        }


        return false;
    }
}
