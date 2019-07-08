public class SavingsAccount extends Account{

    /** Creates a new instance of SavingsAccount */
    public SavingsAccount(Customer customer) {
        super(customer);
    }

    /***********************************************
     * Adds amount to balance
     * pre: amount must be a positive value
     * post: balance increases in amount value
     * @param amount double Deposit amount
     */
    public void deposit(double amount) {
        this.balance += amount;
        this.addTransaction(new Transaction((byte) 0, amount, 0, "A deposit"));
    }

    /***********************************************
     * Substracts amount from balance
     * pre: amount must be a positive value
     * post: balance decreases in amount value
     * @param amount double Withdrawal amount
     */
    public void withdraw(double amount) {
        double fees = 0;
        if (this.customer instanceof Student) {
            if (this.balance - amount < 0) {
                return;
            } else {
                this.balance -= amount;
            }
        } else {
            if (this.balance - amount < -500) {
                return;
            } else {
                this.balance -= amount;
                if (this.balance < 0) {
                    this.balance -= this.customer.getOverdraftPenalty(this.balance);
                    fees += this.customer.getOverdraftPenalty(this.balance);
                }
            }
        }

        this.addTransaction(new Transaction((byte) 1, amount, fees, "A withdraw"));
    }

    /***********************************************
     * Adds amount to balance
     * pre: amount must be a positive value
     * post: balance increases in amount value
     * @param amount double Interes amount
     */

    public void addInterest() {
        double amount = this.balance * this.customer.getSavingsInterest();
        this.balance += amount;

        this.addTransaction(new Transaction((byte) 2, amount, 0, "An interest adding"));
    }

}
