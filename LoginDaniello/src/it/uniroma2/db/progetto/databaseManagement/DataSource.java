package it.uniroma2.db.progetto.databaseManagement;

import java.sql.*;

//	Ottimizzazione per la creazione della connessione al DB
public class DataSource {
	private String dbURI = "jdbc:postgresql://localhost:5432/testdb";
	private String USER = "superuser";
	private String PASS = "password";

	public DataSource(){
		// Void constructor - TODO maybe a Singleton?
	}

	public Connection getConnection() throws Exception {
		Class.forName("org.postgresql.Driver");
		Connection connection = DriverManager.getConnection(dbURI, USER, PASS);
		return connection;

	}

}
