package persistency;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;
import java.sql.Types;

import entities.*;
import util.DatabaseConnector;

public enum PersonMapper {
	//private static PersonMapper uniqueInstance = null;
	INSTANCE;

	/**
	 * Private constructor for Singleton design pattern
	 */
	private PersonMapper() {
		// private Constructor
	}

	
	/**
	 * Store a person in the database
	 * 
	 * @param person The Person object that needs to be stored
	 */
	public int createPerson(Person person) {
		int id = -1;
		String sql = "INSERT INTO People (lastName, firstName, phone, email, dateOfBirth, groupId) VALUES (?,?,?,?,?,?)";
		try (PreparedStatement pstmt = DatabaseConnector.INSTANCE.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			pstmt.setString(1, person.getLastName());
			pstmt.setString(2, person.getFirstName());
			pstmt.setString(3, person.getPhone());
			pstmt.setString(4, person.getEmail());
			pstmt.setDate(5, Date.valueOf(person.getDateOfBirth()));
			pstmt.setInt(6, person.getGroup().getId());
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
			
			person.setId(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}
	
	
	/**
	 * Delete a person from the database
	 * 
	 * @param id The id of the Person to be deleted
	 * @return Number of rows affected (should be 1)
	 * @throws SQLException
	 */
	public int deletePerson(Person person) {
		int rowsAffected = 0;
		String sql = "DELETE FROM People WHERE id = ?";
		try {
			PreparedStatement prepstat = DatabaseConnector.INSTANCE.getConnection().prepareStatement(sql);
			prepstat.setInt(1, person.getId());
			rowsAffected = prepstat.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowsAffected;
	}
	
	
	/**
	 * Update the columns of a person in the database
	 * 
	 * @param person The Person object with the new data
	 * @return Number of rows affected (should be 1)
	 */
	public int updatePerson(Person person) {
		int rowsAffected = 0;
		String sql = "UPDATE People SET lastName = ?, firstName = ?, phone = ?, email = ?, dateOfBirth = ?, groupId = ?, teamId = ? WHERE id = ?";
		try (PreparedStatement pstmt = DatabaseConnector.INSTANCE.getConnection().prepareStatement(sql)) {
			Team team = person.getTeam();
			if (team != null) {
				pstmt.setInt(7, team.getId());
			} else {
				pstmt.setNull(7, 4);
			}
			pstmt.setString(1, person.getLastName());
			pstmt.setString(2, person.getFirstName());
			pstmt.setString(3, person.getPhone());
			pstmt.setString(4, person.getEmail());
			pstmt.setDate(5, Date.valueOf(person.getDateOfBirth()));
			pstmt.setInt(6, person.getGroup().getId());
			pstmt.setInt(8, person.getId());
			 // executeUpdate() should be called to change something in the database
			rowsAffected = pstmt.executeUpdate();
			System.out.println(""+rowsAffected);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowsAffected;
	}
	
	public List<Person> getPeopleFromGroup(int groupId) {
		List<Person> people = new LinkedList<Person>();
		String select = "SELECT id, firstName, lastName, phone, email, dateOfBirth, teamId, groupId FROM People WHERE groupId = ?";
		try {
			PreparedStatement prepstat = DatabaseConnector.INSTANCE.getConnection().prepareStatement(select);
			prepstat.setInt(1, groupId);
			ResultSet rset = prepstat.executeQuery();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			
			while (rset.next()) {
				people.add(new Person(
									rset.getInt("id"),
									rset.getString("lastName"),
									rset.getString("firstName"),
									rset.getString("phone"),
									rset.getString("email"),
									formatter.format(rset.getDate("dateOfBirth").toLocalDate()),
									GroupMapper.INSTANCE.getGroupById(rset.getInt("groupId"))
				)); 
			}
			
			rset.close();
			prepstat.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return people;
	}
	
	public Person getPersonById(int personId) {
		String select = "SELECT id, lastName, firstName, phone, email, dateOfBirth, groupId FROM People WHERE id = ?";
		Person person = null;
		try {
			
			PreparedStatement prepstat = DatabaseConnector.INSTANCE.getConnection().prepareStatement(select);
			prepstat.setInt(1, personId);
			ResultSet rset = prepstat.executeQuery();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			
			if (rset.next()) {
				person = new Person(
									rset.getInt("id"),
									rset.getString("lastName"),
									rset.getString("firstName"),
									rset.getString("phone"),
									rset.getString("email"),
									formatter.format(rset.getDate("dateOfBirth").toLocalDate()),
									GroupMapper.INSTANCE.getGroupById(rset.getInt("groupId"))
				); 
			}
			rset.close();
			prepstat.close();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return person;
	}
	
	
	/**
	 * Get all person names
	 * 
	 * @return A Collection of all person names
	 */
	public List<String> getPersonNames() {
		List<String> names = new LinkedList<String>();
		try {
			Statement stmt = DatabaseConnector.INSTANCE.getConnection().createStatement();
			ResultSet rset = stmt.executeQuery("SELECT firstName FROM People ORDER BY firstName");
			while (rset.next()) {
				names.add(rset.getString(1)); // scroll trough the data and fill
												// the coll11ection
			}
			rset.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return names;
	}
}
