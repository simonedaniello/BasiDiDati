package it.uniroma2.db.controller;
import java.sql.*;

import it.uniroma2.db.boundary.MainMenuBoundary;
import it.uniroma2.db.boundary.RegBoundary;
import it.uniroma2.db.boundary.StartBoundary;
import it.uniroma2.db.entity.User;
import it.uniroma2.db.entity.UserRepository;
import it.uniroma2.db.progetto.dbManagement.DataSource;

import javax.swing.*;


public class LoginController {
	
	private DataSource dataSource;
	private static LoginController controllerInstance = null;
	
//	Singleton class
	private LoginController(JFrame mainWindow){
		dataSource = DataSource.getDataSourceInstance();	
	}
	
	public static LoginController getGuiControllerInstance(JFrame mainWindow){
		if( controllerInstance == null) {
			controllerInstance = new LoginController(mainWindow);
		}
		return controllerInstance;
	}
	
	
//	Controller user login
	public User loginUserController(String username, String password) throws Exception{
//		Statement stmt = null;
//
//			Connection connection = this.dataSource.getConnection();
//			stmt = connection.createStatement();
//			
//			String sql = "SELECT USERID, PASSWORD  FROM SISTEMADIGALASSIE.User WHERE USERID='" + User + "' AND PASSWORD='" + Pwd +"'" ;
//			ResultSet rs = stmt.executeQuery(sql);
//			
//			if (!rs.next() ) {    
//				//SCOPRI COME FARE IL MESSAGGIO DI ERRORE. I JOPTIONPANE FANNO UN CASINO ALLUCINANTE
//				JOptionPane.showMessageDialog(mainWindow,
//					    "User not found!",
//					    "Login error",
//					    JOptionPane.ERROR_MESSAGE);
//			}
//			else {
//				new MainMenuBoundary(0, mainWindow);
//			}
//			
//
//			rs.close();
//		}catch(Exception e){
//			e.printStackTrace();
//			System.err.println("**** Error with the statement! ****");
//		}finally{
//			try{
//				if(stmt!=null)
//					stmt.close();
//			}catch(SQLException se){
//			}
//		}
			
			UserRepository rep = new UserRepository();
			User savedUser = rep.findByPrimaryKey(username);
			if( savedUser == null){
				System.err.println("Something wrong on username");
				throw new Exception();
			}
			if( password.equals(savedUser.getPassword())){
				return savedUser;
			}
			else{
				System.err.println("Something wrong on password");
				throw new Exception();
			}
			
	}
	
//	Controller admin login
	public void loginAdminController(String User, String Pwd, JFrame mainWindow) throws Exception{
		Statement stmt = null;
		
		try{
			Connection connection = dataSource.getConnection();
			
			stmt = connection.createStatement();
			
			String sql = "SELECT USERID, PASSWORD  FROM SISTEMADIGALASSIE.User WHERE USERID='" + User + "' AND PASSWORD='" + Pwd +
					"' AND AMMINISTRATORE = 'TRUE'" ;
			
			ResultSet rs = stmt.executeQuery(sql);
			
			if (!rs.next() ) {    
				//SCOPRI COME FARE IL MESSAGGIO DI ERRORE. I JOPTIONPANE FANNO UN CASINO ALLUCINANTE
				new StartBoundary();
			}
			else {
				new MainMenuBoundary(1, mainWindow);
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
	public static void listenR(JFrame mainWindow){
		new RegBoundary(mainWindow);
	}

}