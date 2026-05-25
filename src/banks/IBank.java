package banks;

import accounts.AbstractAccount;
import exceptions.AIException;
import exceptions.BIException;

public interface IBank {
    public double totalBalance();
    public int totalAccounts();
    public void register(AbstractAccount account);
    public AbstractAccount find(String id);
    public void credit(String id, double value) throws AIException;
    public void debit(String id, double value) throws AIException, BIException;
    public double balance(String id) throws AIException;
    public void transfer(String origin, String destiny, double value) throws AIException, BIException;
    public void runBonus(String id) throws AIException;
    public void runFees(String id) throws AIException;
}
