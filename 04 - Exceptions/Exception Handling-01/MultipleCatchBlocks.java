import java.util.Scanner;
public class MultipleCatchBlocks {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int[] Array= {2,7,9};
        try{
            System.out.println("Enter the Index");
            int index=sc.nextInt();
            System.out.println("Value of index "+index+": "+ Array[index]);
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Invalid Index!");
        }
        catch(NullPointerException e){
            System.out.println("Array Is Not Initialized!");
        }
    }
}
