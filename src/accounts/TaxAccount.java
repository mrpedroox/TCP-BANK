package accounts;

public class TaxAccount extends AbstractAccount{
    public TaxAccount(String id){
        super(id);
    }

    @Override
    public void debit(double value) {
        balance -= value + (value*0.001);
    }

}
