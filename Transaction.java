import java.util.Date;

public class Transaction {

    private byte type;
    private double amount;
    private Date date;
    private double fees;
    private String description;

    public Transaction(byte type, double amount, double fees, String description) {
        this.type = type;
        this.amount = amount;
        this.date = new Date();
        this.fees = fees;
        this.description = description;
    }

    public String processTransaction() {
        String typeString = "";
        switch (type) {
            case 0:
                typeString = "deposit";
                break;
            case 1:
                typeString = "withdraw";
                break;
            case 2:
                typeString = "added interest";
                break;
        }
        return "Transaction: $" + this.amount + " of " + typeString + " on " + this.date + " with fees $" + this.fees + ", " + this.description;
    }

}
