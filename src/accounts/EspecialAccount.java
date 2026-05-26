package accounts;

public class EspecialAccount extends Account{
    private double bonus;
    public EspecialAccount(String id){
        super(id);
    }

    public double getBonus(){
        return bonus;
    }

    public void setBonus(double bonus){
        this.bonus = bonus;
    }
    public void runBonus(){
        super.credit(bonus);
        bonus = 0;
    }

    @Override
    public void credit(double value){
        bonus += value*0.01;
        super.credit(value);
    }
}
