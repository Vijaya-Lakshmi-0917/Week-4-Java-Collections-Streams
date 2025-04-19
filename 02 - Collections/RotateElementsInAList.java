import java.util.*;

public class RotateElementsInAList {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));
        int rotateBy = 2;

        int size = list.size();
        rotateBy = rotateBy % size;

        List<Integer> rotated = new ArrayList<>();
        rotated.addAll(list.subList(rotateBy, size));
        rotated.addAll(list.subList(0, rotateBy));

        System.out.println(rotated);
    }
}