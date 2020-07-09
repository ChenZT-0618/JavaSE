package Exercises.exer1;

/**
 * @author ChenZT
 */
public class CheckAccountTest {
    public static void main(String[] args) {
        CheckAccount checkAccount = new CheckAccount(1122, 20000, 0.045, 5000);
        checkAccount.withdraw(5000);
        checkAccount.print();
        checkAccount.withdraw(18000);
        checkAccount.print();
        checkAccount.withdraw(3000);
        checkAccount.print();
    }


}
