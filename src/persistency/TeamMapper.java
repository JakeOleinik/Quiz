package persistency;

import java.sql.PreparedStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import entities.Team;
import util.DatabaseConnector;

public enum TeamMapper {
	INSTANCE;
	
	private TeamMapper() {
		
	}
	
	public int createTeam(Team team) {
		int id = -1;
		String sql = "INSERT INTO Teams (name, groupId) VALUES (?,?)";
		try (PreparedStatement pstmt = DatabaseConnector.INSTANCE.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			pstmt.setString(1, team.getName());
			pstmt.setInt(2, team.getGroupId());
			 // executeUpdate() should be called to change something in the database
			int rowsAffected = pstmt.executeUpdate();
			if (rowsAffected > 0) {
				ResultSet rs = pstmt.getGeneratedKeys();
				if (rs != null) {
					if (rs.next()) {
						id = rs.getInt(1);
					}
				}
			}
			team.setId(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return id;
	}
	
	public List<Team> getTeams() {
		List<Team> teams = new LinkedList<Team>();
		try {
			Statement stmt = DatabaseConnector.INSTANCE.getConnection().createStatement();
			ResultSet rset = stmt.executeQuery("SELECT id, name, groupId FROM Teams");
			while (rset.next()) {
				teams.add(new Team(rset.getInt(1), rset.getString(2), GroupMapper.INSTANCE.getGroupById(rset.getInt(3)))); // scroll trough the data and fill
			}
			rset.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return teams;
	}
}
