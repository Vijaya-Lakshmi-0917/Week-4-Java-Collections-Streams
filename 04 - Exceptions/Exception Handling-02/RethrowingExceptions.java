import java.util.Scanner;
public class RethrowingExceptions {
    public static double performDivision(int numerator, int denominator){
        if(denominator==0){
            throw new ArithmeticException("Denominator is zero");
        }
        return numerator/denominator;
    }
    public static double calculate(int numerator, int denominator){
        try {
            double result = performDivision(numerator, denominator);
            return result;
        }
        catch (ArithmeticException e){
            throw new ArithmeticException("Denominator is Zero");
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the numerator");
        int numerator=sc.nextInt();
        System.out.println("Enter the denominator");
        int denominator=sc.nextInt();
        try{
             System.out.println("result is: "+calculate(numerator, denominator));
        }
        catch(ArithmeticException e){
            System.out.println("Denominator is Zero");
        }
    }
}
