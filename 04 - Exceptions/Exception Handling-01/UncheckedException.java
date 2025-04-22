import java.util.InputMismatchException;
import java.util.Scanner;
public class UncheckedException{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try{
            System.out.println("Enter the First Number");
            int a =sc.nextInt();
            System.out.println("Enter the Second Number");
            int b= sc.nextInt();
            int result= a/b;
            System.out.println("The result is: "+result);
        }
        catch (ArithmeticException e) {
            System.out.println("Error: Denominator is Zero");
        }
        catch (InputMismatchException e){
            System.out.println("Error: Invalid Input Type");
        }
    }
}
