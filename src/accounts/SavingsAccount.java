package accounts;

public class SavingsAccount extends Account{
    public SavingsAccount(String id){
        super(id);
    }
    public void fees(double fee){
        credit(getBalance()*fee);
    }
}
