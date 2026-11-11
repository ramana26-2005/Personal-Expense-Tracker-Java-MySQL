
public class TestTransaction {

    public static void main(String[] args) {

        TransactionDAO dao = new TransactionDAO();

        Transaction t = new Transaction(
            "Java Test Expense",
            250.00,
            "Expense",
            "Testing"
        );

        dao.addTransaction(t);
    }
}
