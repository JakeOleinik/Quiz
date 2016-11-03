package persistency;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

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
												// the collection
			}
			rset.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return names;
	}
}
