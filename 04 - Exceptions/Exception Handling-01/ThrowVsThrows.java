import java.util.Scanner;
public class ThrowVsThrows {
    public static double calculateInterest(double amount, double rate, int years){
        if (amount <0 || rate<0){
            throw new IllegalArgumentException("Invalid input: Amount and rate must be positive");
        }
        return amount*rate*years/100;
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the amount");
        double amount = sc.nextDouble();
        System.out.println("Enter the rate");
        double rate= sc.nextDouble();
        System.out.println("Enter the years");
        int years= sc.nextInt();

        try{
            double interest= calculateInterest( amount,  rate,  years);
            System.out.println("The Interest is: "+interest );
        }
        catch (IllegalArgumentException e){
            System.out.println("Error: " +e.getMessage() );
        }
    }
}
