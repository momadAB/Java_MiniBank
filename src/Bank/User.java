package Bank;

public class User {
  private String username;
  private String password;
  private BankAccount account;

  public User(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public void displayAccountDetails() {
    System.out.println(account);
  }

  public BankAccount getAccount() {
    return account;
  }

  public void setAccount(BankAccount account) {
    this.account = account;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public void updatePassword(String oldPassword, String newPassword) {
    if (this.password.equals(oldPassword)) {
      this.password = newPassword;
    } else System.out.println("Error");
  }

  protected String getPassword() {
    return password;
  }

  public void updateUsername(String newUsername) {
    setUsername(newUsername);
  }

  public void updatePassword(String newPassword) {
    this.password = newPassword;
  }
}
