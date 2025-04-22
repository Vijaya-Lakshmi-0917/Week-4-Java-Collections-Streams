import java.util.Scanner;
public class NestedTryCatchBlock {
    public static void main(String[] args) {
        int[] array= {2,4,1,5,7,1};
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the divisor");
        int divisor= sc.nextInt();
        System.out.println("Enter the index");
        int index=sc.nextInt();
        try{
            int number=array[index];
            try{
                double result= number/divisor;
                System.out.println("The result is: "+ result);
            } catch (ArithmeticException e) {
                System.out.println("Cannot divide by zero!");
            }
        }
        catch (ArrayIndexOutOfBoundsException E){
            System.out.println("Invalid array index!");
        }
    }
}
