import java.util.Scanner;
class InsufficientBalanceException extends Exception{
    InsufficientBalanceException(String message){
        super(message);
    }
}
public class BankTransactionSystem {
    double balance  =5000;
    static void insufficientBalance(double amount) throws InsufficientBalanceException{
        double balance  =5000;
        if(amount <0) {
            throw new IllegalArgumentException("Invalid amount!");
        }
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance!");
        } else {
            System.out.println("Withdrawal successful, new balance: " + (balance - amount));
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the amount");
        double amount = sc.nextDouble();
        try{
            if(amount <0){
                throw new IllegalArgumentException("Invalid amount!");
            }
            insufficientBalance(amount);
        }
        catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}

