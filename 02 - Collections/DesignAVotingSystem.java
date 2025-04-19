import java.util.*;

public class DesignAVotingSystem {
    Map<String, Integer> votesMap;
    Map<String, Integer> votesLinkedMap;
    Map<String, Integer> votesTreeMap;

    public DesignAVotingSystem() {
        votesMap = new HashMap<>();
        votesLinkedMap = new LinkedHashMap<>();
        votesTreeMap = new TreeMap<>();
    }

    public void vote(String candidate) {
        votesMap.put(candidate, votesMap.getOrDefault(candidate, 0) + 1);
        votesLinkedMap.put(candidate, votesLinkedMap.getOrDefault(candidate, 0) + 1);
        votesTreeMap.put(candidate, votesTreeMap.getOrDefault(candidate, 0) + 1);
    }

    public void displayVotes(Map<String, Integer> voteCollection) {
        for (Map.Entry<String, Integer> entry : voteCollection.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " votes");
        }
    }

    public void displaySortedResults() {
        System.out.println("Votes in sorted order:");
        displayVotes(votesTreeMap);
    }

    public void displayOrderedResults() {
        System.out.println("Votes in insertion order:");
        displayVotes(votesLinkedMap);
    }

    public void displayTotalResults() {
        System.out.println("Votes in arbitrary order:");
        displayVotes(votesMap);
    }

    public static void main(String[] args) {
        DesignAVotingSystem votingSystem = new DesignAVotingSystem();

        votingSystem.vote("A");
        votingSystem.vote("B");
        votingSystem.vote("A");
        votingSystem.vote("C");
        votingSystem.vote("B");
        votingSystem.vote("A");

        votingSystem.displayTotalResults();
        votingSystem.displayOrderedResults();
        votingSystem.displaySortedResults();
    }
}