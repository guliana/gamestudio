package score;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class HallOfFameDatabase extends HallOfFame {
	//CREATE TABLE score (name VARCHAR(64) NOT NULL, seconds INT NOT NULL)
	static final String URL = "jdbc:mysql://localhost/test";
	static final String USER = "root";
	static final String PASSWORDD = "";
	static final String SELECT_SCORES_QUERY = "SELECT name, id, game, time FROM userscore ORDER BY seconds";
	static final String INSERT_SCORE_UPDATE = "INSERT INTO userscore (name, game, time) VALUES ('%s', '%s', %d)";
	
	public void addScore(String name, String game, int time) throws SQLException {		
		try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORDD);
				Statement statement = connection.createStatement()) {
			
			String update = String.format(INSERT_SCORE_UPDATE, name, game, time);
			statement.executeUpdate(update);
		}		
	}
	
/*	public void addScore(String name, int time) throws SQLException {
			try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
					PreparedStatement statement = connection.prepareStatement(INSERT_SCORE)) {
				statement.setString(1, name);
				statement.setInt(2, time);
				statement.setString(3, getGame());
				statement.executeUpdate();
			}
		} 
*/
	public List<UserScore> loadScore() throws SQLException {
		List<UserScore> scores = new ArrayList<>();
		
		try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORDD);
				Statement statement = connection.createStatement();
				ResultSet rs = statement.executeQuery(SELECT_SCORES_QUERY)
				) {
			while (rs.next()) {
				scores.add(new UserScore(rs.getString(1), rs.getString(2), rs.getInt(3)));
			}			
		}
		
		return scores;
	}
	
}
