public class BankAccountController {
    public static void main(String[] args) {
        BankAccount b = new BankAccount();
        BankAccount b2 = new BankAccount();
        b.depositToChecking(33400);
        b.depositToSavings(4444);
        b.withdrawFromChecking(63300);

        System.out.println(b.checkingBalance);
    }
}
