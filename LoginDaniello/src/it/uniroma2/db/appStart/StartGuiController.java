package it.uniroma2.db.appStart;
import java.sql.*;

import it.uniroma2.db.progetto.databaseManagement.DataSource;
import it.uniroma2.db.progetto.guiClass.*;
import javax.swing.*;


public class StartGuiController {

//	static final String JDBC_DRIVER = "org.postgresql.Driver";  
//	static final String DB_URL = "jdbc:postgresql://localhost:5432/testdb";

	//  Database credentials
//	static final String USER = "superuser";
//	static final String PASS = "password";
	
	private static DataSource dataSource;

	public StartGuiController(){
		dataSource = new DataSource();
	}
	
	public void listenC(String User, String Pwd) throws Exception{
		Statement stmt = null;
		
		try{
//			Class.forName("org.postgresql.Driver");
//			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Connection connection = dataSource.getConnection();
			
			stmt = connection.createStatement();
			
			String sql = "SELECT USERID, PASSWORD  FROM SISTEMADIGALASSIE.User WHERE USERID='" + User + "' AND PASSWORD='" + Pwd +"'" ;
			ResultSet rs = stmt.executeQuery(sql);
			
			if (!rs.next() ) {    
				JLabel panel = new JLabel("User Not Found");
				JFrame frame = new JFrame("JOptionPane showMessageDialog component example");
				JOptionPane.showMessageDialog(frame, panel, "Ops!", 0);
			}
			else {
				new MainMenu();
			}

			rs.close();
		}catch(Exception e){
			e.printStackTrace();
			System.err.println("**** Error with the statement! ****");
		}finally{
			//finally block used to close resources
			try{
				if(stmt!=null)
					stmt.close();
			}catch(SQLException se){
			}//end finally try
		}//end try
	}

	public static void listenR(){
		new RegisInterface();
	}
	
	public static void main(String[] args) {
		new MyFrame();
	}
}