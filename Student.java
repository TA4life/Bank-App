public class Student extends Customer{

    private static final double SAVINGS_INTEREST = 0.07; //7%
    private static final double CHECK_INTEREST = 0.03; //3%
    private static final double CHECK_CHARGE = 0.02; //2 cents
    private static final double OVERDRAFT_PENALTY = 0; //$0

    /** Creates a new instance of Student */
    public Student(String name, String address, int age, String telephoneNumber) {
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
        return 0;
    }

}
