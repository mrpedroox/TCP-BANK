package exceptions;

public class BIException extends Exception{
    private double balance;
    private String id;

    public BIException(String id, double balance){
        super("Insufficient Balance");
        this.id = id;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public String getId() {
        return id;
    }
}
