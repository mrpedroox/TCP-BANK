package banks;

import accounts.AbstractAccount;
import accounts.EspecialAccount;
import accounts.IAccountRepo;
import accounts.SavingsAccount;

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
    public void credit(String id, double value){
        AbstractAccount a = accounts.search(id);
        if(a != null){
            a.credit(value);
        }
    }

    @Override
    public void debit(String id, double value){
        AbstractAccount a = accounts.search(id);
        if(a!=null){
            a.debit(value);
        }
    }

    @Override
    public double balance(String id){
        AbstractAccount a = accounts.search(id);
        return a.getBalance();
    }

    @Override
    public void transfer(String origin, String destiny, double value){
        AbstractAccount org = accounts.search(origin);
        AbstractAccount des = accounts.search(destiny);
        if(org!=null && des!=null){
            org.debit(value);
            des.credit(value);
        }
    }

    @Override
    public void runBonus(String id){
        AbstractAccount a = accounts.search(id);
        if(a instanceof EspecialAccount){
            ((EspecialAccount) a).runBonus();
        }
    }

    @Override
    public void runFees(String id){
        AbstractAccount a = accounts.search(id);
        if(a instanceof SavingsAccount){
            ((SavingsAccount) a).fees(fee);
        }
    }

}
