import java.util.Scanner;

public class Quiz implements QuizOperations {

    private Question[] questions;

    public Quiz(Question[] questions) {
        this.questions = questions;
    }

    public void startQuiz(Player player) {

        Scanner scanner = new Scanner(System.in);

        for (Question q : questions) {

            q.displayQuestion();

            System.out.print("Enter option number: ");
            int answer = scanner.nextInt();

            if (q.checkAnswer(answer)) {
                System.out.println("Correct!");
                player.increaseScore();
            } else {
                System.out.println("Wrong answer!");
            }
        }

        System.out.println("\nFinal Score: " + player.getScore() + "/" + questions.length);
    }

}
@Override
public void startQuiz() {
    System.out.println("Quiz started!");
    // your existing quiz logic here
}