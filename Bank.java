public class Bank {

    private Account[] accounts;
    private int size;
    private int capacity;

    private static final int SAVINGS = 0;
    private static final int CHECKING = 1;
    private static final int SENIOR = 0;
    private static final int ADULT = 1;
    private static final int STUDENT = 2;
    private static final int INIT_CAPACITY = 100;

    /** Creates a new instance of Bank */
    public Bank() {
        accounts = new Account[INIT_CAPACITY];
        capacity = INIT_CAPACITY;
    }

    /********************************************************************
     * Creates a new account.
     * pre: customer information must be not null and types must be valid
     * post: New account added to bank
     * @param customerName String Account owner's name
     * @param customerAddress String Owner's address
     * @param customerAge int Owner's age (in years)
     * @param customerPhoneNumber String Owner's phone number
     * @param customerType int Owner's type of customer within bank
     *  * @param typeAccount int Account type (savings or checking)
     * @return String New account number
     */
    public String addAccount(String customerName, String customerAddress,
                            int customerAge, String customerPhoneNumber,
                            int customerType, int typeAccount, boolean vip){
        String accountNumber;
        Customer customer;
        if (customerType == SENIOR){
            customer = new Senior(customerName, customerAddress, customerAge, customerPhoneNumber, vip);
        }else if (customerType == ADULT){
            customer = new Adult(customerName, customerAddress, customerAge, customerPhoneNumber);
        }else{
            customer = new Student(customerName, customerAddress, customerAge, customerPhoneNumber);
        }
        if (size == capacity)
            reallocate();
        if (typeAccount == SAVINGS){
            accounts[size] = new SavingsAccount(customer);
        }else{
            accounts[size] = new CheckingAccount(customer);
        }
        accountNumber = accounts[size].getNumber();
        size++;
        return accountNumber;
    }

    /***********************************************************************
     * Make a deposit into account.
     * pre: amount must be a positive integer
     * post: Account's balance increases
     * @param accountNumber String Account's number
     * @param amount double Amount to deposit
     * @return double New balance
     */
    public String makeDeposit(String accountNumber, double amount){
        int index = find(accountNumber);
        if (index > -1) {
            accounts[index].deposit(amount);
            return Double.toString(accounts[index].getBalance());
        } else {
            return null;
        }
    }

    /***********************************************************************
     * Make a withdrawal from account.
     * pre: amount must be a positive integer
     * post: Account's balance decreases
     * @param accountNumber String Account's number
     * @param amount double Amount to withdraw
     * @return double New balance
     */
    public String makeWithdrawal(String accountNumber, double amount){
        int index = find(accountNumber);
        if (index > -1) {
            accounts[index].withdraw(amount);
            return Double.toString(accounts[index].getBalance());
        } else {
            return null;
        }
    }

    /***********************************************************************
     * Add interest to an account.
     * post: Account's balance increases
     * @param accountNumber String Account's number
     * @return double New balance
     */
    public String addInterest(String accountNumber) {
        int index = find(accountNumber);
        if (index > -1) {
            this.accounts[index].addInterest();
            return Double.toString(this.accounts[index].getBalance());
        } else {
            return null;
        }
    }

    /***********************************************************************
     * Returns account information as a string so it can be displayed
     * @param accountNumber String Account's number
     * @return String Account information as a String object
     */
    public String getAccount(String accountNumber){
        int index = find(accountNumber);
        if (index > -1) {
            return accounts[index].toString();
        } else {
            return null;
        }
    }

    /***********************************************************************
     * Given an account number tells if the account exists or not
     * @param accountNumber String Account's number
     * @return int TRUE if accountNumber exists in accounts[]. Otherwise, -1.
     */
    private int find(String accountNumber){
        for (int i = 0; i < this.size; i++){
            if (accounts[i].getNumber().equals(accountNumber)){
                return i;
            }
        }
        return (-1);
    }

    /** Allocate a new array to hold the transactions. */
    private void reallocate() {
        capacity *= 2;
        Account[] newAccounts = new Account[capacity];
        System.arraycopy(accounts, 0, newAccounts, 0, accounts.length);
        accounts = newAccounts;
    }

}
