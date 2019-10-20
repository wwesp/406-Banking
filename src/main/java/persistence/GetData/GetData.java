package persistence.GetData;


import Accounts.BankAccounts.Debt.*;
import Accounts.BankAccounts.Money.CDs;
import Accounts.BankAccounts.Money.RegSavings;
import Accounts.People.*;

import java.util.ArrayList;

public class GetData {
//date fomrated at MM-dd-yyyy
    public Customer getCustomerBySSN(String SSN){
        Customer a=new Customer("423-45-3245","Ronald", "Jones", "114 North 4th", "Clarkesdale","MO", "64493","2899653222933497" );
        Customer b=new Customer("345-65-3425","Mark","Ingrem","1805 Jules","St. Joseph","MO","64503","4387917994924947");
        Customer c=new Customer("423-14-8894","Sherry","Harrison","2109 Sylviana","St. Joesph","MO","64501","7915365294629613");
        Customer d=new Customer("677-87-9013","John","Morgeson","4305 West 3rd","Wathena","KS","54910","8343891648427859");
        Customer e=new Customer("345-59-9870","Gary","Gilkerson","221 south highly","St. Joesph","MO","64503","5445687789148812");
        Customer f=new Customer("423-56-7890","Mary","Francis","335 Jules","St. Joesph","MO","64503","1592169184752658");
        Customer g=new Customer("345-81-2332","Carolyn","Johnson","1402 Mocking Bird","St. Joesph","MO","64502","2669835839645524");
        Customer h=new Customer("345-87-9912","Larry","Waite","2105 Senior DR.","St. Joesph","MO","64503","6342943423865693");
        Customer i=new Customer("423-16-8945","Marilyn","Macklin","1801 Lovers Ln","St. Joesph","MO","64502","5227566878576698");
        Customer j=new Customer("235-44-5789","Lana","McGlynn","2508 Stonecrest","St. Joesph","MO","64501","1883867798187521");
        Customer k=new Customer("436-78-9213","John","Munzer","4156 N. Mulbury","St. Joesph","MO","64502","");
        Customer l=new Customer("233-43-5656","Mary","White","1525 Kioa","Ellwood","KS","56708","");
        Customer m=new Customer("435-67-8787","Jerry","Gronius","8902 Martha Ln","Gower","MO","63301","");
        Customer n=new Customer("563-43-2913","Martin","Williams","1532 Lovers Ln","St. Joesph","MO","64502","");
        Customer o=new Customer("345-67-9898","Broderick","Jones","703 Park LN","St. Joesph","MO","64501","");

        ArrayList<Customer> x = new ArrayList<>();
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
        x.add(m);
        x.add(n);
        x.add(o);


        for (Customer y :x){
            if (y.getSsn().equals(SSN)){
                return y;
            }
        }
        return null;
    }

    public Customer getCustomerByATM(String ATMNum){
        Customer a=new Customer("423-45-3245","Ronald", "Jones", "114 North 4th", "Clarkesdale","MO", "64493","2899653222933497" );
        Customer b=new Customer("345-65-3425","Mark","Ingrem","1805 Jules","St. Joseph","MO","64503","4387917994924947");
        Customer c=new Customer("423-14-8894","Sherry","Harrison","2109 Sylviana","St. Joesph","MO","64501","7915365294629613");
        Customer d=new Customer("677-87-9013","John","Morgeson","4305 West 3rd","Wathena","KS","54910","8343891648427859");
        Customer e=new Customer("345-59-9870","Gary","Gilkerson","221 south highly","St. Joesph","MO","64503","5445687789148812");
        Customer f=new Customer("423-56-7890","Mary","Francis","335 Jules","St. Joesph","MO","64503","1592169184752658");
        Customer g=new Customer("345-81-2332","Carolyn","Johnson","1402 Mocking Bird","St. Joesph","MO","64502","2669835839645524");
        Customer h=new Customer("345-87-9912","Larry","Waite","2105 Senior DR.","St. Joesph","MO","64503","6342943423865693");
        Customer i=new Customer("423-16-8945","Marilyn","Macklin","1801 Lovers Ln","St. Joesph","MO","64502","5227566878576698");
        Customer j=new Customer("235-44-5789","Lana","McGlynn","2508 Stonecrest","St. Joesph","MO","64501","1883867798187521");
        Customer k=new Customer("436-78-9213","John","Munzer","4156 N. Mulbury","St. Joesph","MO","64502","");
        Customer l=new Customer("233-43-5656","Mary","White","1525 Kioa","Ellwood","KS","56708","");
        Customer m=new Customer("435-67-8787","Jerry","Gronius","8902 Martha Ln","Gower","MO","63301","");
        Customer n=new Customer("563-43-2913","Martin","Williams","1532 Lovers Ln","St. Joesph","MO","64502","");
        Customer o=new Customer("345-67-9898","Broderick","Jones","703 Park LN","St. Joesph","MO","64501","");

        ArrayList<Customer> x = new ArrayList<>();
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
        x.add(m);
        x.add(n);
        x.add(o);


        for (Customer y :x){
            if (y.getAtmCard().equals(ATMNum)){
                return y;
            }
        }
        return null;

    }

    public Managment getManager(String SSN){
        Managment a= new Managment("000-00-0000","Boss","Baby");
        ArrayList<Managment> x= new ArrayList<>();
        x.add(a);

        for (Managment y :x){
            if (y.getSsn().equals(SSN)){
                return y;
            }
        }
        return null;

    }

    public Teller getTeller(String SSN){
        Teller a= new Teller("111-11-1111","Teller1","Yeet");
        ArrayList<Teller> x= new ArrayList<>();
        x.add(a);

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
        return returnable;
    }









}
