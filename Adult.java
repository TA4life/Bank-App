public class Adult extends Customer{

    private static final double SAVINGS_INTEREST = 0.03; //3%
    private static final double CHECK_INTEREST = 0.01; //1%
    private static final double CHECK_CHARGE = 0.03; //3 cents
    private static final double OVERDRAFT_PENALTY = 25; //$25

    /** Creates a new instance of Adult */
    public Adult(String name, String address, int age, String telephoneNumber) {
        super(name, address, age, telephoneNumber);
    }

    public double getSavingsInterest(){
        return this.SAVINGS_INTEREST;
    }

    public double getCheckInterest(){
        return this.CHECK_INTEREST;
    }

    public double getCheckCharge(){
        return this.CHECK_CHARGE;
    }

    public double getOverdraftPenalty(double balance) {
        return OVERDRAFT_PENALTY;
    }

}
