package accounts;

public class Account extends AbstractAccount {
    public Account(String id){
        super(id);
    }

    public void debit(double value){
        balance -= value;
    }
}
