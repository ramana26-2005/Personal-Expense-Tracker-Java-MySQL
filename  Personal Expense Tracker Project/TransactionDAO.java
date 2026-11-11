
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionDAO {

    public void addTransaction(Transaction t) {

        String sql = "INSERT INTO transactions " +
                     "(title, amount, type, category) " +
                     "VALUES (?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, t.title);
            ps.setDouble(2, t.amount);
            ps.setString(3, t.type);
            ps.setString(4, t.category);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Transaction saved to MySQL!");
            }

        } catch (SQLException e) {
            System.out.println("Database operation failed!");
            System.out.println("Error code: " + e.getErrorCode());
            System.out.println("SQL state: " + e.getSQLState());
            System.out.println("Details: " + e.getMessage());
        }
    }


public void viewTransactions() {

    String sql = "SELECT * FROM transactions ORDER BY id DESC";

    try (Connection con = DBConnection.getConnection();
         PreparedStatement ps = con.prepareStatement(sql);
         java.sql.ResultSet rs = ps.executeQuery()) {

        System.out.println("\n===== SAVED TRANSACTIONS =====");

        while (rs.next()) {
            System.out.println(
                "ID: " + rs.getInt("id")
                + " | Title: " + rs.getString("title")
                + " | Amount: Rs. " + rs.getBigDecimal("amount")
                + " | Type: " + rs.getString("type")
                + " | Category: " + rs.getString("category")
            );
        }

    } catch (SQLException e) {
        System.out.println("Failed to retrieve transactions.");
        System.out.println(e.getMessage());
    }
}


public void viewSummary() {

    String sql = "SELECT " +
                 "SUM(CASE WHEN type = 'Income' THEN amount ELSE 0 END) AS income, " +
                 "SUM(CASE WHEN type = 'Expense' THEN amount ELSE 0 END) AS expenses " +
                 "FROM transactions";

    try (Connection con = DBConnection.getConnection();
         PreparedStatement ps = con.prepareStatement(sql);
         java.sql.ResultSet rs = ps.executeQuery()) {

        if (rs.next()) {
            java.math.BigDecimal income = rs.getBigDecimal("income");
            java.math.BigDecimal expenses = rs.getBigDecimal("expenses");

            if (income == null) {
                income = java.math.BigDecimal.ZERO;
            }

            if (expenses == null) {
                expenses = java.math.BigDecimal.ZERO;
            }

            System.out.println("\n===== FINANCIAL SUMMARY =====");
            System.out.println("Total Income: Rs. " + income);
            System.out.println("Total Expenses: Rs. " + expenses);
            System.out.println(
                "Remaining Balance: Rs. " + income.subtract(expenses)
            );
        }

    } catch (SQLException e) {
        System.out.println("Failed to calculate summary.");
        System.out.println(e.getMessage());
    }
}


}
