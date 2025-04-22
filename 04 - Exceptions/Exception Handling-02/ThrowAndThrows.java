import java.util.ArrayList;
import java.util.Scanner;
class UserAlreadyExistsException extends Exception{
    UserAlreadyExistsException(String message){
        super(message);
    }
}
class UserNotFoundException extends Exception{
    UserNotFoundException(String message){
        super(message);
    }
}
class UserService {
    static ArrayList<String> arrayList = new ArrayList<String>();
    public static void registerUser(String UserName) throws UserAlreadyExistsException {
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).equalsIgnoreCase(UserName)) {
                throw new UserAlreadyExistsException("User Already Exist");
            }
        }
        arrayList.add(UserName);
    }

    public static void checkUserExistence(String UserName) throws UserNotFoundException {
        boolean userExistence = false;
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).equalsIgnoreCase(UserName)) {
                userExistence = true;
            }
        }
        if (!userExistence) {
            throw new UserNotFoundException("User Not Found");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        arrayList.add("User1");
        arrayList.add("User90");
        arrayList.add("User45");
        boolean toContinue=true;
        while(toContinue) {
            System.out.println("To add a user enter, \"add\".\nTo check if user exists, enter \"check\".");
            String userChoice = sc.next();
            System.out.println("Enter the user name");
            String userName = sc.next();
            if (userChoice.equalsIgnoreCase("add")) {
                try {
                    registerUser(userName);
                    for(int i=0; i<arrayList.size();i++){
                        System.out.print(arrayList.get(i)+" ");
                    }
                    System.out.println("\n");
                } catch (UserAlreadyExistsException e) {
                    System.out.println(e.getMessage());
                }
            } else if (userChoice.equalsIgnoreCase("check")) {
                try {
                    checkUserExistence(userName);
                } catch (UserNotFoundException e) {
                    System.out.println(e.getMessage());
                }
            }
            System.out.println("To continue enter \"true\".\nTo stop enter \"false\".");
            toContinue = sc.nextBoolean();
        }
    }
}

