package banks;

import accounts.AbstractAccount;

public interface IBank {
    public double totalBalance();
    public int totalAccounts();
    public void register(AbstractAccount account);
    public AbstractAccount find(String id);
    public void credit(String id, double value);
    public void debit(String id, double value);
    public double balance(String id);
    public void transfer(String origin, String destiny, double value);
    public void runBonus(String id);
    public void runFees(String id);
}
