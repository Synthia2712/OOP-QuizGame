import java.sql.*;
import java.util.*;

public class QuestionDAO {

    Connection conn;

    public QuestionDAO() throws Exception {
        conn = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/quizdb",
            "root",
            "password"
        );
    }

    public void addQuestion(Question q) throws Exception {
        String sql = "INSERT INTO questions(question, option1, option2, option3, option4, answer, difficulty) VALUES (?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, q.getText());
        ps.setString(2, q.getOptions()[0]);
        ps.setString(3, q.getOptions()[1]);
        ps.setString(4, q.getOptions()[2]);
        ps.setString(5, q.getOptions()[3]);
        ps.setInt(6, q.getAnswer());
        ps.setString(7, q.getDifficulty());

        ps.executeUpdate();
    }
}

