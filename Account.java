import java.util.*;

abstract class Account {

    protected static int lastAccountNumber = 9999;
    protected static final int INITSIZE = 25;

    protected Customer customer;
    protected double balance;
    protected String accountNumber;
    protected Transaction[] transactions;
    protected int capacity;
    protected int tranIndex;

    /** Creates a new instance of Account */
    public Account(Customer customer) {
        this.accountNumber = Integer.toString(++lastAccountNumber);
        this.capacity = INITSIZE;
        this.tranIndex = 0;
        this.transactions = new Transaction[capacity];
        this.balance = 0;
        this.customer = customer;
    }

    /*******************************************
     * Returns account balance
     * @return double Account balance
     */
    public double getBalance(){
        return this.balance;
    }

    /*******************************************
     * Returns account owner
     * @return Customer Account owner
     */

    public Customer getCustomer(){
        return this.customer;
    }

    /*******************************************
     * Returns account number
     * @return String Account number
     */
    public String getNumber(){
        return this.accountNumber;
    }

    /*******************************************
     * Changes account balance
     * pre: balance must be a positive value
     * post: account balance changes to <balance>
     * @param double balance New balance
     */
    public void setBalance(double balance){
        this.balance = balance;
    }

    /*******************************************
     * Changes account customer
     * pre: customer must be valid
     * post: account owner changes to <customer>
     * @param Customer customer New customer
     */
    public void setCustomer(Customer customer){
        this.customer = customer;
    }

    /*******************************************
     * Converts Account object to a String object
     * @return String account information as String object
     */
    public String toString(){
        String message;
        String type;
        if (customer instanceof Senior){
            type = "Senior";
        }else if (customer instanceof Adult){
            type = "Adult";
        }else{
            type = "Student";
        }
        message = "Account: " + accountNumber + "\nOwner: " +
                  customer.getName() + "\nType of customer: " +
                  type + "\nBalance: $" + balance;
        return message;
    }

    /** Allocate a new array to hold the transactions. */
    public void reallocate() {
        capacity *= 2;
        Transaction[] newTransactions = new Transaction[capacity];
        System.arraycopy(transactions, 0, newTransactions, 0, transactions.length);
        transactions = newTransactions;
    }

    /** Add a new transaction and reallocate the space when needed. */
    protected void addTransaction(Transaction transaction) {
        if (tranIndex == this.capacity) {
            reallocate();
        }

        transactions[tranIndex++] = transaction;
    }

    abstract void deposit(double amount);
    abstract void withdraw(double amount);
    public abstract void addInterest();

}
