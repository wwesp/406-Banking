package persistence.GetData;


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

        for (Customer y :x){
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
        CDs a= new CDs("11","235-44-5789",1500,"10-19-2019","10/19/2023",0.03,"");
        CDs b = new CDs("12","423-16-8945",1200, "12-14-2016", "12-14-2019",0.03,"");
        CDs c= new CDs("13","345-599-870", 8000,"02-28-2017","02-28-2017",0.03,"");
        CDs d= new CDs("14","345-65-3425", 4000,"02-19-2017","02-19-2020",0.03,"");

        ArrayList<CDs> x= new ArrayList<>();
        x.add(a);
        x.add(b);
        x.add(c);
        x.add(d);

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
        RegSavings a= new RegSavings("1","423-45-3245", 200,"12-01-2002",0.022,"");
        RegSavings b= new RegSavings("2","345-65-3425", 100,"02-18-2004",0.023,"");
        RegSavings c= new RegSavings("3","423-14-8894",875.54,"09-15-1998",0.028,"" );
        RegSavings d= new RegSavings("4","677-87-9013",1200.82,"07-08-2008",0.021,"");
        RegSavings e= new RegSavings("5","345-59-9870",1500,"07-26-2017",0.021,"");
        RegSavings f= new RegSavings("6","423-56-7890",1898.07,"01-12-2001",0.021,"");
        RegSavings g= new RegSavings("7","345-81-2332",5000.99,"06-30-2003",0.02,"");
        RegSavings h= new RegSavings("8","345-87-9912",125.54,"12-08-2002",0.029,"");
        RegSavings i= new RegSavings("9","423-16-8945",198.56,"11-1-2011",0.028,"");
        RegSavings j= new RegSavings("10","235-44-5789",98.56,"12-01-2002",0.029,"");
        RegSavings k= new RegSavings("15","345-67-9898",1700,"08-19-2019",0.024,"");

        ArrayList<RegSavings> x= new ArrayList<>();
        x.add(a);
        x.add(b);
        x.add(c);
        x.add(d);
        x.add(e);
        x.add(f);
        x.add(g);
        x.add(h);
        x.add(i);
        x.add(j);
        x.add(k);

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
        Checking a= new Checking("4","423-45-3245",6.23,"12-01-2002",0,"1","2899653222933490",null,null,null,null,null,null);
        Checking b= new Checking("7","345-65-3425",52.9,"01-28-2003",0,"2","4387917994924947",null,null,null,null,null,null);
        Checking c= new Checking("2","423-14-8894",2200.11,"11-05-2000",1,"3","7915365294629613",null,null,null,null,null,null);
        Checking d= new Checking("8","677-87-9013",1378.2,"07-08-2008",1,"4","8343891648427859",null,null,null,null,null,null);
        Checking e= new Checking("12","345-59-9870",522.89,"07-26-2017",0,"5","5445687789148812",null,null,null,null,null,null);
        Checking f= new Checking("10","423-56-7890",1896.44,"09-12-2011",1,"6","1592169184752658",null,null,null,null,null,null);
        Checking g= new Checking("3","345-81-2332",7955,"02-20-2001",1,"7","2669835839645524",null,null,null,null,null,null);
        Checking h= new Checking("5","345-87-9912",85.12,"12-08-2002",0,"8","6342943423865693",null,null,null,null,null,null);
        Checking i= new Checking("11","423-16-8945",133.7,"11-13-2011",0,"9","5227566878576698",null,null,null,null,null,null);
        Checking j= new Checking("6","235-44-5789",12.42,"12-26-2002",0,"10","1883867798187521",null,null,null,null,null,null);
        Checking k= new Checking("9","235-44-5789",8779.55,"12-29-2010",0,"","",null,null,null,null,null,null);
        Checking l= new Checking("1","423-16-8945",1056.88,"06-01-1998",1,"","",null,null,null,null,null,null);
        Checking o= new Checking("13","345-67-9898",3299.33,"08-19-2019",1,"","",null,null,null,null,null,null);

        x.add(a);
        x.add(b);
        x.add(c);
        x.add(d);
        x.add(e);
        x.add(f);
        x.add(g);
        x.add(h);
        x.add(i);
        x.add(j);
        x.add(k);
        x.add(l);
        x.add(o);


        ArrayList<Checking> returnable= new ArrayList<>();
        for (Checking y :x){
            if (y.getCusID().equals(CustomerSSN)){
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


        Checking a= new Checking("4","423-45-3245",6.23,"12-01-2002",0,"1","2899653222933497",null,null,null,null,null,null);
        Checking b= new Checking("7","345-65-3425",52.9,"01-28-2003",0,"2","4387917994924947",null,null,null,null,null,null);
        Checking c= new Checking("2","423-14-8894",2200.11,"11-05-2000",1,"3","7915365294629613",null,null,null,null,null,null);
        Checking d= new Checking("8","677-87-9013",1378.2,"07-08-2008",1,"4","8343891648427859",null,null,null,null,null,null);
        Checking e= new Checking("12","345-59-9870",522.89,"07-26-2017",0,"5","5445687789148812",null,null,null,null,null,null);
        Checking f= new Checking("10","423-56-7890",1896.44,"09-12-2011",1,"6","1592169184752658",null,null,null,null,null,null);
        Checking g= new Checking("3","345-81-2332",7955,"02-20-2001",1,"7","2669835839645524",null,null,null,null,null,null);
        Checking h= new Checking("5","345-87-9912",85.12,"12-08-2002",0,"8","6342943423865693",null,null,null,null,null,null);
        Checking i= new Checking("11","423-16-8945",133.7,"11-13-2011",0,"9","5227566878576698",null,null,null,null,null,null);
        Checking j= new Checking("6","235-44-5789",12.42,"12-26-2002",0,"10","1883867798187521",null,null,null,null,null,null);
        Checking k= new Checking("9","235-44-5789",8779.55,"12-29-2010",0,"","",null,null,null,null,null,null);
        Checking l= new Checking("1","423-16-8945",1056.88,"06-01-1998",1,"","",null,null,null,null,null,null);
        Checking o= new Checking("13","345-67-9898",3299.33,"08-19-2019",1,"","",null,null,null,null,null,null);

        x.add(a);
        x.add(b);
        x.add(c);
        x.add(d);
        x.add(e);
        x.add(f);
        x.add(g);
        x.add(h);
        x.add(i);
        x.add(j);
        x.add(k);
        x.add(l);
        x.add(o);


        ArrayList<Checking> returnable= new ArrayList<>();
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













}
