package it.uniroma2.db.entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import it.uniroma2.db.progetto.dbManagement.DataSource;

public class UserRepository {

	private DataSource dataSource;

	public UserRepository() {
		dataSource = DataSource.getDataSourceInstance();
	}
	

	public void storeUser(User user) throws Exception {
		Connection connection = null;
		PreparedStatement statement = null;
		final String insert = "insert into users(userID, password, firstName, lastName, accountType, mail) values (?,?,?,?,?,?)";
		try{		
			connection = this.dataSource.getConnection();

			if (findByPrimaryKey(user.getUsername()) != null) {
				throw new Exception();
			}

			statement = connection.prepareStatement(insert);
			statement.setString(1, user.getUsername());
			statement.setString(2, user.getPassword());
			statement.setString(3, user.getFirstName());
			statement.setString(4, user.getLastName());
			statement.setInt(5, user.getAccountType());
			statement.setString(6, user.getEmail());
			statement.executeUpdate();

		}
		finally{
			// release resources
			if(statement != null){
				statement.close();
			}
			if(connection  != null){
				connection.close();
			}
		}
	}


	public User findByPrimaryKey(String userUsername) throws Exception {
		Connection connection = null;
		Statement statement = null;
		
		User user = null;
		ResultSet result = null;
		
		String sql = "SELECT USERID, PASSWORD  FROM SISTEMADIGALASSIE.User WHERE USERID='" + userUsername +"'" ;

		try{		
			
			connection = this.dataSource.getConnection();
			statement = connection.createStatement();
			result = statement.executeQuery(sql);

			if (result.next()) {
				if (user == null) {
					user = new User();
					user.setFirstName(result.getString("userID"));
					user.setLastName(result.getString("password"));
					user.setUsername(result.getString("nome"));
					user.setPassword(result.getString("lastName"));
					user.setAccountType(result.getInt("accountType"));
					user.setEmail(result.getString("mail"));
				}
			} else {
				return null;
			}
			result.close();
		}finally{
			// release resources
			if(statement != null){
				statement.close();
			}
			if(connection  != null){
				connection.close();
			}
		}
		return user;
	}
}
