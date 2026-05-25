package accounts;
import banks.IBank;

public class GenericBankAuditor {
    public void audit(IBank bank){
        if((bank.totalBalance()/ bank.totalAccounts()) > 500){
            System.out.println("Approved");
        }else{
            System.out.println("Not Approved");
        }
    }
}
