import java.util.Scanner;
class InvalidAgeException extends Exception{
    InvalidAgeException(String message){
        super(message);
    }
}
public class CustomException {
    static void validateAge(int age) throws InvalidAgeException{
        if(age<18){
            throw new InvalidAgeException("Invalid Age");
        }
    }

    public static void main(String[] args) {
        System.out.println("Enter age");
        Scanner sc= new Scanner(System.in);
        int age= sc.nextInt();
        try{
            validateAge(age);
            System.out.println("Access granted");
        }
        catch (InvalidAgeException e){
            System.out.println("Age must be 18 or above.");
        }
    }
}
