public class Senior extends Customer{

    private static final double SAVINGS_INTEREST = 0.08; //8%
    private static final double CHECK_INTEREST = 0.04; //4%
    private static final double CHECK_CHARGE = 0.01; //1 cent
    private static final double OVERDRAFT_PENALTY = 10; //$10
    private static final double SAVINGS_INTEREST_VIP = 0.1; //10%
    private static final double CHECK_INTEREST_VIP = 0.04; //4%
    private static final double CHECK_CHARGE_VIP = 0; //0 cent
    private static final double OVERDRAFT_PENALTY_VIP = 5; //$5

    private boolean vip;

    /** Creates a new instance of Senior */
    public Senior(String name, String address, int age, String telephoneNumber, boolean vip) {
        super(name, address, age, telephoneNumber);
        this.vip = vip;
    }

    public double getSavingsInterest() {
        if (vip) {
            return SAVINGS_INTEREST_VIP;
        } else {
            return SAVINGS_INTEREST;
        }
    }

    public double getCheckInterest() {
        if (vip) {
            return CHECK_INTEREST_VIP;
        } else {
            return CHECK_INTEREST;
        }
    }

    public double getCheckCharge() {
        if (vip) {
            return CHECK_CHARGE_VIP;
        } else {
            return CHECK_CHARGE;
        }
    }

    public double getOverdraftPenalty(double balance) {
        if (this.vip) {
            if (balance >= -100) {
                return 0;
            } else {
                return OVERDRAFT_PENALTY_VIP;
            }
        } else {
            return OVERDRAFT_PENALTY;
        }
    }

    public boolean isVIP() {
        return this.vip;
    }

}
