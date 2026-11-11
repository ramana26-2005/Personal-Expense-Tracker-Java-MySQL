# Personal Expense Tracker | Java & MySQL

## 📌 Project Overview

The **Personal Expense Tracker** is a menu-driven Java application designed to help users manage their daily income and expenses. It allows users to record transactions, retrieve saved records, and calculate their total income, total expenses, and remaining balance.

The application uses **Java, JDBC, and MySQL** to provide database connectivity and persistent transaction storage.

## 🚀 Features

- **Add Income:** Record income details with title, amount, and category.
- **Add Expense:** Record daily expenses with title, amount, and category.
- **View Transactions:** Retrieve and display all saved transactions from MySQL.
- **Financial Summary:** Calculate total income, total expenses, and remaining balance.
- **Input Validation:** Validate numeric input and reject zero or negative transaction amounts.
- **Database Integration:** Store transaction records permanently using MySQL.

## 🛠️ Technologies Used

| Technology | Purpose |
|---|---|
| Java | Application development |
| JDBC | Java-MySQL connectivity |
| MySQL | Database management |
| SQL | Data insertion, retrieval, and aggregation |
| VS Code | Development environment |

## 📂 Project Structure

```text
Personal-Expense-Tracker/
│
├── DBConnection.java
├── Transaction.java
├── TransactionDAO.java
├── ExpenseTracker.java
├── TestTransaction.java
├── ViewTransactions.java
│
├── lib/
│   └── mysql-connector-j-26.7.0.jar
│
└── README.md
```

## 🗄️ Database Configuration

### Step 1: Create the database

```sql
CREATE DATABASE expense_tracker;

USE expense_tracker;
```

### Step 2: Create the transactions table

```sql
CREATE TABLE transactions (
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(100) NOT NULL,
    amount DECIMAL(10,2) NOT NULL,
    type VARCHAR(20) NOT NULL,
    category VARCHAR(50) NOT NULL,
    transaction_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

### Step 3: Configure database connection

Update the database credentials in `DBConnection.java`:

```java
private static final String URL =
    "jdbc:mysql://127.0.0.1:3306/expense_tracker";

private static final String USER = "root";

private static final String PASSWORD = "your_password";
```

Replace `your_password` with your local MySQL password. Do not upload real database credentials to GitHub.

## ▶️ How to Run the Project

### Prerequisites

- Java JDK installed
- MySQL Server installed and running
- MySQL Connector/J JDBC driver
- VS Code or any Java IDE

### Step 1: Clone the repository

```bash
git clone https://github.com/your-username/Personal-Expense-Tracker-Java-MySQL.git
```

### Step 2: Navigate to the project directory

```bash
cd Personal-Expense-Tracker-Java-MySQL
```

### Step 3: Compile the Java files

```bash
javac -cp ".:lib/mysql-connector-j-26.7.0.jar" Transaction.java DBConnection.java TransactionDAO.java ExpenseTracker.java
```

### Step 4: Run the application

```bash
java -cp ".:lib/mysql-connector-j-26.7.0.jar" ExpenseTracker
```

## 💻 Application Menu

```text
===== PERSONAL EXPENSE TRACKER =====

1. Add Income
2. Add Expense
3. View Transactions
4. View Financial Summary
5. Exit

Enter your choice:
```

## 📊 Sample Output

### Adding Income

```text
Enter your choice: 1
Enter title: Part-time Salary
Enter amount: 10000
Enter category: Salary

Transaction saved to MySQL!
```

### Adding Expense

```text
Enter your choice: 2
Enter title: Lunch
Enter amount: 200
Enter category: Food

Transaction saved to MySQL!
```

### Financial Summary

```text
===== FINANCIAL SUMMARY =====

Total Income: Rs. 10000.00
Total Expenses: Rs. 1100.00
Remaining Balance: Rs. 8900.00
```

*Note: The sample summary includes previously saved test transactions in the database.*

## 🎯 Learning Outcomes

- Gained practical experience in Java programming and object-oriented concepts.
- Understood JDBC connectivity between Java applications and MySQL databases.
- Practiced SQL INSERT and SELECT queries.
- Implemented PreparedStatement for parameterized database operations.
- Learned database exception handling and resource management.
- Developed a menu-driven application with transaction management and financial calculations.

## 🔮 Future Enhancements

- Add, edit, and delete transaction functionality.
- Implement monthly and yearly expense reports.
- Add date-based transaction filtering.
- Develop a graphical user interface using Java Swing or JavaFX.
- Add expense category-wise analysis.
- Improve input validation and database credential management.

## 👨‍💻 Author

**Ramana S**

Electronics and Communication Engineering Student

Interested in Java Development, Software Testing, and Cloud Technologies.

---

⭐ If you find this project useful, feel free to explore the repository!
