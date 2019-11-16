package Accounts;

public class Interest {
    private double CheckingInterestRate;
    private double RegSavingsInterestRate;
    private double CDInterest;
    private double LoansInterest;
    private double CreditCardInterest;
    public Interest(double CheckingInterestRate, double RegSavingsInterestRate, double CDInterest, double LoansInterest, double CreditCardInterest){
        this.CheckingInterestRate=CheckingInterestRate;
        this.RegSavingsInterestRate=RegSavingsInterestRate;
        this.CDInterest=CDInterest;
        this.LoansInterest=LoansInterest;
        this.CreditCardInterest=CreditCardInterest;
    }


    public double getCheckingInterestRate() {
        return CheckingInterestRate;
    }

    public void setCheckingInterestRate(double checkingInterestRate) {
        CheckingInterestRate = checkingInterestRate;
    }

    public double getRegSavingsInterestRate() {
        return RegSavingsInterestRate;
    }

    public void setRegSavingsInterestRate(double regSavingsInterestRate) {
        RegSavingsInterestRate = regSavingsInterestRate;
    }

    public double getCDInterest() {
        return CDInterest;
    }

    public void setCDInterest(double CDInterest) {
        this.CDInterest = CDInterest;
    }

    public double getLoansInterest() {
        return LoansInterest;
    }

    public void setLoansInterest(double loansInterest) {
        LoansInterest = loansInterest;
    }

    public double getCreditCardInterest() {
        return CreditCardInterest;
    }

    public void setCreditCardInterest(double creditCardInterest) {
        CreditCardInterest = creditCardInterest;
    }
}
