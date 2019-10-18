package Accounts.People;

public class Customer extends People {
    String address;
    String city;
    String state;
    String zip;
    int atmCard;
    String[] history;

    public Customer(String ssn,String fName, String lName,String address,String city,String state,String zip,int atmCard,String[] history){
        super(ssn,fName,lName);
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.atmCard = atmCard;
        this.history = history;
    }

    /*
    make withdrawals/deposits thought atm cards, paper deposits, or credit cards
     */

}
