import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        Player player = new Player(name);

        Question q1 = new Question(
                "What is the capital of France?",
                new String[]{"Berlin", "Paris", "Rome", "Madrid"},
                2
        );

        Question q2 = new Question(
                "What is 2 + 2?",
                new String[]{"3", "4", "5", "6"},
                2
        );

        Question q3 = new Question(
                "Which language is used for Android development?",
                new String[]{"Python", "Java", "C++", "Swift"},
                2
        );

        Question[] questions = {q1, q2, q3};

        Quiz quiz = new Quiz(questions);

        quiz.startQuiz(player);

        ScoreManager manager = new ScoreManager();
        manager.saveScore(player);
        manager.showLeaderboard();
    }
}
System.out.println("1. Add Question");
System.out.println("2. View Questions");
System.out.println("3. Update Question");
System.out.println("4. Delete Question");
System.out.println("5. Start Quiz");