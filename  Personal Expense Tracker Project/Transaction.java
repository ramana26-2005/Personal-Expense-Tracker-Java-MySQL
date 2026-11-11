
public class Transaction {

    String title;
    double amount;
    String type;
    String category;

    public Transaction(String title, double amount,
                       String type, String category) {
        this.title = title;
        this.amount = amount;
        this.type = type;
        this.category = category;
    }

    public void displayTransaction() {
        System.out.println(
            title + " | " + amount + " | " + type + " | " + category
        );
    }
}
