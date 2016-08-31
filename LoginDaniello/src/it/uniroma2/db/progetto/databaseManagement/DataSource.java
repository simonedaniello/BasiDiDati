package it.uniroma2.db.progetto.databaseManagement;

import java.sql.*;

public class DataSource {
	private String dbURI = "jdbc:postgresql://localhost:5432/testdb";
	private String USER = "superuser";
	private String PASS = "password";
	
	private static DataSource dataSourceInstance = null;
	
//	Singleton pattern
	private DataSource(){
//		Void constructor for singleton pattern
	}
	
	public static DataSource getDataSourceInstance() {
		if( dataSourceInstance == null) {
			dataSourceInstance = new DataSource();
		}
		return dataSourceInstance;
	}

	public Connection getConnection() throws Exception {
		Class.forName("org.postgresql.Driver");
		Connection connection = DriverManager.getConnection(dbURI, USER, PASS);
		return connection;
	}

}
