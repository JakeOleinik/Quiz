package persistency;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

import util.DatabaseConnector;

public enum GroupMapper {
	INSTANCE;
	
	private GroupMapper() {
		
	}
	
	public int CreateGroup(String name) {
		int id = -1;
		String sql = "INSERT INTO Groups (name) VALUES (?)";
		try (PreparedStatement pstmt = DatabaseConnector.INSTANCE.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			pstmt.setString(1, name);
			
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
