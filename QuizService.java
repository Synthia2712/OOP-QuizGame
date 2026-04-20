package service;

import model.Player;
import model.Question;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuizService {
    private List<Question> questions;

    public QuizService() {
        this.questions = new ArrayList<>();
        loadQuestions();
    }

    private void loadQuestions() {
        // Dummy data for questions
        questions.add(new Question("What is the most powerful alarm clock known to humanity?", 
                new String[]{"Soft music", "Phone alarm", "Mom yelling your full name", "Sunrise"}, 3, "easy"));
        questions.add(new Question("What is the real purpose of opening the fridge repeatedly?", 
                new String[]{"Checking if new food appeared", "Organizing groceries", "Cooking", "Cleaning"}, 1, "easy"));
        questions.add(new Question("What happens when someone says 'We'll see'?", 
                new String[]{"It will happen", "Maybe later", "It’s a polite no", "Immediate action"}, 3, "medium"));
        questions.add(new Question("What is the fastest way to lose motivation?", 
                new String[]{"Hard work", "Seeing full syllabus", "Drinking water", "Music"}, 2, "medium"));
        questions.add(new Question("What happens when you sit to study seriously?", 
                new String[]{"Full focus", "Immediate productivity", "Sudden urge to do everything else", "Calm mind"}, 3, "hard"));
    }

    public List<Question> getQuestions(String difficulty) {
        List<Question> filtered = new ArrayList<>();
        for (Question q : questions) {
            if (q.getDifficulty().equalsIgnoreCase(difficulty)) {
                filtered.add(q);
            }
        }
        return filtered;
    }
}
