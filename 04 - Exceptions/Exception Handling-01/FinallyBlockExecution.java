import java.util.Scanner;
public class FinallyBlockExecution {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the First Number");
        int firstNumber= sc.nextInt();
        System.out.println("Enter the Second Number");
        int secondNumber= sc.nextInt();
        try{
           double division =(firstNumber/secondNumber);
           System.out.println(division);
        }
        catch (ArithmeticException e){
            System.out.println("Enter a valid number");
        }
        finally{
            System.out.println("Operations Completed");
        }
    }
}
