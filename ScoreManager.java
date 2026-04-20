import java.util.ArrayList;

public class ScoreManager {

    private ArrayList<String> leaderboard = new ArrayList<>();

    public void saveScore(Player player) {

        String entry = player.getName() + " - " + player.getScore();
        leaderboard.add(entry);
    }

    public void showLeaderboard() {

        System.out.println("\nLeaderboard:");

        for (String entry : leaderboard) {
            System.out.println(entry);
        }
    }
}