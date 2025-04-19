import java.util.*;

public class RemoveDuplicatesWhilePreservingTheDuplicates {
    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(3, 1, 2, 2, 3, 4);
        List<Integer> result = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();

        for (Integer num : input) {
            if (!seen.contains(num)) {
                seen.add(num);
                result.add(num);
            }
        }

        System.out.println(result);
    }
}
