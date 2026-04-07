import java.util.*;

// Class for Voter
class Voter {
    int voterId;
    String name;
    boolean hasVoted;

    // Constructor
    Voter(int voterId, String name) {
        this.voterId = voterId;
        this.name = name;
        this.hasVoted = false;
    }
}

// Class for Candidate
class Candidate {
    String name;
    int votes;

    // Constructor
    Candidate(String name) {
        this.name = name;
        this.votes = 0;
    }

    // Add vote
    void addVote() {
        votes++;
    }
}

public class VotingSystem {

    static ArrayList<Voter> voters = new ArrayList<>();
    static ArrayList<Candidate> candidates = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        // Predefined candidates
        candidates.add(new Candidate("Alice"));
        candidates.add(new Candidate("Bob"));
        candidates.add(new Candidate("Charlie"));

        int choice;

        do {
            System.out.println("\n--- Online Voting System ---");
            System.out.println("1. Register Voter");
            System.out.println("2. Cast Vote");
            System.out.println("3. Display Results");
            System.out.println("4. Declare Winner");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    registerVoter();
                    break;
                case 2:
                    castVote();
                    break;
                case 3:
                    displayResults();
                    break;
                case 4:
                    declareWinner();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);
    }

    // Register new voter
    static void registerVoter() {
        System.out.print("Enter Voter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        voters.add(new Voter(id, name));

        System.out.println("Voter registered successfully.");
    }

    // Cast vote
    static void castVote() {
        System.out.print("Enter Voter ID: ");
        int id = sc.nextInt();

        Voter voter = null;

        // Find voter
        for (Voter v : voters) {
            if (v.voterId == id) {
                voter = v;
                break;
            }
        }

        if (voter == null) {
            System.out.println("Voter not found.");
            return;
        }

        if (voter.hasVoted) {
            System.out.println("You have already voted!");
            return;
        }

        // Show candidates
        System.out.println("Candidates:");
        for (int i = 0; i < candidates.size(); i++) {
            System.out.println((i + 1) + ". " + candidates.get(i).name);
        }

        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();

        if (choice < 1 || choice > candidates.size()) {
            System.out.println("Invalid candidate.");
            return;
        }

        // Add vote
        candidates.get(choice - 1).addVote();
        voter.hasVoted = true;

        System.out.println("Vote cast successfully.");
    }

    // Display vote results
    static void displayResults() {
        System.out.println("\n--- Voting Results ---");
        for (Candidate c : candidates) {
            System.out.println(c.name + " : " + c.votes + " votes");
        }
    }

    // Declare winner
    static void declareWinner() {
        Candidate winner = null;

        for (Candidate c : candidates) {
            if (winner == null || c.votes > winner.votes) {
                winner = c;
            }
        }

        if (winner != null) {
            System.out.println("Winner is: " + winner.name + 
                               " with " + winner.votes + " votes.");
        } else {
            System.out.println("No votes cast yet.");
        }
    }
}