package accounts;

import java.util.Vector;

public class VectorAccount implements IAccountRepo{
    private Vector<AbstractAccount> accounts;

    public VectorAccount(){
        accounts = new Vector<AbstractAccount>();
    }

    @Override
    public void insert(AbstractAccount account) {
        accounts.add(account);
    }

    @Override
    public void remove(String id) {
        AbstractAccount a = search(id);
        if(a != null){
            accounts.remove(a);
        }
    }

    @Override
    public AbstractAccount search(String id) {
        for (AbstractAccount account : accounts) {
            if (account.getId().equals(id)) {
                return account;
            }
        }
        return null;
    }

    @Override
    public AbstractAccount[] listt() {
        AbstractAccount[] array = new AbstractAccount[accounts.size()];
        for(int i = 0; i < accounts.size(); i++){
            array[i] = accounts.get(i);
        }
        return array;
    }

    @Override
    public int sizee() {
        return accounts.size();
    }
}
