package it.uniroma2.db.progetto.guiClass;
import java.sql.*;

import it.uniroma2.db.Boundary.StartFrame;
import it.uniroma2.db.progetto.databaseManagement.DataSource;
import javax.swing.*;


public class GuiController {
	
	private DataSource dataSource;
	private static GuiController controllerInstance = null;
	
	private GuiController(JFrame mainWindow){
		dataSource = DataSource.getDataSourceInstance();
		
	}
	
	public static GuiController getGuiControllerInstance(JFrame mainWindow){
		if( controllerInstance == null) {
			controllerInstance = new GuiController(mainWindow);
		}
		return controllerInstance;
	}
	
	
//	CONTROLLER USER LOGIN
	public void loginUserController(String User, String Pwd, JFrame mainWindow) throws Exception{
		Statement stmt = null;
		
		try{
//			Class.forName("org.postgresql.Driver");
//			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Connection connection = this.dataSource.getConnection();
			stmt = connection.createStatement();
			
			String sql = "SELECT USERID, PASSWORD  FROM SISTEMADIGALASSIE.User WHERE USERID='" + User + "' AND PASSWORD='" + Pwd +"'" ;
			ResultSet rs = stmt.executeQuery(sql);
			
			if (!rs.next() ) {    
				//SCOPRI COME FARE IL MESSAGGIO DI ERRORE. I JOPTIONPANE FANNO UN CASINO ALLUCINANTE
				//System.exit(0);
				JOptionPane.showMessageDialog(mainWindow,
					    "User not found!",
					    "Login error",
					    JOptionPane.ERROR_MESSAGE);
			}
			else {
				new MainMenu(0, mainWindow);
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
				new StartFrame();
			}
			else {
				new MainMenu(1, mainWindow);
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
	/*public static void listenR(){
		new RegisInterface(mainWindow);
	}*/

}