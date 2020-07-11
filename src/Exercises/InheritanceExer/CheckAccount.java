package Exercises.InheritanceExer;

/**
 * @author ChenZT
 */
public class CheckAccount extends Account {
    private double overdraft;

    public double getOverdraft() {
        return overdraft;
    }

    public void setOverdraft(double overdraft) {
        this.overdraft = overdraft;
    }

    public CheckAccount(int id, double balance, double annualInterestRate, double overdraft) {
        super(id, balance, annualInterestRate);
        this.overdraft = overdraft;
    }

    @Override
    public void withdraw(double amount) {
        if (getBalance() > amount) {
            super.withdraw(amount);
        } else if (getBalance() + overdraft >= amount) {
            this.overdraft -= (amount - getBalance());
            super.setBalance(getBalance() - amount);
        } else {
            System.out.println("超过可透支限额！");
        }
    }

    public void print() {
        System.out.println("您的账户余额为：" + getBalance());
        System.out.println("您的可透支额度为：" + getOverdraft());
    }
}
