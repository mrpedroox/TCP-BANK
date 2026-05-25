package banks;

import accounts.AbstractAccount;
import accounts.IAccountRepo;

public class GenericBank implements IBank{
    private IAccountRepo accounts;

    public GenericBank(IAccountRepo accounts){
        this.accounts = accounts;
    }

    @Override
    public void register(AbstractAccount account) {

    }
}
