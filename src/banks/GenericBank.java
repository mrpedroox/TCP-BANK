package banks;

import accounts.AbstractAccount;
import accounts.EspecialAccount;
import accounts.IAccountRepo;
import accounts.SavingsAccount;
import exceptions.AIException;
import exceptions.BIException;

public class GenericBank implements IBank{
    private IAccountRepo accounts;
    private double fee;

    public GenericBank(IAccountRepo accounts){
        this.accounts = accounts;
    }

    @Override
    public void register(AbstractAccount account) {
        accounts.insert(account);
    }

    @Override
    public AbstractAccount find(String id){
        return accounts.search(id);
    }

    @Override
    public int totalAccounts(){
        return accounts.sizee();
    }

    @Override
    public double totalBalance(){
        AbstractAccount[] array = accounts.listt();
        double t = 0;
        for(int i = 0; i < accounts.sizee(); i++){
            t += array[i].getBalance();
        }
        return t;
    }

    @Override
    public void credit(String id, double value) throws AIException{
        AbstractAccount a = accounts.search(id);
        if(a == null) throw new AIException(id);
        a.credit(value);
    }

    @Override
    public void debit(String id, double value) throws AIException, BIException {
        AbstractAccount a = accounts.search(id);
        if(a == null) throw new AIException(id);
        if(a.getBalance() < value) throw new BIException(id, a.getBalance());
        a.debit(value);
    }

    @Override
    public double balance(String id) throws AIException{
        AbstractAccount a = accounts.search(id);
        if(a==null) throw new AIException(id);
        return a.getBalance();
    }

    @Override
    public void transfer(String origin, String destiny, double value) throws AIException, BIException{
        AbstractAccount org = accounts.search(origin);
        if(org == null) throw new AIException(origin);
        AbstractAccount des = accounts.search(destiny);
        if(des == null) throw new AIException(destiny);
        if(org.getBalance()<value) throw new BIException(origin, org.getBalance());
        org.debit(value);
        des.credit(value);
    }

    @Override
    public void runBonus(String id) throws AIException{
        AbstractAccount a = accounts.search(id);
        if(a == null) throw new AIException(id);
        if(a instanceof EspecialAccount){
            ((EspecialAccount) a).runBonus();
        }
    }

    @Override
    public void runFees(String id) throws AIException{
        AbstractAccount a = accounts.search(id);
        if(a==null) throw new AIException(id);
        if(a instanceof SavingsAccount){
            ((SavingsAccount) a).fees(fee);
        }
    }

}
