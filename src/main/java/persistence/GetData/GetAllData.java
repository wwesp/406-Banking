package persistence.GetData;

import Accounts.BankAccounts.Debt.CreditCard;
import Accounts.BankAccounts.Debt.LongTermLoan;
import Accounts.BankAccounts.Debt.ShortTermLoan;
import Accounts.BankAccounts.Money.CDs;
import Accounts.BankAccounts.Money.Checking;
import Accounts.BankAccounts.Money.RegSavings;
import Accounts.Interest;
import Accounts.People.Customer;
import Accounts.People.Managment;
import Accounts.People.Teller;
import com.google.gson.Gson;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class GetAllData {





    public ArrayList<RegSavings> getRegSavings(){
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


        return x;

    }

    public ArrayList<CDs> getAllCDs(){

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



        return x;

    }


    public ArrayList<CreditCard> getCC(){
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

        return x;

    }

    public ArrayList<ShortTermLoan> getShortLoan(){
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


        return x;

    }

    public ArrayList<LongTermLoan> getLongLoan(){
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



        return x;

    }

    public ArrayList<Checking> getChecking(){
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


        return x;

    }





}
