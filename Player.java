public class Player extends User {

    private String name;
    private int score;

    public Player(String name) {
        super(name);
        this.name = name;
        this.score = 0;
    }

    public void increaseScore() {
        score++;
    }

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }
}