
import java.util.Scanner;

public class ExpenseTracker {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        TransactionDAO dao = new TransactionDAO();

        int choice;

        do {
            System.out.println("\n===== PERSONAL EXPENSE TRACKER =====");
            System.out.println("1. Add Income");
            System.out.println("2. Add Expense");
            System.out.println("3. View Transactions");
            System.out.println("4. View Financial Summary");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("Please enter a number from 1 to 5.");
                sc.nextLine();
                choice = 0;
                continue;
            }

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                case 2:
                    String type = (choice == 1) ? "Income" : "Expense";

                    System.out.print("Enter title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter amount: ");

                    if (!sc.hasNextDouble()) {
                        System.out.println("Please enter a valid amount.");
                        sc.nextLine();
                        break;
                    }

                    double amount = sc.nextDouble();
                    sc.nextLine();

                    if (amount <= 0) {
                        System.out.println("Amount must be greater than zero.");
                        break;
                    }

                    System.out.print("Enter category: ");
                    String category = sc.nextLine();

                    Transaction t = new Transaction(
                        title, amount, type, category
                    );

                    dao.addTransaction(t);
                    break;

                case 3:
                    dao.viewTransactions();
                    break;

                case 4:
                    dao.viewSummary();
                    break;

                case 5:
                    System.out.println("Thank you for using the tracker!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 5);

        sc.close();
    }
}
