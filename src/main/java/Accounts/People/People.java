package Accounts.People;



abstract public class People {
    String ssn;
    String fName;
    String lName;



    public People(String ssn, String fName, String lName){
        this.ssn = ssn;
        this.fName = fName;
        this.lName = lName;
    }

    public String getSsn() {
        return ssn;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }



}
