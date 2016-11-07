package persistency;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
}
