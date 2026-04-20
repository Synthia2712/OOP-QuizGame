package dao;

import model.Player;

import java.util.List;

public interface ScoreDAO {
    void saveScore(Player player, String difficulty);
    void displayLeaderboard();
    List<String> getLeaderboardJson();
}
