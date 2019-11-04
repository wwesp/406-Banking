package persistence.DataBomb;

import Accounts.People.Customer;
import Accounts.People.Managment;
import Accounts.People.Teller;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;

public class DataBomb {

    public void CustBomb(){
        File CustFile = new File("src/main/java/persistence/DataBases/Customers.txt");
        Gson gson = new GsonBuilder().create();

        Customer a=new Customer("423-45-3245","Ronald", "Jones", "114 North 4th", "Clarkesdale","MO", "64493","2899653222933497");
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


        try(FileWriter writer = new FileWriter(CustFile)) {
            gson.toJson(a, writer);
            writer.write("\n");
            gson.toJson(b, writer);
            writer.write("\n");
            gson.toJson(c, writer);
            writer.write("\n");
            gson.toJson(d, writer);
            writer.write("\n");
            gson.toJson(e, writer);
            writer.write("\n");
            gson.toJson(f, writer);
            writer.write("\n");
            gson.toJson(g, writer);
            writer.write("\n");
            gson.toJson(h, writer);
            writer.write("\n");
            gson.toJson(i, writer);
            writer.write("\n");
            gson.toJson(j, writer);
            writer.write("\n");
            gson.toJson(k, writer);
            writer.write("\n");
            gson.toJson(l, writer);
            writer.write("\n");
            gson.toJson(m, writer);
            writer.write("\n");
            gson.toJson(n, writer);
            writer.write("\n");
            gson.toJson(o, writer);

        }
        catch (Exception x){
            x.printStackTrace();
        }
    }

    public void ManagBomb(){
        File ManagFile = new File("src/main/java/persistence/DataBases/Managment.txt");
        Gson gson = new GsonBuilder().create();

        Managment a= new Managment("000-00-0000","Boss","Baby");

        try(FileWriter writer = new FileWriter(ManagFile)) {
            gson.toJson(a, writer);
            writer.write("\n");

        }
        catch (Exception x){
            x.printStackTrace();
        }
    }

    public void TellerBomb(){
        File TellerFile = new File("src/main/java/persistence/DataBases/Teller.txt");
        Gson gson = new GsonBuilder().create();

        Teller a= new Teller("111-11-1111","Teller1","Yeet");

        try(FileWriter writer = new FileWriter(TellerFile)) {
            gson.toJson(a, writer);
            writer.write("\n");

        }
        catch (Exception x){
            x.printStackTrace();
        }
    }
/*
    public void CDBomb(){
        File CDFile = new File("src/main/java/persistence/DataBases/CD.txt");
        Gson gson = new GsonBuilder().create();

        CDs a= new CDs("11","235-44-5789",1500,"10-19-2019","10/19/2023",0.03,"");
        CDs b = new CDs("12","423-16-8945",1200, "12-14-2016", "12-14-2019",0.03,"");
        CDs c= new CDs("13","345-599-870", 8000,"02-28-2017","02-28-2017",0.03,"");
        CDs d= new CDs("14","345-65-3425", 4000,"02-19-2017","02-19-2020",0.03,"");

        try(FileWriter writer = new FileWriter(CDFile)) {
            gson.toJson(a, writer);
            writer.write("\n");
            gson.toJson(b, writer);
            writer.write("\n");
            gson.toJson(c, writer);
            writer.write("\n");
            gson.toJson(d, writer);
            writer.write("\n");

        }
        catch (Exception x){
            x.printStackTrace();
        }
    }
*/
}
