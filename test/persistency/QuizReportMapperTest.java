package persistency;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import entities.Team;
import entities.QuizReport;
import entities.Group;
import entities.Person;
import entities.Quiz;

public class QuizReportMapperTest {
	private Team team;
	private Quiz quiz;
	private QuizReport quizReport;
	
	@Before
	public void setUp() throws Exception {
		this.team = TeamMapper.INSTANCE.getTeamById(1);
		this.quiz = QuizMapper.INSTANCE.getQuizById(1);
		this.quizReport = new QuizReport(team, quiz);
	}
	
	@Test
	public void testCreateQuizReport() {
		// Report creation affected one row
		assertEquals(1, QuizReportMapper.INSTANCE.createQuizReport(quizReport));
		// Report deletion affected one row
		assertEquals(1, QuizReportMapper.INSTANCE.deleteQuizReport(quizReport));
	}
}
