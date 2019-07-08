abstract class Customer {

    private String name;
    private String address;
    private int age;
    private String telephoneNumber;
    private String customerNumber;
    private static int lastCustomerNumber = 9999;

    /** Creates a new instance of Customer */
    public Customer(String name, String address, int age, String telephoneNumber) {
        this.customerNumber = Integer.toString(++lastCustomerNumber);
        this.name = name;
        this.address = address;
        this.age = age;
        this.telephoneNumber = telephoneNumber;
    }

    /*******************************************
     * Returns customer's name
     * @return String customer's name
     */
    public String getName(){
        return this.name;
    }

    /*******************************************
     * Returns customer's address
     * @return String customer's address
     */
    public String getAddress(){
        return this.address;
    }

    /*******************************************
     * Returns customer's age
     * @return int customer's age
     */
    public int getAge(){
        return this.age;
    }

    /*******************************************
     * Returns customer's phone number
     * @return String customer's phone number
     */
    public String getTelephoneNumber(){
        return this.telephoneNumber;
    }

    /*******************************************
     * Returns customer's number
     * @return String customer's number
     */
    public String getCustomerNumber(){
        return this.customerNumber;
    }

    /*******************************************
     * Changes customer's name
     * pre: name must be a not null string
     * post: customer's name changes to <name>
     * @param String name New name
     */
    public void setCustomerName(String name){
        this.name = name;
    }

    /*******************************************
     * Changes customer's address
     * pre: address must be a not null string
     * post: customer's address changes to <address>
     * @param String address New address
     */
    public void setCustomerAddress(String address){
        this.address = address;
    }

    /*******************************************
     * Changes customer's age
     * pre: age must be a positive value
     * post: customer's age changes to <age>
     * @param String age New age
     */
    public void setCustomerAge(int age){
        this.age = age;
    }

    /*******************************************
     * Changes customer's phone number
     * pre: phone number must be a not null string
     * post: customer's phone number changes to <phoneNumber>
     * @param String phoneNumber New number
     */
    public void setCustomerTelephoneNumber(String phoneNumber){
        this.telephoneNumber = phoneNumber;
    }

    /*******************************************
     * Changes customer's number
     * pre: customerNumber must be a not null string
     * post: customer's number changes to <customerNumber>
     * @param String customerNumber New customer number
     */
    public void setCustomerNumber(String customerNumber){
        this.customerNumber = customerNumber;
    }

    abstract double getSavingsInterest();
    abstract double getCheckInterest();
    abstract double getCheckCharge();
    public abstract double getOverdraftPenalty(double balance);

}
