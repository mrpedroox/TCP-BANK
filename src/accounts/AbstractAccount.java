package accounts;

public abstract class AbstractAccount {
    protected String id;
    protected double balance;

    public AbstractAccount(String id){
        this.id = id;
        balance = 0;
    }

    public void credit(double value){
        balance += value;
    }

    public abstract void debit(double value);

    public String getId(){
        return id;
    }

    public double getBalance(){
        return balance;
    }
}
