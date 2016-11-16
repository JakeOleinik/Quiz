package persistency;

import java.sql.PreparedStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

import entities.Group;
import entities.Person;
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
	
	public Team getTeamById(int teamId) {
		String select = "SELECT id, name, groupId FROM Teams WHERE id = ?";
		Team team = null;
		try {
			
			PreparedStatement prepstat = DatabaseConnector.INSTANCE.getConnection().prepareStatement(select);
			prepstat.setInt(1, teamId);
			ResultSet rset = prepstat.executeQuery();
			
			if (rset.next()) {
				team = new Team(
								rset.getInt("id"),
								rset.getString("name"),
								GroupMapper.INSTANCE.getGroupById(rset.getInt("groupId"))
				); 
			}
			rset.close();
			prepstat.close();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return team;
	}
	
	public int deleteTeam(Team team) {
		int rowsAffected = 0;
		String sql = "DELETE FROM Teams WHERE id = ?";
		try {
			PreparedStatement prepstat = DatabaseConnector.INSTANCE.getConnection().prepareStatement(sql);
			prepstat.setInt(1, team.getId());
			rowsAffected = prepstat.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowsAffected;
	}
}
