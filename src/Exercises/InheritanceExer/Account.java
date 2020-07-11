package Exercises.InheritanceExer;

/**
 * @author ChenZT
 */
public class Account {
    private int id; // 账号
    private double balance; //余额
    private double annualInterestRate; // 年利率


    public Account(int id, double balance, double annualInterestRate) {
        this.id = id;
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public double getMonthlyInterest() {
        return this.annualInterestRate / 12;
    }

    public void withdraw(double amount) {
        if (this.balance >= amount) {
            this.balance -= amount;
            return;
        }
        System.out.println("余额不足");

    }

    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
        }
    }
}
