package persistency;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.sql.PreparedStatement;

import util.DatabaseConnector;

public enum TeamMapper {
	INSTANCE;
	
	private TeamMapper() {
		
	}
	
	public int createTeam(String name, int groupId) {
		int id = -1;
		String sql = "INSERT INTO Teams (name, groupId) VALUES (?)";
		try (PreparedStatement pstmt = DatabaseConnector.INSTANCE.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			pstmt.setString(1, name);
			pstmt.setInt(2, groupId);
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
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return id;
	}
}
