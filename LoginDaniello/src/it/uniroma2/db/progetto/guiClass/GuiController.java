package it.uniroma2.db.progetto.guiClass;
import java.sql.*;

import it.uniroma2.db.Boundary.StartFrame;
import it.uniroma2.db.progetto.databaseManagement.DataSource;
import it.uniroma2.db.progetto.guiClass.*;
import javax.swing.*;


public class GuiController {
	
	private DataSource dataSource;

	public GuiController(){
		dataSource = DataSource.getDataSourceInstance();
	}
	
//	CONTROLLER USER LOGIN
	public void loginUserController(String User, String Pwd) throws Exception{
		Statement stmt = null;
		
		try{
//			Class.forName("org.postgresql.Driver");
//			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Connection connection = this.dataSource.getConnection();
			stmt = connection.createStatement();
			
			String sql = "SELECT USERID, PASSWORD  FROM SISTEMADIGALASSIE.User WHERE USERID='" + User + "' AND PASSWORD='" + Pwd +"'" ;
			ResultSet rs = stmt.executeQuery(sql);
			
			if (!rs.next() ) {    
				JLabel panel = new JLabel("User Not Found");
				JFrame frame = new JFrame("JOptionPane showMessageDialog component example");
				JOptionPane.showMessageDialog(frame, panel, "Ops!", 0);
				System.exit(0);
			}
			else {
				new MainMenu(0);
			}

			rs.close();
		}catch(Exception e){
			e.printStackTrace();
			System.err.println("**** Error with the statement! ****");
		}finally{
			try{
				if(stmt!=null)
					stmt.close();
			}catch(SQLException se){
			}
		}
	}
	
//	CONTROLLER ADMIN LOGIN
	public void loginAdminController(String User, String Pwd) throws Exception{
		Statement stmt = null;
		
		try{
			Connection connection = dataSource.getConnection();
			
			stmt = connection.createStatement();
			
			String sql = "SELECT USERID, PASSWORD  FROM SISTEMADIGALASSIE.User WHERE USERID='" + User + "' AND PASSWORD='" + Pwd +
					"' AND AMMINISTRATORE = 'TRUE'" ;
			
			ResultSet rs = stmt.executeQuery(sql);
			
			if (!rs.next() ) {    
				JLabel panel = new JLabel("User Not Found"); 
				JFrame frame = new JFrame("JOptionPane showMessageDialog component example");
				JOptionPane.showMessageDialog(frame, panel, "Ops!", 0);
				new StartFrame();
			}
			else {
				new MainMenu(1);
			}

			rs.close();
		}catch(Exception e){
			e.printStackTrace();
			System.err.println("**** Error with the statement! ****");
		}finally{
			try{
				if(stmt!=null)
					stmt.close();
			}catch(SQLException se){
			}
		}
	}
	
//	CONTROLLER SIGN IN
	public static void listenR(){
		new RegisInterface();
	}

}