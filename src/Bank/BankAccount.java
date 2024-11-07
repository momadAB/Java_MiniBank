package Bank;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BankAccount {
  private String accountNumber;
  private List<Transaction> transactionHistory = new ArrayList<Transaction>();
  private double balance;

  public BankAccount(String accountNumber) {
    this.accountNumber = accountNumber;
    this.balance = 0;
  }

  // Cant change accountNumber
  public String getAccountNumber() {
    return accountNumber;
  }

  public void setAccountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
  }

  public double getBalance() {
    return balance;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }

  public void deposit(double amount) {
    this.balance += amount;
    addTransaction("deposit", amount);
  }

  public void withdrawal(double amount) {
    if (amount < this.balance) {
      this.balance -= amount;
      addTransaction("withdrawal", amount);
    } else System.out.println("Insufficient funds.");
  }

  // Adds a transaction to the transaction history after a deposit/withdrawal
  private void addTransaction(String type, double amount) {
    if(type.equals("withdrawal")) {
      transactionHistory.add(new Transaction(new Date(), "withdrawal", amount));
    }
    else {
      transactionHistory.add(new Transaction(new Date(), "deposit", amount));
    }
  }

  public void displayTransactionHistory() {
    System.out.println(transactionHistory);
  }

  public List<Transaction> getTransactionHistory() {
    return transactionHistory;
  }

  public void setTransactionHistory(List<Transaction> transactionHistory) {
    this.transactionHistory = transactionHistory;
  }
}
