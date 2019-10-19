package Accounts.People;

public class Customer extends People {
    String address;
    String city;
    String state;
    String zip;
    //atm card is just a auth string for a person
    String atmCard;


    public Customer(String ssn,String fName, String lName,String address,String city,String state,String zip,String atmCard){
        super(ssn,fName,lName);
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.atmCard = atmCard;
    }

    /*
    make withdrawals/deposits thought atm cards, paper deposits, or credit cards
     */

}
