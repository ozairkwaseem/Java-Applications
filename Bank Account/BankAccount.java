import java.util.Random;
import java.util.ArrayList;
import java.util.List;
public class BankAccount{
    public String accountNumber;
    public double checkingBalance = 5500.75;
    public double savingsBalance = 3347.65;
    static int numberofAccounts;
    static  double accountTotal;

    private String accountNumberGenerator(){
        Random r = new Random();
        String accNumber = "";
        for(int i = 0; i<10; i++){
            int account = r.nextInt(10); 
            accNumber += account; 
        }
            return accNumber;
    }

    public  BankAccount(){
        this.accountNumber= accountNumberGenerator();
        numberofAccounts++;
        System.out.println("Your Account Number is: " + accountNumber);
        System.out.println("The total number of accounts is: " + numberofAccounts);
    }


    public double getAccountBalance(){
        return checkingBalance;
    }

    public double depositToChecking(double checkingDeposit){
        this.checkingBalance= checkingBalance + checkingDeposit;
        return checkingBalance;        
    }
    public double depositToSavings(double savingsDeposit){
    this.savingsBalance = savingsBalance + savingsDeposit;
    return savingsBalance;
    }
    public void withdrawFromChecking(double checkingWithdrawlAmount){
        if (checkingWithdrawlAmount> checkingBalance) System.out.println("You do not have enough in your Checking Account!");
        if (checkingWithdrawlAmount< checkingBalance) this.checkingBalance-= checkingWithdrawlAmount;
        System.out.println("Your Checking Balance is now: " + checkingBalance);
    }
    public void withdrawFromSavings(double savingsWithdrawlAmount){
        if (savingsWithdrawlAmount > savingsBalance) System.out.println("You do not have enough in your Savings Account!");
        if (savingsBalance < savingsWithdrawlAmount) this.savingsBalance-= savingsWithdrawlAmount;
        System.out.println("Your Checking Balance is now: " + savingsBalance);
    }
    public double getTotalBalance(){
        double totalBalance= savingsBalance+ checkingBalance;
        return totalBalance;
    }


}