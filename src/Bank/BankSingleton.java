package Bank;

import java.util.ArrayList;
import java.util.List;

public class BankSingleton {
  private static BankSingleton instance;
  private final List<User> users = new ArrayList<>();

  // Ensure single instance
  private BankSingleton() {}

  public static synchronized BankSingleton getInstance() {
    if (instance == null) {
      instance = new BankSingleton();
    }
    return instance;
  }

  // Adds a new user to userList
  // Does not allow duplicate usernames
  public User createUser(String username, String password) throws Exception {
    for (User user : users) {
      if (user.getUsername().equals(username)) {
        throw new Exception();
      }
    }
    User newUser = new User(username, password);
    users.add(newUser);
    return newUser;
  }

  public User authenticate(String username, String password) {
    // Method that authenticates users during login
    for (User user : users) {
      if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
        return user;
      }
    }
    System.out.println("Invalid credentials");
    return null;
  }
}
