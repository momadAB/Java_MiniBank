package Bank;

public class Employee extends User {
  // Payment history can be found through the User methods (getTransactionHistory, etc.)
  private final double OVERTIME_RATE = 1.25;
  private final double WEEKEND_RATE = 1.5;
  private final double HOLIDAY_RATE = 2.0;
  private final String employeeID;
  private String name;
  private final String position;
  private final int salary; // hourly

  public Employee(
      String username,
      String password,
      String employeeID,
      String name,
      String position,
      int salary) {
    super(username, password);
    this.employeeID = employeeID;
    this.name = name;
    this.position = position;
    this.salary = salary;
  }

  public void giveSalary(
          int hoursWorked,
          int overtimeHoursWorked,
          int weekendHours,
          int holidayHours,
          int bonuses,
          int deductions) {

    double calculatedSalary = getCalculatedSalary(
        hoursWorked,
        overtimeHoursWorked,
        weekendHours,
        holidayHours,
        bonuses,
        deductions);
    BankAccount account = this.getAccount();
    account.deposit(calculatedSalary);
  }

  public int getSalary() {
    return salary;
  }

  public double getCalculatedSalary(
      int hoursWorked,
      int overtimeHoursWorked,
      int weekendHours,
      int holidayHours,
      int bonuses,
      int deductions) {
    return hoursWorked * salary
        + overtimeHoursWorked * salary * OVERTIME_RATE
        + weekendHours * WEEKEND_RATE
        + holidayHours * HOLIDAY_RATE
        + bonuses
        - deductions;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPosition() {
    return position;
  }
}
