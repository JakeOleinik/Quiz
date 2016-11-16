package persistency;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import entities.Quiz;
import util.DatabaseConnector;

public enum QuizMapper {
	INSTANCE;
	
	private QuizMapper() {
	
	}

	public List<Quiz> getQuizzes() {
		List<Quiz> quizzes = new LinkedList<Quiz>();
		try {
			Statement stmt = DatabaseConnector.INSTANCE.getConnection().createStatement();
			ResultSet rset = stmt.executeQuery("SELECT id, name, date, location FROM Quizzes");
			while (rset.next()) {
				quizzes.add(new Quiz(rset.getInt(1), rset.getString(2), rset.getString(3))); // scroll trough the data and fill
			}
			rset.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return quizzes;
	}
}
