package Exercises.exer1;

/**
 * @author ChenZT
 */
public class AccountTest {
    public static void main(String[] args) {
        Account account = new Account(1122, 20000, 0.045);

        account.withdraw(30000);
        System.out.println("您的账户余额为：" + account.getBalance());
        account.withdraw(2500);
        System.out.println("您的账户余额为：" + account.getBalance());
        account.deposit(3000);
        System.out.println("您的账户余额为：" + account.getBalance());

        System.out.println("月利率为：" + (account.getMonthlyInterest() * 100) + "%");
    }
}
