package persistency;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.sql.PreparedStatement;
import entities.Group;

import util.DatabaseConnector;

public enum GroupMapper {
	INSTANCE;
	
	private GroupMapper() {
		
	}
	
	public int createGroup(Group group) {
		int id = -1;
		String sql = "INSERT INTO Groups (name) VALUES (?)";
		try (PreparedStatement pstmt = DatabaseConnector.INSTANCE.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			pstmt.setString(1, group.getName());
			
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
			group.setId(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}
	
	public List<Group> getGroups() {
		List<Group> groups = new LinkedList<Group>();
		try {
			Statement stmt = DatabaseConnector.INSTANCE.getConnection().createStatement();
			ResultSet rset = stmt.executeQuery("SELECT id, name FROM Groups");
			while (rset.next()) {
				groups.add(new Group(rset.getInt(1), rset.getString(2))); // scroll trough the data and fill
			}
			rset.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return groups;
	}
	
	public Group getGroupById(int groupId) {
		String select = "SELECT id, name FROM Groups WHERE id = ?";
		Group group = null;
		try {
			PreparedStatement prepstat = DatabaseConnector.INSTANCE.getConnection().prepareStatement(select);
			prepstat.setInt(1, groupId);
			ResultSet rset = prepstat.executeQuery();
			if (rset.next()) {
				group = new Group(rset.getInt("id"), rset.getString("name"));
			}
			rset.close();
			prepstat.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return group;
	}
	
	public int deleteGroup(Group group) {
		int rowsAffected = 0;
		String sql = "DELETE FROM Groups WHERE id = ?";
		try {
			PreparedStatement prepstat = DatabaseConnector.INSTANCE.getConnection().prepareStatement(sql);
			prepstat.setInt(1, group.getId());
			rowsAffected = prepstat.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowsAffected;
	}
} 
