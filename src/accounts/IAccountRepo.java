package accounts;

public interface IAccountRepo {
    public void insert(AbstractAccount account);
    public void remove(String id);
    public AbstractAccount search(String id);
    public AbstractAccount[] listt();
    public int sizee();
}
